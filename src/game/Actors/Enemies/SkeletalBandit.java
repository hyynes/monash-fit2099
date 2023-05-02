package game.Actors.Enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Items.Weapons.Scimitar;

/**
 * A Skeletal Bandit with 184 hp.
 * Carries around a Scimitar weapon.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public class SkeletalBandit extends Enemy{

    /**
     * Constructor.
     *
     * @param target Actor the Skeletal Bandit will follow.
     */
    public SkeletalBandit(Actor target) {
        super("Skeletal Bandit", 'b', 184, target);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        this.addCapability(Status.SECOND_LIFE);
        this.addWeaponToInventory(new Scimitar());
    }
}
