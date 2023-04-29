package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.enemies.GiantCrab;

public class PuddleOfWater extends Ground {
    private static Actor target;

    public PuddleOfWater() {
        super('~');
    }

    @Override
    public void tick(Location location)
    {
        int randomNumber = RandomNumberGenerator.getRandomInt(100);
        if (randomNumber < 2){
            if (!location.containsAnActor()) {
                location.addActor(new GiantCrab(target));
            }
        }
    }

    public static void setTarget(Actor actor) {
        target = actor;
    }
}
