package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.neutral.*;

import java.util.Arrays;
import java.util.List;

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

    public static String displayString(){
        return "Boss Room";
    }

}
