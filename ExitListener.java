import java.awt.event.*;

/**
 * ExitListener.java
 * Summary: ExitListener is called when the user clicks
 * the "Exit" button on the game screen, exits the game
 * @version 06/21/16
 * @author Cooper Chia, Griffin Craft, Noah Weiss
 */

public class ExitListener implements ActionListener{
   //Exits the game screen when the user clicks the "Exit" button in the frame
   public void actionPerformed(ActionEvent e){
      System.exit(0);
   }
}