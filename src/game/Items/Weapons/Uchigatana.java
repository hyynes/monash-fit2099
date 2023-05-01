package game.Items.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Utils.Status;

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
        super("Uchigatana", ')', 115, "thrusts", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int buyPrice() {
        return 5000;
    }

    public int sellPrice(){
        return 500;
    }
}
