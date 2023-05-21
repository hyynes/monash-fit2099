package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import game.actors.enemies.StatusManager;

public interface Statusable {
    void addStatus(StatusManager status);
    void removeStatus(StatusManager status);
    Action checkStatus(StatusManager status);
}
