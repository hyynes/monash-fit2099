package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.Actors.FriendlyActors.Player;
import game.Items.StackableItems.Rune;

public class PlayerDeathAction extends Action{

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
        Rune rune = new Rune();

        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        for (int y = 0; y <= yRange.max(); y++) {
            for (int x = 0; x <= xRange.max(); x++) {
                if (map.at(x,y).getItems() == rune){
                    map.at(x,y).removeItem(rune);
                }
            }
        }

        if (target instanceof Player) {
            result += System.lineSeparator() + target + " has died.";
            if (((Player) target).runes.getNoOfStacks() != 0) {
                rune.setNoOfStacks(((Player) target).runes.getNoOfStacks());
                result += System.lineSeparator() + target + " has dropped " + ((Player) target).runes.getNoOfStacks() + " runes.";
                ((Player) target).runes.setNoOfStacks(0);
                map.locationOf(target).addItem(rune);
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
