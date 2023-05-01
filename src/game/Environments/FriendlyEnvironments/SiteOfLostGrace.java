package game.Environments.FriendlyEnvironments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils.Status;

public class SiteOfLostGrace extends Ground {

    // constructor
    public SiteOfLostGrace() {
        super('U');
    }
    public static boolean isPlayerInSite;

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            Actor actor = location.getActor();
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                isPlayerInSite = true;
            }
        }
    }
}
