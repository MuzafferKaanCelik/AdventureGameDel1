public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, String description,int damage){
        super(name,description,damage);
    }
    @Override
    public boolean canEquip(){
        return true;
    }
    @Override
    public void equip(){
    }

}
