package game.items.weapons;

/**
 * A knife that deals 75 damage with 70% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */
public class GreatKnife extends SellableWeapon implements PurchasableWeapon {


    public GreatKnife() {
        super("Great Knife", '/', 75, "stabs", 70);
    }

    /**
     *
     * @return The price at which the GreatKnife can be purchased from the trader.
     */
    @Override
    public int buyPrice() {
        return 3500;
    }

    /**
     *
     * @return The price at which the GreatKnife can be sold to the trader.
     */
    @Override
    public int sellPrice() {
        return 350;
    }
}