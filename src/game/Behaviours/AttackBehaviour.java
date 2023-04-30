package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Actions.SurroundingAttack;
import game.FriendlyActors;
import game.RandomNumberGenerator;
import game.Status;

public class AttackBehaviour implements Behaviour {

    /**
     * Constructor.
     */
    public AttackBehaviour() {
    }
    // Method that returns the weapon an actor is holding, otherwise returns null
    public Weapon getWeapon(Actor actor) {
        for (Item weaponItem : actor.getWeaponInventory()) {
            if (weaponItem instanceof WeaponItem) {
                return (Weapon) weaponItem;
            }
        }
        return null;
    }

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
                    actions.add(new AttackAction(adjacent, direction, getWeapon(actor)));
                    actions.add(getWeapon(actor).getSkill(actor));
                }

                // Checks if the enemy has a slam attack ability with no weapon
                else if (actor.hasCapability(Status.SLAM_ATTACK)){
                    actions.add(new AttackAction(adjacent, direction));
                    actions.add(new SurroundingAttack(adjacent, actor.getIntrinsicWeapon()));
                }
                // Otherwise if actor has no weapon, use intrinsic weapon.
                else {
                    return new AttackAction(adjacent, direction);
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

