package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;

public class GiantDog extends Enemy{
    public GiantDog(Actor target) {
        super("Giant Dog", 'G', 693, target);
        this.addCapability(Status.SLAM_ATTACK);
        this.addCapability(Status.FRIENDLY_TO_WOLF);
        this.runeMin = 313;
        this.runeMax = 1808;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
    }
}