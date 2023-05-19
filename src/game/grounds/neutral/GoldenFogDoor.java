package game.grounds.neutral;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.MapTravelling;
import game.utils.Status;

public class GoldenFogDoor extends Ground {
    private final GameMap travel;
    private final String displayString;
    private int x;
    private int y;

    /**
     * Constructor.
     *
     */
    public GoldenFogDoor(GameMap travel, String displayString, int x, int y) {
        super('D');
        this.travel = travel;
        this.displayString = displayString;
        this.x = x;
        this.y = y;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new MapTravelling(travel, displayString, x, y));
            //location.map().moveActor(actor,travel.locationOf(actor));
        }
        return actions;
    }
}
