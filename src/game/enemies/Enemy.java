package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.Behaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class to identify enemy actors.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public abstract class Enemy extends Actor {


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    public int runeMax;
    public int runeMin;
}
