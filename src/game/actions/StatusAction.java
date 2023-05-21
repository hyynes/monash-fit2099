package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.RandomNumberGenerator;
import game.utils.WeaponEffect;

import static game.utils.WeaponEffect.POISON;
import static game.utils.WeaponEffect.SLEEP;

public class StatusAction extends Action {

    private final WeaponEffect status;

    public StatusAction(WeaponEffect status) {
        this.status = status;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String results = "";

        if (status == POISON){
            int damageTaken = (RandomNumberGenerator.getRandomInt(7,30));
            actor.hurt(damageTaken);
            results = actor + " has taken " + damageTaken + " poison damage.";
        }

        if (status == SLEEP){
            results = actor + " is sleeping and cannot do anything.";
        }

        return results;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
