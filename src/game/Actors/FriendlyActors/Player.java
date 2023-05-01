package game.Actors.FriendlyActors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.*;
import game.Grounds.NeutralGrounds.SiteOfLostGrace;
import game.Items.StackableItems.FlaskOfCrimsonTears;
import game.Utils.PlayerSpawnPoint;
import game.Utils.RandomNumberGenerator;
import game.Utils.Resettable;
import game.Items.StackableItems.Rune;
import game.Utils.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong, Kenan Baydar
 */
public class Player extends Actor implements Resettable, PlayableCharacter {

	private int maxHP;
	private final Menu menu = new Menu();
	public Rune runes = new Rune();
	public FlaskOfCrimsonTears flask = new FlaskOfCrimsonTears();

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

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// Displays its health and runes, and updates it every turn.
		System.out.println(displayStats());

		actions.add(new HealAction());

		if (SiteOfLostGrace.isPlayerInSite){
			actions.add(new RestAction());
		}

		if (map.locationOf(this).getDisplayChar() == '$'){
			actions.add(new PickUpRunesAction((Rune) map.locationOf(this).getItems()));
		}

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void reset(GameMap map){
		// as to avoid runtime errors
		if (map.locationOf(this) != PlayerSpawnPoint.getInstance().getSpawnLocation()) {
			map.moveActor(this, PlayerSpawnPoint.getInstance().getSpawnLocation());
		}
		this.heal(maxHP);
		flask.setNoOfStacks(2);
	}

	/**
	 * Add Runes function.
	 * Adds a number of runes to the player's inventory after defeating an enemy.
	 *
	 * @param enemy the enemy that drops the runes
	 * @param min	the minimum number of runes that can be generated
	 * @param max	the maximum number of runes that can be generated
	 * @see DeathAction
	 */
	public String enemyDefeatedRunes(Actor enemy, int min, int max){
		int generatedRunes = RandomNumberGenerator.getRandomInt(min, max);
		if (runes.addStacks(generatedRunes)){
			return enemy + " drops " + generatedRunes + " runes";
		}
		return null;
	}

	/**
	 * Removes a number of runes from the player's inventory.
	 *
	 * @param removeRunes the amount of runes to be removed.
	 * @return true or false on whether the player will have a positive amount of runes after removing runes.
	 * @see BuyAction
	 */

	@Override
	public boolean removeRunes(int removeRunes){
		return runes.removeStacks(removeRunes);
	}

	@Override
	public boolean addRunes(int addRunes) {
		return runes.addStacks(addRunes);
	}

	public String displayStats(){
		return name + " (" + this.hitPoints + "/" + this.getMaxHp() + "), " + "runes: " + runes.getNoOfStacks();
	}
}
