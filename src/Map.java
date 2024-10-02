public class Map {
    private Room theFirstRoom;

    public Map() {
        buildMap();
    }

    public void buildMap() {

        Room room1 = new Room("Room 1", "A cave like room with nothing in it, the bedrock flooring is tiled and the walls are spiky\n" +
                "Some of the spikes have dead bodies or pierced skulls on them and there are two doors well lit by a torch on each side.");
        Room room2 = new Room("Room 2", """
                A Very large room compared to room 1. There is only one other door in this room besides the one you came from.
                The door is closed and has 7 colored spirits on it.
                The rest of the room consists of crimson red granite, there are platforms, ladders and gaps all over.
                Jack seems to be able to spot some weaker lights scattered across the room which are the same colors as on the door.""");
        Room room3 = new Room("Room 3", "description of room 3");
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

        room2.addItem("Soul of Envy", " - A shiny green soul that symbolizes the sin or envy.");
        room3.addItem("Soul of Pride", " - A shiny violet soul that symbolizes the sin or pride.");
        room4.addItem("Soul of Wrath", " - A shiny red soul that symbolizes the sin or wrath.");
        room6.addItem("Soul of Sloth", " - A shiny light blue soul that symbolizes the sin or sloth.");
        room7.addItem("Soul of Lust", " - A shiny blue soul that symbolizes the sin or lust.");
        room8.addItem("Soul of Greed", " - A shiny yellow soul that symbolizes the sin or wrath.");
        room9.addItem("Soul of Gluttony", " - A shiny orange soul that symbolizes the sin or gluttony.");

        Food redP = new Food("Red pill", " - A menacing red pill", 1);
        Food greenP = new Food("Green pill", " - A menacing green pill", -1);
        Food violetP = new Food("Violet pill", " - A menacing purple pill", -3);
        Food lightA = new Food("Azure pill", " - A menacing azure pill", 2);
        Food blueP = new Food("Blue pill", " - A menacing blue pill", 2);
        Food yellowP = new Food("Yellow pill", " - A menacing Yellow pill", -2);
        Food orangeP = new Food("Orange pill", " - A menacing orange pill", 1);

        room2.addItem(greenP);
        room3.addItem(violetP);
        room4.addItem(redP);
        room6.addItem(lightA);
        room7.addItem(blueP);
        room8.addItem(yellowP);
        room9.addItem(orangeP);
    }

    public Room getTheFirstRoom() {
        return this.theFirstRoom;
    }
}

