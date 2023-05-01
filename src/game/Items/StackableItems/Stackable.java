package game.Items.StackableItems;

public interface Stackable {
    int getNoOfStacks();
    String displayToString();
    boolean addStacks(int stacks);
    boolean removeStacks(int stacks);
}
