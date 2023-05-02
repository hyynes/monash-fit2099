package game.items.stackable;

import edu.monash.fit2099.engine.items.Item;

/**
 * An abstract class to denote items that can be stacked.
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */

public abstract class StackableItem extends Item {
    private int noOfStacks;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     * @param stacks the initial number of stacks of the item.
     */
    public StackableItem(String name, char displayChar, boolean portable, int stacks) {
        super(name, displayChar, portable);
        this.noOfStacks = stacks;
    }

    /**
     * Gets the number of stacks in the item.
     * @return the number of stacks.
     */

    public int getNoOfStacks() {
        return noOfStacks;
    }

    /**
     * Adds a number of stacks to the item
     * @param stacks - the number of stacks to be added
     * @return true if the method was valid or not (if stacks was positive)
     */
    public boolean addStacks(int stacks) {
        if (stacks > 0){
            noOfStacks += stacks;
            return true;
        }
        return false;
    }

    /**
     * Removes a number of stacks from the item
     * @param stacks - the number of stacks to be removed
     * @return true if the player still has zero-positive stacks afterwards
     */
    public boolean removeStacks(int stacks) {
        if (noOfStacks >= stacks){
            noOfStacks -= stacks;
            return true;
        }
        return false;
    }

    /**
     * Sets the number of stacks to a certain number.
     * @param stacks - the number of stacks to be set.
     */
    public void setNoOfStacks(int stacks) {
        if (stacks >= 0) {
            this.noOfStacks = stacks;
        }
    }

    /**
     * A string for display.
     * @return the String to be displayed.
     * @see FlaskOfCrimsonTears
     * @see Rune
     */
    public abstract String displayToString();
}
