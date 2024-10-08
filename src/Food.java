public class Food extends Item {

    private int hitPoints;

    public Food(String food, String foodDescription, int hitPoints){
        super(food,foodDescription);
        this.hitPoints = hitPoints;
    }

    public int getHitPoints(){
        return hitPoints;
    }
}
