package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface Skeleton {
    int getTurnsAfterDeath();
    void setTurnsAfterDeath(int turnsAfterDeath);
    void revive(GameMap map, Location location);
}
