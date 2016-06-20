import java.awt.event.*;

public class ExitListener implements ActionListener{
   //Exits the game screen when the user clicks the "Exit" button in the frame
   public void actionPerformed(ActionEvent e){
      System.exit(0);
   }
}