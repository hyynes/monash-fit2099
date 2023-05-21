package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.weapons.BasiliskClaw;

import static game.utils.Status.IMMUNE_TO_ROT;

/**
 * Inhabitant of the Lake of Rot.
 * Created by:
 * @author Danny Duong
 */
public class Basilisk extends RegularEnemy{

    /**
     * Constructor.
     *
     */
    public Basilisk(Actor target) {
        super("Basilisk", 'J', 50, target);
        this.addCapability(IMMUNE_TO_ROT);
        this.addWeaponToInventory(new BasiliskClaw());
    }

    @Override
    public int getRuneMin() {
        return 130;
    }

    @Override
    public int getRuneMax() {
        return 819;
    }
}
