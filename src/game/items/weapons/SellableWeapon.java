package game.items.weapons;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.utils.Status;

/**
 * An abstract class that weapons extend from if sellable to any trader.
 * Created by:
 * @author Kenan Baydar
 *
 */
public abstract class SellableWeapon extends WeaponItem {

    /**
     * Instantiation of the sellAction.
     */
    SellAction sell = new SellAction(this, sellPrice());;

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public SellableWeapon(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Checks whether a trader is nearby and if so, add a sellAction for the weapon.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        removeAction(sell);
        for (Exit exit: currentLocation.getExits()){
            if (exit.getDestination().containsAnActor()){
                if (exit.getDestination().getActor().hasCapability(Status.TRADER)){
                    addAction(sell);
                }
            }
        }
    }

    /**
     *
     * @return the price at which the weapon is sold.
     */
    public abstract int sellPrice();
}
