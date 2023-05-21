package game.items.weapons;
import game.utils.StatusEffect;

public interface Inflictable {
    StatusEffect inflict();
    int inflictTimer();
}
