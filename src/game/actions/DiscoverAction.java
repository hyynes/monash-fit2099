package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.displays.FancyMessage;

public class DiscoverAction extends Action {

    private boolean discover = false;

    public DiscoverAction(){
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        discover = true;
        return FancyMessage.LOST_GRACE_DISCOVERED;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " touches Site of Lost Grace";
    }

    public boolean isDiscovered(){
        return discover;
    }
}
