package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Status;
import game.behaviours.AttackBehaviour;
import java.util.Random;

/**
 * An Action for an Actor to attacks its surroundings.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public class SurroundingAttack extends Action{

    /**
     * Weapon used to attack its surroundings
     */
    private final Weapon weapon;

    /**
     * Random number generator
     */
    private final Random rand = new Random();

    /**
     * The Actor that is targeted by the target in followBehaviour.
     */
    private Actor targetsTarget;

    /**
     * Constructor.
     *
     * @param weapon Weapon used to execute the surrounding attack
     */
    public SurroundingAttack(Actor targetsTarget,Weapon weapon) {
        this.targetsTarget = targetsTarget;
        this.weapon = weapon;
    }

    public SurroundingAttack(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * When executed, the actor checks its surroundings, and if there is an enemy in its surroundings, it will
     * loop through all exits and attacks all its exits.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, whether the target is hit or not, since actor may miss.
     * @see AttackBehaviour
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        StringBuilder result = new StringBuilder(menuDescription(actor));

        // Damage dealt by weapon
        int damage = weapon.damage();

        // Checks if there is an enemy in surroundings, if so, loop through and attack all exits.
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor targetActor = destination.getActor();

                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    return result + System.lineSeparator() + actor + " misses " + targetActor + ".";
                }

                result.append(System.lineSeparator() + actor + " " + weapon.verb() + " " + targetActor + " for " + damage + " damage.");
                targetActor.hurt(damage);

                if (!targetActor.isConscious()){
                    if (targetActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        result.append(new PlayerDeathAction(actor).execute(targetActor, map));;
                    }
                    else{
                        result.append(new DeathAction(actor,targetsTarget).execute(targetActor, map));
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * Describes which actor attacks its surroundings
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        if (actor.hasCapability(Status.SLAM_ATTACK)){
            return actor + " slams its surroundings!";
        }
        return actor + " performs a Special Spin Attack!";
    }

}
