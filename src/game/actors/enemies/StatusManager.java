package game.actors.enemies;
import game.utils.WeaponEffect;

/**
 * Managing status effects.
 * Created by:
 * @author Danny Duong
 */

public class StatusManager {

    private WeaponEffect effect;
    private int timer;

    /**
     * Constructor
     * @param effect - the effect that is to be applied
     * @param timer - for how many turns.
     */

    public StatusManager(WeaponEffect effect, int timer) {
        this.timer = timer;
        this.effect = effect;
    }

    public WeaponEffect getEffect(){ return effect;}

    public int getStatusTimer(){ return timer;}

    public void decreaseStatusTimer(){
        timer--;
    }
}
