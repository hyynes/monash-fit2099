package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.GodrickSoldier;

public class Barrack extends Environment{

    public Barrack() {
        super('B');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn depending on whether the Graveyard is located east
     * or west of the map.
     */
    @Override
    public int getSpawnChance() {
        return 45;
    }

    /**
     * The enemy that will spawn from the Gust of Wind
     *
     * @return A certain actor depending on whether the Graveyard is located east or west of the mop.
     */
    @Override
    public Actor spawningEnemy() {
        return new GodrickSoldier(target);
    }
}
