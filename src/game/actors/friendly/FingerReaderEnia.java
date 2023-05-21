package game.actors.friendly;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

/**
 * A trader that can exchange remembrance of the grafted.
 * created by:
 * @author Kenan Baydar
 */
public class FingerReaderEnia extends Actor {

    /**
     * Constructor.
     * Has the trader and finger reader capabilities.
     *
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 100);
        this.addCapability(Status.TRADER);
        this.addCapability(Status.FINGER_READER);
    }

    /**
     * Does nothing.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

}
