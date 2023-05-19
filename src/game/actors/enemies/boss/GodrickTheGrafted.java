package game.actors.enemies.boss;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class GodrickTheGrafted extends BossEnemy {

    /**
     * Constructor.
     *
     * @param target Actor the Giant Dog will follow.
     */
    public GodrickTheGrafted(Actor target) {
        super("Godrick The Grafted", 'Y', 6080, target);
    }

    /**
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hitPoints <= maxHitPoints/2){
            //removeWeaponFromInventory();
            //addWeaponToInventory();
            return null;
        }
        return null;

    }
    */

    /**
     *
     * @return minimum number of runes Godrick The Grafted can generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 20000;
    }

    /**
     *
     * @return maximum number of runes the Godrick The Grafted can generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 20000;
    }
}
