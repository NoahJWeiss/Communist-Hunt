import javax.swing.*;
import java.awt.event.*;

public class RulesListener implements ActionListener {
   //opens up a pane that shows the rules when the user clicks the "Rules" button
   public void actionPerformed(ActionEvent event) {
      JOptionPane.showMessageDialog(null, "It is the future, in the year 2002. Joseph Stalin \nhas been cloned 10 times to create a destructive force \nthat thretens the whole world The current president \nHarry Truman Jr. has tasked you with the job to destroy all \nStalin's before they infect the world with their Red ideals");
   }
}