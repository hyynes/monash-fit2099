package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong, Kenan Baydar
 */

public class ResetManager{
    private final List<Resettable> resettables;
    private final List<GameMap> gameMaps = new ArrayList<>();
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }
    private static ResetManager instance = null;

    /**
     * Instance setter.
     * @return the singleton instance of ResetManger.
     */
    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Loops through all resettable actors in all maps and calls the reset function.
     */
    public void run() {

        for (GameMap map : gameMaps) {
            NumberRange xRange = map.getXRange();
            NumberRange yRange = map.getYRange();

            List<Resettable> resettablesToRemove = new ArrayList<>();

            for (int y = 0; y <= yRange.max(); y++) {
                for (int x = 0; x <= xRange.max(); x++) {
                    Actor actor = map.at(x, y).getActor();
                    if (actor instanceof Resettable) {
                        registerResettable((Resettable) actor);
                    }
                }
            }

            // removes all enemies from the game map
            for (Resettable resettable : resettables) {
                resettable.reset(map);
                resettablesToRemove.add(resettable);
            }

            for (Resettable resettable : resettablesToRemove) {
                removeResettable(resettable);
            }
        }

    }

    /**
     * Adds a resettable to the resettables arraylist.
     * @param resettable - the resettable to be added.
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * Removes a resettable to the resettables arraylist.
     * @param resettable - the resettable to be removed.
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }

    /**
     * Sets the map to be resetted.
     * @param map - the map added into the game
     * @see Application
     */
    public void addMaps(GameMap map){
        gameMaps.add(map);
    }
}
