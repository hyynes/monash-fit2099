package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.friendly.Player;
import game.displays.FancyMessage;
import game.items.stackable.Rune;
import game.utils.ResetManager;
import game.utils.Status;

/**
 * An action executed for when the player death (not to be confused with DeathAction)
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public class PlayerDeathAction extends Action{

    public PlayerDeathAction() {}

    /**
     * Checks if there are any runes on the map existing. If so, remove them.
     * Sets the player's runes to 0 and puts them on the map.
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */

    @Override
    public String execute(Actor target, GameMap map)
    {
        String result = "";
        Rune runesDropped = new Rune();
        Player player = (Player) target;

        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        // Removes runes that may have been in the game previously
        for (int y = 0; y <= yRange.max(); y++) {
            for (int x = 0; x <= xRange.max(); x++) {
                for (int i = 0; i < map.at(x,y).getItems().size(); i++){
                    if (map.at(x,y).getItems().get(i) instanceof Rune) {
                       map.at(x,y).removeItem(map.at(x,y).getItems().get(i));
                    }
                }
            }
        }

        // calculates how many runes the player has to drop
        runesDropped.setNoOfStacks(player.runes.getNoOfStacks());
        result += System.lineSeparator() + target + " has dropped " + runesDropped.getNoOfStacks() + " runes.";

        result += System.lineSeparator() + FancyMessage.YOU_DIED;

        // Drops runes at the last location
        player.getLastLocation().addItem(runesDropped);

        // Back to 0 runes
        player.runes.setNoOfStacks(0);

        ResetManager.getInstance().run();
        player.reset(map);
        return result;
    }

    // this method is never used
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
