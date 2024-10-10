public class RangedWeapon extends Weapon {
    private int damagePoints;
    private int uses;

    public RangedWeapon(String weaponName, String weaponDescription, int damagePoints, int uses) {
        super(weaponName, weaponDescription);
        this.damagePoints = damagePoints;
        this.uses = uses;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    @Override
    Item weapon(String weaponName, String weaponDescription, int damagePoints) {
        return null;
    }
}


