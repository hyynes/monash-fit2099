package game.Grounds.EnemyEnvironments;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Application;
import game.Utils.RandomNumberGenerator;

/**
 * Abstract class to denote enemy environments.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public abstract class Environment extends Ground{

    protected static Actor target;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Environment(char displayChar) {
        super(displayChar);
    }

    /**
     * Tick function to see if the location can spawn an enemy.
     * @param location The location of the environment
     */

    @Override
    public void tick(Location location)
    {
        int randomNumber = RandomNumberGenerator.getRandomInt(100);
        if (randomNumber < getSpawnChance()){
            if (!location.containsAnActor()) {
                location.addActor((spawningEnemy()));
            }
        }
    }

    /**
     * Gets spawn chance of enemy.
     * @return spawn chance of enemy
     */

    public abstract int getSpawnChance();

    /**
     * Function to spawn the enemy.
     * @return Enemy to be spawned.
     */
    public abstract Actor spawningEnemy();

    /**
     * Initializes the environment.
     * @param actor the player to be targeted.
     * @see Application
     */
    public static void setTarget(Actor actor) {
        target = actor;
    }
}
