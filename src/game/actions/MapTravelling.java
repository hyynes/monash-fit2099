package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class MapTravelling extends Action {

    private GameMap travelMap;

    private String displayString;

    public MapTravelling(GameMap travelMap, String displayString){
        this.travelMap = travelMap;
        this.displayString = displayString;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor,travelMap.at(3,5));
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + displayString;
    }
}
