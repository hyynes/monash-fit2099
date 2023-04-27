package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Skeleton;
import edu.monash.fit2099.engine.actions.Action;

public class ReviveAction extends Action{
    private Actor actor;

    public ReviveAction(Actor actor){
        this.actor = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        // Remove the pile of bones from the map
        Location location = map.locationOf(actor);
        // Revive the original actor with full health
        ((Skeleton)actor).revive(map, location);
        result += System.lineSeparator() + menuDescription(actor);
        return result;
    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is revived";
    }
}
