package game.grounds.neutral;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @modifier Kenan Baydar
 *
 */
public class Wall extends Ground {

	/**
	 * Constructor.
	 */
	public Wall() {
		super('#');
	}

	/**
	 * Constructor.
	 *
	 * @param actor	All actors cannot enter the wall.
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * The wall will be able to block all thrown objects.
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
