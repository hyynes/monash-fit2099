package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SurroundingAttack;
import game.utils.Status;

/**
 * The knife that goes spin.
 * Deals 115 damage with an 85% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */

public class Grossmesser extends WeaponItem implements WeaponRunes{

    /**
     * If carried by an enemy, stores its target actor to follow.
     */
    private Actor target;

    /**
     * Constructor.
     *
     * @param target The Actor that the enemy is targeting in followBehaviour.
     */
    public Grossmesser(Actor target) {
        super("Grossmesser", '?', 115, "Slices", 85);
        this.target = target;
        this.addCapability(Status.GROSSMESSER);
    }


    /**
     * Special Spin Attack Skill
     *
     * @param holder Actor that holds the Grossmesser
     * @return A Surrounding attack that hits its surroundings with the Grossmesser.
     */
    @Override
    public Action getSkill(Actor holder){
        if (target!= null){
            return new SurroundingAttack(target,this);
        }
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Grossmesser can be purchased from the Merchant
     * In this case, not available for purchase from Merchant.
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
