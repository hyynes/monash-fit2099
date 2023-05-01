package game.Actors.FriendlyActors;

import edu.monash.fit2099.engine.actors.Actor;

public interface PlayableCharacter {
    String enemyDefeatedRunes(Actor enemy, int min, int max);
    boolean removeRunes(int removeRunes);
    boolean addRunes(int addRunes);

}
