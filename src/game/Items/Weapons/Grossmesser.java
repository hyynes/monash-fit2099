package game.Items.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.SurroundingAttack;
import game.Utils.Status;

/**
 * The knife that goes spin.
 * Created by:
 * @author Kenan Baydar
 * Modified by:
 *
 */

public class Grossmesser extends WeaponItem implements WeaponRunes{

    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slices", 85);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    // Special Spin Attack Skill
    @Override
    public Action getSkill(Actor holder){
        return new SurroundingAttack(this);
    }

    @Override
    public int buyPrice() {
        return 0;
    }

    @Override
    public int sellPrice() {
        return 100;
    }

}
