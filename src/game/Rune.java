package game;
import edu.monash.fit2099.engine.items.Item;

public class Rune extends Item implements Stackable{
    private int noOfRunes;

    public Rune(){
        super("Rune",'$',true);
        noOfRunes = 0;
    }

    @Override
    public int noOfStacks() {
        return noOfRunes;
    }

    @Override
    public String displayToString(){
        return "Runes (" + noOfStacks() + ")";
    }
}
