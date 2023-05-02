package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SurroundingAttack;
import game.actors.friendly.FriendlyActors;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class AttackBehaviour implements Behaviour {

    private final Actor targetsTarget;

    /**
     * Constructor.
     *
     * @param targetsTarget The Actor that the target is targeting in the Follow Behaviour.
     */
    public AttackBehaviour(Actor targetsTarget) {
        this.targetsTarget = targetsTarget;
    }

    /**
     * Method that returns all the weapons an actor is holding, otherwise returns null
     *
     * @param actor The actor that is holding the weapon
     * @return weapon the actor is holding.
     */
    public WeaponItem getWeapon(Actor actor) {
        for (WeaponItem weaponItem : actor.getWeaponInventory()) {
            return weaponItem;
        }
        return null;
    }


    /**
     * Returns an AttackAction to attack the another non-friendly Actor if nearby.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map){
        // location of where the actor is standing
        Location here = map.locationOf(actor);

        // looping through all the exits of where the actor is standing
        for (Exit exit : here.getExits()){

            // storing one of the exits in destination at a time
            Location destination = exit.getDestination();

            // Sees if there is an actor at that destination. If there is, then it is stored in adjacent. If not, null.
            Actor adjacent = map.getActorAt(destination);

            // If there is a target at that destination, which is stored in adjacent
            if (adjacent != null && !adjacent.equals(actor)) {

                // Determines if the adjacent actor is an enemy based on status
                FriendlyActors friendlyActors = new FriendlyActors(actor, adjacent);
                if (!friendlyActors.statusCheck()) {

                    // Get the name of the exit, store it in direction
                    String direction = exit.getName();

                    // Makes a list of actions, which is either going to be AttackAction or SurroundingAttack.
                    ActionList actions = new ActionList();

                    // Checks if the Enemy has a weapon or not. If so it uses the weapon, otherwise not.
                    if (getWeapon(actor)!= null) {
                        actions.add(new AttackAction(adjacent, targetsTarget, direction, getWeapon(actor)));
                        actions.add(getWeapon(actor).getSkill(actor));
                    }

                    // Checks if the enemy has a slam attack ability with no weapon
                    else if (actor.hasCapability(Status.SLAM_ATTACK)){
                        actions.add(new AttackAction(adjacent, targetsTarget, direction));
                        actions.add(new SurroundingAttack(actor.getIntrinsicWeapon()));
                    }
                    // Otherwise if actor has no weapon, use intrinsic weapon.
                    else {
                        return new AttackAction(adjacent, targetsTarget, direction);
                    }

                    // Randomly choose which attack, 50/50 chance
                    int randomNumber = RandomNumberGenerator.getRandomInt(100);
                    if (randomNumber < 50){
                        return actions.get(0);
                    }
                    return actions.get(1);
                }
            }
        }
        return null;
    }
}

