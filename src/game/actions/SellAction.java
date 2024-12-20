package game.actions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.friendly.PlayableCharacter;
import game.utils.Status;

/**
 * An action executed for when the player sells an item
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public class SellAction extends Action {
    private final WeaponItem weapon;

    private final int sellPrice;

    /**
     * Constructor.
     * @param weapon the weapon to be sold.
     */
    public SellAction(WeaponItem weapon, int sellPrice){
        this.weapon = weapon;
        this.sellPrice = sellPrice;
    }

    /**
     * Checks if an item can be sold. If it can, sell it.
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return a message to be displayed to the UI.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor merchantActor = destination.getActor();
                if (merchantActor.hasCapability(Status.TRADER)) {
                    if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        ((PlayableCharacter) actor).addRunes(sellPrice);
                        actor.removeWeaponFromInventory(weapon);
                        return actor + " sold " + weapon + " for " + sellPrice + " runes.";
                    }
                }
            }
        }
        return null;
    }

    /**
     * Menu description.
     * @param actor The actor performing the purchase action.
     * @return an option displaying the weapon being sold and its price.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + weapon + " for " + sellPrice + " runes.";
    }
}
