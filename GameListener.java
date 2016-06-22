import java.awt.event.*;
import java.io.*;

/**
 * GameListener.java
 * Summary: GameListener is called when the user clicks the 
 * "New Game" button on the game screen, starts a new game
 * @version 06/21/16
 * @author Cooper Chia, Griffin Craft, Noah Weiss
 */


public class GameListener implements ActionListener{
   //starts a new game when the user clicks the "New Game" button
   public void actionPerformed(ActionEvent event){
      String[] hey = new String[1];
      try{
         Background.main(hey);
      }
      catch(Exception e) {
      }
   }
}
