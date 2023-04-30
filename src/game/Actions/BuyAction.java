package game.Actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;


// Buy action allows Actor that is nearby to purchase from the merchant. merchant class will use this class.
// Can check the merchants surrounding, if there is an actor nearby that has the status HOSTILE_TO_ENEMY,
// allow buyAction.
// In the merchant class can use the allowableActions method on itself.
public class BuyAction extends Action{

    Actor otherActor;
    WeaponItem weapon;

    public BuyAction(Actor otherActor, WeaponItem weapon){
        this.otherActor = otherActor;
        this.weapon = weapon;
    }

    /**
     *
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        otherActor.addWeaponToInventory(weapon);

        return null;
    }

    /**
     *
     * @param actor The actor performing the purchase action.
     * @return
     */

    /**
    @Override
    public String menuDescription(Actor actor) {
        if (actor is still buying){
            return actor + " purchases " + weapon + " for " + rune;
        }
        else{
            return actor + " purchased " + weapon + " for " + rune;
        }
    }
    */

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

}
