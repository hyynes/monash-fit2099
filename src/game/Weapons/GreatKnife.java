package game.Weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A knife that deals 75 damage with 70% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public class GreatKnife extends WeaponItem implements WeaponRunes{


    public GreatKnife() {
        super("Great Knife", '/', 75, "stabs", 70);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}


    @Override
    public int buyPrice() {
        return 3500;
    }

    @Override
    public int sellPrice() {
        return 350;
    }
}