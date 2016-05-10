public class Hit{
   private int radius;
   private int x.stal;
   private int y.stal;
   private int x.gun;
   private int y.gun;
  
   public Hit(Stalin stal, Gun gun){
      this.radius = stal.getRadius();
      this.x.stal = stal.getX();
      this.y.stal = stal.getY();
      this.x.gun = gun.getX();
      this.y.gun = gun.getY();
   }
   
   public boolean hitOrMiss(){
      if(x.gun >= x.stal && x.gun <= x.stal + (2 * radius) && y.gun >= y.stal && y.gun <= y.stal + (2 * radius)){
         return true;
      }   
         return truman();
         
   }
   
   public boolean truman(){
      if(
   
   }
}