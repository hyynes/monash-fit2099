package game.Utils;
import edu.monash.fit2099.engine.positions.Location;
import game.Actors.FriendlyActors.Player;

public class PlayerSpawnPoint {
    private Location spawnLocation;
    private PlayerSpawnPoint(){}
    private static PlayerSpawnPoint instance;
    public static PlayerSpawnPoint getInstance(){
        if (instance == null) {
            instance = new PlayerSpawnPoint();
        }
        return instance;
    }

    public Location getSpawnLocation(){
        return spawnLocation;
    }

    public void setSpawnLocation(Location location){
        spawnLocation = location;
    }
}
