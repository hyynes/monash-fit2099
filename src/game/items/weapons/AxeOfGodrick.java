package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SurroundingAttack;

/**
 * The Weapon yielded by Godrick the Grafted during the first phase.
 * Deals 142 damage with an 84% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class AxeOfGodrick extends WeaponItem implements WeaponRunes {

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
     * @return Cannot be purchased from the Merchant.
     */
    @Override
    public int buyPrice() {
        return 0;
    }

    /**
     *
     * @return The price at which the Axe of Godrick can be sold to the Merchant.
     */
    @Override
    public int sellPrice() {
        return 100;
    }
}
