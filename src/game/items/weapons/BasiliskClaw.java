package game.items.weapons;

import game.utils.StatusEffect;

import static game.utils.StatusEffect.SCARLET_ROT;

public class BasiliskClaw extends SellableWeapon implements Inflictable{

    /**
     * Constructor.
     */
    public BasiliskClaw() {
        super("Basilisk Claw", 'C', 103, "slashes", 85);
    }

    @Override
    public StatusEffect inflict() {
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
