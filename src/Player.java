import java.util.ArrayList;

public class Player {
    private Room theRoomIamIn;
    private static ArrayList<Item> inventory = new ArrayList<>();
    private static ArrayList<Item> equipped = new ArrayList<>();
    public static Weapon currentEquipped;
    private int jackHitPoints;

    public Player(Room firstRoom) {
        theRoomIamIn = firstRoom;
        jackHitPoints = 1;
    }

    public void setJackOverHeal(int newOverHeal) {
        this.jackHitPoints = Math.min(newOverHeal, 3);
    }

    public ArrayList<Item> getEquipped() {
        return equipped;
    }

    public static Item getCurrentEquipped() {
        return currentEquipped;
    }

    public String jackHealth() {
        if (this.jackHitPoints == 1) {
            return this.jackHitPoints + "HP. You could die at any moment, just like in real life\n" +
                    "(Which is ironic since you are dead.";
        } else if (this.jackHitPoints == 2) {
            return this.jackHitPoints + "HP. You can somehow survive a lethal attack that is incredible!";
        } else if (this.jackHitPoints == 3) {
            return this.jackHitPoints + "HP. You have some how been blessed by the gods, even though you are in hell.\n" +
                    "You can take 2 hits without dying!(The HP limit is 3)";
        }
        return null;
    }

    public static Item findItemInInventory(String eatItem) {
        for (Item item : inventory) {
            if (item.getItem().equalsIgnoreCase(eatItem)) {
                return item;
            }
        }
        return null;
    }

    public  void removeFromInventory(Item itemToEat) {
        inventory.remove(itemToEat);
    }

    public foodToEat jackEats(String eating) {
        Item itemToEat = findItemInInventory(eating);

        if (itemToEat == null) {
            itemToEat = theRoomIamIn.findItemInRoom(eating);
        }
        if (itemToEat == null) {
            return foodToEat.NOT_FOUND;
        } else if (itemToEat instanceof Food) {
            int hitPointsFromFood = ((Food) itemToEat).getHitPoints();
            setJackOverHeal(jackHitPoints + hitPointsFromFood);
            if (inventory.contains(itemToEat)) {
                removeFromInventory(itemToEat);
            } else {
                theRoomIamIn.removeItemFromList(itemToEat);
            }
            return foodToEat.EDIBLE;
        } else {
            return foodToEat.NOT_FOOD;
        }
    }

    public boolean canMove(String direction) {
        switch (direction) {
            case "north":
                return theRoomIamIn.getNorthAdjacentRoom() != null;
            case "south":
                return theRoomIamIn.getSouthAdjacentRoom() != null;
            case "east":
                return theRoomIamIn.getEastAdjacentRoom() != null;
            case "west":
                return theRoomIamIn.getWestAdjacentRoom() != null;
            default:
                return false;
        }
    }

    public void moveToRoom(String direction) {
        if (direction.equalsIgnoreCase("north")) {
            theRoomIamIn = theRoomIamIn.getNorthAdjacentRoom();
        } else if (direction.equalsIgnoreCase("south")) {
            theRoomIamIn = theRoomIamIn.getSouthAdjacentRoom();
        } else if (direction.equalsIgnoreCase("east")) {
            theRoomIamIn = theRoomIamIn.getEastAdjacentRoom();
        } else if (direction.equalsIgnoreCase("west")) {
            theRoomIamIn = theRoomIamIn.getWestAdjacentRoom();
        }
    }

    public Item findItem(String findItem) {
        for (Item item : inventory) {
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
        inventory.remove(variable);
        theRoomIamIn.addItem(variable);
        return true;
    }

    public boolean takeItem(String itemToTake) {
        Item variableitem = theRoomIamIn.findItemInRoom(itemToTake);
        if (variableitem == null) {
            return false;
        }
        inventory.add(variableitem);
        theRoomIamIn.removeItemFromList(variableitem);
        return true;
    }

    public String findItem() {
        int counter = 1;
        String empty = "";
        for (Item currentItem : inventory) {
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

    public int getHitPoints() {
        return jackHitPoints;
    }

    public static WeaponsToUse equip (String weaponName) {
        Item weaponEquip = findItemInInventory(weaponName);
        if (weaponEquip == null) {
            return WeaponsToUse.NOT_IN_INVENTORY;


        }
        if (weaponEquip instanceof Weapon) {
            Weapon weapon = (Weapon) weaponEquip;
            inventory.remove(weapon);
            equipped.add(weapon);
            currentEquipped = weapon;
            return WeaponsToUse.WEAPON;
        } else if (!(weaponEquip instanceof Weapon)) {
            return WeaponsToUse.NOT_WEAPON;
        }
        return WeaponsToUse.NOT_WEAPON;
    }

    public static WeaponsToUse attack() {
        Weapon weapon = currentEquipped;
        if (weapon == null) {
            return WeaponsToUse.NOT_EQUIPPED;
        } else if (weapon.canEquip()) {
            weapon.equip();
            return WeaponsToUse.EQUIPPED;
        } else {
            return WeaponsToUse.NO_AMMO;
        }
    }
}

