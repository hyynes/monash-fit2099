package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actors.FriendlyActors.PlayableCharacter;
import game.Utils.Status;
import game.Actors.Enemies.Enemy;
import game.Actors.Enemies.Skeleton;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class DeathAction extends Action {
    private final Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        // Instead of dying, Skeleton types are turned into a Pile Of Bones
        if (target instanceof Skeleton && !((Skeleton) target).getPileOfBones()){
            ((Skeleton) target).setPileOfBones(true);
            result += System.lineSeparator() + target + " has turned into a Pile of Bones!";
            return result;
        }

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);

        // Player obtains runes from enemy, printed to the screen.
        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
            result += System.lineSeparator() + ((PlayableCharacter) attacker).enemyDefeatedRunes(target,(((Enemy) target).runeMin), ((Enemy) target).runeMax);
        }
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
