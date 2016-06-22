import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

/**
 * Background.java
 * Assignment: Communist Hunt
 * Summary: This is the client code. Creates the game
 * and JFrame.
 * @version 06/21/16
 * @authors Noah Weiss, Grifin Craft, Cooper Chia
 */

public class Background {
   private static int ammo = 6;
   private static int score = 0;
   private static JLabel label2 = new JLabel(String.valueOf(ammo));
   private static JLabel label = new JLabel(String.valueOf(score));
   
   //Client code. Starts the program and intitalizes some of the building blocks 
   //like the jframe. Starts the game class.
   public static void main(String[] args) throws IOException {
      JFrame frame = new JFrame("Stalin");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      Game game = new Game(frame);
      frame.add(label2, BorderLayout.WEST);
      frame.add(game, BorderLayout.CENTER);
      frame.add(label, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280, 1024);
      frame.setVisible(true);
   }
   
   //Updates the score counter in the jframe.
   public static void score(int score) {
      label.setText(String.valueOf(score));
      score++;
   }
   
   //Returns the current score of the game.
   public static int getScore() {
      return score;
   }
   
   //Updates the ammo counter in the jframe.
   public static void changeAmmo(int ammo) {
      if(ammo > 0)
      label2.setText(String.valueOf(ammo));
      else
      label2.setText(String.valueOf(0));
   }

}