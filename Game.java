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
import java.util.Random;
import javax.swing.*;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * Game.java
 * Assignment: Communist Hunt
 * Purpose: To create a simple Duck Hunt game  
 * @version 6/20/2016
 * @authors Griffin Craft, Cooper Chia, Noah Weiss
 */

public class Game extends JPanel implements ActionListener, MouseListener, KeyListener {
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   
   
   private Stalin temp;
   private Stalin communistBackground;
   private Random r;
   private Menu menu;
   

   private int ammo = 6;
   private int test = 1;
   private int score = 0;
   private int stalinX = 100;
   private int stalinY = 100;
   private int stalinYSpeed = -1;
   private int stalinXSpeed = -5;
   private int width = 108;
   private int radius2 = 152;
   private JMenuBar bar;
   private JMenu jmenu;
   private boolean playingGame = true;
   
   //Constructor that creates the menu, random object, background, and the end screen
   public Game(JFrame frame) { 
      Background.changeAmmo(6);
      menu = new Menu(frame);
      r = new Random();
      Background.score(score);
      communistBackground = new Stalin(0,0,"sovietflag.jpg");
      setBackground(Color.WHITE);     
      setFocusable(true);
      addMouseListener(this);
      addKeyListener(this);
      Timer timer = new Timer(1000/60, this);
      timer.start();
      bar = new JMenuBar();
      jmenu = new JMenu("Options");
      JMenuItem jmExit = new JMenuItem("Exit");
      JMenuItem jmRules = new JMenuItem("Rules");
      JMenuItem jmClose = new JMenuItem("Close");
      JMenuItem jmNewGame = new JMenuItem("New Game");
      jmenu.add(jmClose);
      jmenu.add(jmNewGame);
      jmenu.add(jmRules);
      jmenu.add(jmExit);
      bar.add(jmenu);
      jmExit.addActionListener(new ExitListener());
      jmClose.addActionListener(this);
      jmRules.addActionListener(new RulesListener());
      jmNewGame.addActionListener(new GameListener());
      frame.setJMenuBar(bar); 
   
   }
   //Paints all the stuff onto the screen
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //end state to the game
      if(score>=10){
         menu.render(g);
      }
      //draws the stalins onto the screen
      else
      {
         g.setColor(Color.BLACK);
         communistBackground.render(g);
         for(int i = 0; i< s.size(); i++) {
            temp = s.get(i);
            temp.render(g);
         }
         if(ammo == 0) {
            Font fnt0 = new Font("helvetica", Font.BOLD, 50);
            g.setFont(fnt0);
            g.setColor(Color.BLUE);
            g.drawString("Reload! Press R!", 350, 600);
         }
      }
     
      repaint();
   }
    //Makes the game have animation 
   public void actionPerformed(ActionEvent e) {
      reset();
   }
   //Stalin AI method that resets the screen
   public void reset()  {
      int start = 0;
   
      if(s.size()<=7 && score < 92) {
         for(int j= s.size(); j<7; j++) {
            if(r.nextInt(100)%2 ==0)
               start = 1280;
            s.add(new Stalin(0, r.nextInt(1040-184), "stalin.png"));
         }
      }
      /*
      AI segment, that dictates a movement patern for the Stalin's
      */
      for(int i = 0; i<s.size(); i++) {
         Stalin TempStalin = s.get(i);
         if(s.get(i).getX() >= 1280-160)
            stalinXSpeed = -3;
         else if(s.get(i).getX()<=0)
            stalinXSpeed = 3;
         if(s.get(i).getY() <= 0)
            stalinYSpeed = 3;
         else if(s.get(i).getY() >= 1040-184)
            stalinYSpeed =-3;
         s.get(i).changeCoordinates(stalinXSpeed,stalinYSpeed);
      
      }
   }
   //Registers if the mouse is clicked
   public void mouseClicked(MouseEvent e) {
      Background.changeAmmo(ammo-1);
      ammo--;
      System.out.println(ammo);
      for(int i = 0; i<s.size(); i++) {
         Stalin TempStalin = s.get(i);
         if(e.getX() >= TempStalin.getX() && e.getX() <= TempStalin.getX() + width && e.getY() >= TempStalin.getY() && e.getY() <= TempStalin.getY() + radius2 && ammo > 0) {
            killStalin(TempStalin);
            score++;
            Background.score(score);
         }
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
   public void keyTyped(KeyEvent e) {
      
   }
   //Registers if the R key is typed
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_R) {
         ammo = 6;
         Background.changeAmmo(6);
      }
   }
   public void keyReleased(KeyEvent e) {
   
   }
   //Add's a Stalin to the screen
   public void addStalin(Stalin boo) {
      s.add(boo);
   }
   //Removes a Stalin from the screen 
   public void killStalin(Stalin boo) {
      s.remove(boo);   
   }
}