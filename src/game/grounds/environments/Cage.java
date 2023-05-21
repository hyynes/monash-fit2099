package game.grounds.environments;
import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.regular.Dog;

/**
 * Environment that spawns dogs.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class Cage extends Environment{

    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }

    /**
     * Spawn chance of enemies.
     *
     * @return the chance that a certain enemy will spawn from the Cage.
     */
    @Override
    public int getSpawnChance() {
        return 37;
    }

    /**
     *
     * @return The enemy that will spawn from the Cage
     */
    @Override
    public Actor spawningEnemy() {
        return new Dog(target);
    }
}
