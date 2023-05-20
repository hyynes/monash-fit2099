package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.environments.*;
import game.grounds.neutral.*;

import java.util.Arrays;
import java.util.List;

public class RoundTableHold implements DifferentMaps{

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
            new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cage(), new Barrack(), new SiteOfLostGrace(),
            new Cliff());

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

    public static String displayString(){
        return "Roundtable Hold";
    }
}
