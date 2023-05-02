package game.Actors.FriendlyActors;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Behaviours.AttackBehaviour;

/**
 * To denote friendly actors.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class FriendlyActors {

    /**
     * An actor
     */
    private final Actor actor;

    /**
     * A different actor
     */
    private final Actor otherActor;


    /**
     * Constructor.
     *
     * @param actor An Actor.
     * @param otherActor Another actor that is compared with.
     */
    public FriendlyActors(Actor actor, Actor otherActor){
        this.actor = actor;
        this.otherActor = otherActor;
    }

    /**
     * If both Actors have a certain Status that is the same, they are friendly and won't attack each other.
     *
     * @return true if both actors are friendly to each other, otherwise false.
     * @see AttackBehaviour
     */
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
