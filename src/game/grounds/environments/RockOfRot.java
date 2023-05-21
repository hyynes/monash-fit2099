package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.regular.Basilisk;

/**
 * Rock that spawns basilisks.
 * Created by:
 * @author Danny Duong
 */
public class RockOfRot extends Environment{
    public RockOfRot(){super('O');}

    @Override
    public int getSpawnChance() {
        return 50;
    }

    @Override
    public Actor spawningEnemy() {
        return new Basilisk(target);
    }
}
