package game.actors.enemies;
import game.utils.StatusEffect;

/**
 * Managing status effects.
 * Created by:
 * @author Danny Duong
 */

public class StatusManager {

    private StatusEffect effect;
    private int timer;

    /**
     * Constructor
     * @param effect - the effect that is to be applied
     * @param timer - for how many turns.
     */

    public StatusManager(StatusEffect effect, int timer) {
        this.timer = timer;
        this.effect = effect;
    }

    public StatusEffect getEffect(){ return effect;}

    public int getStatusTimer(){ return timer;}

    public void decreaseStatusTimer(){
        timer--;
    }
}
