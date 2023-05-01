package game.Utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager{
    private List<Resettable> resettables;
    private GameMap map;

    private ResetManager() {
        this.resettables = new ArrayList<>();
    }
    private static ResetManager instance = null;

    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

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

    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }

    public void setMap(GameMap currentMap){
        this.map = currentMap;
    }
}
