package game.Environments.EnemyEnvironments;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils.RandomNumberGenerator;

public abstract class Environment extends Ground{

    protected static Actor target;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Environment(char displayChar) {
        super(displayChar);
    }

    @Override
    public void tick(Location location)
    {
        int randomNumber = RandomNumberGenerator.getRandomInt(100);
        if (randomNumber < getSpawnChance()){
            if (!location.containsAnActor()) {
                location.addActor((spawningEnemy()));
            }
        }
    }

    public abstract int getSpawnChance();
    public abstract Actor spawningEnemy();

    public static void setTarget(Actor actor) {
        target = actor;
    }
}
