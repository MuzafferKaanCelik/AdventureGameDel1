// User interface class to interact with the player via command-line input.

import java.util.Scanner;

public class UserInterface {

    Adventure adventure;

    public UserInterface() {
        adventure = new Adventure();
    }


    public void StartGame() {


        Scanner input = new Scanner(System.in);

        String userinput;
        System.out.println("Welcome to Jack Hellscape!");
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
                COMMAND LIST\
                
                'HELP' - if you want instructions or an overview of the commandos\
                
                'LOOK' - if you want to have the description of the current room.\
                
                'go north'
                'go south'
                'go east'
                'go west' - to move in whatever direction you want.\
                
                'EXIT' - if you want to exit the game.\
                
                'TAKE' + 'itemName' - to grab an item.\
                
                'DROP' + 'itemName' - to drop an item.\
                
                'INVENTORY' - to get a list of items you carry.\
                
                'HEALTH' - to see your health in the game.\
                
                'EAT' - to eat an item in the current room or from your inventory.""");
        System.out.println();
        System.out.println("Jack finds himself in room 1.");
        System.out.println();
        System.out.print("Type Start to begin>");

        userinput = "";
        while (!userinput.equalsIgnoreCase("EXIT")) {
            userinput = input.nextLine();
            String[] commandUserInput = userinput.split(" ");
            switch (commandUserInput[0]) {
                case "start", "START", "s", "Start":
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                case "look", "LOOK", "l", "Look":
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                case "help", "HELP", "h", "Help":
                    System.out.println(""" 
                            COMMAND LIST\
                            
                            'HELP' - if you want instructions or an overview of the commandos\
                            
                            'LOOK' - if you want to have the description of the current room.\
                            
                            'go north'
                            'go south'
                            'go east'
                            'go west' - to move in whatever direction you want.\
                            
                            'EXIT' - if you want to exit the game.\
                            
                            'TAKE' + 'itemName' - to grab an item.\
                            
                            'DROP' + 'itemName' - to drop an item.\
                            
                            'INVENTORY' - to get a list of items you carry.\
                            
                            'HEALTH' - to see your health in the game.\
                            
                            'EAT' - to eat an item in the current room or from your inventory.""");
                    break;
                case "eat", "EAT", "Eat", "e":
                    foodToEat isItFood = adventure.canJackEat(commandUserInput[1] + " " + commandUserInput[2]);
                    switch (isItFood) {
                        case EDIBLE:
                            System.out.println("You take the " + commandUserInput[1] + " " + commandUserInput[2]);
                            break;
                        case NOT_FOUND:
                            System.out.println("No food in the room or inventory");
                            break;
                        case NOT_FOOD:
                            System.out.println("That's not edible");
                        default:
                    }
                    break;
                case "health", "HEALTH", "hp", "Health":
                    System.out.println(adventure.jackHealth());
                    break;
                case "take", "TAKE", "t", "Take":
                    if (adventure.takeItem(commandUserInput[1])) {
                        System.out.println("You pick up the " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " from the room");
                    } else {
                        System.out.println("theres no " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in the room");
                    }
                    break;
                case "drop", "DROP", "d", "Drop":
                    if (adventure.dropItem(commandUserInput[1])) {
                        System.out.println("you drop the " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in " + adventure.getCurrentRoomName());
                    } else {
                        System.out.println("you don't have a " + commandUserInput[1] + " " + commandUserInput[2] + " " + commandUserInput[3] + " in your inventory");
                    }
                    break;
                case "inventory", "inv", "i", "INVENTORY":
                    System.out.println(adventure.findItem());
                    break;
                case "go":
                    if (adventure.canJackMove(commandUserInput[1])) {
                        adventure.moveJackToRoom(commandUserInput[1]);
                        System.out.println("you go " + commandUserInput[1]);
                    } else {
                        System.out.println("you can't go " + commandUserInput[1] + " from here");
                    }
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                case "attack", "ATTACK", "Attack", "a":
                    String attackResult = adventure.attack();
                    System.out.println(attackResult);
                    break;
                case "equip", "EQUIP", "Equip", "eq":
                    if (commandUserInput.length > 1) {
                        String itemToEquip = commandUserInput[1];

                        WeaponsToUse equipResult = Player.equip(itemToEquip);
                        switch (equipResult) {
                            case WEAPON:
                                System.out.println("You have equipped the " + itemToEquip + " as your weapon.");
                                break;
                            case NOT_IN_INVENTORY:
                                System.out.println("You do not have a " + itemToEquip + " in your inventory.");
                                break;
                            case NOT_WEAPON:
                                System.out.println("The item " + itemToEquip + " is not a weapon and cannot be equipped.");
                                break;
                            default:
                                System.out.println("An unknown error occurred while trying to equip the item.");
                                break;
                        }
                    } else {
                        System.out.println("Please specify the item you want to equip.");
                    }
                    break;
                case "EXIT":
                    break;
                default:
                    System.out.println("Invalid command. Type 'HELP' or 'h' for a list of possible commands.");
            }
            if (adventure.getJack().getHitPoints() <= 0) {
                System.out.println("-YOU FACE DOOM! GOOD LUCK IN YOUR NEXT DEATH!");
                break;
            }
        }
    }
}

