package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;

/**
 * A Giant Dog with 693 hp.
 * Deals 314 damage with a 90% hit rate.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public class GiantDog extends Enemy{

    /**
     * Constructor.
     *
     * @param target Actor the Giant Dog will follow.
     */
    public GiantDog(Actor target) {
        super("Giant Dog", 'G', 693, target);
        this.addCapability(Status.SLAM_ATTACK);
        this.addCapability(Status.FRIENDLY_TO_WOLF);
    }

    /**
     *
     * @return The Giant Dog's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
    }

    /**
     *
     * @return minimum number of runes the Giant Dog can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 313;
    }

    /**
     *
     * @return maximum number of runes the Giant Dog can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 1808;
    }
}
