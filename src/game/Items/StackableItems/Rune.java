package game.Items.StackableItems;

public class Rune extends StackableItem{

    public Rune(){
        super("Rune",'$',false, 0);
    }

    public void setNoOfStacks(int newStacks) {
        if (newStacks >= 0){
            this.noOfRunes = newStacks;
        }
    }

    @Override
    public String displayToString() {
        return "Runes (" + getNoOfStacks() + ')';
    }
}
