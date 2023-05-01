package game.Actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actors.PlayableCharacter;
import game.Status;
import game.Weapons.WeaponRunes;

// Buy action allows Actor that is nearby to purchase from the merchant. merchant class will use this class.
// Can check the merchants surrounding, if there is an actor nearby that has the status HOSTILE_TO_ENEMY,
// allow buyAction.
// In the merchant class can use the allowableActions method on itself.
public class BuyAction extends Action{

    private Actor merchantActor;
    private WeaponItem weapon;

    public BuyAction(WeaponItem weapon){
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

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                merchantActor = destination.getActor();
                if (merchantActor.hasCapability(Status.TRADER)) {
                    if (actor instanceof PlayableCharacter) {
                        if (((PlayableCharacter) actor).removeRunes(((WeaponRunes) weapon).buyPrice())){
                            actor.addWeaponToInventory(weapon);
                            return actor + " purchased " + weapon + " for " + ((WeaponRunes) weapon).buyPrice() + " runes.";
                        }
                        else {
                            return actor + " does not have enough runes to purchase " + weapon + "!";
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * @param actor The actor performing the purchase action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + weapon + " for " + ((WeaponRunes) weapon).buyPrice() + " runes.";
    }
}
