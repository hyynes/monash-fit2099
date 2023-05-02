package game.Displays;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Interface used to display messages on screen when attacking an enemy with weapon.
 *
 */
public interface DisplayStrings {

    default String missPileOfBones(Actor actor){
        return System.lineSeparator() + actor + " misses Pile of Bones.";
    }
    default String missEnemy(Actor actor, Actor target){
        return System.lineSeparator() + actor + " misses " + target + ".";
    }

    default String hitPileOfBones(Actor actor, Weapon weapon, int damage){
        return System.lineSeparator() + actor + " " + weapon.verb() + " Pile of Bones for " + damage + " damage.";
    }

    default String hitEnemy(Actor actor, Actor target, Weapon weapon, int damage) {
        return System.lineSeparator() + actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
    }
}
