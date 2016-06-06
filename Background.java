import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.*;

import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Background {
   private static int score = 0;
   private static JLabel label = new JLabel(String.valueOf(score));
   public static void main(String[] args) throws IOException {
      JFrame frame = new JFrame("Stalin");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      Game game = new Game();
      frame.add(game, BorderLayout.CENTER);
      frame.add(label, BorderLayout.NORTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280, 1024);
      frame.setVisible(true);
   }
   public static void score() {
      score++;
      label.setText(String.valueOf(score));
   }
   public static int getScore() {
      return score;
   }
}