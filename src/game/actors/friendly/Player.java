package game.actors.friendly;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.*;
import game.Application;
import game.grounds.neutral.SiteOfLostGrace;
import game.items.stackable.FlaskOfCrimsonTears;
import game.items.stackable.Rune;
import game.utils.*;

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
		// Handle multi-turn actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// displays its health and runes, and updates it every turn.
		System.out.println(displayStats());

		// if flask has more than one stack, allow HealAction
		if (flask.getNoOfStacks() > 0) {
			actions.add(new HealAction());
		}

		// if player is on site of lost grace, allow rest action
		if (SiteOfLostGrace.isPlayerInSite){
			actions.add(new RestAction());
		}

		// if player is standing on top of rune, allow pick up runes action
		if (!map.locationOf(this).getItems().isEmpty()){
			for (int i = 0; i < map.locationOf(this).getItems().size(); i++){
				if (map.locationOf(this).getItems().get(i) instanceof Rune) {
					actions.add(new PickUpRunesAction((Rune) map.locationOf(this).getItems().get(i)));
				}
			}
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
		this.resetMaxHp(maxHP);
		flask.setNoOfStacks(2);
	}

	/**
	 * Method to add runes when player defeats enemies.
	 * @param enemy the enemy that drops the runes
	 * @param min	the minimum number of runes that can be generated
	 * @param max	the maximum number of runes that can be generated
	 * @return a message displaying how many runes the player picked up.
	 */

	public String enemyDefeatedRunes(Actor enemy, int min, int max){
		int generatedRunes = RandomNumberGenerator.getRandomInt(min, max);
		if (runes.addStacks(generatedRunes)){
			return enemy + " drops " + generatedRunes + " runes";
		}
		return null;
	}

	@Override
	public boolean removeRunes(int removeRunes){
		return runes.removeStacks(removeRunes);
	}

	@Override
	public boolean addRunes(int addRunes) {
		return runes.addStacks(addRunes);
	}

	/**
	 * Displays the player's stats to a digestible format.
	 * @return the string to be displayed.
	 * @see Application
	 */

	public String displayStats(){
		String stats;
		stats = name + " (" + this.hitPoints + "/" + this.getMaxHp() + ")";
		stats += System.lineSeparator() + runes.displayToString();
		stats += System.lineSeparator() + flask.displayToString();
		return stats;
	}
}
