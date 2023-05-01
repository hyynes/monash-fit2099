package game.Weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A knife that deals 115 damage with 80% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class Uchigatana extends WeaponItem implements WeaponRunes {

    // Constructor
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int runePrice() {
        return 5000;
    }
}
