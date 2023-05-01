package game.Actors.Enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils.Status;


/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */


/**
 * MY MESSAGE:
 * CAN IMPLEMENT 'playTurn' AND 'allowableActions' METHODS IN THE 'Enemy' ABSTRACT CLASS.
 * THIS IS BECAUSE ALL ENEMIES WILL HAVE THESE SAME METHODS.
 *
 */
public class LoneWolf extends Enemy {

    public LoneWolf(Actor target) {
        super("Lone Wolf", 'h', 102, target);
        this.addCapability(Status.FRIENDLY_TO_WOLF);
        this.runeMin = 55;
        this.runeMax = 1470;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}
