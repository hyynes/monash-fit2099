package game;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemies.Skeleton;

public class PileOfBones{
    private Actor actor;
    private Boolean pileOfBones = false;
    private int turnsAfterDeath;
    public PileOfBones() {
        turnsAfterDeath = 0;
    }

    public boolean checkState(Actor actor, int deathTimer, int maxHitPoints, boolean pileOfBone) {
        if (pileOfBone) {
            if (deathTimer >= 3) {
                actor.heal(maxHitPoints);
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
