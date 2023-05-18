package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.environments.*;
import game.grounds.neutral.*;
import java.util.Arrays;
import java.util.List;

public class Limgrave implements DifferentMaps{

    public GameMap map(){

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
                new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cage(), new Barrack(), new SiteOfLostGrace(),
                new Cliff());

        List<String> map = Arrays.asList(
                "......................#.............#..........................+++.........",
                "......................#.............#.......................+++++..........",
                "......................#..___....____#.........................+++++........",
                "......................#...........__#............................++........",
                "......................#_____........#.............................+++......",
                "......................#............_#..............................+++.....",
                "......................######...######......................................",
                "...........................................................................",
                "...........................................................................",
                "........++++......................###___###................................",
                "........+++++++...................________#................................",
                "..........+++.....................#________................................",
                "............+++...................#_______#................................",
                ".............+....................###___###................................",
                "............++......................#___#..................................",
                "..............+............................................................",
                "..............++...........................................................",
                "..............................................++...........................",
                "..................++++......................+++...............######..##...",
                "#####___######....++...........................+++............#....____....",
                "_____________#.....++++..........................+..............__.....#...",
                "_____________#.....+....++........................++.........._.....__.#...",
                "_____________#.........+..+.....................+++...........###..__###...",
                "_____________#.............++..............................................");

        return new GameMap(groundFactory, map);
    }

    public static String displayToString(){
        return "Limgrave";
    }

}
