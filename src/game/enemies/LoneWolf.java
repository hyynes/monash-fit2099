package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.*;
import game.Actions.AttackAction;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.Behaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();


    public LoneWolf(Actor target) {
        super("Lone Wolf", 'h', 102);
        this.behaviours.put(998, new WanderBehaviour());
        this.behaviours.put(997, new FollowBehaviour(target));
        this.behaviours.put(996, new AttackBehaviour(target));
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
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
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
        // nevermind, dont have to change this, never will be used by NPC enemies
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            // Checks if the Player has a weapon
            List<WeaponItem> weapons = new ArrayList<>(otherActor.getWeaponInventory());
            // If Player has a weapon, it may choose to either use it or its intrinsic weapon
            if (!weapons.isEmpty()) {
                // Use equipped weapon
                for (WeaponItem weapon : weapons) {
                    if (weapon.hasCapability(Status.SPECIAL_ATTACK)){
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
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
