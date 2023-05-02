package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.utils.Status;
import game.actors.enemies.GiantDog;
import game.actors.enemies.LoneWolf;

/**
 * Environment that spawns giant dogs and lone wolves.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class GustOfWind extends Environment {

    /**
     * Initialises how the Gust of Wind will be displayed on the map.
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn depending on whether the Gust of Wind is located east
     * or west of the map.
     */
    @Override
    public int getSpawnChance() {
        if (this.hasCapability(Status.EAST)){
            return 4;
        }
        else if (this.hasCapability(Status.WEST)){
            return 33;
        }
        return 0;
    }

    /**
     * The enemy that will spawn from the Gust of Wind
     *
     * @return A certain actor depending on whether the Gust of Wind is located east or west of the mop.
     */
    @Override
    public Actor spawningEnemy(){
        if (this.hasCapability(Status.EAST)) {
            return new GiantDog(target);
        }
        else if (this.hasCapability(Status.WEST)){
            return new LoneWolf(target);
        }
        return null;
    }
}
