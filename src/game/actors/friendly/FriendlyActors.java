package game.actors.friendly;

import edu.monash.fit2099.engine.actors.Actor;
import game.utils.Status;
import game.behaviours.AttackBehaviour;

import java.util.List;

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
     * If both actors have a certain Status that is the same, they are friendly and won't attack each other.
     *
     * @return true if both actors are friendly to each other, otherwise false.
     * @see AttackBehaviour
     */
    public boolean statusCheck(){
        List<Status> actorCapabilities = actor.findCapabilitiesByType(Status.class);
        List<Status> otherActorCapabilities = otherActor.findCapabilitiesByType(Status.class);

        // Loops through all the actors capabilities and checks whether the other actor has the same capability
        for (Status capabilities : actorCapabilities) {
            if (capabilities != Status.SLAM_ATTACK) {
                if (otherActorCapabilities.contains(capabilities)) {
                    return true;
                }
            }
        }
        return false;
    }
}
