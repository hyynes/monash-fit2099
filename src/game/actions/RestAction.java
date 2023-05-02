package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.utils.PlayerSpawnPoint;
import game.utils.ResetManager;

public class RestAction extends Action {
    public RestAction(){}

    @Override
    public String execute(Actor actor, GameMap map) {
        String result;
        if (actor instanceof Player){
            PlayerSpawnPoint.getInstance().setSpawnLocation(map.locationOf(actor));
            ResetManager.getInstance().run();
            result = actor + " has rested.";
        }
        else {
            result = "Something went wrong.";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at the Site of Lost Grace.";
    }
}
