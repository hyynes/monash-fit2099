package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.SurroundingAttack;


/**
 * The Weapon yielded by Godrick the Grafted during the second phase.
 * Deals 89 damage with an 90% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class GraftedDragon extends SellableWeapon {

    /**
     * Constructor.
     *
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "Swings", 90);
    }

    /**
     * Special Spin Attack Skill
     *
     * @param holder Actor that holds the Grafted Dragon
     * @return A Surrounding attack that hits its surroundings with the Grafted Dragon.
     */
    @Override
    public Action getSkill(Actor holder) {
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Grafted Dragon can be sold to the trader.
     */
    @Override
    public int sellPrice() {
        return 200;
    }
}
