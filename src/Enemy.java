public class Enemy {
   private String enemyName;
   private String enemyDescription;
   private int enemyHitPoints;
   private int jackDamage;
   private Weapon enemyWeapon;

   public Enemy(String enemyName, String enemyDescription, int enemyHitPoints, int jackDamage, Weapon enemyWeapon){
      this.enemyName = enemyName;
      this.enemyDescription = enemyDescription;
      this.enemyHitPoints = enemyHitPoints;
      this.jackDamage = jackDamage;
      this.enemyWeapon = enemyWeapon;
   }

   public Weapon getEnemyWeapon(){
      return enemyWeapon;
   }

   public String getEnemyName(){
      return enemyName;
   }

   public String getEnemyDescription(){
      return enemyDescription;
   }
   public int getEnemyHitPoints(){
      return enemyHitPoints;
   }
   public void takeDamage(int damage){
      enemyHitPoints -= damage;
      if(enemyHitPoints<=0){
         enemyHitPoints=0;
      }
   }

}

