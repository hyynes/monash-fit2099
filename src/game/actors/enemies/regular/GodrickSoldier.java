package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.Enemy;
import game.items.weapons.Uchigatana;
import game.utils.Status;

public class GodrickSoldier extends RegularEnemy {

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

    /**
     *
     * @return minimum number of runes the Godrick Soldier can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 38;
    }

    /**
     *
     * @return maximum number of runes the Godrick Soldier can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 70;
    }
}
