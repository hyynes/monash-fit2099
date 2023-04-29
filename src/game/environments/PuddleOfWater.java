package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemies.GiantCrab;

public class PuddleOfWater extends Environment {

    public PuddleOfWater() {
        super('~');
    }

    @Override
    public int getSpawnChance() {
        return 2;
    }

    @Override
    public Actor spawningEnemy(){
        return new GiantCrab(target);
    }

}
