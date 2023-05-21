package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

/**
 * Called for an exchange between two items with no runes involved.
 * created by:
 * @author Kenan Baydar
 */
public class ExchangeAction extends Action {

    /**
     * First item being exchanged.
     */
    private final Item item;

    /**
     * Second item being exchanged
     */
    private final Item secondItem;


    /**
     * Constructor
     * @param item First item to exchange.
     * @param secondItem Second item to exchange.
     */
    public ExchangeAction(Item item, Item secondItem){
        this.item = item;
        this.secondItem = secondItem;
    }

    /**
     * When executed, if a finger reader is nearby, allow an exchange.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a menu description describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor fingerReader = destination.getActor();
                if (fingerReader.hasCapability(Status.FINGER_READER)) {
                    if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        actor.removeItemFromInventory(secondItem);
                        actor.addItemToInventory(item);
                        return menuDescription(actor);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Menu description used for UI.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges " + secondItem.toString() + " for " + item;
    }
}
