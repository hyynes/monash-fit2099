package game.Actors.Enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Items.Weapons.Scimitar;

public class SkeletalBandit extends Enemy implements Skeleton{

    public SkeletalBandit(Actor target) {
        super("Skeletal Bandit", 'b', 184, target);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        this.addWeaponToInventory(new Scimitar());
        this.runeMin = 35;
        this.runeMax = 892;
    }

    @Override
    public final char getOriginalDisplayChar() {
        return 'b';
    }
}
