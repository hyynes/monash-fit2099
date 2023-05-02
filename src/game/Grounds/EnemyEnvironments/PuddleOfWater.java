package game.Grounds.EnemyEnvironments;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Actors.Enemies.GiantCrab;
import game.Actors.Enemies.GiantCrayfish;

/**
 * Water that spawns giant crabs and crayfish.
 * Created by:
 * @author Kenan Baydar
 *
 */

public class PuddleOfWater extends Environment {

    /**
     * Initialises how the Puddle of Water will be displayed on the map.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn depending on whether the Puddle of Water is located east
     * or west of the map.
     */
    @Override
    public int getSpawnChance() {
        if (this.hasCapability(Status.EAST)) {
            return 1;
        }
        else if (this.hasCapability(Status.WEST)){
            return 2;
        }
        return 0;
    }

    /**
     * The enemy that will spawn from the Gust of Wind
     *
     * @return A certain actor depending on whether the Puddle of Water is located east or west of the mop.
     */
    @Override
    public Actor spawningEnemy(){
        if (this.hasCapability(Status.EAST)) {
            return new GiantCrayfish(target);
        }
        else if(this.hasCapability(Status.WEST)){
            return new GiantCrab(target);
        }
        return null;
    }
}
