package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class MapTravelling extends Action {

    private final GameMap travelMap;
    private final String displayString;
    private final int x;
    private final int y;

    public MapTravelling(GameMap travelMap, String displayString, int x, int y){
        this.travelMap = travelMap;
        this.displayString = displayString;
        this.x = x;
        this.y = y;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor,travelMap.at(x,y));
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + displayString;
    }
}
