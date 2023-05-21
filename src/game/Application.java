package game;

import java.util.ArrayList;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.positions.World;
import game.actions.PlayerDeathAction;
import game.actors.enemies.boss.GodrickTheGrafted;
import game.actors.friendly.FingerReaderEnia;
import game.actors.friendly.MerchantKale;
import game.actors.friendly.Player;
import game.grounds.environments.*;
import game.displays.FancyMessage;
import game.grounds.neutral.GoldenFogDoor;
import game.grounds.neutral.SiteOfLostGrace;
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
		LakeOfRot lakeOfRotBase = new LakeOfRot();

		GameMap limgrave = limgraveBase.map();
		GameMap stormveilCastle = stormveilCastleBase.map();
		GameMap bossRoom = bossRoomBase.map();
		GameMap roundTableHold = roundTableHoldBase.map();
		GameMap lakeOfRot = lakeOfRotBase.map();

		// Add all gameMaps into an arrayList.
		ArrayList<GameMap> gameMaps = new ArrayList<>();
		gameMaps.add(limgrave);
		gameMaps.add(stormveilCastle);
		gameMaps.add(bossRoom);
		gameMaps.add(roundTableHold);
		gameMaps.add(lakeOfRot);

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
		limgrave.at(74,11).setGround(new GoldenFogDoor(lakeOfRot, LakeOfRot.displayString(), 0, 10));
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

		// Merchants to be added into the game.
		MerchantKale merchant1 = new MerchantKale();
		MerchantKale merchant2 = new MerchantKale();
		MerchantKale merchant3 = new MerchantKale();
		FingerReaderEnia fingerReaderEnia1 = new FingerReaderEnia();
		FingerReaderEnia fingerReaderEnia2 = new FingerReaderEnia();

		// Setting the target for the enemies spawned from the environments to Tarnished.
		Graveyard.setTarget(player);
		GustOfWind.setTarget(player);
		PuddleOfWater.setTarget(player);
		Cage.setTarget(player);
		Barrack.setTarget(player);

		// initialise merchant and player locations
		world.addPlayer(merchant1, limgrave.at(40, 12));
		world.addPlayer(merchant2, limgrave.at(3, 21));
		world.addPlayer(merchant3, stormveilCastle.at(40, 21));
		world.addPlayer(fingerReaderEnia1, bossRoom.at(5,5));
		world.addPlayer(fingerReaderEnia2, roundTableHold.at(9,3));
		world.addPlayer(player, limgrave.at(36, 10));
		PlayerSpawnPoint.getInstance().setSpawnLocation(limgrave.at(36, 10));

		// Adding golden runes scattered across the game
		limgraveBase.addGoldenRunes(limgrave, player);
		stormveilCastleBase.addGoldenRunes(stormveilCastle, player);

		// name Site of Lost Graces & discover the first step
		for (GameMap maps: gameMaps){
			NumberRange xRange = maps.getXRange();
			NumberRange yRange = maps.getYRange();

			for (int y = 0; y <= yRange.max(); y++) {
				for (int x = 0; x <= xRange.max(); x++) {
					if (maps.at(x,y).getDisplayChar() == 'U'){
						if (maps.equals(limgrave)){
							((SiteOfLostGrace) maps.at(x,y).getGround()).setName("The First Step");
							((SiteOfLostGrace) maps.at(x,y).getGround()).setDiscovered(true);
						}
						if (maps.equals(roundTableHold)){
							((SiteOfLostGrace) maps.at(x,y).getGround()).setName("Table of Lost Grace");
						}
						if (maps.equals(stormveilCastle)){
							((SiteOfLostGrace) maps.at(x,y).getGround()).setName("Stormveil Main Gate");
						}
						if (maps.equals(lakeOfRot)){
							((SiteOfLostGrace) maps.at(x,y).getGround()).setName("Grand Cloister");
						}
					}
				}
			}
		}

		// Spawn the Godrick the Grafted boss.
		GodrickTheGrafted godrickTheGrafted = new GodrickTheGrafted(player);
		bossRoom.at(12,4).addActor(godrickTheGrafted);
		godrickTheGrafted.setOriginalLocation(bossRoom.locationOf(godrickTheGrafted));

		world.run();
	}
}


