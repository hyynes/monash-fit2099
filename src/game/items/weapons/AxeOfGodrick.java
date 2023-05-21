package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.SurroundingAttack;

/**
 * The Weapon yielded by Godrick the Grafted during the first phase.
 * Deals 142 damage with an 84% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class AxeOfGodrick extends SellableWeapon {

    /**
     * Constructor.
     *
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "Chops", 84);
    }

    /**
     * Special Spin Attack Skill
     *
     * @param holder Actor that holds the Axe of Godrick.
     * @return A Surrounding attack that hits its surroundings with the Axe of Godrick.
     */
    @Override
    public Action getSkill(Actor holder) {
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Axe of Godrick can be sold to the trader.
     */
    @Override
    public int sellPrice() {
        return 100;
    }
}
