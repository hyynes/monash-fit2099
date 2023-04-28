package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

public class SurroundingAttack extends Action {
    private Weapon weapon;
    //private Actor target;

    /**
     * Random number generator
     */
    private Random rand = new Random();


    /**
     * Doesn't necesarilly have a target, so only paramater needed is the weapon used.
     * @param weapon
     */
    public SurroundingAttack(Weapon weapon) {
        //this.target = target;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Actor performs a spin attack
        String result = menuDescription(actor);

        // Damage dealt by weapon
        int damage = weapon.damage();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor targetActor = destination.getActor();
                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    result += System.lineSeparator() + actor + " misses " + targetActor + ".";
                }
                else {
                    result += System.lineSeparator() + actor + " " + weapon.verb() + " " + targetActor +
                            " for " + damage + " damage.";
                    targetActor.hurt(damage);
                }
                if (!targetActor.isConscious()){
                    result += new DeathAction(actor).execute(targetActor, map);
                }
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs a spin attack";
    }

}
