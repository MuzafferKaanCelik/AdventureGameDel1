import java.util.Scanner;

public class UserInterface {

    Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }
    public void StartGame() {

        Scanner input = new Scanner(System.in);

        String userinput;

        System.out.println("Welcome to Jack Hellscape.");
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




        userinput = "";
        while (!userinput.equalsIgnoreCase("EXIT")) {
            userinput = input.nextLine();
            String[] commandUserInput = userinput.split(" ");
            switch (commandUserInput[0]) {
                case "START":
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;

                case "LOOK":
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                    
                case "HELP":
                    System.out.println("""
                            COMMAND LIST:\s
                            'go north' - to go north.
                            'go south' - to go south.
                            'go east' - to go east.
                            'go west' - to go west.
                            'EXIT' - to close the game.
                            'LOOK' - to get room number and description again.""");
                    break;
                case "take":
                    if (adventure.takeItem(commandUserInput[1])) {
                        System.out.println("you have pick up the " + commandUserInput[1] + " from the room");
                    }else {
                        System.out.println("There is no such thing as a"+ commandUserInput[1]+" in this room");
                }
                    break;

                case "drop":
                    if (adventure.dropItem(commandUserInput[1])) {
                        System.out.println("You have dropped the" + commandUserInput[1] + " in " + adventure.getCurrentRoomName());
                    }else {
                        System.out.println("You do not have " + commandUserInput[1] + " in your inventory");
                    }
                    break;
                case "inventory":
                    System.out.println(adventure.findItem());
                    break;
                case "go":
                    if (adventure.canJackMove(commandUserInput[1])) {
                        adventure.moveJackToRoom(commandUserInput[1]);
                        System.out.println("you head" + commandUserInput[1]);
                    } else {
                        System.out.println("you can't " + commandUserInput[1] + " from here");
                    }
                    System.out.println(adventure.getCurrentRoomDetails());
                    break;
                case "EXIT":
                    break;

                default:
                    System.out.println("Invalid command. Type 'HELP' for a list of possible commands.");

            }
        }
    }
}
