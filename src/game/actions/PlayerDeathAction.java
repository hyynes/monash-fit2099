package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.friendly.Player;
import game.displays.FancyMessage;
import game.items.stackable.Rune;
import game.utils.ResetManager;

import java.util.ArrayList;
import java.util.List;

/**
 * An action executed for when the player dies (not to be confused with DeathAction)
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */
public class PlayerDeathAction extends Action{

    private final Rune runesDropped = new Rune();

    private static final List<GameMap> gameMaps = new ArrayList<>();

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
        Player player = (Player) target;

        for (GameMap maps : gameMaps) {
            NumberRange xRange = maps.getXRange();
            NumberRange yRange = maps.getYRange();

            // Removes runes that may have been in the game previously
            for (int y = 0; y <= yRange.max(); y++) {
                for (int x = 0; x <= xRange.max(); x++) {
                    for (int i = 0; i < maps.at(x, y).getItems().size(); i++) {
                        if (maps.at(x, y).getItems().get(i).getDisplayChar() == '$') {
                            maps.at(x, y).removeItem(maps.at(x, y).getItems().get(i));
                        }
                    }
                }
            }
        }

        // calculates how many runes the player has to drop
        runesDropped.setNoOfStacks(player.getRunes().getNoOfStacks());
        result += System.lineSeparator() + menuDescription(player);

        result += System.lineSeparator() + FancyMessage.YOU_DIED;

        // Drops runes at the last location
        player.getLastLocation().addItem(runesDropped);

        // Back to 0 runes
        player.getRunes().setNoOfStacks(0);

        ResetManager.getInstance().run();

        return result;
    }

    /**
     * Describes how many runes the actor drops
     *
     * @param actor The actor that dies
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has dropped " + runesDropped.getNoOfStacks() + " runes.";
    }

    public static void addMaps(GameMap map){
        gameMaps.add(map);
    }
}
