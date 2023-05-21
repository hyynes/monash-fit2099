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
 * The map of the Stormveil Castle.
 * Created by:
 * @author Kenan Baydar
 *
 */
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
                "+++++++++++++++++++++++++++................U...#+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
        return new GameMap(groundFactory, map);
    }

    /**
     *
     * Golden Runes scattered across the map.
     */
    public void addGoldenRunes(GameMap maps, Player actor) {
        maps.at(6,6).addItem(new GoldenRunes(actor));
        maps.at(12,10).addItem(new GoldenRunes(actor));
        maps.at(23,2).addItem(new GoldenRunes(actor));
        maps.at(2,18).addItem(new GoldenRunes(actor));
        maps.at(36,12).addItem(new GoldenRunes(actor));
        maps.at(34,7).addItem(new GoldenRunes(actor));
        maps.at(64,11).addItem(new GoldenRunes(actor));
        maps.at(54,16).addItem(new GoldenRunes(actor));
        maps.at(40,17).addItem(new GoldenRunes(actor));
    }

    /**
     *
     * @return The name of the map displayed as a string.
     */
    public static String displayString(){
        return "Stormveil Castle";
    }
}
