package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.items.stackable.Rune;

/**
 * An action executed for picking up runes.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class PickUpRunesAction extends Action {

    Rune pickedUpRunes;
    public PickUpRunesAction(Rune runes){
        this.pickedUpRunes = runes;
    }

    /**
     * Adds runes to player's inventory and removes them from the map.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message showing how many runes the player picked up.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result;

        if (actor instanceof Player){
            if (pickedUpRunes != null) {
                ((Player) actor).addRunes(pickedUpRunes.getNoOfStacks());
                result = actor + " has picked up " + pickedUpRunes.getNoOfStacks() + " runes.";
                map.locationOf(actor).removeItem(pickedUpRunes);
            }
            else {
                result = "Something went wrong.";
            }
        }
        else {
            result = "Something went wrong.";
        }
        return result;
    }

    /**
     * Menu description
     * @param actor The actor performing the action.
     * @return menu option showing how many runes the player can pick up.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up " + pickedUpRunes.getNoOfStacks() + " runes.";
    }
}
