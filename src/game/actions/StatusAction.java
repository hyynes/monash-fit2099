package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.StatusManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.WeaponEffect;
import static game.utils.WeaponEffect.*;

/**
 * General action that manages statuses.
 * Created by:
 * @author Danny Duong
 */
public class StatusAction extends Action {

    private final StatusManager statusManager;

    /**
     * Constructor.
     * @param statusManager - the status manager, containing information such as the duration of the effect and the effect itself
     */
    public StatusAction(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    /**
     * Executes an action according to the effect.
     * e.g poison inflicts damage between 7 and 30.
     * @param actor The actor that is being affected.
     * @param map The map the actor is on.
     * @return the effect.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String results = "";

        statusManager.decreaseStatusTimer();
        WeaponEffect status = statusManager.getEffect();
        if (status == POISON){
            int damageTaken = (RandomNumberGenerator.getRandomInt(7,30));
            actor.hurt(damageTaken);
            results = actor + " has taken " + damageTaken + " poison damage.";
        }

        if (status == SCARLET_ROT){
            int damageTaken = (RandomNumberGenerator.getRandomInt(15, 45));
            actor.hurt(damageTaken);
            results = actor + " has taken " + damageTaken + " damage from scarlet rot.";
        }

        if (status == SLEEP){
            results = actor + " is sleeping and cannot do anything.";
        }

        if (!actor.isConscious()) {
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                results += new PlayerDeathAction().execute(actor, map);
            }
            else{
                results += new DeathAction(actor, actor).execute(actor, map);
            }
        }

        return results;
    }

    // is never used.
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
