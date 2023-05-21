package game.actors.enemies;
import game.utils.WeaponEffect;

public class StatusManager {

    private WeaponEffect effect;
    private int timer;

    public StatusManager(WeaponEffect effect, int timer) {
        this.timer = timer;
        this.effect = effect;
    }

    public WeaponEffect getEffect(){return effect;}

    public int getStatusTimer(){ return timer;}

    public void decreaseStatusTimer(){
        timer--;
    }
}
