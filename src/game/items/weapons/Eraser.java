package game.items.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

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
}
