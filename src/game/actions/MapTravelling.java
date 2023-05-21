package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * When an actor instantly travels from one place to another
 * Created by:
 * @author Kenan Baydar
 *
 */
public class MapTravelling extends Action {

    /**
     * The map to travel to.
     */
    private final GameMap travelMap;

    /**
     * Name of the map.
     */
    private final String displayString;

    /**
     * Location in the x direction.
     */
    private final int x;

    /**
     * Location in the y direction.
     */
    private final int y;

    /**
     * Constructor.
     *
     * @param travelMap the map the actor is travelling to
     * @param displayString the name of the map
     * @param x location on the map in the x direction.
     * @param y location on the map in the y direction.
     */
    public MapTravelling(GameMap travelMap, String displayString, int x, int y){
        this.travelMap = travelMap;
        this.displayString = displayString;
        this.x = x;
        this.y = y;
    }

    /**
     * Executed when the player decides to travel from one place to another.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description used for the menu UI
     *
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor,travelMap.at(x,y));
        return menuDescription(actor);
    }

    /**
     * A description used for the menu UI
     *
     * @param actor The actor performing the action.
     * @return Description describing where the actor has travelled to.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + displayString;
    }
}
