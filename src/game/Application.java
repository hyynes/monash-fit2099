package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.positions.World;
import game.Actors.FriendlyActors.Merchant;
import game.Actors.FriendlyActors.Player;
import game.Displays.FancyMessage;
import game.Grounds.NeutralEnvironments.Dirt;
import game.Grounds.NeutralEnvironments.Floor;
import game.Grounds.NeutralEnvironments.Wall;
import game.Grounds.EnemyEnvironments.Environment;
import game.Grounds.EnemyEnvironments.Graveyard;
import game.Grounds.EnemyEnvironments.GustOfWind;
import game.Grounds.EnemyEnvironments.PuddleOfWater;
import game.Utils.Status;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Kenan Baydar
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		Player player = new Player("Tarnished", '@', 300);

		Merchant merchant = new Merchant("Merchant Kale", 'K', 100);

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(), new PuddleOfWater());

		// Setting the target for the enemies spawned from the environments to Tarnished.
		Graveyard.setTarget(player);
		GustOfWind.setTarget(player);
		PuddleOfWater.setTarget(player);

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"......~~~.........................__#...........................~~~........",
				"......~~~.............._____........#...........................~~~........",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"...&&.............................###___###........................&&......",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"...........nn.......................................nn........###..__###...",
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

		// Add merchant and player to the game
		world.addPlayer(merchant, gameMap.at(40, 12));
		world.addPlayer(player, gameMap.at(36, 10));

		NumberRange xRange = gameMap.getXRange();

		int xRangeSize = xRange.max() - xRange.min() + 1;
		int middleX = xRange.min() + xRangeSize / 2;

		NumberRange yRange = gameMap.getYRange();

		// Checks whether the environment is located east or west of the map to determine what type of enemy should spawn.
		for (int y = 0; y <= yRange.max(); y++) {
			for (int x = 0; x <= xRange.max(); x++) {
				if (gameMap.at(x, y).getGround() instanceof Environment) {
					if (x <= middleX){
						gameMap.at(x, y).getGround().addCapability(Status.WEST);
					}
					else {
						gameMap.at(x, y).getGround().addCapability(Status.EAST);
					}
				}
			}
		}

		world.run();
	}
}


/**
 gameMap.at(23, 17).addActor(new LoneWolf(player));
 gameMap.at(20, 10).addActor(new HeavySkeletalSwordsman(player));
 gameMap.at(40, 18).addActor(new GiantCrab(player));
 gameMap.at(3, 8).addActor(new SkeletalBandit(player));
 gameMap.at(13, 23).addActor(new GiantDog(player));
 gameMap.at(12, 3).addActor(new GiantCrayfish(player));

 */
