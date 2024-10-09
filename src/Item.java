public class Item {
    private String item;
    private String itemDescription;

    public Item(String item, String itemDescription) {
        this.item = item;
        this.itemDescription = itemDescription;
    }

    public String getItem() {
        return item;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return item + " " + itemDescription;
    }
}
