package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.environments.*;
import game.grounds.neutral.*;

import java.util.Arrays;
import java.util.List;

/**
 * The map of the Round Table Hold.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class RoundTableHold implements DifferentMaps{

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Wall(), new Floor(), new SiteOfLostGrace());

    public GameMap map(){
        List<String> map = Arrays.asList(
                "##################",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "########___#######");
        return new GameMap(groundFactory, map);
    }

    /**
     *
     * @return The name of the map displayed as a string.
     */
    public static String displayString(){
        return "Round Table Hold";
    }
}
