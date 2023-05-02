package game.Actors.Enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils.Status;

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
        this.runeMin = 313;
        this.runeMax = 1808;
    }

    /**
     *
     * @return The Giant Dog's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
    }
}
