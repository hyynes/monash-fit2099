package game.items;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.friendly.Player;

public class GoldenRunes extends Item {

    private boolean addedAction = false;
    private final ConsumeAction consumeAction;

    /***
     * Constructor.
     *
     */
    public GoldenRunes(Player player) {
        super("Golden Runes", '*', true);
        consumeAction = new ConsumeAction(this, player);
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        if (!addedAction){
            addAction(consumeAction);
            addedAction = true;
        }
    }
}
