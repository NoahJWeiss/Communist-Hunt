import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import java.util.ArrayList;
import javax.swing.*;



public class Game extends JPanel implements ActionListener, MouseListener  {
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   
   private JFrame frame;
   
   private Stalin stalin = null;
   private Stalin temp;
   
   private int score = 0;
   private int stalinX = 100;
   private int stalinY = 100;
   private int stalinYSpeed = -5;
   private int stalinXSpeed = -5;
   private int radius1 = 100;
   private int radius2 = 175;
   
   private Gun gun;
   
   
   public Game(JFrame frame) {
      Stalin stalin = new Stalin(100,100);
      this.frame = frame;
      setBackground(Color.WHITE);     
      setFocusable(true);
      addMouseListener(this);
      Timer timer = new Timer(1000/60, this);
      timer.start();
      for(int j= 0; j<9; j++) {
      s.add(new Stalin(100 + 10*j,100 + 10 *j));
      }
      }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.setColor(Color.GREEN);
      g.fillRect(0,250,1000,20);
      g.setColor(Color.BLUE);
      for(int i = 0; i< s.size(); i++) {
         temp = s.get(i);
         temp.render(g);
      }
      repaint();
   }
   
   public void actionPerformed(ActionEvent e) {
      reset();
   }
   
   public void reset()  {
      
      for(int i = 0; i<s.size(); i++) {
         Stalin TempStalin = s.get(i);
         if(TempStalin.getX() >= 1000-160)
            stalinXSpeed = -3;
         else if(TempStalin.getX()<=0)
            stalinXSpeed = 3;
         if(TempStalin.getY() <= 0)
            stalinYSpeed = 3;
         else if(TempStalin.getY() >= 250-184)
            stalinYSpeed =-3;
         TempStalin.changeCoordinates(stalinXSpeed,stalinYSpeed);
         stalinX+=stalinXSpeed;
         stalinY+= stalinYSpeed;
      }
   }
   public void mouseClicked(MouseEvent e) {
      for(int i = 0; i<s.size(); i++) {
      Stalin TempStalin = s.get(i);
      if(e.getX() >= TempStalin.getX() && e.getX() <= TempStalin.getX() + radius1 && e.getY() >= TempStalin.getY() && e.getY() <= TempStalin.getY() + radius2 ) {
      System.out.println("Hit");
      killStalin(TempStalin);
      }
      else
      System.out.println("Miss");    
      }
   }
   public void mouseEntered(MouseEvent e) {
   
   }
   public void mouseExited(MouseEvent e) {
   
   }
   public void mousePressed(MouseEvent e) {
   
   }
   public void mouseReleased(MouseEvent e) {
   
   }
   public void addStalin(Stalin boo) {
      s.add(boo);
   }
   public void killStalin(Stalin boo) {
      s.remove(boo);   
   }
}