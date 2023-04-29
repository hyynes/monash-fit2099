package game;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Weapons.*;

/**
 * For buying stuff.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class Merchant extends Actor {

    public Merchant(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addWeaponToInventory(new Club());
        this.addWeaponToInventory(new GreatKnife());
        this.addWeaponToInventory(new Uchigatana());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
