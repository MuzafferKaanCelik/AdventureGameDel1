public class RangedWeapon extends Weapon{
    private int ammo;

    public RangedWeapon(String name, String description, int damage){
        super(name,description,damage);
        this.ammo = ammo;
    }
    @Override
    public boolean canEquip(){
        return ammo > 0;
    }
    @Override
    public void equip(){
        if(ammo>0){
            ammo--;
        }
    }

    public int getAmmo(){
        return ammo;
    }


}
