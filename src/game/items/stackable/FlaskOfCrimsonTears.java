package game.items.stackable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Statusable;
import game.actors.enemies.StatusManager;
import game.actors.friendly.Player;
import game.utils.WeaponEffect;

/**
 * A healing potion for when you can't dodge attacks.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class FlaskOfCrimsonTears extends StackableItem implements Consumable {

    /**
     * Constructor.
     */
    public FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", '.', false, 2);
    }

    @Override
    public String displayToString() {
        return "Flask of Crimson Tears (" + getNoOfStacks() + ')';
    }

    @Override
    public String consume(Actor actor, GameMap map) {
        String results;
        if (this.removeStacks(1)) {
            ((Statusable) actor).addStatus(new StatusManager(WeaponEffect.SCARLET_ROT, 10));
            actor.heal(250);
            results = actor + " consumed " + this + '.';
        }
        else {
            results = actor + " has no charges left in their " + this + ".";
        }
        return results;
    }
}
