package game.Utils;

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
 * @modifier Danny Duong
 */
public class ResetManager{
    private List<Resettable> resettables;
    private GameMap map;

    private ResetManager() {
        this.resettables = new ArrayList<>();
    }
    private static ResetManager instance = null;

    /**
     * Instance setter.
     * @return the singleton instance of ResetManager.
     */
    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }


    /**
     * Loops through all resettable actors and calls the reset function.
     */
    public void run() {

        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        for (int y = 0; y <= yRange.max(); y++) {
            for (int x = 0; x <= xRange.max(); x++) {
                Actor actor = map.at(x, y).getActor();
                if (actor != null && actor instanceof Resettable){
                    registerResettable((Resettable) actor);
                }
            }
        }

        if (map != null) {
            for (int i = 0; i < resettables.size(); i++) {
                resettables.get(i).reset(map);
                removeResettable(resettables.get(i));
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
     * @param currentMap - the map to be set.
     * @see Application
     */
    public void setMap(GameMap currentMap){
        this.map = currentMap;
    }
}
