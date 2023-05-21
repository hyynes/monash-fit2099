package game.actors.friendly;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.BuyAction;
import game.actions.DeathAction;
import game.actions.SellAction;
import game.items.stackable.EnemyRunes;

/**
 * An interface to signify the player.
 *
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public interface PlayableCharacter {

    /**
     * Add Runes function.
     * Adds a number of runes to the player's inventory after defeating an enemy.
     *
     * @param enemy the enemy that drops the runes
     * @param enemyRunes the amount of runes that is dropped by the enemy
     * @see DeathAction
     */
    String enemyDefeatedRunes(Actor enemy, EnemyRunes enemyRunes);

    /**
     * Removes a number of runes from the player's inventory.
     *
     * @param removeRunes the amount of runes to be removed.
     * @return true or false on whether the player will have a positive amount of runes after removing runes.
     * @see BuyAction
     */
    boolean removeRunes(int removeRunes);

    /**
     * Removes a number of runes from the player's inventory.
     *
     * @param addRunes the amount of runes to be removed.
     * @return true or false on whether the player will have a positive amount of runes after adding runes.
     * @see SellAction
     */
    void addRunes(int addRunes);
}
