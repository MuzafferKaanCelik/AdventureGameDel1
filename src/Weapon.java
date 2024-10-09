public abstract class Weapon extends Item {
    private String name;
    private int damage;

    public Weapon(String name, String description, int damage){
        super(name,description);
        this.damage = damage;
    }
    public abstract boolean canEquip();
    public abstract void equip();

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }

}
