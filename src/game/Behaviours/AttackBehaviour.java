package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.AttackAction;

public class AttackBehaviour implements Behaviour {

    private final Actor target;

    /**
     * Constructor.
     *
     * @param actor the Actor to attack
     */
    public AttackBehaviour(Actor actor){
        this.target = actor;
    }


    public Action getAction(Actor actor, GameMap map){
        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()){
            Location destination = exit.getDestination();
            Actor adjacent = map.getActorAt(destination);
            if (adjacent != null && adjacent.equals(target)) {
                String direction = exit.getName();
                return new AttackAction(target, direction);
            }
        }
        return null;

    }

}
