package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.PileOfBones;
import game.actors.friendly.PlayableCharacter;
import game.items.stackable.EnemyRunes;
import game.utils.Status;
import game.actors.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong
 * @modifier Kenan Baydar
 */
public class DeathAction extends Action {
    private final Actor attacker;
    private Actor actorsTarget;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * Constructor.
     *
     * @param actor the actor that is attacking.
     * @param actorsTarget the targeted enemy of the actor that is being attacked.
     */
    public DeathAction(Actor actor, Actor actorsTarget){
        this.attacker = actor;
        this.actorsTarget = actorsTarget;
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

        Location location = map.locationOf(target);

        ActionList dropActions = new ActionList();

        // Instead of dying, actors that have a second life will turn into a Pile of Bones.
        if (target.hasCapability(Status.SECOND_LIFE)) {

            // remove actor
            map.removeActor(target);

            // Transfer all weapons to the Pile of Bones
            List<WeaponItem> allWeapons = new ArrayList<>(target.getWeaponInventory());

            // Replace position with new Pile of Bones Actor
            map.addActor(new PileOfBones(actorsTarget, allWeapons), location);
            return System.lineSeparator() + target + " has turned into into a Pile of Bones!";
        }

        // drop all items
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);

        // remove actor
        map.removeActor(target);

        // Player obtains runes from enemy, printed to the screen.
        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
            EnemyRunes enemyRunes = (EnemyRunes) target;
            result += System.lineSeparator() + ((PlayableCharacter) attacker).enemyDefeatedRunes(target, enemyRunes);
        }

        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Describes which actor is killed.
     *
     * @param actor The actor that dies
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
