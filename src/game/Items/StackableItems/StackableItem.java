package game.Items.StackableItems;
import edu.monash.fit2099.engine.items.Item;

public abstract class StackableItem extends Item {

    private int noOfStacks;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public StackableItem(String name, char displayChar, boolean portable, int noOfStacks) {
        super(name, displayChar, portable);
        this.noOfStacks = noOfStacks;
    }

    public int getNoOfStacks() {
        return noOfStacks;
    }

    public void setNoOfStacks(int newStacks) {
        if (newStacks >= 0){
            this.noOfStacks = newStacks;
        }
    }

    public boolean addStacks(int stacks) {
        if (stacks >= 0){
            noOfStacks += stacks;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean removeStacks(int stacks) {
        if (stacks >= 0){
            noOfStacks += stacks;
            return true;
        }
        else {
            return false;
        }
    }

    abstract String displayToString();
}
