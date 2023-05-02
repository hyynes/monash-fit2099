package game.Items.Weapons;

/**
 * An interface to manage rune prices of weapons.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public interface WeaponRunes {

    /**
     *
     * @return the price at which the weapon can be purchased from the merchant.
     */
    int buyPrice();

    /**
     *
     * @return the price at which the weapon can be sold to the merchant.
     */
    int sellPrice();
}
