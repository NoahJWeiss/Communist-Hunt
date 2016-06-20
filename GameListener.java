import java.awt.event.*;
import java.io.*;

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