package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.friendly.MerchantKale;
import game.actors.friendly.PlayableCharacter;
import game.utils.Status;
import game.items.weapons.PurchasableWeapon;

/**
 * For buying stuff.
 * Created by:
 * @author Danny Duong
 * Modifiers:
 * @modifier Kenan Baydar
 */
public class BuyAction extends Action{

    private final WeaponItem weapon;


    public BuyAction(WeaponItem weapon){
        this.weapon = weapon;
    }

    /**
     * Buy action allows Actor that is nearby to purchase from the merchant. merchant class will use this class.
     * Can check the merchants surrounding, if there is an actor nearby that has the status HOSTILE_TO_ENEMY,
     * allow buyAction.
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @see MerchantKale
     * @return a message whether the weapon is bought or not, or if the player doesn't have enough runes.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor merchantActor = destination.getActor();
                if (merchantActor.hasCapability(Status.TRADER)) {
                    if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        if(merchantActor.hasCapability(Status.FINGER_READER)){
                            actor.addWeaponToInventory(weapon);
                            return actor + " recieves " + weapon;
                        }
                        else if (((PlayableCharacter) actor).removeRunes(((PurchasableWeapon) weapon).buyPrice())){
                            actor.addWeaponToInventory(weapon);
                            return actor + " purchased " + weapon + " for " + ((PurchasableWeapon) weapon).buyPrice() + " runes.";
                        }
                        else {
                            return actor + " does not have enough runes to purchase " + weapon + "!";
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
     * @return a menu option describing the weapon being bought and its price.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + weapon + " for " + ((PurchasableWeapon) weapon).buyPrice() + " runes.";
    }
}
