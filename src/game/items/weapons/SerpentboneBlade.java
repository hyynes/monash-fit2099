package game.items.weapons;
import game.utils.WeaponEffect;

import static game.utils.WeaponEffect.*;

public class SerpentboneBlade extends SellableWeapon implements PurchasableWeapon, Inflictable{

    /**
     * Constructor.
     */
    public SerpentboneBlade() {
        super("Serpentbone Blade", '>', 120, "slashes", 85);
    }

    /**
     *
     * @return The price at which the Serpentbone Blade can be purchased from the trader.
     */
    @Override
    public int buyPrice() {
        return 4500;
    }

    /**
     *
     * @return The price at which the Serpentbone Blade can be sold to the trader.
     */
    @Override
    public int sellPrice() {
        return 200;
    }


    @Override
    public WeaponEffect inflict() {
        return POISON;
    }

    @Override
    public int inflictTimer(){
        return 3;
    }
}
