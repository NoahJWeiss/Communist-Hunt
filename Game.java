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



public class Game extends JPanel implements ActionListener{
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   public JFrame frame;
   public BufferedImage img;

   private Stalin stalin = null;
   private Stalin temp;
   
   private Graphics g;
   private int stalinX = 100;
   private int stalinY = 100;
   private int stalinYSpeed = -3;
   private int stalinXSpeed = -3;
   
   private Gun gun;
   
   
   public Game(JFrame frame) throws IOException {
      setBackground(Color.WHITE);
      this.frame = frame;
      stalin = new Stalin(stalinX, stalinY);     
      Stalin stalin2 = new Stalin(stalinX + 100, stalinY - 40);
      gun = new Gun(stalin, frame);
      //gun.mouseMoved();
      Timer timer = new Timer(1000/60, this);
      timer.start();
      }
 
    public void paintComponent(Graphics g){
      
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
   
   public void reset() {
      for(int i = 0; i<s.size(); i++) {
      Stalin TempStalin = s.get(i);
      if(stalinX >= 1000-160)
         stalinXSpeed = -3;
      else if(stalinX<=0)
         stalinXSpeed = 3;
      if(stalinY <= 0)
         stalinYSpeed = 3;
      else if(stalinY >= 250-184)
         stalinYSpeed =-3;
      stalinY+=stalinYSpeed;
      stalinX+=stalinXSpeed;
      TempStalin.changeCoordinates(stalinXSpeed,stalinYSpeed);
     }
   }
   
    public void addStalin(Stalin boo) {
      s.add(boo);
   }
   public void killStalin(Stalin boo) {
      s.remove(boo);   
   }
 }