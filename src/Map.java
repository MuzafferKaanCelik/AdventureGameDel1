public class Map {
    private Room theFirstRoom;

    public Map() {
        buildMap();
    }

    public void buildMap() {


        Room room1 = new Room("Room 1.","- A cave like room with nothing in it, the bedrock flooring is tiled and the walls spiky\\n\" +\n" +
                "\"Some of the spikes have dead bodies or pierced skulls on them and there are two doors well lit by a torch on each side.");
        Room room2 = new Room("Room 2", "description of room 2");
        Room room3 = new Room("Room3", "description of room 3");
        Room room4 = new Room("Room 4", "description of room 4");
        Room room5 = new Room("Room 5", "description of room 5");
        Room room6 = new Room("Room 6", "description of room 6");
        Room room7 = new Room("Room 7", "description of room 7");
        Room room8 = new Room("Room 8", "description of room 8");
        Room room9 = new Room("Room 9", "description of room 9");

        theFirstRoom = room1;

        room1.setNorthAdjacentRoom(null);
        room1.setSouthAdjacentRoom(room4);
        room1.setEastAdjacentRoom(room2);
        room1.setWestAdjacentRoom(null);

        room2.setNorthAdjacentRoom(null);
        room2.setSouthAdjacentRoom(null);
        room2.setEastAdjacentRoom(room3);
        room2.setWestAdjacentRoom(room1);

        room3.setNorthAdjacentRoom(null);
        room3.setSouthAdjacentRoom(room6);
        room3.setEastAdjacentRoom(null);
        room3.setWestAdjacentRoom(room2);

        room4.setNorthAdjacentRoom(room1);
        room4.setSouthAdjacentRoom(room7);
        room4.setEastAdjacentRoom(null);
        room4.setWestAdjacentRoom(null);

        room5.setNorthAdjacentRoom(null);
        room5.setSouthAdjacentRoom(room8);
        room5.setEastAdjacentRoom(null);
        room5.setWestAdjacentRoom(null);

        room6.setNorthAdjacentRoom(room3);
        room6.setSouthAdjacentRoom(room9);
        room6.setEastAdjacentRoom(null);
        room6.setWestAdjacentRoom(null);

        room7.setNorthAdjacentRoom(room4);
        room7.setSouthAdjacentRoom(null);
        room7.setEastAdjacentRoom(room8);
        room7.setWestAdjacentRoom(null);

        room8.setNorthAdjacentRoom(room5);
        room8.setSouthAdjacentRoom(null);
        room8.setEastAdjacentRoom(room9);
        room8.setWestAdjacentRoom(room7);

        room9.setNorthAdjacentRoom(room6);
        room9.setSouthAdjacentRoom(null);
        room9.setEastAdjacentRoom(null);
        room9.setWestAdjacentRoom(room8);

        room2.addItem("Soul of Envy", " - A deep green soul that symbolizes the sin of envy.");
        room2.addFood("Green pill", " - A menacing green pill", -1);

        room3.addItem("Soul of Pride", " - A gloomy violet soul that symbolizes the sin of pride.");
        room3.addFood("violet pill", " - A menacing violet pill", -3);

        room4.addItem("Soul of Wrath", " - A gloomy violet soul that symbolizes the sin of wrath.");
        room4.addFood("Red pill", " - A menacing red pill", 1);

        room6.addItem("Soul of Sloth", " - A bright blue soul that symbolizes the sin of sloth.");
        room6.addFood("Azure pill", " - A menacing azure pill", 2);

        room7.addItem("Soul of Lust", " - A dark blue soul that symbolizes the sin of lust.");
        room7.addFood("Blue pill", " - A menacing blue pill", 2);

        room8.addItem("Soul of Greed", " - A bright yellow soul that symbolizes the sin of greed.");
        room8.addFood("Yellow pill", " - A menacing yellow pill", -2);

        room9.addItem("Soul of Gluttony", " - A deep orange soul that symbolizes the sin of gluttony.");
        room9.addFood("Orange pill", " - A menacing Orange pill", 1);
    }

    public Room getTheFirstRoom() {
        return this.theFirstRoom;
    }

}
