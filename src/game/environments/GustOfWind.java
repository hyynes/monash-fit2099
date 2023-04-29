package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemies.LoneWolf;

public class GustOfWind extends Environment {

    public GustOfWind() {
        super('&');
    }

    @Override
    public int getSpawnChance() {
        return 33;
    }

    @Override
    public Actor spawningEnemy(){
        return new LoneWolf(target);
    }

}
