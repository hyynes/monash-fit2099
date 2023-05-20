package game;

import java.util.ArrayList;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.positions.World;
import game.actions.PlayerDeathAction;
import game.actors.enemies.boss.GodrickTheGrafted;
import game.actors.friendly.Merchant;
import game.actors.friendly.Player;
import game.grounds.environments.*;
import game.displays.FancyMessage;
import game.grounds.neutral.GoldenFogDoor;
import game.items.weapons.*;
import game.actors.friendly.PlayerSpawnPoint;
import game.maps.*;
import game.utils.ResetManager;
import game.utils.Status;

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

		// Initialise all gameMaps that will be added into the game.
		Limgrave limgraveBase = new Limgrave();
		StormveilCastle stormveilCastleBase = new StormveilCastle();
		BossRoom bossRoomBase = new BossRoom();
		RoundTableHold roundTableHoldBase = new RoundTableHold();

		GameMap limgrave = limgraveBase.map();
		GameMap stormveilCastle = stormveilCastleBase.map();
		GameMap bossRoom = bossRoomBase.map();
		GameMap roundTableHold = roundTableHoldBase.map();

		// Add all gameMaps into an arrayList.
		ArrayList<GameMap> gameMaps = new ArrayList<>();
		gameMaps.add(limgrave);
		gameMaps.add(stormveilCastle);
		gameMaps.add(bossRoom);
		gameMaps.add(roundTableHold);

		// Loop through all gameMaps in the arrayList and add them into the world.
		for (GameMap gameMap: gameMaps) {
			world.addGameMap(gameMap);
			ResetManager.getInstance().addMaps(gameMap);
			PlayerDeathAction.addMaps(gameMap);

			NumberRange yRange = gameMap.getYRange();
			NumberRange xRange = gameMap.getXRange();

			int xRangeSize = xRange.max() - xRange.min() + 1;
			int middleX = xRange.min() + xRangeSize / 2;

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
		}

		// Add Golden Fog Doors to certain areas in different gameMaps.
		limgrave.at(30,0).setGround(new GoldenFogDoor(stormveilCastle, StormveilCastle.displayString(),38,23));
		limgrave.at(5,23).setGround(new GoldenFogDoor(roundTableHold, RoundTableHold.displayString(),9,10));
		stormveilCastle.at(38,23).setGround(new GoldenFogDoor(limgrave, Limgrave.displayString(),30,0));
		stormveilCastle.at(5,0).setGround(new GoldenFogDoor(bossRoom, BossRoom.displayString(),0,4));
		roundTableHold.at(9,10).setGround(new GoldenFogDoor(limgrave, Limgrave.displayString(),5,23));

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
		Player player = null;
		Scanner scanner = new Scanner(System.in);
		while (player == null) {
			System.out.println("Choose your class:\ns: Samurai\nb: Bandit\nw: Wretch\nT: Testing");
			String classes = scanner.next();
			player = switch (classes) {
				case "s" -> new Player("Tarnished", '@', 455, new Uchigatana());
				case "b" -> new Player("Tarnished", '@', 414, new GreatKnife());
				case "w" -> new Player("Tarnished", '@', 414, new Club());
				case "T" -> new Player("Tarnished", '@', 100000, new Eraser());
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
		Cage.setTarget(player);
		Barrack.setTarget(player);

		// initialise merchant and player locations
		world.addPlayer(merchant, limgrave.at(40, 12));
		world.addPlayer(player, limgrave.at(36, 10));
		PlayerSpawnPoint.getInstance().setSpawnLocation(limgrave.at(36, 10));

		// Adding golden runes into the game.
		limgraveBase.addGoldenRunes(limgrave, player);
		stormveilCastleBase.addGoldenRunes(stormveilCastle, player);

		// Spawn the Godrick the Grafted boss.
		GodrickTheGrafted godrickTheGrafted = new GodrickTheGrafted(player);
		bossRoom.at(12,4).addActor(godrickTheGrafted);
		godrickTheGrafted.setOriginalLocation(bossRoom.locationOf(godrickTheGrafted));

		world.run();
	}
}


