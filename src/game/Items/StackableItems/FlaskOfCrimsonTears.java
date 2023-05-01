package game.Items.StackableItems;

public class FlaskOfCrimsonTears extends StackableItem{
    // Constructor
    public FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", '.', false, 2);
    }

    @Override
    public String displayToString() {
        return "Flask of Crimson Tears (" + getNoOfStacks() + ')';
    }
}
