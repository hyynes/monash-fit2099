package game.actors.enemies.regular;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;

/**
 * An abstract class to be extended from normal enemies.
 * Normal enemies have a 10% chance to despawn after each turn if not following or attacking a player.
 * Normal enemies are also removed from the game after the game is reset.
 * Created by:
 * @author Kenan Baydar
 */
public abstract class RegularEnemy extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param target      the Actor that the enemy will follow
     */
    public RegularEnemy(String name, char displayChar, int hitPoints, Actor target) {
        super(name, displayChar, hitPoints, target);
    }

    /**
     * Resets the enemies, removing them from the game.
     *
     * @param map - the map that the actors are in.
     */
    @Override
    public void reset(GameMap map){
        callReset = true;
    }
}
