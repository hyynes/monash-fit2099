package game.items.weapons;

/**
 * An interface for weapons that can be purchased from traders.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public interface PurchasableWeapon {

    /**
     *
     * @return the price at which the weapon can be purchased from the trader.
     */
    int buyPrice();
}
