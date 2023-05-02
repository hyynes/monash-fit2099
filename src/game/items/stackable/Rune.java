package game.items.stackable;

/**
 * MONEY
 * Created by:
 * @author Danny Duong
 * Modified by:
 *
 */
public class Rune extends StackableItem{

    public Rune(){
        super("Rune",'$',false, 0);
    }

    @Override
    public String displayToString() {
        return "Runes (" + getNoOfStacks() + ')';
    }
}
