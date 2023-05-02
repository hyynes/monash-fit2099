package game.Grounds.EnemyEnvironments;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Actors.Enemies.GiantDog;
import game.Actors.Enemies.LoneWolf;

/**
 * Environment that spawns giant dogs and lone wolves.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */
public class GustOfWind extends Environment {

    public GustOfWind() {
        super('&');
    }

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
