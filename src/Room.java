import java.util.ArrayList;

public class Room {

    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Enemy currentEnemy;

    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Enemy>enemyList = new ArrayList();

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

    public void addFood(String food, String foodDescription, int healthPoints) {
        itemList.add(new Food(food, foodDescription, healthPoints));
    }

    public void addMeleeWeapon(String weaponName, String weaponDescription, int healthPoints) {
        itemList.add(new MeleeWeapon(weaponName, weaponDescription, healthPoints));
    }

    public void addRangedWeapon(String weaponName, String weaponDescription, int healthPoints, int uses) {
        itemList.add(new RangedWeapon(weaponName, weaponDescription, healthPoints, uses));
    }

    public void addWeapon(Weapon weapon){
        if (weapon != null){
            itemList.add(weapon);
        }
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

    public void addEnemy(String enemyName, String enemyDescription, int enemyHealthPoints, int damageAlice, Weapon enemyWeapon){
        enemyList.add(new Enemy(enemyName,enemyDescription,enemyHealthPoints, damageAlice, enemyWeapon));
    }
    public Enemy findEnemyInRoom(String fightEnemy) {
        for (Enemy enemy : enemyList) {
            if (enemy.getEnemyName().equalsIgnoreCase(fightEnemy)) {
                return enemy;
            }
        }
        return null;
    }
    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }

    @Override
    public String toString() {
        String variabel;
        int counter = 1;
        variabel = getRoomName() + ", " + getRoomDescription();
        if (!itemList.isEmpty()) {
            variabel += "\n You see these items: ";
            for (Item currentItem : itemList) {
                variabel += "\n" + counter++ + ". " + currentItem.getItem() + currentItem.getItemDescription();
            }
        }

        if (!enemyList.isEmpty()) {
            variabel += "\nan enemy appears! ";
            for (Enemy currentEnemy : enemyList) {
                variabel += currentEnemy.getEnemyName() + "\n" + currentEnemy.getEnemyDescription();
            }
        }
        return variabel;
    }
}
