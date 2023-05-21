package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.displays.FancyMessage;

/**
 * When the Site Of Lost Grace is first discovered by the player.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class DiscoverAction extends Action {

    /**
     * Whether the site of lost grace has been discovered yet or not.
     */
    private boolean discover = false;

    /**
     * Constructor.
     */
    public DiscoverAction(){}

    /**
     * When the player first discovers the site of lost grace and touches it.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        discover = true;
        return FancyMessage.LOST_GRACE_DISCOVERED;
    }

    /**
     * Describes the actor touching the site of lost grace.
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " touches Site of Lost Grace";
    }

    /**
     * If the site of lost grace has been discovered.
     *
     * @return A boolean whether the site of lost grace has been discovered or not.
     */
    public boolean isDiscovered(){
        return discover;
    }
}
