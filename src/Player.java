public class Player {
    private Room theRoomIamIn;


    public Player(Room firstRoom) {
        this.theRoomIamIn = firstRoom;
    }

    public boolean canMove(String direction) {
        return switch (direction) {
            case "go north" -> theRoomIamIn.getNorth() != null;
            case "go south" -> theRoomIamIn.getSouth() != null;
            case "go east" -> theRoomIamIn.getEast() != null;
            case "go west" -> theRoomIamIn.getWest() != null;
            default -> false;
        };
    }

    public void moveToRoom(String direction) {
        if (direction.equalsIgnoreCase("go north")) {
            theRoomIamIn = theRoomIamIn.getNorth();
        } else if (direction.equalsIgnoreCase("go south")) {
            theRoomIamIn = theRoomIamIn.getSouth();
        } else if (direction.equalsIgnoreCase("go east")) {
            theRoomIamIn = theRoomIamIn.getEast();
        } else if (direction.equalsIgnoreCase("go west")) {
            theRoomIamIn = theRoomIamIn.getWest();
        }
    }

    public void goToNorthRoom() {
        theRoomIamIn = theRoomIamIn.getNorth();
    }

    public void goToSouthRoom() {
        theRoomIamIn = theRoomIamIn.getSouth();
    }

    public void goToEastRoom() {
        theRoomIamIn = theRoomIamIn.getEast();
    }

    public void goToWestRoom() {
        theRoomIamIn = theRoomIamIn.getWest();
    }

    public String whereRU() {
        return theRoomIamIn.getRoomName();
    }

    public String getCurrentRoomName() {
        return theRoomIamIn.getRoomName();
    }

    public String getCurrentRoomDescription() {
        return theRoomIamIn.getRoomDescription();
    }

}
