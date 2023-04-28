package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

public class SurroundingAttack extends Action {
    private Weapon weapon;
    private Actor target;

    public SurroundingAttack(Actor target, Weapon weapon) {
        this.target = target;
        this.weapon = weapon;
    }

    /**
    @Override
    public String execute(Actor actor, GameMap map) {
        int damage = weapon.damage();
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                target.hurt(damage);
            }
        }
        return System.lineSeparator() + menuDescription(actor);
    }
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor targetActor = destination.getActor();
                result += new AttackAction(targetActor, exit.getName(), weapon).execute(actor, map);
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs a spin attack";
    }

}
