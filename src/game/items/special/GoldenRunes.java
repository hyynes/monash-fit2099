package game.items.special;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.friendly.Player;
import game.items.stackable.Consumable;
import game.utils.RandomNumberGenerator;

/**
 * An item that is scattered across Elden Ring.
 * If picked up and consumed, creates runes.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 * @modifier Danny Duong
 */
public class GoldenRunes extends Item implements Consumable {

    public GoldenRunes(Player player) {
        super("Golden Runes", '*', true);
    }

    @Override
    public String consume(Actor actor, GameMap map) {
        String results;
        actor.removeItemFromInventory(this);
        int runesGenerated = RandomNumberGenerator.getRandomInt(200,10000);
        ((Player)actor).addRunes(runesGenerated);
        return actor + " consumed " + this + " for " + runesGenerated + " runes.";
    }
}
