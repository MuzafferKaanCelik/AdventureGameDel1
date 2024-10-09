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

    public String jackHealth(){
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
    public Player getJack(){
        return Jack;
    }
    public Item seeCurrentEquipped(){
        return Player.getCurrentEquipped();
    }

    public String equip(String itemName){
        WeaponsToUse status = Player.equip(itemName);
        return switch (status){
            case WEAPON -> "You have equipped: " + itemName + Player.getCurrentEquipped();
            case NOT_WEAPON -> "You can not equip that";
            case NOT_IN_INVENTORY -> "You do not have that in your inventory";
            default -> "Invalid command";
        };
    }
    public String attack(){
        WeaponsToUse status = Player.attack();
        return switch (status){
            case NOT_EQUIPPED -> "You do not have anything equipped and therefore can not attack";
            case EQUIPPED -> "You attack "+ seeCurrentEquipped().getItem();
            case NO_AMMO -> "You have no ammo";
            default -> "Invalid command";
        };
    }
}
