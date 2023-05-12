package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.actions.DespawnAction;

import java.util.Random;

/**
 * A Behaviour used on certain enemies that may despawn them by chance.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class DespawnBehaviour implements Behaviour{

    /**
     * Random number generator
     */
    private final Random random = new Random();


     /**
     * When executed, there is a 10% chance an enemy is despawned by creating a new despawnAction.
     *
     * @param actor The actor being removed from the game
     * @param map The map the actor is on.
     * @return description of the actor being removed for the menu UI
     * @see Enemy
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (random.nextInt(10) == 0) {
            return new DespawnAction();
        }
        return null;
    }
}
