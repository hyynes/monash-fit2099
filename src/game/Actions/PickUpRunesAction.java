package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actors.FriendlyActors.Player;
import game.Items.StackableItems.Rune;

public class PickUpRunesAction extends Action {

    Rune runes;
    public PickUpRunesAction(Rune rune){
        this.runes = rune;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result;
        if (actor instanceof Player){
            ((Player) actor).addRunes(runes.getNoOfStacks());
            map.locationOf(actor).removeItem(runes);
            result = actor + " has picked up " + runes.getNoOfStacks() + " runes.";
        }
        else {
            result = "Something went wrong.";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up " + runes.getNoOfStacks() + " runes.";
    }
}
