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

import java.io.*;
import javax.swing.*;

/**
 * Game.java
 * Assignment: Communist Hunt
 * Purpose: To create a simple Duck Hunt game  
 * @version 6/20/2016
 * @authors Griffin Craft, Cooper Chia, Noah Weiss
 */


public class Game extends JPanel implements ActionListener, MouseListener,MouseMotionListener, KeyListener  {
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   private Stalin temp;
   private Stalin communistBackground;
   private Random r;
   private Menu menu;
   private int ammo = 6;
   private int score = 0;
   private int width = 108;
   private int height = 152;
   private JMenuBar bar;
   private JMenu jmenu;
   private int count;
   
   public enum STATE {
      Menu,
      Game
   };
   public STATE GameState = STATE.Game;
   
   //Constructor that creates the menu, random object, background, and the end screen
   public Game(JFrame frame) {
      Background.changeAmmo(6);
      Background.score(score);
      menu = new Menu();
      r = new Random();
      communistBackground = new Stalin(0,0,0,"sovietflag.jpg",true);
      setBackground(Color.WHITE);     
      setFocusable(true);
      addMouseListener(this);
      addKeyListener(this);
      Timer timer = new Timer(1000/60, this);
      timer.start();
      bar = new JMenuBar();
      jmenu = new JMenu("Options");
      JMenuItem jmExit = new JMenuItem("Exit");
      jmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
      JMenuItem jmStory = new JMenuItem("Story");
      jmStory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
      JMenuItem jmClose = new JMenuItem("Close");
      JMenuItem jmNewGame = new JMenuItem("New Game");
      jmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0));
      JMenuItem jmRules = new JMenuItem("Rules");
      jmRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
      jmenu.add(jmClose);
      jmenu.add(jmNewGame);
      jmenu.add(jmRules);
      jmenu.add(jmExit);
      jmenu.add(jmStory);
      bar.add(jmenu);
      jmExit.addActionListener(new ExitListener());
      jmClose.addActionListener(this);
      jmStory.addActionListener(new StoryListener());
      jmNewGame.addActionListener(new GameListener());
      jmRules.addActionListener(new  RulesListener());
      frame.setJMenuBar(bar); 
   
   }
   
   //Paints all the stuff onto the screen
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //end state to the game
      if(score==10){
         menu.render(g,accuracy());
      }
      //draws the stalins onto the screen
      else if(GameState == STATE.Game){
         g.setColor(Color.BLACK);
         communistBackground.render(g);
         for(int i = 0; i< s.size(); i++) {
            temp = s.get(i);
            temp.render(g);
         }
         repaint();
      }
   }
   
   //Makes the game have animation 
   public void actionPerformed(ActionEvent e) {
      reset();
   }
   
   //Stalin AI method that resets the screen
   public void reset()  {
      int start = 10;
      boolean positive = true;
      if(GameState == STATE.Game) {
         if(s.size()<=5) {
            for(int j= s.size(); j<5; j++) {
               if((r.nextInt(10))%2 == 0){
                  start = 1270;
                  positive = false;
               }
               Stalin ten = new Stalin(start, r.nextInt(1040-184),r.nextInt(5) + 3, "stalin.png",positive);
               s.add(ten);   
            }
         }
         /*
             AI segment, that dictates a movement patern for the Stalin's
         */
         for(int i = 0; i<s.size();i++) {
            Stalin TempStalin = s.get(i);
            if(TempStalin.getX() >= 1280){
            
               killStalin(TempStalin);
            }
            else if(TempStalin.getX()<=0){
            
               killStalin(TempStalin);
            }
            if(TempStalin.getY() <= 0){
            
               killStalin(TempStalin);
            }
            else if(TempStalin.getY() >= 1000){
            
               killStalin(TempStalin);
            }
            TempStalin.speed();
         }
      }
   }
   
   //Registers if the mouse is clicked
   public void mouseClicked(MouseEvent e) {
      Background.changeAmmo(ammo-1);
      ammo--;
      count++;
      for(int i = 0; i<s.size(); i++) {
         Stalin TempStalin = s.get(i);
         if(e.getX() >= TempStalin.getX() - TempStalin.getSpeed() && e.getX() <= TempStalin.getX() + width + TempStalin.getSpeed() && e.getY() >= TempStalin.getY() - TempStalin.getYSpeed() && e.getY() <= TempStalin.getY() + height + TempStalin.getSpeed() && ammo > 0) {
            killStalin(TempStalin);
            score++;
            Background.score(score);
         }
      }
   }
   //computes the users accuracy and returns a double value
   public double accuracy(){
      double accuracy = (double)score/count;
      if(accuracy>1){
         accuracy = 1;
      }
      return accuracy*100;
   }
   
   
   public void mouseEntered(MouseEvent e) {
   
   }
   public void mouseExited(MouseEvent e) {
   
   }
   public void mousePressed(MouseEvent e) {
   
   }
   public void mouseReleased(MouseEvent e) {
   
   }
   public void mouseDragged(MouseEvent e) {                      
   
   }
   public void mouseMoved(MouseEvent e) {
                                                                                                                           
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