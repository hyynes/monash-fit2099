package game.Actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actors.FriendlyActors.Player;
import game.Displays.DisplayStrings;

public class HealAction extends Action implements DisplayStrings {

    public HealAction(){}

    @Override
    public String execute(Actor actor, GameMap map) {
        String result;
        if (actor instanceof Player){
            if (((Player)actor).flask.removeStacks(1)) {
                //((Player)actor).flask.setNoOfStacks(((Player)actor).flask.getNoOfStacks() - 1);
                actor.heal(250);
                result = actor + " consumed " + ((Player)actor).flask + ".";
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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + ((Player)actor).flask + " (" + ((Player)actor).flask.getNoOfStacks() + "/2)";
    }
}
