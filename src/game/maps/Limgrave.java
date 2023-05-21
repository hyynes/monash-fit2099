package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.friendly.Player;
import game.grounds.environments.*;
import game.grounds.neutral.*;
import game.items.special.GoldenRunes;

import java.util.Arrays;
import java.util.List;

/**
 * The map of Limgrave.
 * Created by:
 * @author Kenan Baydar
 *
 */
public class Limgrave implements DifferentMaps{

    public GameMap map(){

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
                new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cage(), new Barrack(), new SiteOfLostGrace(),
                new Cliff());

        List<String> map = Arrays.asList(
                "......................#.............#..........................+++.........",
                "......................#.............#.......................+++++..........",
                ".nnn..................#..___....____#.........................+++++........",
                ".nnn..................#...........__#...................~~~......++........",
                "......................#_____........#...................~~~.......+++......",
                "......................#............_#...................~~~........+++.....",
                "......................######...######......................................",
                "...........................................................................",
                "...........................................................................",
                "........++++......................###___###............................____",
                "........+++++++...................______U_#....nnn...................._____",
                "~~~.......+++.....................#________.........................._____.",
                "~~~.........+++...................#_______#....nnn...................._____",
                "~~~..........+....................###___###............................____",
                "~~~.........++......................#___#..................................",
                "..............+............................................................",
                "..............++...........................................................",
                "..............................................++...........................",
                "..................++++......................+++.......&&......######..##...",
                "#####___######....++...........................+++....&&......#....____....",
                "_____________#.....+&&+..........................+..............__.....#...",
                "_____________#.....+&&..++........................++.........._.....__.#...",
                "_____________#.........+..+.....................+++...........###..__###...",
                "_____________#.............++..............................................");

        return new GameMap(groundFactory, map);
    }

    /**
     *
     * Golden Runes scattered across the map.
     */
    public void addGoldenRunes(GameMap maps, Player actor){
        maps.at(6,6).addItem(new GoldenRunes(actor));
        maps.at(22,10).addItem(new GoldenRunes(actor));
        maps.at(23,2).addItem(new GoldenRunes(actor));
        maps.at(15,15).addItem(new GoldenRunes(actor));
        maps.at(41,4).addItem(new GoldenRunes(actor));
        maps.at(37,16).addItem(new GoldenRunes(actor));
        maps.at(61,13).addItem(new GoldenRunes(actor));
        maps.at(56,9).addItem(new GoldenRunes(actor));
    }

    /**
     *
     * @return The name of the map displayed as a String.
     */
    public static String displayString(){
        return "Limgrave";
    }
}
