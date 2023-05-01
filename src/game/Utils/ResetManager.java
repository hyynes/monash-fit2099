package game.Utils;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.Grounds.EnemyEnvironments.Environment;

import java.util.ArrayList;
import java.util.Iterator;
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
        if (map != null) {
            for (int i = 0; i < resettables.size(); i++) {
                resettables.get(i).reset(map);
            }
        }
    }

    public void registerResettable(Resettable resettable) {

    }

    public void removeResettable(Resettable resettable) {}

    public void setMap(GameMap currentMap){
        this.map = currentMap;
    }
}
