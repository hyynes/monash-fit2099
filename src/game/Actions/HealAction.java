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
            if (((Player)actor).flask.getNoOfStacks() > 0) {
                ((Player)actor).flask.setNoOfStacks(((Player)actor).flask.getNoOfStacks() - 1);
                ((Player) actor).heal(250);
                result = actor + " has healed.";
            }
            else {
                result = actor + " has no charges in their Flask of Crimson tears.";
            }
        }
        else {
            result = "Something went wrong.";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " heals using the Flask of Crimson Tears";
    }
}
