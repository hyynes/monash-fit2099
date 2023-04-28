package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class SurroundingAttack extends Action {
    private final int damage;
    private final int accuracy;

    public SurroundingAttack(int damage, int accuracy) {
        this.damage = damage;
        this.accuracy = accuracy;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                target.hurt(damage);
            }
        }
        return System.lineSeparator() + menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs a spin attack";
    }

}
