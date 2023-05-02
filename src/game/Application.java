package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.positions.World;
import game.Actors.Enemies.HeavySkeletalSwordsman;
import game.Actors.Enemies.LoneWolf;
import game.Actors.FriendlyActors.Merchant;
import game.Actors.FriendlyActors.Player;
import game.Grounds.NeutralGrounds.SiteOfLostGrace;
import game.Displays.FancyMessage;
import game.Grounds.NeutralGrounds.Dirt;
import game.Grounds.NeutralGrounds.Floor;
import game.Grounds.NeutralGrounds.Wall;
import game.Grounds.EnemyEnvironments.Environment;
import game.Grounds.EnemyEnvironments.Graveyard;
import game.Grounds.EnemyEnvironments.GustOfWind;
import game.Grounds.EnemyEnvironments.PuddleOfWater;
import game.Items.Weapons.Club;
import game.Items.Weapons.GreatKnife;
import game.Items.Weapons.Grossmesser;
import game.Items.Weapons.Uchigatana;
import game.Utils.PlayerSpawnPoint;
import game.Utils.ResetManager;
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

		Player player = null;

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace());

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
				"..................................______U_#................................",
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
		ResetManager.getInstance().setMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		// Optional req 4 implementation
		Scanner scanner = new Scanner(System.in);
		while (player == null) {
			System.out.println("Choose your class:\ns: Samurai\nb: Bandit\nw: Wretch");
			String classes = scanner.next();
			player = switch (classes) {
				case "s" -> new Player("Tarnished", '@', 455, new Uchigatana());
				case "b" -> new Player("Tarnished", '@', 414, new GreatKnife());
				case "w" -> new Player("Tarnished", '@', 414, new Club());
				default -> {
					System.out.println("Enter a valid class");
					yield null;
				}
			};
		}

		Merchant merchant = new Merchant("Merchant Kale", 'K', 100);

		// Setting the target for the enemies spawned from the environments to Tarnished.
		Graveyard.setTarget(player);
		GustOfWind.setTarget(player);
		PuddleOfWater.setTarget(player);

		// HINT: what does it mean to prefer composition to inheritance?

		// initialise merchant and player locations
		world.addPlayer(merchant, gameMap.at(40, 12));
		world.addPlayer(player, gameMap.at(36, 10));

		gameMap.at(30, 10).addActor(new HeavySkeletalSwordsman(player));

		PlayerSpawnPoint.getInstance().setSpawnLocation(gameMap.at(38, 10));

		NumberRange xRange = gameMap.getXRange();

		int xRangeSize = xRange.max() - xRange.min() + 1;
		int middleX = xRange.min() + xRangeSize / 2;

		NumberRange yRange = gameMap.getYRange();

		// Checks whether the environment is located east or west of the map to determine what type of enemy should spawn.
		for (int y = 0; y <= yRange.max(); y++) {
			for (int x = 0; x <= xRange.max(); x++) {
				if (x <= middleX){
					gameMap.at(x, y).getGround().addCapability(Status.WEST);
				}
				else {
					gameMap.at(x, y).getGround().addCapability(Status.EAST);
				}
			}
		}

		world.run();
	}
}


