package game.items.weapons;
import game.utils.WeaponEffect;

public interface Inflictable {
    WeaponEffect inflict();
    int inflictTimer();
}
