import java.util.ArrayList;

public class NumberedSelectionMenu<T> extends Menu {
    private ArrayList<T> menuItems;
    private int startingIndex = 0;
    
    public NumberedSelectionMenu(String h, String p) {
        super(h, p);
        this.menuItems = new ArrayList<>();
    }

    public NumberedSelectionMenu(String h, String p, ArrayList<T> items) {
        this(h, p);
        this.menuItems = items;
    }

    public ArrayList<T> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItem(T item) {
        this.getMenuItems().add(item);
    }

    public void addMenuItems(ArrayList<T> items) {
        this.getMenuItems().addAll(items);
    }

    public T itemAtIndex(int i) {
        return this.getMenuItems().get(i);
    }

    public void setStartingIndex(int i) {
        this.startingIndex = i;
    }

    public int getStartingIndex() {
        return this.startingIndex;
    }

    @Override
    public String toString() {
        String str = this.getHeader() + '\n';
        int j = this.getStartingIndex();
        for (int i = 0; i < this.getMenuItems().size(); i++) {
            str += "" + j++ + ". " + this.itemAtIndex(i).toString() + '\n';
        }
        return str
            + this.getSeparator() + '\n'
            + this.getPrompt() + ": ";
    }
}
