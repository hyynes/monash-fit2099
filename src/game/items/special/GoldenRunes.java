package game.items.special;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
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

    Player player;

    public GoldenRunes(Player player) {
        super("Golden Runes", '*', true);
        this.player = player;
    }

    @Override
    public String consume(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        int runesGenerated = RandomNumberGenerator.getRandomInt(200,10000);
        player.addRunes(runesGenerated);
        return actor + " consumed " + this + " for " + runesGenerated + " runes.";
    }
}
