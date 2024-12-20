package game.actors.friendly;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.*;
import game.Application;
import game.actors.Statusable;
import game.actors.enemies.StatusManager;
import game.items.stackable.Consumable;
import game.items.stackable.EnemyRunes;
import game.items.stackable.FlaskOfCrimsonTears;
import game.items.stackable.Rune;
import game.utils.*;
import java.util.ArrayList;

import static game.utils.StatusEffect.SLEEP;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong, Kenan Baydar
 */
public class Player extends Actor implements Resettable, PlayableCharacter, Statusable {

	private final int maxHP;
	private final Menu menu = new Menu();
	private final Rune runes = new Rune();
	private final FlaskOfCrimsonTears flask = new FlaskOfCrimsonTears();
	private Location lastLocation;
	private ArrayList<StatusManager> statuses = new ArrayList<StatusManager>();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, WeaponItem weapon) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(weapon);
		this.addItemToInventory(runes);
		this.addItemToInventory(flask);
		maxHP = hitPoints;
	}

	/**
	 * New actions added after each turn depending on position and location, and others.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn.
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return All possible actions for the player
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		ArrayList<StatusManager> statusesToRemove = new ArrayList<>();

		for (StatusManager status : statuses) {
			if (checkStatus(status) != null) {
				System.out.println(checkStatus(status).execute(this, map));
			}
			else {
				statusesToRemove.add(status);
			}
			if (status.getEffect() == SLEEP) {
				return new DoNothingAction();
			}
		}

		for (StatusManager status : statusesToRemove){
			statuses.remove(status);
		}

		statusesToRemove.clear();
		if (this.hitPoints <= 0){
			return new PlayerDeathAction();
		}
		// Handle multi-turn actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// displays its health and runes, and updates it every turn.
		System.out.println(displayStats());

		for (Item item : getItemInventory()){
			if (item instanceof Consumable){
				actions.add(new ConsumeAction(item, this));
			}
		}

		// if player is standing on top of rune, allow pick up runes action
		if (!map.locationOf(this).getItems().isEmpty()){
			for (int i = 0; i < map.locationOf(this).getItems().size(); i++){
				if (map.locationOf(this).getItems().get(i) instanceof Rune) {
					actions.add(new PickUpRunesAction((Rune) map.locationOf(this).getItems().get(i)));
				}
			}
		}
		lastLocation = map.locationOf(this);

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void reset(GameMap map){
		// as to avoid runtime errors
		if (map.locationOf(this) != PlayerSpawnPoint.getInstance().getSpawnLocation()) {
			map.moveActor(this, PlayerSpawnPoint.getInstance().getSpawnLocation());
		}
		this.statuses.clear();
		this.resetMaxHp(maxHP);
		flask.setNoOfStacks(2);
	}

	/**
	 * Method to add runes when player defeats enemies.
	 * @param enemy the enemy that drops the runes
	 * @param enemyRunes the amount of runes the enemy can drop
	 * @return a message displaying how many runes the player picked up.
	 */

	public String enemyDefeatedRunes(Actor enemy, EnemyRunes enemyRunes){
		int generatedRunes = RandomNumberGenerator.getRandomInt(enemyRunes.getRuneMin(), enemyRunes.getRuneMax());
		runes.addStacks(generatedRunes);
		return enemy + " drops " + generatedRunes + " runes.";
	}

	@Override
	public boolean removeRunes(int removeRunes){
		return runes.removeStacks(removeRunes);
	}

	@Override
	public void addRunes(int addRunes) {
		runes.addStacks(addRunes);
	}

	/**
	 * Displays the player's stats to a digestible format.
	 * @return the string to be displayed.
	 * @see Application
	 */

	public String displayStats(){
		String stats;
		stats = name + " " + printHp() + ", " + runes.displayToString();
		return stats;
	}

	public Location getLastLocation(){
		return lastLocation;
	}

	public Rune getRunes(){
		return runes;
	}

	@Override
	public void addStatus(StatusManager status){
		statuses.add(status);
	}

	@Override
	public void removeStatus(StatusManager status){statuses.remove(status);}

	@Override
	public Action checkStatus(StatusManager status){
		if (status.getStatusTimer() == 0) {
			return null;
		}
		else {
			return new StatusAction(status);
		}
	}
}
