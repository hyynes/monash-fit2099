package game.items.special;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ExchangeAction;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;
import game.utils.Status;

/**
 * Item dropped after defeating Godrick the Grafted.
 * Can be exchanged for a Grafted Dragon or Axe of Godrick.
 *
 */
public class RemembranceOfTheGrafted extends Item {

    /**
     * Able to exchange this item for the Grafted Dragon.
     */
    ExchangeAction exchangeDragon = new ExchangeAction(new GraftedDragon(), this);

    /**
     * Able to exchange this item for the Axe of Godrick.
     */
    ExchangeAction exchangeAxe = new ExchangeAction(new AxeOfGodrick(), this);

    /***
     * Constructor.
     *
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
    }

    /**
     * Adds the action to exchange the Remembrance of the Grafted for one of two items if a finger reader is nearby.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        for (Exit exit: currentLocation.getExits()){
            if (exit.getDestination().containsAnActor()){
                if (exit.getDestination().getActor().hasCapability(Status.FINGER_READER)){
                    addAction(exchangeDragon);
                    addAction(exchangeAxe);
                }
            }
        }
    }

    /**
     * If the item is dropped, remove the exchange action.
     *
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        removeAction(exchangeDragon);
        removeAction(exchangeAxe);
        return super.getDropAction(actor);
    }
}
