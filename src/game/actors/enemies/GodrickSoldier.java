package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.weapons.Uchigatana;
import game.utils.Status;

public class GodrickSoldier extends Enemy {

    /**
     * Constructor.
     *
     * @param target Actor the Godrick Soldier will follow.
     */
    public GodrickSoldier(Actor target) {
        super("Godrick Soldier", 'p', 198, target);
        this.addCapability(Status.FRIENDLY_TO_CASTLE);
        this.addWeaponToInventory(new Uchigatana());
    }

    @Override
    public int getRuneMin() {
        return 38;
    }

    @Override
    public int getRuneMax() {
        return 70;
    }
}
