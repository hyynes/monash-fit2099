package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
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
    public String execute(Actor target, GameMap map) {
        String result = "";
        Rune rune = new Rune();
        Rune runesDropped = new Rune();

        if (target instanceof Player) {
            for (int i = 0; i < target.getItemInventory().size(); i++) {
                if (target.getItemInventory().get(i) instanceof Rune) {
                    runesDropped = (Rune) target.getItemInventory().get(i);
                    result += System.lineSeparator() + target + " has dropped " + (runesDropped.getNoOfStacks()) + " runes.";
                    ((Rune) target.getItemInventory().get(i)).setNoOfStacks(0);
                }
            }

            result += System.lineSeparator() + FancyMessage.YOU_DIED;
            if (runesDropped.getNoOfStacks() != 0) {
                rune.setNoOfStacks(runesDropped.getNoOfStacks());
                map.locationOf(target).addItem(rune);
            }
            ResetManager.getInstance().run();
        }
        return result;
    }

    // this method is never used
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed." + System.lineSeparator();
    }
}
