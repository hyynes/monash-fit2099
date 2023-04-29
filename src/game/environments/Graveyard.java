package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.enemies.HeavySkeletalSwordsman;

public class Graveyard extends Ground {

    private static Actor target;

    public Graveyard() {
        super('n');
    }

    @Override
    public void tick(Location location)
    {
        int randomNumber = RandomNumberGenerator.getRandomInt(100);
        if (randomNumber < 27){
            if (!location.containsAnActor()) {
                location.addActor(new HeavySkeletalSwordsman(target));
            }
        }
    }

    public static void setTarget(Actor actor) {
        target = actor;
    }
}
