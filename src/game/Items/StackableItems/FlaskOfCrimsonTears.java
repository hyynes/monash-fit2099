package game.Items.StackableItems;
import edu.monash.fit2099.engine.items.Item;

public class FlaskOfCrimsonTears extends Item implements Stackable{

    private int noOfStacks;

    // Constructor
    public FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", '.', false);
        noOfStacks = 2;
    }

    @Override
    public int getNoOfStacks() {
        return noOfStacks;
    }

    @Override
    public String displayToString() {
        return "Flask of Crimson Tears: " + noOfStacks;
    }

    @Override
    public boolean addStacks(int stacks) {
        if (stacks >= 0){
            noOfStacks += stacks;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeStacks(int stacks) {
        if (stacks >= 0){
            noOfStacks += stacks;
            return true;
        }
        else {
            return false;
        }
    }
}
