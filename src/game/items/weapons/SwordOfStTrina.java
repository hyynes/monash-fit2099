package game.items.weapons;
import game.utils.WeaponEffect;

import static game.utils.WeaponEffect.*;

public class SwordOfStTrina extends SellableWeapon implements PurchasableWeapon, Inflictable{

    /**
     * Constructor.
     *
     */
    public SwordOfStTrina() {
        super("Sword of St Trina", '|', 107, "slashes", 75);
    }

    @Override
    public WeaponEffect inflict() {
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
