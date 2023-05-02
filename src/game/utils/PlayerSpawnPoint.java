package game.utils;
import edu.monash.fit2099.engine.positions.Location;
import game.Application;

/**
 * A spawn point manager.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class PlayerSpawnPoint {
    private Location spawnLocation;
    private PlayerSpawnPoint(){}
    private static PlayerSpawnPoint instance;

    /**
     * Instance getter.
     * @return a singleton instance of PlayerSpawnPoint
     * @see Application
     */
    public static PlayerSpawnPoint getInstance(){
        if (instance == null) {
            instance = new PlayerSpawnPoint();
        }
        return instance;
    }

    /**
     * Gets the location of the player spawn point.
     * @return the spawn Location.
     */
    public Location getSpawnLocation(){
        return spawnLocation;
    }

    /**
     * Sets the location of the player spawn point.
     * @param location - the new spawn location.
     */
    public void setSpawnLocation(Location location){
        spawnLocation = location;
    }
}
