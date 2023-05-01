package game.Utils;
import edu.monash.fit2099.engine.positions.Location;

public class PlayerSpawnPoint {
    private Location spawnLocation;
    private PlayerSpawnPoint(){}
    private static PlayerSpawnPoint instance = null;
    public static PlayerSpawnPoint getInstance(){
        if (instance == null){
            instance = new PlayerSpawnPoint();
        }
        return instance;
    }

    public Location getSpawnLocation(){
        return spawnLocation;
    }

    public void setSpawnLocation(Location newLocation){
        this.spawnLocation = newLocation;
    }
}
