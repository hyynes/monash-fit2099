package game.grounds.neutral;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DiscoverAction;
import game.actions.MapTravelling;
import game.actions.RestAction;
import game.utils.Status;

/**
 * The respawn site.
 * Created by:
 * @author Danny Duong
 * Modified by:
 * @modifier Kenan Baydar
 */
public class SiteOfLostGrace extends Ground {

    /**
     * Constructor.
     */
    public SiteOfLostGrace() {
        super('U');
    }

    /**
     * Instance of discover action when player first touches Site of Lost Grace.
     */
    private final DiscoverAction discoverAction = new DiscoverAction();

    /**
     * The actions allowed to be performed on the Site of lost Grace.
     *
     * @param actor the Actor performing the action.
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An Actionlist.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if (!discoverAction.isDiscovered()) {
                actions.add(discoverAction);
            } else {
                actions.add(new RestAction());
            }
        }
        return actions;
    }
}
