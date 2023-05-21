package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actors.Statusable;
import game.actors.enemies.Enemy;
import game.actors.enemies.StatusManager;
import game.items.weapons.Inflictable;
import game.utils.Status;

/**
 * An Action to attack another Actor.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @modifier Danny Duong, Kenan Baydar
 */
public class AttackAction extends Action{

	/**
	 * The Actor that is to be attacked
	 */
	private final Actor target;

	/**
	 * The Actor that is targeted by the target in followBehaviour.
	 */
	private final Actor targetsTarget;

	/**
	 * The direction of incoming attack.
	 */
	private final String direction;

	/**
	 * Random number generator
	 */
	private final Random rand = new Random();

	/**
	 * Weapon used for the attack
	 */
	private Weapon weapon;

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 * @param targetsTarget the Actor that is targeted by the target.
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 * @param weapon the weapon use by the Actor that is attacking
	 */
	public AttackAction(Actor target, Actor targetsTarget, String direction, Weapon weapon) {
		this.target = target;
		this.targetsTarget = targetsTarget;
		this.direction = direction;
		this.weapon = weapon;
	}

	/**
	 * Constructor with intrinsic weapon as default
	 *
	 * @param target the actor to attack
	 * @param targetsTarget the Actor that is targeted by the target.
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, Actor targetsTarget, String direction) {
		this.target = target;
		this.targetsTarget = targetsTarget;
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
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();
		result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);

		if (weapon instanceof Inflictable){
			if (target instanceof Statusable){
				StatusManager status = new StatusManager(
						((Inflictable) weapon).inflict(),
						((Inflictable) weapon).inflictTimer()
				);
				((Statusable) target).addStatus(status);
			}
		}

		if (!target.isConscious()) {
			if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
				result += new PlayerDeathAction().execute(target, map);
			}
			else{
				result += new DeathAction(actor, targetsTarget).execute(target, map);
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
		return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
	}
}
