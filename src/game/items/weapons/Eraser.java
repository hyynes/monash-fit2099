package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SurroundingAttack;

/**
 * A weapon that will instantly kill any enemy.
 * Used for testing.
 *
 * Created by:
 * @author Kenan Baydar
 */
public class Eraser extends WeaponItem {

    public Eraser() {
        super("Eraser", 'E', 4000, "erases", 100);
    }

    @Override
    public Action getSkill(Actor holder) {
        return new SurroundingAttack(this);
    }
}
