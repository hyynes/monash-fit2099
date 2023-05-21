package game.items.weapons;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Kenan Baydar
 */
public class Club extends SellableWeapon implements PurchasableWeapon {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     *
     * @return The price at which the Club can be purchased from the trader.
     */
    public int buyPrice(){
        return 600;
    }

    /**
     *
     * @return The price at which the Club can be sold to the trader.
     */
    public int sellPrice(){
        return 100;
    }

}
