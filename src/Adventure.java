import java.util.Scanner;

public class Adventure {

    private Room currentRoom;

    private void buildMap() {
        Room room1 = new Room(1, "A cave like room with nothing in it, the bedrock flooring is tiled and the walls spiky.\n" +
                "Some of the spikes have dead bodies or pierced skulls on them and there are two doors well lit by a torch on each side.");
        Room room2 = new Room(2, """
                A Very large room compared to room 1. There is only one other door in this room besides the one you came from.
                The door is closed and has 7 colored spirits on it.
                The rest of the room consists of crimson red granite, there are platforms, ladders and gaps all over.
                The room is lit for about 5 seconds, then it turns dark for about 5 seconds.
                During dark time you seem to be able to spot some weaker lights scattered across the room which are the same colors as on the door.""");
        Room room3 = new Room(3, "Description of room three");
        Room room4 = new Room(4, "Description of room four");
        Room room5 = new Room(5, "Description of room five");
        Room room6 = new Room(6, "Description of room six");
        Room room7 = new Room(7, "Description of room seven");
        Room room8 = new Room(8, "Description of room one");
        Room room9 = new Room(9, "Description of room nine");


        room1.setNorth(null);
        room1.setWest(null);
        room1.setSouth(room4);
        room1.setEast(room2);

        room2.setNorth(null);
        room2.setWest(room1);
        room2.setSouth(null);
        room2.setEast(room3);

        room3.setNorth(null);
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.setEast(null);

        room4.setNorth(room1);
        room4.setWest(null);
        room4.setSouth(room7);
        room4.setEast(null);

        room5.setNorth(null);
        room5.setWest(null);
        room5.setSouth(room8);
        room5.setEast(null);

        room6.setNorth(room3);
        room6.setWest(null);
        room6.setSouth(null);
        room6.setEast(room9);

        room7.setNorth(room4);
        room7.setWest(null);
        room7.setSouth(null);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setSouth(null);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);
        room9.setSouth(null);
        room9.setEast(null);

        currentRoom = room1;
    }

    public void startAdventure() {
        buildMap();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Welcome to Hellscape!");
        System.out.println();

        System.out.println("""
                In your former life you were a very bad person.
                When your time finally came you saw nothing,but darkness.
                Your body and mind were conscious, but you were unable to move a muscle.
                It felt like you were falling and it felt like an eternity, for a long time nothing happened and you had completely lost track of time.
                Thinking to yourself that this was all death was, you decide to close your eyes and accept the fate you were given.
                After what felt like months of falling, a bright flame sparks in front of you.
                Even through your closed eyelids the light is blinding.
                You open your eyes and see a menacing figure towering over you.""");
        System.out.println();
        System.out.println("-Greetings friend");
        System.out.println();
        System.out.println("The moment you hear the voice you hit a hard surface 'THUMB' you land on a floor consisting bedrock.");
        System.out.println();
        System.out.println("'EVIL LAUGHTER'");
        System.out.println();
        System.out.println("-Sooo i see we have another tough nut to crack, not everyone survives that fall you know although i'm\n" +
                "sure you'll soon wish that you had perished from it.");
        System.out.println();
        System.out.println("""
                Your mouth is sealed shut. Being unable to speak you instead try to get a hold of your surroundings.
                Having had your eyes closed for so long you can only make out the glowing figure in front of you.
                A humanoid being with red skin, the horns and lower body of a ram, the torso and head of a man.
                The set of teeth in his maw are like a shark's, the beard looks like a goat's, his head is bald
                and the ears are pointy like an elf, from his eye sockets comes a radiant yellow glow.
                The figure smiles and yells.""");
        System.out.println();
        System.out.println("-WELCOME TO HELL!");
        System.out.println();
        System.out.println("You look confused, you never really believed in all that heaven and hell stuff.\n" +
                "The devil in front of you smirks.");
        System.out.println();
        System.out.println("""
                -I'm Satan and your remorseless soul WILL KNOW AGONY!
                This is my humble dungeon and beyond this room lies 7 gruelling tasks.
                If you prevail successful with all 7 of them i may or may not be able to give you another shot at life.""");
        System.out.println();
        System.out.println("""
                Satan bursts out into yet another spark before disappearing before your very eyes.
                You finally muster up the strength to get yourself standing.
                As you get to your senses the room you are standing in becomes clearer, you are in a squared room.
                There are two doors in the room, each door has a torch on each side.
                As you look around you realize that there is not really anything in this room, what do you do now?""");
        System.out.println();

        boolean gameStarted = false;
        while (!gameStarted) {
            System.out.println("Type 'START' to start the game or type 'EXIT' to exit the game");
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("START")) {
                gameStarted = true;
                System.out.println("Game started! Type 'go north', 'go south', 'go east', 'go west', 'LOOK', 'HELP', or 'EXIT'.");
            } else if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting the game.");
                scanner.close();
                return;
            } else {
                System.out.println("Unknown command. Please type 'start' to begin or 'exit' to quit.");
            }
        }

        while (!input.equalsIgnoreCase("EXIT")) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.startsWith("go ")) {
                String direction = input.substring(3).toLowerCase();

                switch (direction) {
                    case "north":
                        if (currentRoom.getNorth() != null) {
                            currentRoom = currentRoom.getNorth();
                            currentRoom.LOOK();
                        } else {
                            System.out.println("You cannot go that way.");
                        }
                        break;
                    case "south":
                        if (currentRoom.getSouth() != null) {
                            currentRoom = currentRoom.getSouth();
                            currentRoom.LOOK();
                        } else {
                            System.out.println("You cannot go that way.");
                        }
                        break;
                    case "east":
                        if (currentRoom.getEast() != null) {
                            currentRoom = currentRoom.getEast();
                            currentRoom.LOOK();
                        } else {
                            System.out.println("You cannot go that way.");
                        }
                        break;
                    case "west":
                        if (currentRoom.getWest() != null) {
                            currentRoom = currentRoom.getWest();
                            currentRoom.LOOK();
                        } else {
                            System.out.println("You cannot go that way.");
                        }
                        break;
                    default:
                        System.out.println("Unknown direction.");
                }
            } else if (input.equalsIgnoreCase("LOOK")) {
                currentRoom.LOOK();
            } else if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting the game");
            } else if (input.equalsIgnoreCase("HELP")) {
                System.out.println(" Here is a list of possible commands \n" +
                        "'go north', 'go south', 'go east', 'go west', 'LOOK', 'HELP', or 'EXIT'.");
            } else {
                System.out.println("Unknown command, try another command");
            }
        }

        scanner.close();
    }

}



