package game;

public interface Stackable {
    int getNoOfStacks();
    String displayToString();
    boolean addStacks(int stacks);
    boolean removeStacks(int stacks);
}
