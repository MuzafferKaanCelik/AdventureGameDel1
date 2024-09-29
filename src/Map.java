public class Map {
    private Room theFirstRoom;

    public Map() {
        buildMap();
    }
    public void buildMap() {

        Room room1 = new Room("1", "A cave like room with nothing in it, the bedrock flooring is tiled and the walls spiky\n" +
                "                Some of the spikes have dead bodies or pierced skulls on them and there are two doors well lit by a torch on each side.");
        Room room2 = new Room("2", """
                 A Very large room compared to room 1. There is only one other door in this room besides the one you came from.
                The door is closed and has 7 colored spirits on it.
                The rest of the room consists of crimson red granite, there are platforms, ladders and gaps all over.
                The room is lit for about 5 seconds, then it turns dark for about 5 seconds.
                During dark time you seem to be able to spot some weaker lights scattered across the room which are the same colors as on the door.""");
        Room room3 = new Room("3", "description of room 3");
        Room room4 = new Room("4", "description of room 4");
        Room room5 = new Room("5", "description of room 5");
        Room room6 = new Room("6", "description of room 6");
        Room room7 = new Room("7", "description of room 7");
        Room room8 = new Room("8", "description of room 8");
        Room room9 = new Room("9", "description of room 9");

        theFirstRoom = room1;

        room1.setNorth(null);
        room1.setSouth(room4);
        room1.setEast(room2);
        room1.setWest(null);

        room2.setNorth(null);
        room2.setSouth(null);
        room2.setEast(room3);
        room2.setWest(room1);

        room3.setNorth(null);
        room3.setSouth(room6);
        room3.setEast(null);
        room3.setWest(room2);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setEast(null);
        room4.setWest(null);

        room5.setNorth(null);
        room5.setSouth(room8);
        room5.setEast(null);
        room5.setWest(null);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setEast(null);
        room6.setWest(null);

        room7.setNorth(room4);
        room7.setSouth(null);
        room7.setEast(room8);
        room7.setWest(null);

        room8.setNorth(room5);
        room8.setSouth(null);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setSouth(null);
        room9.setEast(null);
        room9.setWest(room8);
    }

    public Room getTheFirstRoom() {
        return this.theFirstRoom;
    }
}
