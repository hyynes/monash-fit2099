package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;

/**
 * An action executed if an actor heals. (can also be used as a debug action)
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */
public class HealAction extends Action {

    public HealAction(){}

    /**
     * Heals the player if successful.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message displaying whether the player successfully healed or not.
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        String result;
        if (actor instanceof Player){
            if (((Player)actor).flask.removeStacks(1)) {
                actor.heal(250);
                result = actor + " consumed " + ((Player)actor).flask + ".";
                // insert any debug code here (e.g add 250 runes to player inventory)
            }
            else {
                result = actor + " has no charges left in their " + ((Player)actor).flask + ".";
            }
        }
        else {
            result = "Something went wrong.";
        }
        return result;
    }

    /**
     * Menu description.
     * @param actor The actor performing the action.
     * @return a menu option showing the amount of flask charges left
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + ((Player)actor).flask + " (" + ((Player)actor).flask.getNoOfStacks() + "/2)";
    }
}
