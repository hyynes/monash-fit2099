package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.PlayerSpawnPoint;
import game.utils.ResetManager;

/**
 * An action executed for when a player chooses to rest at a Site of Lost Grace.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public class RestAction extends Action {

    private final String name;
    public RestAction(String name){
        this.name = name;
    }
    /**
     * Resets the player spawn point, and resets the map.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the message to be displayed on the UI.
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        String result;

        PlayerSpawnPoint.getInstance().setSpawnLocation(map.locationOf(actor));
        ResetManager.getInstance().run();
        result = actor + " has rested at " + name + '.';

        return result;
    }

    /**
     * Menu description.
     * @param actor The actor performing the action.
     * @return the menu option.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + name;
    }
}
