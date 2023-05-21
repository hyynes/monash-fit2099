package game.grounds.neutral;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.MapTravelling;
import game.utils.Status;
import game.Application;

/**
 * New ground that only the player can enter.
 * If the player enters, they will travel somewhere...
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 * @see Application
 */
public class GoldenFogDoor extends Ground {

    /**
     * The map to travel to.
     */
    private final GameMap travel;

    /**
     * The name of the map.
     */
    private final String displayString;

    /**
     * The location in the x direction.
     */
    private int x;

    /**
     * The location in the y direction.
     */
    private int y;

    /**
     * Constructor.
     *
     * @param travel The map that the actor will travel to.
     * @param displayString The name of the map which will be displayed as a string.
     * @param x The location to travel to in the x direction.
     * @param y The location to travel to in the y direciton.
     */
    public GoldenFogDoor(GameMap travel, String displayString, int x, int y) {
        super('D');
        this.travel = travel;
        this.displayString = displayString;
        this.x = x;
        this.y = y;
    }

    /**
     * The actions allowed to be performed on the Golden Fog Door.
     * The actor will instantly teleport to another location after interaction with the Golden Fog Door.
     *
     * @param actor the Actor performing the action.
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new MapTravelling(travel, displayString, x, y));
        }
        return actions;
    }
}
