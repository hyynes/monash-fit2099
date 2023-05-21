package game.actors.friendly;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyAction;
import game.utils.Status;
import game.items.weapons.*;
import java.util.ArrayList;
import java.util.List;

/**
 * For buying stuff.
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 *
 */

public class Merchant extends Actor {

    /**
     * Constructor. Adds weapons to the merchant's inventory: a club, a scimitar, a great knife and an uchigatana.
     *
     */
    public Merchant() {
        super("Merchant Kale", 'K', 100);
        this.addCapability(Status.TRADER);
        merchantsShop();
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        List<WeaponItem> purchaseWeapons = new ArrayList<>(this.getWeaponInventory());
        if (!purchaseWeapons.isEmpty()) {
            for (WeaponItem weapon : purchaseWeapons) {
                this.removeWeaponFromInventory(weapon);
            }
        }
        merchantsShop();
        return new DoNothingAction();
    }

    /**
     * To check if a player is in the merchant's surroundings. If so, allow SellAction and BuyAction.
     * @param otherActor the other Actor
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return all SellActions and BuyActions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // A list that will store all weapons that the merchant has.
            List<WeaponItem> purchaseWeapons = new ArrayList<>(this.getWeaponInventory());
            if (!purchaseWeapons.isEmpty()) {
                for (WeaponItem weapon : purchaseWeapons) {
                    actions.add(new BuyAction(weapon));
                }
            }
        }
        return actions;
    }

    public void merchantsShop(){
        this.addWeaponToInventory(new Club());
        this.addWeaponToInventory(new Scimitar());
        this.addWeaponToInventory(new GreatKnife());
        this.addWeaponToInventory(new Uchigatana());
    }
}
