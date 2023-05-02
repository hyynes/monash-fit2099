package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.Actors.FriendlyActors.Player;
import game.Displays.FancyMessage;
import game.Items.StackableItems.Rune;
import game.Utils.ResetManager;

public class PlayerDeathAction extends Action{

    public PlayerDeathAction(Actor actor) {}

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map)
    {
        String result = "";
        Rune runesDropped = new Rune();

        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        for (int y = 0; y <= yRange.max(); y++) {
            for (int x = 0; x <= xRange.max(); x++) {
                for (int i = 0; i < map.at(x,y).getItems().size(); i++){
                    if (map.at(x,y).getItems().get(i) instanceof Rune) {
                       map.at(x,y).removeItem(map.at(x,y).getItems().get(i));
                    }
                }
            }
        }

        if (target instanceof Player) {
            runesDropped.setNoOfStacks(((Player) target).runes.getNoOfStacks());
            result += System.lineSeparator() + target + " has dropped " + (runesDropped.getNoOfStacks()) + " runes.";

            result += System.lineSeparator() + FancyMessage.YOU_DIED;
            if (runesDropped.getNoOfStacks() != 0) {
                map.locationOf(target).addItem(runesDropped);
            }
            ((Player) target).runes.setNoOfStacks(0);
        }
        ResetManager.getInstance().run();
        ((Player) target).reset(map);
        return result;
    }

    // this method is never used
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
