package game.actors.enemies.boss;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.Behaviour;
import game.items.RemembranceOfTheGrafted;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;

/**
 * First boss that is located in the Boss Room.
 * Drops a site of lost grace after being defeated.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class GodrickTheGrafted extends BossEnemy {

    /**
     * Axe of Godrick weapon used by Godrick the Grafted during his first phase.
     */
    WeaponItem axeOfGodrick = new AxeOfGodrick();

    /**
     * Grafted Dragon weapon used by Godrick the Grafted during his second phase.
     */
    WeaponItem graftedDragon = new GraftedDragon();

    /**
     * Toggle for second phase of the boss.
     */
    private boolean toggle = true;

    /**
     * Constructor.
     *
     * @param target Actor Godrick the Grafted will follow.
     */
    public GodrickTheGrafted(Actor target) {
        super("Godrick The Grafted", 'Y', 6080, target);
        axeOfGodrick.togglePortability();
        this.addWeaponToInventory(axeOfGodrick);
        this.addItemToInventory(new RemembranceOfTheGrafted());
    }

    /**
     * At each turn, select a valid action to perform.
     * Enters a new phase after losing 50% health.
     *
     * @param actions    collection of possible actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // Enters second phase after having less than 50% health
        if (this.hitPoints <= maxHitPoints/2 && toggle){
            removeWeaponFromInventory(axeOfGodrick);
            graftedDragon.togglePortability();
            addWeaponToInventory(graftedDragon);
            toggle = false;
        }

        // General behaviours for enemies excluding the chance to despawn.
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     *
     * @return minimum number of runes Godrick the Grafted will generate after being killed.
     */
    @Override
    public int getRuneMin() {
        return 20000;
    }

    /**
     *
     * @return maximum number of runes Godrick the Grafted will generate after being killed.
     */
    @Override
    public int getRuneMax() {
        return 20000;
    }
}
