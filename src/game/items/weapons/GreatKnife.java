package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A knife that deals 75 damage with 70% hit rate
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */
public class GreatKnife extends WeaponItem implements WeaponRunes{


    public GreatKnife() {
        super("Great Knife", '/', 75, "stabs", 70);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}


    /**
     *
     * @return The price at which the GreatKnife can be purchased from the Merchant.
     */
    @Override
    public int buyPrice() {
        return 3500;
    }

    /**
     *
     * @return The price at which the GreatKnife can be sold to the Merchant
     */
    @Override
    public int sellPrice() {
        return 350;
    }
}