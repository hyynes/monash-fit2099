package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.enemies.LoneWolf;

public class GustOfWind extends Ground {

    private static Actor target;

    public GustOfWind() {
        super('&');
    }

    @Override
    public void tick(Location location)
    {
        int randomNumber = RandomNumberGenerator.getRandomInt(100);
        if (randomNumber < 33){
            if (!location.containsAnActor()) {
                location.addActor(new LoneWolf(target));
            }
        }
    }

    public static void setTarget(Actor actor) {
        target = actor;
    }

}
