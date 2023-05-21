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
 * Lake of rot.
 * Created by:
 * @author Danny Duong
 */

public class LakeOfRot implements DifferentMaps{

    public GameMap map(){

        FancyGroundFactory groundFactory = new FancyGroundFactory(new RockOfRot(), new SiteOfLostGrace(), new RotLakeWater(), new Cliff(), new Floor(), new Wall(), new Dirt());

        List<String> map = Arrays.asList(
                "========++++=====##...........................",
                "=========++=======##...................O......",
                "==========+========##.................OOO.....",
                "====================##.................O......",
                "======OO=============##.......................",
                "======OO==============##......................",
                "=======================#####...###############",
                "===========================.....==============",
                "........................................======",
                ".............................=====###___###===",
                "........................==========#_______#===",
                "......============================#___U___#===",
                ".....=======+++============OOO====#_______#===",
                "============+++============OOO====#########===",
                "===========+++++==============================");

        return new GameMap(groundFactory, map);
    }

    /**
     *
     * Golden Runes scattered across the map.
     */
    public void addGoldenRunes(GameMap maps, Player actor){

    }

    /**
     *
     * @return The name of the map displayed as a string.
     */
    public static String displayString(){
        return "Lake of Rot";
    }
}
