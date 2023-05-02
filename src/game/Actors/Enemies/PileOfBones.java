package game.Actors.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actors.FriendlyActors.Player;
import game.Utils.Status;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * For when a skeleton dies.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */
public class PileOfBones extends Enemy{

    private int turnsAfterDeath = 0;

    public PileOfBones(Actor targets, List<WeaponItem> weapons){
        super("Pile of Bones",'X',1,targets);
        this.addCapability(Status.FRIENDLY_TO_SKELETON);
        for (WeaponItem weapon : weapons){
            this.addWeaponToInventory(weapon);
        }
        this.runeMin = 35;
        this.runeMax = 892;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (turnsAfterDeath >= 3) {
            Location location = map.locationOf(this);
            map.removeActor(this);
            map.addActor(new HeavySkeletalSwordsman(target), location);
        } else {
            ++turnsAfterDeath;
        }
        return new DoNothingAction();
    }
}