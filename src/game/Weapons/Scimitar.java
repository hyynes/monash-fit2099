package game.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.SurroundingAttack;
import game.Status;

/**
 * The knife that goes spin v2.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */

public class Scimitar extends WeaponItem {
    public Scimitar() {
        super("Scimitar", 's', 118, "Slashes", 88);
        this.addCapability(Status.SPECIAL_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    // Special Spin Attack Skill
    @Override
    public Action getSkill(Actor holder){
        return new SurroundingAttack(this);
    }
}
