package game.Actors.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.Behaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;
import game.Utils.Resettable;
import game.Utils.Status;

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

    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    protected int turnsAfterDeath = 0;
    protected boolean initialCheck = true;
    protected boolean isPileOfBones = false;
    PileOfBones pileOfBones = new PileOfBones();

    protected Actor target;


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints, Actor target) {
        super(name, displayChar, hitPoints);
        this.target = target;
        this.behaviours.put(998, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour());
        this.behaviours.put(996, new FollowBehaviour(target));
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // Extra steps for Skeleton types with Pile of Bones ability
        if (this instanceof Skeleton) {
            // If Skeleton just turned into a Pile of Bones that turn, initialises all values.
            if (pileOfBones.checkState(this, turnsAfterDeath, getPileOfBones()) && initialCheck) {
                this.setDisplayChar('X');
                // Set its health to 1
                this.hitPoints = 1;
                initialCheck = false;
            }

            // If Skeleton is in Pile of Bones state
            if (pileOfBones.checkState(this, turnsAfterDeath, getPileOfBones())) {
                ++turnsAfterDeath;
                return new DoNothingAction();
            } else {
                if (!initialCheck) {
                    // Set its display character back to that of Heavy Skeletal Swordsman
                    this.setDisplayChar(((Skeleton) this).getOriginalDisplayChar());
                    this.hitPoints = 153;
                    setTurnsAfterDeath(0);
                }
                initialCheck = true;
            }
        }

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
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
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
                    if (weapon.hasCapability(Status.SPECIAL_ATTACK)) {
                        actions.add(weapon.getSkill(otherActor));
                    }
                    actions.add(new AttackAction(this, direction, weapon));
                }
            } else {
                // Use intrinsic weapon
                actions.add(new AttackAction(this, direction));
            }
            // If player has no weapon in its inventory, it may only choose to use its intrinsic weapon.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    @Override
    public void reset(GameMap map){
        map.removeActor(this);
    }

    public boolean getPileOfBones() {
        return isPileOfBones;
    }

    public void setPileOfBones(boolean pileOfBones) {
        isPileOfBones = pileOfBones;
    }

    public void setTurnsAfterDeath(int turnsAfterDeath){
        this.turnsAfterDeath = turnsAfterDeath;
    }

    public int runeMax;
    public int runeMin;

}