package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.items.special.GoldenRunes;
import game.items.stackable.Consumable;

/**
 * A general action for modifying items that implement the Consumable interface.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public class ConsumeAction extends Action {

    /**
     * The item that is being consumed.
     */
    private final Item consumedItem;
    /**
     * The player that is consuming the item
     */
    private final Player player;

    /**
     * Constructor.
     *
     * @param consumedItem the item being consumed
     * @param player The player consuming the item
     */

    public ConsumeAction(Item consumedItem, Player player){
        this.consumedItem = consumedItem;
        this.player = player;
    }

    /**
     * Executes the consume action for the item.
     * @param actor The actor consuming the item
     * @param map The map the actor is on.
     * @return description of the actor consuming for the menu UI
     * @see GoldenRunes
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return ((Consumable) consumedItem).consume(actor, map);
    }

    /**
     * Describes the actor that can consume an item
     *
     * @param actor The actor that consumes the item
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumedItem.toString();
    }
}
