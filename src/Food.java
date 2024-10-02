public class Food extends Item {
    int HealthAndDamage;

    public Food(String Item, String ItemDescription, int HealthAndDamage){
        super(Item,ItemDescription);
        this.HealthAndDamage=HealthAndDamage;
    }

    public int getHealthAndDamage() {
        return HealthAndDamage;
    }
}
