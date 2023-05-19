package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.utils.Status;
import java.util.List;

/**
 * When a Skeleton dies, turns into a Pile of Bones
 * Has 1 hp and will die instantly after being hit.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class PileOfBones extends RegularEnemy {

    /**
     * Amount of turns after death of Skeleton.
     */
    private int turnsAfterDeath = 0;

    /**
     * Constructor.
     *
     * @param targets Actor the Skeleton will follow after being revived.
     * @param weapons A list of weapons that was carried by the Skeleton, which is transferred to the Pile of Bones.
     */
    public PileOfBones(Actor targets, List<WeaponItem> weapons){
        super("Pile of Bones",'X',1,targets);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        for (WeaponItem weapon : weapons){
            this.addWeaponToInventory(weapon);
            this.addCapability(weapon.capabilitiesList().get(0));
        }
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible actions for this Actor
     * @param lastAction The Action this Actor took last turn
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (turnsAfterDeath >= 3) {
            Location location = map.locationOf(this);
            map.removeActor(this);
            if (this.hasCapability(Status.GROSSMESSER)){
                map.addActor(new HeavySkeletalSwordsman(target), location);
            }
            else if (this.hasCapability(Status.SCIMITAR)){
                map.addActor(new SkeletalBandit(target), location);
            }
        } else {
            ++turnsAfterDeath;
        }
        return new DoNothingAction();
    }

    /**
     *
     * @return minimum number of runes the Pile Of Bones can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 35;
    }

    /**
     *
     * @return maximum number of runes the Pile Of Bones can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 892;
    }
}