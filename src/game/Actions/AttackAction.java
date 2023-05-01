package game.Actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Actors.Enemies.Enemy;
import game.Actors.FriendlyActors.Player;
import game.Displays.DisplayStrings;
import game.Actors.Enemies.Skeleton;

/**
 * An Action to attack another Actor.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong
 */
public class AttackAction extends Action implements DisplayStrings {

	/**
	 * The Actor that is to be attacked
	 */
	private Actor target;

	/**
	 * The direction of incoming attack.
	 */
	private String direction;

	/**
	 * Random number generator
	 */
	private Random rand = new Random();

	/**
	 * Weapon used for the attack
	 */
	private Weapon weapon;

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, String direction, Weapon weapon) {
		this.target = target;
		this.direction = direction;
		this.weapon = weapon;
	}

	/**
	 * Constructor with intrinsic weapon as default
	 *
	 * @param target the actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

	/**
	 * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
	 * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
	 *
	 * @param actor The actor performing the attack action.
	 * @param map The map the actor is on.
	 * @return the result of the attack, e.g. whether the target is killed, etc.
	 * @see DeathAction
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result;
		if (weapon == null) {
			weapon = actor.getIntrinsicWeapon();
		}

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			if (target instanceof Skeleton && ((Skeleton) target).getPileOfBones()) {
				return missPileOfBones(actor);
			}
			return missEnemy(actor, target);
		}

		int damage = weapon.damage();
		if (target instanceof Skeleton && ((Skeleton) target).getPileOfBones()){
			result = hitPileOfBones(actor, weapon, damage);
		}
		else{
			result = hitEnemy(actor, target, weapon, damage);
		}
		target.hurt(damage);
		if (!target.isConscious()) {
			if (target instanceof Enemy) {
				result += new DeathAction(actor).execute(target, map);
			}
			else if (target instanceof Player){
				result += new PlayerDeathAction().execute(target, map);
			}
		}
		return result;
	}

	/**
	 * Describes which target the actor is attacking with which weapon
	 *
	 * @param actor The actor performing the action.
	 * @return a description used for the menu UI
	 */
	@Override
	public String menuDescription(Actor actor) {
		if (target instanceof Skeleton && ((Skeleton) target).getPileOfBones()){
			return actor + " attacks Pile of Bones at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
		}
		return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
	}
}
