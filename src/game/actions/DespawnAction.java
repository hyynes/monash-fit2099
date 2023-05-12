package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.DespawnBehaviour;

/**
 * An Action called when an enemy despawns by chance.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class DespawnAction extends Action{

    /**
     * When executed, the actor is removed from the game without dropping any items if it has any.
     *
     * @param actor The actor being removed from the game
     * @param map The map the actor is on.
     * @return description of the actor being removed for the menu UI
     * @see DespawnBehaviour
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Describes which actor has been despawned from the game.
     *
     * @param actor The actor that has been removed from the game.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been removed from the game.";
    }

}
