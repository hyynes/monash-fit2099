package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemies.HeavySkeletalSwordsman;

public class Graveyard extends Environment {

    public Graveyard() {
        super('n');
    }

    @Override
    public int getSpawnChance() {
        return 27;
    }

    @Override
    public Actor spawningEnemy(){
        return new HeavySkeletalSwordsman(target);
    }

}
