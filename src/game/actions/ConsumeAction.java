package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.utils.RandomNumberGenerator;

public class ConsumeAction extends Action {

    private final Item consumedItem;
    private final Player player;

    public ConsumeAction(Item consumedItem, Player player){
        this.consumedItem = consumedItem;
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        player.removeItemFromInventory(consumedItem);
        int runesGenerated = RandomNumberGenerator.getRandomInt(200,10000);
        player.addRunes(runesGenerated);
        return menuDescription(actor) + " for " + runesGenerated + " runes.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumedItem.toString();
    }
}
