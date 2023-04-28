package game.Weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.SurroundingAttack;

public class Grossmesser extends WeaponItem{

    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slashes", 85);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

}
