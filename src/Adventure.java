public class Adventure {

    private  Map map;
    private final Player Jack;


    public Adventure() {
        this.map = new Map();
        this.Jack = new Player(map.getTheFirstRoom());
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
}