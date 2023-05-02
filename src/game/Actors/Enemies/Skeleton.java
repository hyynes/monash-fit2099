package game.Actors.Enemies;

/**
 * An interface to manage when a skeleton turns into bones.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */

public interface Skeleton {

    // Sets the value of how many turns Pile of Bones has till its revived.
    void setTurnsAfterDeath(int turnsAfterDeath);

    // Returns true or false whether the skeleton is a Pile of Bones or not
    boolean getPileOfBones();

    // Sets the Pile of Bones state as either true or false
    void setPileOfBones(boolean pileOfBones);

    // Gets the display char of the Skeleton
    char getOriginalDisplayChar();

}
