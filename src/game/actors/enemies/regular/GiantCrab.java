package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.Enemy;
import game.utils.Status;

/**
 * A Giant Crab with 407 hp.
 * Deals 200 damage with a 90% hit rate.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */


public class GiantCrab extends RegularEnemy {

    /**
     * Constructor.
     *
     * @param target Actor the Giant Crab will follow.
     */
    public GiantCrab(Actor target) {
        super("Giant Crab", 'C', 407, target);
        this.addCapability(Status.SLAM_ATTACK);
        this.addCapability(Status.FRIENDLY_TO_SEA);
    }

    /**
     *
     * @return The Giant Crab's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    /**
     *
     * @return minimum number of runes the Giant Crab can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 318;
    }

    /**
     *
     * @return maximum number of runes the Giant Crab can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 4961;
    }
}
