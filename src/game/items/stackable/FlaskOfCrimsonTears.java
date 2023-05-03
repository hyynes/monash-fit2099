package game.items.stackable;

/**
 * A healing potion for when you can't dodge attacks.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public class FlaskOfCrimsonTears extends StackableItem{

    /**
     * Constructor.
     *
     */
    public FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", '.', false, 2);
    }

    @Override
    public String displayToString() {
        return "Flask of Crimson Tears (" + getNoOfStacks() + ')';
    }
}
