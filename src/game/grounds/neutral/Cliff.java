package game.grounds.neutral;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

public class Cliff extends Ground {

    private final int MAX_VALUE = 1000000;

    /**
     * Constructor.
     *
     */
    public Cliff() {
        super('+');
    }

    /**
     *
     * @param actor The Actor that can enter the cliff
     * @return Either true or false whether the actor can enter the cliff or not
     */
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    public void tick(Location location) {
        if (location.containsAnActor()) {
            location.getActor().hurt(MAX_VALUE);
        }
    }
}
