package game.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.SurroundingAttack;
import game.Status;

public class Scimitar extends WeaponItem {
    public Scimitar() {
        super("Scimitar", 's', 118, "Slashes", 88);
        this.addCapability(Status.SPECIAL_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public Action getSkill(Actor holder){
        return new SurroundingAttack(this);
    }
}
