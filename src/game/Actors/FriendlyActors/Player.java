package game.Actors.FriendlyActors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.*;
import game.Application;
import game.Grounds.NeutralGrounds.SiteOfLostGrace;
import game.Items.StackableItems.FlaskOfCrimsonTears;
import game.Items.StackableItems.Rune;
import game.Utils.*;

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

		if (flask.getNoOfStacks() > 0) {
			actions.add(new HealAction());
		}

		if (SiteOfLostGrace.isPlayerInSite){
			actions.add(new RestAction());
		}

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
		// as to avoid runtime errors*
		if (map.locationOf(this) != PlayerSpawnPoint.getInstance().getSpawnLocation()) {
			map.moveActor(this, PlayerSpawnPoint.getInstance().getSpawnLocation());
		}
		this.resetMaxHp(maxHP);
		flask.setNoOfStacks(2);
	}

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
