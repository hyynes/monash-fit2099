package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.environments.*;
import game.grounds.neutral.*;
import java.util.Arrays;
import java.util.List;

public class StormveilCastle implements DifferentMaps{

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
            new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cage(), new Barrack(), new SiteOfLostGrace(),
            new Cliff());

    public GameMap map(){
        List<String> map = Arrays.asList(
                "...........................................................................",
                "..................<...............<........................................",
                "...........................................................................",
                "##############################################...##########################",
                "............................#................#.......B..............B......",
                ".....B...............B......#................#.............................",
                "...............................<.........<.................................",
                ".....B...............B......#................#.......B..............B......",
                "............................#................#.............................",
                "#####################..#############...############.####..#########...#####",
                "...............#++++++++++++#................#++++++++++++#................",
                "...............#++++++++++++...<.........<...#++++++++++++#................",
                "...............#++++++++++++..................++++++++++++#................",
                "...............#++++++++++++#................#++++++++++++#................",
                "#####...##########.....#############...#############..#############...#####",
                ".._______........................B......B........................B.....B...",
                "_____..._..____....&&........<..............<..............................",
                ".........____......&&......................................................",
                "...._______..................<..............<....................<.....<...",
                "#####....##...###..#####...##########___###############......##.....####...",
                "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
        return new GameMap(groundFactory, map);
    }

    public static String displayToString(){
        return "Stormveil Castle";
    }
}
