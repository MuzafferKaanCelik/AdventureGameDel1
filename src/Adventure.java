public class Adventure {

    private Map map;
    private final Player Jack;


    public Adventure() {
        map = new Map();
        Jack = new Player(map.getTheFirstRoom());
    }

    public String getCurrentRoomName() {
        return Jack.getCurrentRoomName();
    }

    public boolean canJackMove(String direction) {
        return Jack.canMove(direction);
    }

    public void moveJackToRoom(String direction) {
        Jack.moveToRoom(direction);
    }

    public foodToEat canJackEat(String food) {
        return Jack.jackEats(food);
    }

    public String jackHealth() {
        return Jack.jackHealth();
    }

    public String getCurrentRoomDetails() {
        return Jack.getCurrentRoom().toString();
    }

    public boolean dropItem(String itemToDrop) {
        return Jack.dropItem(itemToDrop);
    }

    public Boolean takeItem(String itemToTake) {
        return Jack.takeItem(itemToTake);
    }

    public String findItem() {
        return Jack.findItem();
    }

    public Player getJack() {
        return Jack;
    }

    public String equipWeapon(String weapon){
        return Jack.equipWeapon(weapon);
    }

    public String attack(String enemy){
        return Jack.attack(enemy);
    }

    public boolean dropWeapon(String itemToDrop) {
        return Jack.dropWeapon(itemToDrop);
    }

    public String changeWeapon(String weaponName){
        return Jack.changeWeapon(weaponName);
    }
}



