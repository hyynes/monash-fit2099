package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;


/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */

public class LoneWolf extends Enemy {

    /**
     * Constructor.
     *
     * @param target Actor the Lone Wolf will follow.
     */
    public LoneWolf(Actor target) {
        super("Lone Wolf", 'h', 102, target);
        this.addCapability(Status.FRIENDLY_TO_WOLF);
        this.runeMin = 55;
        this.runeMax = 1470;
    }

    /**
     *
     * @return The Lone Wolf's Intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}
