package game.Items.Weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Kenan Baydar
 */
public class Club extends WeaponItem implements WeaponRunes{

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     *
     * @return The price at which the Club can be purchased from the Merchant.
     */
    public int buyPrice(){
        return 600;
    }

    /**
     *
     * @return The price at which the Club can be sold to the Merchant
     */
    public int sellPrice(){
        return 100;
    }
}
