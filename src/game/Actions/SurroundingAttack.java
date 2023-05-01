package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Displays.DisplayStrings;
import game.Utils.Status;
import game.Actors.Enemies.Skeleton;

import java.util.Random;

/**
 * Class that allows the actor to attack its surrounding with its weapon, including intrinsic weapon.
 *
 */
public class SurroundingAttack extends Action implements DisplayStrings {
    private Weapon weapon;
    private Actor target;

    /**
     * Random number generator
     */
    private Random rand = new Random();


    public SurroundingAttack(Actor target, Weapon weapon) {
        this.target = target;
        this.weapon = weapon;
    }

    /**
     * Doesn't necessarily have a target, so only parameter needed is the weapon used.
     */
    public SurroundingAttack(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        // Actor performs a spin attack
        String result = menuDescription(actor);

        // Damage dealt by weapon
        int damage = weapon.damage();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor targetActor = destination.getActor();
                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    if (target instanceof Skeleton && ((Skeleton) target).getPileOfBones()) {
                        return result + missPileOfBones(actor);
                    }
                    else {
                        return result + missEnemy(actor, targetActor);
                    }
                }
                else {
                    if (target instanceof Skeleton && ((Skeleton) target).getPileOfBones()) {
                        result += hitPileOfBones(actor, weapon, damage);
                    }
                    else{
                        result += hitEnemy(actor, targetActor, weapon, damage);
                    }
                    targetActor.hurt(damage);
                }
                if (!targetActor.isConscious()){
                    result += new DeathAction(actor).execute(targetActor, map);
                }
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        if (actor.hasCapability(Status.SLAM_ATTACK)){
            return actor + " slams its surroundings!";
        }
        return actor + " performs a Special Spin Attack!";
    }

}
