package game.items.stackable;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A consumable interface.
 * @author Danny Duong
 */
public interface Consumable {
    String consume(Actor actor, GameMap map);
}
