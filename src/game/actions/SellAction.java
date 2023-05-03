package game.actions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.friendly.PlayableCharacter;
import game.utils.Status;
import game.items.weapons.WeaponRunes;

/**
 * An action executed for when the player death (not to be confused with DeathAction)
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

/* Sell action allows Actor that is nearby a merchant to sell their items. In this case the player.
 Could possibly make another class that the player extends called 'PlayableCharacter', where all those players
have the capability to sell to the merchant, not just the player, to make it easier to extend the assignment. */
public class SellAction extends Action {
    private final WeaponItem weapon;

    /**
     * Constructor.
     * @param weapon the weapon to be sold.
     */
    public SellAction(WeaponItem weapon){
        this.weapon = weapon;
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
                        if (((PlayableCharacter) actor).addRunes(((WeaponRunes) weapon).sellPrice())){
                            actor.removeWeaponFromInventory(weapon);
                            return actor + " sold " + weapon + " for " + ((WeaponRunes) weapon).sellPrice() + " runes.";
                        }
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
        return actor + " sells " + weapon + " for " + ((WeaponRunes) weapon).sellPrice() + " runes.";
    }
}
