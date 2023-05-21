package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.StatusManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.WeaponEffect;
import static game.utils.WeaponEffect.*;

public class StatusAction extends Action {

    private final StatusManager statusManager;

    public StatusAction(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
