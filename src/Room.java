public class Room {

    private int roomNumber;
    private String roomDescription;
    private Room north;
    private Room west;
    private Room south;
    private Room east;

    public Room(int roomNumber, String roomDescription) {
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;

    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getWest() {
        return west;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void LOOK() {
        System.out.println("You're in room" + roomNumber + " " + roomDescription);
    }
}
