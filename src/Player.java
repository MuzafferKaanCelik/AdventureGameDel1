import java.util.ArrayList;

public class Player {
    private Room theRoomIamIn;
    private static ArrayList<Item> inventory = new ArrayList<>();
    private int jackHitPoints;
    private Weapon currentWeapon;

    public Player(Room firstRoom) {
        theRoomIamIn = firstRoom;
        jackHitPoints = 1;
        currentWeapon = null;
    }

    public void setJackOverHeal(int newOverHeal) {
        this.jackHitPoints = Math.min(newOverHeal, 5);
    }


    public String jackHealth() {
        if (this.jackHitPoints == 1) {
            return this.jackHitPoints + "HP. You could die at any moment, just like in real life\n" +
                    "(Which is ironic since you are dead.";
        } else if (this.jackHitPoints == 2) {
            return this.jackHitPoints + "HP. You can somehow survive a lethal attack that is incredible!";
        } else if (this.jackHitPoints == 3) {
            return this.jackHitPoints + "HP. You have some how been blessed by the gods, even though you are in hell.\n" +
                    "(You can take 2 hits without dying!)";
        } else if (this.jackHitPoints == 4) {
            return this.jackHitPoints+"HP. You are out of this world quite literally!\n" +
                    "(You can take 3 hits without dying!)";
        } else if (this.jackHitPoints == 5) {
            return this.jackHitPoints+"HP. Even Satan is starting to shiver his timbers.\n" +
                    " (You can take 4 hits without dying!) (The HP limit is 5";

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

    public void removeFromInventory(Item itemToEat) {
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
                return theRoomIamIn.getNorth() != null;
            case "south":
                return theRoomIamIn.getSouth() != null;
            case "east":
                return theRoomIamIn.getEast() != null;
            case "west":
                return theRoomIamIn.getWest() != null;
            default:
                return false;
        }
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

    public void takeDamage(int damage){
        jackHitPoints -= damage;
        if (jackHitPoints<=0){
            jackHitPoints=0;
        }
    }

    public String equipWeapon(String weapon) {
        Item itemToEquip = findItemInInventory(weapon);
        if (itemToEquip == null) {
            return weapon + " is not in inventory";
        } else if (itemToEquip instanceof Weapon) {
            currentWeapon = ((Weapon) itemToEquip);
            inventory.remove(itemToEquip);
            return "you equip yourself with the" + weapon;
        } else {
            return "that's not a weapon";
        }
    }

    public String attack(String enemy) {
        Enemy currentEnemy =theRoomIamIn.findEnemyInRoom(enemy);

        Item itemToAttackWith = currentWeapon;
        if (currentEnemy.getEnemyHitPoints() > 0) {
            if (itemToAttackWith == null) {
                return "you are not equipped with a weapon";
            } else if (itemToAttackWith instanceof RangedWeapon) {
                RangedWeapon rangedWeapon = (RangedWeapon) currentWeapon;
                currentWeapon.remainingUses();
                currentEnemy.takeDamage(currentWeapon.getDamagePoints());
                if (currentEnemy.getEnemyHitPoints() > 0) {
                    takeDamage(currentEnemy.getEnemyWeapon().getDamagePoints());
                    return "you attack the " + currentEnemy.getEnemyName() + " with your " + currentWeapon.getItem() + ", you used one of your ammos in this weapon. \nenemies health: " + currentEnemy.getEnemyHitPoints()
                            + "\nbut they attack you right back afterwards. \nyour health: " + jackHealth();
                } else {
                    if (currentEnemy.getEnemyWeapon() != null) {
                        theRoomIamIn.addWeapon(currentEnemy.getEnemyWeapon());
                    }
                    theRoomIamIn.removeEnemy(currentEnemy);
                    return currentEnemy.getEnemyName() + " is defeated! and left behind a " + currentEnemy.getEnemyWeapon().getItem();
                }
            } else if (itemToAttackWith instanceof MeleeWeapon) {
                currentEnemy.takeDamage(((MeleeWeapon) itemToAttackWith).getDamagePoints());
                if (currentEnemy.getEnemyHitPoints() > 0) {
                    takeDamage(currentEnemy.getEnemyWeapon().getDamagePoints());
                    return "you attack the " + currentEnemy.getEnemyName() + " with your " + itemToAttackWith.getItem()
                            + "\nenemy's health: " + currentEnemy.getEnemyHitPoints()  + "\nbut they attack you right back afterwards. \nyour health: " + jackHealth();
                } else {
                    if (currentEnemy.getEnemyWeapon() != null) {
                        theRoomIamIn.addWeapon(currentEnemy.getEnemyWeapon());
                    }
                    theRoomIamIn.removeEnemy(currentEnemy);
                    return currentEnemy.getEnemyName() + " is defeated! and left behind a " + currentEnemy.getEnemyWeapon().getItem();
                }
            }
        }
        return currentEnemy.getEnemyName() + " is already defeated";
    }



    public boolean dropWeapon(String itemToDrop) {
        if (currentWeapon == null || !currentWeapon.getItem().equalsIgnoreCase(itemToDrop)) {
            return false;
        }

        theRoomIamIn.addItem(currentWeapon);
        currentWeapon = null;
        return true;
    }


    public String changeWeapon(String newWeaponName) {
        if (currentWeapon != null) {
            inventory.add(currentWeapon);
            System.out.println(currentWeapon.getItem() + " was added to your inventory.");
        } else {
            return "you're not equipped with a weapon";
        }
        return " ";
    }
}