package game.Environments.EnemyEnvironments;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utils.Status;
import game.Actors.Enemies.HeavySkeletalSwordsman;
import game.Actors.Enemies.SkeletalBandit;

public class Graveyard extends Environment {

    public Graveyard() {
        super('n');
    }

    @Override
    public int getSpawnChance() {
        return 27;
    }

    @Override
    public Actor spawningEnemy() {
        if (this.hasCapability(Status.EAST)) {
            return new SkeletalBandit(target);
        }
        else if (this.hasCapability(Status.WEST)){
            return new HeavySkeletalSwordsman(target);
        }
        return null;
    }


}
