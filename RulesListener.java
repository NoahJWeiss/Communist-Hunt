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
      JOptionPane.showMessageDialog(null, "Click the Stalin heads to kill the hell out of them /n press r to reload, your ammo count is on the left");
   }
}