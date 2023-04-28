package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Random;

public class DespawnAction extends Action{
    private final Random random = new Random();


    @Override
    public String execute(Actor actor, GameMap map) {
        if (random.nextInt(10) == 0) {
            map.removeActor(actor);
            return System.lineSeparator() + menuDescription(actor);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been removed from the game.";
    }

}
