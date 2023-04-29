package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Grounds.Dirt;
import game.Grounds.Floor;
import game.Grounds.Wall;
import game.enemies.*;
import game.environments.Graveyard;
import game.environments.GustOfWind;
import game.environments.PuddleOfWater;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		Player player = new Player("Tarnished", '@', 300);

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(), new PuddleOfWater());

		Graveyard.setTarget(player);
		GustOfWind.setTarget(player);
		PuddleOfWater.setTarget(player);

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#...........................~~~........",
				"......................._____........#...........................~~~........",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"...&&.............................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"....................................................nn........###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		// HINT: what does it mean to prefer composition to inheritance?
		world.addPlayer(player, gameMap.at(36, 10));

		gameMap.at(23, 17).addActor(new LoneWolf(player));
		gameMap.at(30, 10).addActor(new HeavySkeletalSwordsman(player));
		gameMap.at(24, 18).addActor(new GiantCrab(player));
		gameMap.at(3, 8).addActor(new SkeletalBandit(player));
		gameMap.at(13, 23).addActor(new GiantDog(player));
		gameMap.at(12, 3).addActor(new GiantCrayfish(player));

		world.run();
	}
}
