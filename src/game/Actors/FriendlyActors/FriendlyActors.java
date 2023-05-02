package game.Actors.FriendlyActors;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;

/**
 * To denote friendly actors.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */

public class FriendlyActors {

    private Actor actor;
    private Actor otherActor;
    public FriendlyActors(Actor actor, Actor otherActor){
        this.actor = actor;
        this.otherActor = otherActor;
    }

    public boolean statusCheck(){
        if (actor.hasCapability(Status.FRIENDLY_TO_WOLF) && otherActor.hasCapability(Status.FRIENDLY_TO_WOLF)){
            return true;
        }
        else if (actor.hasCapability(Status.FRIENDLY_TO_SKELETON) && otherActor.hasCapability(Status.FRIENDLY_TO_SKELETON)){
            return true;
        }
        else if (actor.hasCapability(Status.FRIENDLY_TO_SEA) && otherActor.hasCapability(Status.FRIENDLY_TO_SEA)){
            return true;
        }
        else{
            return false;
        }
    }
}
