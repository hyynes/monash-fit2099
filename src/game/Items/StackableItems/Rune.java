package game.Items.StackableItems;
import edu.monash.fit2099.engine.items.Item;

public class Rune extends Item implements Stackable {
    private int noOfRunes;

    public Rune(){
        super("Rune",'$',false);
        noOfRunes = 0;
    }

    @Override
    public int getNoOfStacks() {
        return noOfRunes;
    }

    @Override
    public String displayToString(){
        return "Runes: " + noOfRunes;
    }

    @Override
    public boolean addStacks(int stacks){
        if (stacks >= 0){
            noOfRunes += stacks;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeStacks(int stacks){
        if (noOfRunes - stacks >= 0){
            noOfRunes -= stacks;
            return true;
        }
        else{
            return false;
        }
    }
}
