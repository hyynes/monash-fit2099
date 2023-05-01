package game.Actors;

import edu.monash.fit2099.engine.actors.Actor;

public interface PlayableCharacter {
    String addRunes(Actor enemy, int min, int max);
    boolean removeRunes(int removeRunes);

}
