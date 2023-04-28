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
import game.RandomNumberGenerator;

public class AttackBehaviour implements Behaviour {

    private final Actor target;

    /**
     * Constructor.
     *
     * @param actor the Actor to attack
     */
    public AttackBehaviour(Actor actor){
        this.target = actor;
    }


    // Method that returns the weapon an actor is holding, otherwise returns null
    public Weapon getWeapon(Actor actor){
        for (Item weaponItem : actor.getWeaponInventory()) {
            if (weaponItem instanceof WeaponItem) {
                return (Weapon) weaponItem;
            }
        }
        return null;
    }



    @Override
    public Action getAction(Actor actor, GameMap map){
        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()){
            Location destination = exit.getDestination();
            //Checks if the enemy has the spin attack ability
            /**
             * if (spinAttack(actor)!= null{
             *    for (Exit exit: here.getExits()){
             *       String direction = exit.getName()
             *       List of attack actions, then returns all the attackActions, so it attacks in all exits.
             *       Attacks its surroundings.
             */
            Actor adjacent = map.getActorAt(destination);
            if (adjacent != null && adjacent.equals(target)) {
                String direction = exit.getName();

                // Checks if the Enemy has a weapon or not. If so it uses the weapon, otherwise not.
                if (getWeapon(actor)!= null){
                    ActionList actions = new ActionList();
                    actions.add(new AttackAction(target,direction,getWeapon(actor)));
                    actions.add(new SurroundingAttack(0,1));
                    int randomNumber = RandomNumberGenerator.getRandomInt(0,100);
                        if (randomNumber <= 50){
                            return actions.get(0);
                        }
                        return actions.get(1);
                    }
                }
                else{
                    return new AttackAction(target,direction);
                }
            }
        }
        return null;

    }

}
