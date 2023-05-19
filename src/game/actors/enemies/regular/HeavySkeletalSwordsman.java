package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.Enemy;
import game.utils.Status;
import game.items.weapons.Grossmesser;

/**
 * A Heavy Skeletal Swordsman with 153 hp.
 * Carries around a Grossmesser weapon.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public class HeavySkeletalSwordsman extends RegularEnemy {

    /**
     * Constructor.
     *
     * @param target Actor the Heavy Skeletal Swordsman will follow.
     */
    public HeavySkeletalSwordsman(Actor target) {
        super("Heavy Skeletal Swordsman", 'q', 153, target);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        this.addCapability(Status.SECOND_LIFE);
        this.addWeaponToInventory(new Grossmesser(target));
    }

    /**
     *
     * @return minimum number of runes the Heavy Skeletal Swordsman can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 35;
    }

    /**
     *
     * @return maximum number of runes the Heavy Skeletal Swordsman can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 892;
    }
}
