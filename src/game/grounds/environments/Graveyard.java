package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.utils.Status;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;

/**
 * Environment that spawns skeletal bandits and swordsmen.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class Graveyard extends Environment {

    /**
     * Initialises how the Graveyard will be displayed on the map.
     */
    public Graveyard() {
        super('n');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn depending on whether the Graveyard is located east
     * or west of the map.
     */
    @Override
    public int getSpawnChance() {
        return 27;
    }

    /**
     * The enemy that will spawn from the Gust of Wind
     *
     * @return A certain actor depending on whether the Graveyard is located east or west of the mop.
     */
    @Override
    public Actor spawningEnemy() {
        if (this.hasCapability(Status.EAST)) {
            return new SkeletalBandit(target);
        }
        else if (this.hasCapability(Status.WEST)){
            return new HeavySkeletalSwordsman(target);
        }
        return null;
    }


}
