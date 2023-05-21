package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.regular.GodrickSoldier;

/**
 * Environment that spawns Godrick Soldiers.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class Barrack extends Environment{

    /**
     * Constructor.
     *
     */
    public Barrack() {
        super('B');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn from the Barrack.
     */
    @Override
    public int getSpawnChance() {
        return 45;
    }

    /**
     *
     * @return The enemy that will spawn from the Barrack.
     */
    @Override
    public Actor spawningEnemy() {
        return new GodrickSoldier(target);
    }
}
