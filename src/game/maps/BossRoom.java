package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.neutral.*;

import java.util.Arrays;
import java.util.List;

/**
 * The map of the Boss Room.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class BossRoom implements DifferentMaps{

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new SiteOfLostGrace(), new Cliff());

    public GameMap map(){
        List<String> map = Arrays.asList(
                "+++++++++++++++++++++++++",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                "+++++++++++++++++++++++++");
        return new GameMap(groundFactory, map);
    }

    /**
     *
     * @return The name of the map displayed as a String.
     */
    public static String displayString(){
        return "Boss Room";
    }

}
