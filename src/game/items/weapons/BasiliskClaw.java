package game.items.weapons;

import game.utils.WeaponEffect;

import static game.utils.WeaponEffect.SCARLET_ROT;
import static game.utils.WeaponEffect.SLEEP;

public class BasiliskClaw extends SellableWeapon implements Inflictable{

    /**
     * Constructor.
     */
    public BasiliskClaw() {
        super("Basilisk Claw", 'C', 103, "slashes", 85);
    }

    @Override
    public WeaponEffect inflict() {
        return SCARLET_ROT;
    }

    @Override
    public int inflictTimer() {
        return 2;
    }

    @Override
    public int sellPrice() {
        return 180;
    }
}
