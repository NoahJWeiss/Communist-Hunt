import java.awt.*;

/**
 * Menu.java
 * Summary: Menu.java is the screen that shows up after the game has been
 * completed. A message is displayed and the player's acuracy is shown.
 * @version 06/21/16
 * @author Cooper Chia, Griffin Craft, Noah Weiss
 */

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