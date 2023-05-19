package game.actors.enemies.boss;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.behaviours.Behaviour;

public abstract class BossEnemy extends Enemy {

    private Location originalLocation;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param target      the Actor that the enemy will follow
     */
    public BossEnemy(String name, char displayChar, int hitPoints, Actor target) {
        super(name, displayChar, hitPoints, target);
        this.behaviours.remove(998);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // General playTurn step for all enemies
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * Resets the enemies
     *
     * @param map - the map that the actors are in.
     */
    @Override
    public void reset(GameMap map){
        map.moveActor(this, originalLocation);
    }

    public void setOriginalLocation(Location originalLocation){
        this.originalLocation = originalLocation;
    }
}
