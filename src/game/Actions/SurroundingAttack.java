package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Utils.Status;

import java.util.Random;

/**
 * Class that allows the actor to attack its surrounding with its weapon, including intrinsic weapon.
 *
 */
public class SurroundingAttack extends Action{
    private final Weapon weapon;
    private Actor target;

    /**
     * Random number generator
     */
    private final Random rand = new Random();


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
        StringBuilder result = new StringBuilder(menuDescription(actor));

        // Damage dealt by weapon
        int damage = weapon.damage();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor targetActor = destination.getActor();
                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    return result + System.lineSeparator() + actor + " misses " + target + ".";
                }

                result.append(System.lineSeparator() + " " + weapon.verb() + " " + target + " for " + damage + " damage.");
                targetActor.hurt(damage);

                if (!targetActor.isConscious()){
                    if (targetActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        result.append(new PlayerDeathAction(actor).execute(targetActor, map));;
                    }
                    else{
                        result.append(new DeathAction(actor).execute(targetActor, map));
                    }
                }
            }
        }
        return result.toString();
    }

    @Override
    public String menuDescription(Actor actor) {
        if (actor.hasCapability(Status.SLAM_ATTACK)){
            return actor + " slams its surroundings!";
        }
        return actor + " performs a Special Spin Attack!";
    }

}
