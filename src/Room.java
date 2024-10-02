import java.util.ArrayList;

public class Room {

    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> itemList = new ArrayList<>();

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void addItem(String item, String itemDescription) {
        itemList.add(new Item(item, itemDescription));
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public boolean areThereItems() {
        if (!itemList.isEmpty()) {
            return true;
        }
        return false;
    }

    public Item findItemInRoom(String takeItem) {
        for (Item item : itemList) {
            if (item.getItem().equalsIgnoreCase(takeItem)) {
                return item;
            }
        }
        return null;
    }

    public void removeItemFromList(Item item) {
        itemList.remove(item);
    }

    @Override
    public String toString() {
        String variabel;
        int counter = 1;
        variabel = getRoomName() + ", " + getRoomDescription();
        if (!itemList.isEmpty()) {
            variabel += "\nthe items are";
            for (Item currentItem : itemList) {
                variabel += "\n" + counter++ + ". " + currentItem.getItem() + currentItem.getItemDescription();
            }
        }
        return variabel;
    }
}


