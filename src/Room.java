import java.util.ArrayList;

public class Room {

    private String roomName;
    private String roomDescription;
    private Room northAdjacentRoom;
    private Room southAdjacentRoom;
    private Room eastAdjacentRoom;
    private Room westAdjacentRoom;

    private ArrayList<Item> itemList = new ArrayList<>();

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public Room getNorthAdjacentRoom() {
        return northAdjacentRoom;
    }

    public void setNorthAdjacentRoom(Room northAdjacentRoom) {
        this.northAdjacentRoom = northAdjacentRoom;
    }

    public Room getSouthAdjacentRoom() {
        return southAdjacentRoom;
    }

    public void setSouthAdjacentRoom(Room southAdjacentRoom) {
        this.southAdjacentRoom = southAdjacentRoom;
    }

    public Room getEastAdjacentRoom() {
        return eastAdjacentRoom;
    }

    public void setEastAdjacentRoom(Room eastAdjacentRoom) {
        this.eastAdjacentRoom = eastAdjacentRoom;
    }

    public Room getWestAdjacentRoom() {
        return westAdjacentRoom;
    }

    public void setWestAdjacentRoom(Room westAdjacentRoom) {
        this.westAdjacentRoom = westAdjacentRoom;
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

    public void addItem(Item item){
        itemList.add(item);
    }

    public void addFood(String food, String foodDescription, int healthPoints){
        itemList.add(new Food(food,foodDescription,healthPoints));
    }

    public Item findItemInRoom(String takeItem){
        for(Item item:itemList) {
            if (item.getItem().equalsIgnoreCase(takeItem)) {
                return item;
            }
        }
        return null;
    }

    public void removeItemFromList(Item item){
        itemList.remove(item);
    }

    @Override
    public String toString() {
        String variabel;
        int counter = 1;
        variabel = getRoomName() + ", " + getRoomDescription();
        if (!itemList.isEmpty()) {
            variabel += "\nthe items are ";
            for (Item currentItem : itemList) {
                variabel += "\n" + counter++ + ". " + currentItem.getItem() + currentItem.getItemDescription();
            }
        }
        return variabel;
    }
}
