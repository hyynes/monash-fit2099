package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.enemies.GiantDog;
import game.enemies.LoneWolf;

public class GustOfWind extends Environment {

    public GustOfWind() {
        super('&');
    }

    @Override
    public int getSpawnChance() {
        if (this.hasCapability(Status.EAST)){
            return 4;
        }
        else if (this.hasCapability(Status.WEST)){
            return 33;
        }
        return 0;
    }

    @Override
    public Actor spawningEnemy(){
        if (this.hasCapability(Status.EAST)) {
            return new GiantDog(target);
        }
        else if (this.hasCapability(Status.WEST)){
            return new LoneWolf(target);
        }
        return null;
    }
}
