package game;

import edu.monash.fit2099.engine.actors.Actor;

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
        else if (actor.hasCapability(Status.FRINDLY_TO_SEA) && otherActor.hasCapability(Status.FRINDLY_TO_SEA)){
            return true;
        }
        else{
            return false;
        }
    }
}
