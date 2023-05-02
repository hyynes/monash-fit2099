package game.actors.friendly;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyAction;
import game.actions.SellAction;
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

public class Merchant extends Actor{

    public Merchant(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.TRADER);
        this.addWeaponToInventory(new Club());
        this.addWeaponToInventory(new Scimitar());
        this.addWeaponToInventory(new GreatKnife());
        this.addWeaponToInventory(new Uchigatana());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    // iterate through all the Merchants inventory.
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        // make an action list that stores all the possible actions on the Merchant.
        // This would be all the weapons able to be purchased from him.
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // A list that will store all weapons that the merchant has.
            List<WeaponItem> purchaseWeapons = new ArrayList<>(this.getWeaponInventory());

            // If Player has a weapon, it may choose to either use it or its intrinsic weapon
            if (!purchaseWeapons.isEmpty()) {
                for (WeaponItem weapon : purchaseWeapons) {
                    actions.add(new BuyAction(weapon));
                }
            }
            // A list that will store all weapons that the other actor has, in this case, the Player.
            List<WeaponItem> sellWeapons = new ArrayList<>(otherActor.getWeaponInventory());
            if (!sellWeapons.isEmpty()) {
                for (WeaponItem weapon : sellWeapons) {
                    actions.add(new SellAction(weapon));
                }
            }

        }
        return actions;
    }
}
