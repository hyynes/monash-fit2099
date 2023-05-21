package game.items.weapons;

/**
 * A knife that deals 115 damage with 80% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */

public class Uchigatana extends SellableWeapon implements PurchasableWeapon {

    /**
     * Constructor.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "thrusts", 80);
    }

    /**
     *
     * @return The price at which the Uchigatana can be purchased from the trader.
     */
    @Override
    public int buyPrice() {
        return 5000;
    }

    /**
     *
     * @return The price at which the Uchigatana can be sold to the trader.
     */
    public int sellPrice(){
        return 500;
    }
}
