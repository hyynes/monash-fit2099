package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.Weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Enemy implements Skeleton{

    public HeavySkeletalSwordsman(Actor target) {
        super("Heavy Skeletal Swordsman", 'q', 153, target);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        this.addWeaponToInventory(new Grossmesser());
        this.runeMin = 35;
        this.runeMax = 892;
    }

    @Override
    public final char getOriginalDisplayChar() {
        return 'q';
    }

}
