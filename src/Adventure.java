public class Adventure {

    private  Map map;
    private final Player Jack;


    public Adventure() {
        map = new Map();
        Jack = new Player(map.getTheFirstRoom());
    }

    public String getCurrentRoomName() {
        return Jack.getCurrentRoomName();
    }

    public String getCurrentRoomDescription() {
        return Jack.getCurrentRoomDescription();
    }

    public boolean canJackMove(String direction) {
        return Jack.canMove(direction);
    }

    public void moveJackToRoom(String direction) {
        Jack.moveToRoom(direction);
    }

    public Map getMap() {
        return map;
    }

    public Player getJack() {
        return Jack;
    }
    public String getCurrentRoomDetails(){
        return Jack.getCurrentRoom().toString();
    }
    public boolean dropItem (String itemToDrop){
        return Jack.dropItem(itemToDrop);
    }
    public Boolean takeItem(String itemToTake){
        return Jack.takeItem(itemToTake);
    }
    public String findItem(){
        return Jack.findItem();
    }
}