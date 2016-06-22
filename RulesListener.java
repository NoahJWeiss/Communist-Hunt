import javax.swing.*;
import java.awt.event.*;

/**
 * RulesListener.java
 * Summary: RulesListener is called when the user clicks the "Rules" button
 * on the game screen, the rules of the game are displayed in a pane.
 * @version 06/21/16
 * @author Cooper Chia, Griffin Craft, Noah Weiss
 */


public class RulesListener implements ActionListener {
   //opens up a pane that shows the rules when the user clicks the "Rules" button
   public void actionPerformed(ActionEvent event) {
      JOptionPane.showMessageDialog(null, "It is the future, in the year 2002. Joseph Stalin \nhas been cloned 10 times to create a destructive force \nthat thretens the whole world The current president \nHarry Truman Jr. has tasked you with the job to destroy all \nStalin's before they infect the world with their Red ideals");
   }
}