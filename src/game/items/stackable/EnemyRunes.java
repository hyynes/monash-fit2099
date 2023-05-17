package game.items.stackable;

/**
 * An interface to obtain the minimum and maximum number of runes an enemy can generate.
 *
 * Created by:
 * @author Kenan Baydar
 *
 */
public interface EnemyRunes {

    /**
     * get the minimum number of runes the enemy can generate after being killed.
     */
    int getRuneMin();

    /**
     * get the maximum number of runes the enemy can generate after being killed.
     */
    int getRuneMax();
}
