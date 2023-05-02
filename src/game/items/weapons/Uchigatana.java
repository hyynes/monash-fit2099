package game.items.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A knife that deals 115 damage with 80% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */

public class Uchigatana extends WeaponItem implements WeaponRunes {

    /**
     * Constructor.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "thrusts", 80);
    }

    /**
     *
     * @return The price at which the Uchigatana can be purchased from the Merchant
     */
    @Override
    public int buyPrice() {
        return 5000;
    }

    /**
     *
     * @return The price at which the Uchigatana can be sold to the Merchant
     */
    public int sellPrice(){
        return 500;
    }
}
