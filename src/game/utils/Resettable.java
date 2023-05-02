package game.utils;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong
 */
public interface Resettable {

    /**
     * Reset function.
     * @param map - the map that the actors are in.
     * @see ResetManager
     */
    void reset(GameMap map);
}
