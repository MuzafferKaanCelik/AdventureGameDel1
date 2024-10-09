public class Map {
    private Room theFirstRoom;

    public Map() {
        buildMap();
    }

    public void buildMap() {


        Room room1 = new Room("Room 1.", "- A cave like room with nothing in it, the bedrock flooring is tiled and the walls spiky\\n\" +\n" +
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

        room1.addRangedWeapon("Pebble", " - Small rock that can be thrown.", -2, 10);

        room2.addItem("SoulOfEnvy", " - A deep green soul that symbolizes the sin of envy.");
        room2.addFood("GreenPill", " - A menacing green pill", -1);

        room3.addItem("SoulOfPride", " - A gloomy violet soul that symbolizes the sin of pride.");
        room3.addFood("VioletPill", " - A menacing violet pill", -3);

        room4.addItem("SoulOfWrath", " - A gloomy violet soul that symbolizes the sin of wrath.");
        room4.addFood("RedPill", " - A menacing red pill", 1);
        room4.addMeleeWeapon("Shiv", " - Small knife", -4);

        room6.addItem("SoulOfSloth", " - A bright blue soul that symbolizes the sin of sloth.");
        room6.addFood("AzurePill", " - A menacing azure pill", 2);

        room7.addItem("SoulOfLust", " - A dark blue soul that symbolizes the sin of lust.");
        room7.addFood("BluePill", " - A menacing blue pill", 2);

        room8.addItem("SoulOfGreed", " - A bright yellow soul that symbolizes the sin of greed.");
        room8.addFood("YellowPill", " - A menacing yellow pill", -2);

        room9.addItem("SoulOfGluttony", " - A deep orange soul that symbolizes the sin of gluttony.");
        room9.addFood("OrangePill", " - A menacing Orange pill", 1);
    }

    public Room getTheFirstRoom() {
        return this.theFirstRoom;
    }

}
