import java.awt.*;


public class Menu extends Game {
   private int gameWidth = 1280;
   public void render(Graphics g) {
      Font fnt0 = new Font("helvetica", Font.BOLD, 50);
      g.setFont(fnt0);
      g.setColor(Color.RED);
      g.drawString("Congartulations!", 0, 100);
      g.drawString("You're Winner!", gameWidth/2, 100);
   }   
   
}