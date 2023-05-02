package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;

/**
 * A Giant Crab with 407 hp.
 * Deals 200 damage with a 90% hit rate.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */


public class GiantCrab extends Enemy{

    /**
     * Constructor.
     *
     * @param target Actor the Giant Crab will follow.
     */
    public GiantCrab(Actor target) {
        super("Giant Crab", 'C', 407, target);
        this.addCapability(Status.SLAM_ATTACK);
        this.addCapability(Status.FRIENDLY_TO_SEA);
        this.runeMin = 318;
        this.runeMax = 4961;
    }


    /**
     *
     * @return The Giant Crab's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
