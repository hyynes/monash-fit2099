package game.items.special;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.friendly.Player;

/**
 * An item that is scattered across Elden Ring.
 * If picked up and consumed, creates runes.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class GoldenRunes extends Item {

    /**
     * New action when to consume the Golden Rune if held by the player.
     *
     */
    private final ConsumeAction consumeAction;

    /***
     * Constructor.
     *
     * @param player The player holding the item.
     */
    public GoldenRunes(Player player) {
        super("Golden Runes", '*', true);
        consumeAction = new ConsumeAction(this, player);
    }

    /**
     * Adds the action to consume the Golden Rune if held by the player.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        addAction(consumeAction);
    }

    /**
     * If the item is dropped, remove the consume action.
     *
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        removeAction(consumeAction);
        return super.getDropAction(actor);
    }
}
