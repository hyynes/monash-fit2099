package game.grounds.neutral;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

/**
 * The respawn site.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public class SiteOfLostGrace extends Ground {

    // constructor
    public SiteOfLostGrace() {
        super('U');
    }
    public static boolean isPlayerInSite;

    /**
     * Checks if player is in the Site of Lost Grace. If so, tick isPlayerInSite to true. If not, false.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            Actor actor = location.getActor();
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                isPlayerInSite = true;
            }
            else {
                isPlayerInSite = false;
            }
        }
        else {
            isPlayerInSite = false;
        }
    }
}
