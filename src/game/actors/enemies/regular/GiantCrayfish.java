package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.Enemy;
import game.utils.Status;

/**
 * A Giant Crayfish with 4803 hp.
 * Deals 527 damage with a 100% hit rate.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public class GiantCrayfish extends RegularEnemy {

    /**
     * Constructor.
     *
     * @param target Actor the Giant Crayfish will follow.
     */
    public GiantCrayfish(Actor target) {
        super("Giant Crayfish", 'R', 4803, target);
        this.addCapability(Status.SLAM_ATTACK);
        this.addCapability(Status.FRIENDLY_TO_SEA);
    }

    /**
     *
     * @return The Giant Crayfish's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "uses its Giant Pincer to slam", 100);
    }

    /**
     *
     * @return minimum number of runes the Giant Crayfish can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 500;
    }

    /**
     *
     * @return maximum number of runes the Giant Crayfish can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 2374;
    }
}
