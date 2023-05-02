package game.Items.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.SurroundingAttack;
import game.Utils.Status;

/**
 * The knife that goes spin v2.
 * Deals 118 damage with an 88% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */

public class Scimitar extends WeaponItem implements WeaponRunes{

    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "Slashes", 88);
    }

    /**
     * Special Spin Attack Skill
     *
     * @param holder Actor that holds the Scimitar
     * @return A Surrounding attack that hits its surroundings with the Scimitar.
     */
    @Override
    public Action getSkill(Actor holder){
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Scimitar can be purchased from the Merchant
     */
    @Override
    public int buyPrice() {
        return 600;
    }

    /**
     *
     * @return The price at which the Scimitar can be sold to the Merchant
     */
    @Override
    public int sellPrice() {
        return 100;
    }
}
