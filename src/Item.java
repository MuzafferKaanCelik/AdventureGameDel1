public class Item {
    private String Item;
    private String ItemDescription;

    public Item(String Item, String ItemDescription){
        this.Item = Item;
        this.ItemDescription = ItemDescription;
    }

    public String getItem() {
        return Item;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItem(String item) {
        Item = item;
    }

    @Override
    public String toString(){
        return Item + ItemDescription;
    }
}
