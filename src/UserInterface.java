import java.util.Scanner;

public class UserInterface {

    Adventure adventure;


    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void StartGame() {

        Scanner input = new Scanner(System.in);

        String userinfo;
        System.out.println(">Welcome to Jack Hellscape<");
        System.out.println();
        System.out.println("""
                In Jack's former life he was a very bad person.
                When his time finally came he saw nothing,but darkness.
                His body and mind were conscious, but he was unable to move a muscle.
                It felt like he was falling and it felt like an eternity, for a long time nothing happened and he had completely lost track of time.
                Thinking to himself that this was all death was, he decide to close his eyes and accept the fate he was given.
                After what felt like months of falling, a bright flame sparks in front of Jack.
                Even through his closed eyelids the light is blinding.
                Jack opens his eyes and sees a menacing figure towering over him.""");
        System.out.println();
        System.out.println("-Greetings friend");
        System.out.println();
        System.out.println("The moment Jack hears the voice he hit a hard surface 'THUMB' Jack lands on a floor consisting bedrock.");
        System.out.println();
        System.out.println("'EVIL LAUGHTER'");
        System.out.println();
        System.out.println("-So I see we have another tough nut to crack, not everyone survives that fall you know although i'm\n" +
                "sure you'll soon wish that you had perished from it.");
        System.out.println();
        System.out.println("""
                Jack's mouth is sealed shut. Being unable to speak he instead tries to get a hold of his surroundings.
                Having had his eyes closed for so long Jack could only make out the glowing figure in front of him.
                A humanoid being with red skin, the horns and lower body of a ram, the torso and head of a man.
                The set of teeth in his maw are like a shark's, the beard looks like a goat's, his head is bald
                and the ears are pointy like an elf's, from his eye sockets comes a radiant yellow glow.
                The figure smiles and yells.""");
        System.out.println();
        System.out.println("-WELCOME TO HELL!");
        System.out.println();
        System.out.println("Jack looks confused, he never really believed in all that heaven and hell stuff.\n" +
                "The devil in front of him smirks.");
        System.out.println();
        System.out.println("""
                -I'm Satan and your remorseless soul WILL KNOW AGONY!
                This is my humble dungeon and beyond this room lies 7 gruelling tasks.
                If you prevail successfully with all 7 of them I may or may not be able to give you another shot at life.""");
        System.out.println();
        System.out.println("""
                Satan bursts out into yet another spark before disappearing, before Jack's very eyes.
                Jack finally musters up the strength to get himself standing.
                As Jack gets to his senses the room he is standing in becomes clearer, Jack is in a squared room.
                There are two doors in the room, each door has a torch on each side.
                As Jack looks around he realizes that there is not really anything in this room, what does he do now?""");
        System.out.println();
        System.out.println("""
                COMMAND LIST:
                'go north' - to go north.
                'go south' - to go south.
                'go east' - to go east.
                'go west' - to go west.
                'EXIT' or 'e' - to close the game.
                'LOOK' or 'l' - to get room number and description again.
                'TAKE' or 't' - to take an item from a room.
                'DROP' oe 'd' - to drop an item in the room you are currently in.
                'INVENTORY', 'INV' or 'i'
                __________________________________________________________________
                """);

        System.out.print("Type 'START' to begin the game>");

        userinfo = "";
        while (!userinfo.equalsIgnoreCase("EXIT")) {
            userinfo = input.nextLine();
            String[] commandUserInput = userinfo.split(" ");
            switch (commandUserInput[0]) {
                case "START", "start", "s", "Start":
                    System.out.println("Jack finds himself in the first room of Satans dungeon?");
                    System.out.println();
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;

                case "LOOK", "look", "l", "Look":
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;

                case "HELP", "help", "h", "Help":
                    System.out.println("""
                            COMMAND LIST:
                            'go north' - to go north.
                            'go south' - to go south.
                            'go east' - to go east.
                            'go west' - to go west.
                            'EXIT' or 'e' - to close the game.
                            'LOOK' or 'l' - to get room number and description again.
                            'TAKE' or 't' - to take an item from a room.
                            'DROP' or 'd' - to drop an item in the room you are currently in.
                            'INVENTORY', 'INV' or 'i'
                            'HITPOINTS' or 'hp'""");
                    break;
                case "take", "TAKE", "t", "Take":
                    if (adventure.takeItem(commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3])) {
                        System.out.println("you have pick up the " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " from the room");
                    } else {
                        System.out.println("There is no such thing as a " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in this room");
                    }
                    break;
                case "drop", "DROP", "d", "Drop":
                    if (adventure.dropItem(commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3])) {
                        System.out.println("You have dropped the" + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in " + adventure.getCurrentRoomName());
                    } else {
                        System.out.println("You do not have " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in your inventory");
                    }
                    break;
                case "inventory", "INVENTORY", "inv", "INV", "i":
                    System.out.println(adventure.findItem());
                    break;
                case "Hitpoints", "hp", "HITPOINTS", "hitpoints":
                    System.out.println("Your hit points are: " + (adventure.getJack().getHitPoints()));

                    if (adventure.getJack().getHitPoints() == 1) {
                        System.out.println("You could die at any moment, but oh well that's life.\n" +
                                "(Well technically you are already dead, but if you die you will find yourself waking up in room one.)");
                    } else if (adventure.getJack().getHitPoints() == 2) {
                        System.out.println("Somehow you are able to survive one lethal and instantly heal the wound, but that might not happen again.");
                    } else if (adventure.getJack().getHitPoints() == 3) {
                        System.out.println("Even though you're currently in hell GOD must have truly blessed you, you can take two hits without dying.");
                    }
                    break;
                case "go":
                    if (adventure.canJackMove(commandUserInput[1])) {
                        adventure.moveJackToRoom(commandUserInput[1]);
                        System.out.println("you head" + commandUserInput[1]);
                    } else {
                        System.out.println("you can't go " + commandUserInput[1] + " from here");
                    }
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                case "eat":
                    if (commandUserInput.length < 2) {
                        System.out.println("Please specify what you'd like to eat.");
                    } else {
                        String itemToEat = commandUserInput[1] + " " + commandUserInput[2];
                        FoodToEat result = Player.eatItem(itemToEat);
                        switch (result) {
                            case NOT_FOUND:
                                System.out.println("You don't have a " + itemToEat + " in your inventory or in the room.");
                                break;
                            case EDIBLE:
                                System.out.println("You take the " + itemToEat + " You feel a burning sensation inside.");
                                System.out.println("Your hit points are now: " + adventure.getJack().getHitPoints());
                                break;
                            case NOT_FOOD:
                                System.out.println("The " + itemToEat + " is not something you can eat.");
                                break;
                        }
                    }
                    break;
                case "EXIT", "exit", "e", "Exit":
                    break;

                default:
                    System.out.println("Invalid command. Type 'HELP' for a list of possible commands.");
            }
            if (adventure.getJack().getHitPoints() <= 0) {
                System.out.println("YOU FACE DOOM! GOOD LUCK IN YOUR NEXT DEATH!");
                break;
            }
        }


    }

}



