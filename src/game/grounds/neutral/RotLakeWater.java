package game.grounds.neutral;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Statusable;
import game.actors.enemies.StatusManager;
import game.utils.StatusEffect;
import static game.utils.Status.IMMUNE_TO_ROT;

public class RotLakeWater extends Ground {

    /**
     * Constructor.
     */
    public RotLakeWater() {
        super('=');
    }

    /**
     * Checks if an actor standing on the rot lake water is immune to rot or not. If not, apply scarlet rot for 2 turns.
     * @param location The location of the Ground
     */

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            if (location.getActor() instanceof Statusable && !location.getActor().hasCapability(IMMUNE_TO_ROT)) {
                StatusManager status = new StatusManager(
                        StatusEffect.SCARLET_ROT,
                        2
                );
                ((Statusable) location.getActor()).addStatus(status);
            }
        }
    }
}
