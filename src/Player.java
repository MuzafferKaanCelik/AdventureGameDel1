import java.util.ArrayList;

public class Player {
    private static Room theRoomIamIn;
    private static ArrayList<Item> jackItems = new ArrayList<>();
    private static int hitPoints;

    public Player(Room firstRoom) {
        theRoomIamIn = firstRoom;
        hitPoints = 1;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean canMove(String direction) {
        return switch (direction) {
            case "north" -> theRoomIamIn.getNorth() != null;
            case "south" -> theRoomIamIn.getSouth() != null;
            case "east" -> theRoomIamIn.getEast() != null;
            case "west" -> theRoomIamIn.getWest() != null;
            default -> false;
        };
    }

    public void moveToRoom(String direction) {
        if (direction.equalsIgnoreCase("north")) {
            theRoomIamIn = theRoomIamIn.getNorth();
        } else if (direction.equalsIgnoreCase("south")) {
            theRoomIamIn = theRoomIamIn.getSouth();
        } else if (direction.equalsIgnoreCase("east")) {
            theRoomIamIn = theRoomIamIn.getEast();
        } else if (direction.equalsIgnoreCase("west")) {
            theRoomIamIn = theRoomIamIn.getWest();
        }
    }

    public static Item findItem(String findItem) {
        for (Item item : jackItems) {
            if (item.getItem().equalsIgnoreCase(findItem)) {
                return item;
            }
        }
        return null;
    }

    public boolean dropItem(String itemToDrop) {
        Item variable = findItem(itemToDrop);
        if (variable == null) {
            return false;

        }
        jackItems.remove(variable);
        theRoomIamIn.addItem(variable);
        return true;
    }

    public boolean takeItem(String itemToTake) {
        Item variableItem = theRoomIamIn.findItemInRoom(itemToTake);
        if (variableItem == null) {
            return false;
        }
        jackItems.add(variableItem);
        theRoomIamIn.removeItemFromList(variableItem);
        return true;
    }

    public String findItem() {
        int counter = 1;
        String empty = "";
        for (Item currentItem : jackItems) {
            empty += "\n" + counter++ + ". " + currentItem.getItem() + currentItem.getItemDescription();
        }
        return empty;
    }

    public String getCurrentRoomName() {
        return theRoomIamIn.getRoomName();
    }

    public Room getCurrentRoom() {
        return theRoomIamIn;
    }

    public static FoodToEat eatItem(String itemToEat) {
        Item variableItem = theRoomIamIn.findItemInRoom(itemToEat);
        if (variableItem == null) {
            variableItem = findItem(itemToEat);
        }

        if (variableItem == null) {
            return FoodToEat.NOT_FOUND;
        }
        if (variableItem instanceof Food) {
            hitPoints = hitPoints + ((Food) variableItem).getHealthAndDamage();
            if (hitPoints > 3) {
                hitPoints = 3;
            }
            theRoomIamIn.removeItemFromList(variableItem);
            jackItems.remove(variableItem);
            return FoodToEat.EDIBLE;
        }
        return FoodToEat.NOT_FOOD;
    }
}
