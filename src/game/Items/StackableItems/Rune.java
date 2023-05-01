package game.Items.StackableItems;

public class Rune extends StackableItem {

    public Rune(){
        super("Rune",'$',false, 0);
    }

    @Override
    public String displayToString() {
        return "Runes : " + getNoOfStacks();
    }
}
