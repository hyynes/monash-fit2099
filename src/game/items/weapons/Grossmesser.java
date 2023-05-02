package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SurroundingAttack;

/**
 * The knife that goes spin.
 * Deals 115 damage with an 85% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */

public class Grossmesser extends WeaponItem implements WeaponRunes{

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slices", 85);
    }


    /**
     * Special Spin Attack Skill
     *
     * @param holder Actor that holds the Grossmesser
     * @return A Surrounding attack that hits its surroundings with the Grossmesser.
     */
    @Override
    public Action getSkill(Actor holder){
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Grossmesser can be purchased from the Merchant
     */
    @Override
    public int buyPrice() {
        return 0;
    }

    /**
     *
     * @return The price at which the Grossmesser can be sold to the Merchant
     */
    @Override
    public int sellPrice() {
        return 100;
    }

}
