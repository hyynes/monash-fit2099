package game.grounds.neutral;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

public class GoldenFogDoor extends Ground {

    /**
     * Constructor.
     *
     */
    public GoldenFogDoor(GameMap travel) {
        super('D');
        //this.travel = travel;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){

        }

        return null;
    }
}
