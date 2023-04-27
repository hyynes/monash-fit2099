package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;
import java.util.List;

public class PileOfBones{
    private Actor actor;
    private Boolean pileOfBone;
    private int turnsAfterDeath;
    public PileOfBones(Actor originalActor, int turnsAfterDeath) {
        super("Pile Of Bones", 'X', 1);
        this.actor = originalActor;
        this.turnsAfterDeath = turnsAfterDeath;

        // Could be useful when implementing runes in the game
        for (Item item : originalActor.getItemInventory())
            this.addItemToInventory(item);

        // Receives the weapon/s that the original Actor had
        for (WeaponItem weapon : originalActor.getWeaponInventory())
            this.addWeaponToInventory(weapon);
    }

    @Override
    public boolean checkState(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (turnsAfterDeath == 3) {
            // Remove the pile of bones and revive the original actor with full health
            pileOfBone = false;
            return true;
        } else {
            // The pile of bones can't be attacked until 3 turns have passed
            pileOfBone = true;
            turnsAfterDeath += 1;
            return false;
        }
    }

}
