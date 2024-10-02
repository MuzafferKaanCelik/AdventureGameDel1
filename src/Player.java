import java.util.ArrayList;

public class Player {
    private Room theRoomIamIn;
    private ArrayList<Item> JackItems = new ArrayList<>();


    public Player(Room firstRoom) {
        this.theRoomIamIn = firstRoom;
    }

    public boolean canMove(String direction) {
        return switch (direction) {
            case "go north" -> theRoomIamIn.getNorth() != null;
            case "go south" -> theRoomIamIn.getSouth() != null;
            case "go east" -> theRoomIamIn.getEast() != null;
            case "go west" -> theRoomIamIn.getWest() != null;
            default -> false;
        };
    }

    public void moveToRoom(String direction) {
        if (direction.equalsIgnoreCase("go north")) {
            theRoomIamIn = theRoomIamIn.getNorth();
        } else if (direction.equalsIgnoreCase("go south")) {
            theRoomIamIn = theRoomIamIn.getSouth();
        } else if (direction.equalsIgnoreCase("go east")) {
            theRoomIamIn = theRoomIamIn.getEast();
        } else if (direction.equalsIgnoreCase("go west")) {
            theRoomIamIn = theRoomIamIn.getWest();
        }
    }

    public Item findItem (String findItem){
        for (Item item:JackItems){
            if (item.getItem().equalsIgnoreCase(findItem)){
                return item;
            }
        }
        return null;
    }
    public boolean dropItem(String itemToDrop){
        Item variable = findItem(itemToDrop);
        if (variable == null){
            return false;

        }
        JackItems.remove(variable);
        theRoomIamIn.addItem(variable);
        return true;
    }

    public Boolean takeItem(String itemToTake){
        Item variableItem = theRoomIamIn.findItemInRoom(itemToTake);
        if (variableItem==null){
            return false;
        }
        JackItems.add(variableItem);
        theRoomIamIn.removeItemFromList(variableItem);
        return true;
    }

    public String findItem(){
        int counter = 1;
        String empty = "";
        for (Item currentItem : JackItems){
            empty += "\n"+ counter++ + ". " + currentItem.getItem() + currentItem.getItemDescription();
        }
        return empty;
    }

    public void goToNorthRoom() {
        theRoomIamIn = theRoomIamIn.getNorth();
    }

    public void goToSouthRoom() {
        theRoomIamIn = theRoomIamIn.getSouth();
    }

    public void goToEastRoom() {
        theRoomIamIn = theRoomIamIn.getEast();
    }

    public void goToWestRoom() {
        theRoomIamIn = theRoomIamIn.getWest();
    }

    public String whereAreYou() {
        return theRoomIamIn.getRoomName();
    }

    public String getCurrentRoomName() {
        return theRoomIamIn.getRoomName();
    }

    public String getCurrentRoomDescription() {
        return theRoomIamIn.getRoomDescription();
    }

    public Room getCurrentRoom(){
        return theRoomIamIn;
    }

}
