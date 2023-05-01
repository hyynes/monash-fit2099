package game.Actors.FriendlyActors;
import edu.monash.fit2099.engine.positions.Location;

public class PlayerSpawnPoint {
    private Location spawnLocation;
    private PlayerSpawnPoint(){}
    private static PlayerSpawnPoint instance;
    public static PlayerSpawnPoint getInstance(){
       return instance;
    }

    public Location getSpawnLocation(){
        return spawnLocation;
    }

    public void setSpawnLocation(){

    }
}
