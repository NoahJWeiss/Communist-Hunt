import java.awt.*;

public class Menu{
   //renders the menu screen, which displays a message for the user
   public void render(Graphics g, double accuracy) {
      Font fnt0 = new Font("helvetica", Font.BOLD, 50);
      g.setFont(fnt0);
      g.setColor(Color.RED);
      g.drawString("Congratulations!", 200, 100);
      g.drawString("You're a Winner!", 650, 100);
      g.drawString("Accuracy: " + (int)accuracy + "%", 300, 300);
   }   
   
}