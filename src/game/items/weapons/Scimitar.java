package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.SurroundingAttack;
import game.utils.Status;

/**
 * The knife that goes spin v2.
 * Deals 118 damage with an 88% hit rate.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class Scimitar extends SellableWeapon implements PurchasableWeapon {

    /**
     * If carried by an enemy, stores its target actor to follow.
     */
    private Actor target;

    /**
     * Constructor.
     *
     * @param target The Actor that the enemy is targeting in followBehaviour.
     */
    public Scimitar(Actor target) {
        super("Scimitar", 's', 118, "Slashes", 88);
        this.target = target;
        this.addCapability(Status.SCIMITAR);
    }

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
        if (target!= null){
            return new SurroundingAttack(target,this);
        }
        return new SurroundingAttack(this);
    }

    /**
     *
     * @return The price at which the Scimitar can be purchased from the trader.
     */
    @Override
    public int buyPrice() {
        return 600;
    }

    /**
     *
     * @return The price at which the Scimitar can be sold to the trader.
     */
    @Override
    public int sellPrice() {
        return 100;
    }

}
