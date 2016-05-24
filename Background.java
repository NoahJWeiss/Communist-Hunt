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
   public static void main(String[] args) throws IOException {
      JFrame frame = new JFrame("Stalin");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
   	int score = 0;
      JLabel label = new JLabel(Integer.toString(score), JLabel.CENTER);
      label.setText(Integer.toString(score));
      label.setAlignmentX(0);
      label.setAlignmentY(0);
      frame.add(label);
      Game game = new Game(frame);
      frame.add(game, BorderLayout.CENTER);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1000, 300);
      frame.setVisible(true);
   }
}