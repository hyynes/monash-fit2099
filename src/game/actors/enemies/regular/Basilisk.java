package game.actors.enemies.regular;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.StatusManager;
import game.items.weapons.BasiliskClaw;
import game.utils.Status;

import static game.utils.Status.IMMUNE_TO_ROT;
import static game.utils.StatusEffect.SCARLET_ROT;

/**
 * Inhabitant of the Lake of Rot.
 * Created by:
 * @author Danny Duong
 */
public class Basilisk extends RegularEnemy{

    /**
     * Constructor.
     *
     */
    public Basilisk(Actor target) {
        super("Basilisk", 'J', 50, target);
        this.addCapability(IMMUNE_TO_ROT);
        this.addWeaponToInventory(new BasiliskClaw());
    }

    @Override
    public int getRuneMin() {
        return 130;
    }

    @Override
    public int getRuneMax() {
        return 819;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (StatusManager status : statuses){
            if (status.getEffect() == SCARLET_ROT){
                removeStatus(status);
            }
        }
        return null;
    }
}
