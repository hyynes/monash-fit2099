package game.actors.enemies;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.*;
import game.items.stackable.EnemyRunes;
import game.utils.Resettable;
import game.utils.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static game.utils.WeaponEffect.*;

/**
 * An abstract class to identify enemy actors.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */

public abstract class Enemy extends Actor implements Resettable, EnemyRunes {

    /**
     * Map object that stores all behaviours.
     */
    protected final Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Actor to follow.
     */
    protected final Actor target;

    /**
     * When reset is called, so it can display enemy despawns on screen.
     */
    protected boolean callReset = false;


    protected ArrayList<StatusManager> statuses  = new ArrayList<StatusManager>();
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
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(998, new DespawnBehaviour());
        this.behaviours.put(997, new FollowBehaviour(target));
        this.behaviours.put(996, new AttackBehaviour(target));
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
        // If reset is called despawn all enemies and print to screen.
        if (callReset){
            callReset = false;
            return new DespawnAction();
        }

        for (StatusManager status : statuses){
            status.decreaseStatusTimer();
            if (status.getStatusTimer() == 0){
                this.removeCapability(status.getEffect());
            }
        }

        if (this.hasCapability(POISON)){
            int damageTaken = (int) ((0.07 * maxHitPoints) + 7);
            this.hurt(damageTaken);
            System.out.println(this + " has taken " + damageTaken + " poison damage.");
        }

        if (this.hasCapability(SLEEP)){
            return new DoNothingAction();
        }

        // General playTurn step for all regular enemies
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
                    actions.add(weapon.getSkill(otherActor));
                    actions.add(new AttackAction(this, this.target, direction, weapon));
                }
            }
            // If player has no weapon in its inventory, it may only choose to use its intrinsic weapon.
            actions.add(new AttackAction(this, this.target, direction));
        }
        return actions;
    }

    public void addStatus(StatusManager status){
        statuses.add(status);
    }

}
