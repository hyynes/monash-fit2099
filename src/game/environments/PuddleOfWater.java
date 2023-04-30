package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.enemies.GiantCrab;
import game.enemies.GiantCrayfish;

public class PuddleOfWater extends Environment {

    public PuddleOfWater() {
        super('~');
    }

    @Override
    public int getSpawnChance() {
        if (this.hasCapability(Status.EAST)) {
            return 1;
        }
        else if (this.hasCapability(Status.WEST)){
            return 2;
        }
        return 0;
    }

    @Override
    public Actor spawningEnemy(){
        if (this.hasCapability(Status.EAST)) {
            return new GiantCrayfish(target);
        }
        else if(this.hasCapability(Status.WEST)){
            return new GiantCrab(target);
        }
        return null;
    }
}
