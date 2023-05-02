package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.items.stackable.Rune;

public class PickUpRunesAction extends Action {

    Rune pickedUpRunes;
    public PickUpRunesAction(Rune runes){
        this.pickedUpRunes = runes;
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up " + pickedUpRunes.getNoOfStacks() + " runes.";
    }
}
