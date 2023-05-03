package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Resettable;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An abstract class to identify enemy actors.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public abstract class Enemy extends Actor implements Resettable {

    /**
     * Map object that stores all behaviours.
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Actor to follow.
     */
    protected final Actor target;


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param target      the Actor that the enemy will follow
     */
    public Enemy(String name, char displayChar, int hitPoints, Actor target) {
        super(name, displayChar, hitPoints);
        this.target = target;
        this.behaviours.put(998, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour(getTarget()));
        this.behaviours.put(996, new FollowBehaviour(target));
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // General playTurn step for all enemies
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }


    /**
     * The enemies can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A new action
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Checks if the Player has a weapon
            List<WeaponItem> weapons = new ArrayList<>(otherActor.getWeaponInventory());
            // If Player has a weapon, it may choose to either use it or its intrinsic weapon
            if (!weapons.isEmpty()) {
                // Use equipped weapon
                for (WeaponItem weapon : weapons) {
                    actions.add(weapon.getSkill(this));
                    actions.add(new AttackAction(this, this.getTarget(), direction, weapon));
                }
            } else {
                // Use intrinsic weapon
                actions.add(new AttackAction(this, this.getTarget(), direction));
            }
            // If player has no weapon in its inventory, it may only choose to use its intrinsic weapon.
            actions.add(new AttackAction(this, this.getTarget(), direction));
        }
        return actions;
    }

    /**
     * Resets the enemies
     *
     * @param map - the map that the actors are in.
     */
    @Override
    public void reset(GameMap map){
        map.removeActor(this);
    }

    /**
     *
     * @return Actor that the enemy will follow
     */
    public Actor getTarget() {
        return target;
    }

    /**
     * Maximum number of runes that can be obtained from an enemy
     */
    public int runeMax;

    /**
     * Minimum number of runes that can be obtained from an enemy
     */
    public int runeMin;

}
