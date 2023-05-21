package game.items.weapons;
import game.utils.StatusEffect;

import static game.utils.StatusEffect.*;

public class SwordOfStTrina extends SellableWeapon implements PurchasableWeapon, Inflictable{

    /**
     * Constructor.
     *
     */
    public SwordOfStTrina() {
        super("Sword of St Trina", '|', 107, "slashes", 75);
    }

    @Override
    public StatusEffect inflict() {
        return SLEEP;
    }

    @Override
    public int inflictTimer() {
        return 2;
    }

    @Override
    public int buyPrice() {
        return 4500;
    }

    @Override
    public int sellPrice() {
        return 180;
    }
}
