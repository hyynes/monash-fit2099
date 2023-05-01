package game.Grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemies.Skeleton;

/**
 * For when a skeleton dies.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */
public class PileOfBones{

    public boolean checkState(Actor actor, int deathTimer, boolean pileOfBone) {
        if (pileOfBone) {
            if (deathTimer >= 3) {
                ((Skeleton) actor).setPileOfBones(false);
                ((Skeleton) actor).setTurnsAfterDeath(0);
                return false;
            } else {
                return true;
            }
        }

        return false;
    }
}
