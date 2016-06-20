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



public class Game extends JPanel implements ActionListener, MouseListener,MouseMotionListener, KeyListener  {
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   private Stalin temp;
   private Stalin communistBackground;
   private Random r;
   private Menu menu;
   private int ammo = 6;
   private int score = 0;
   private int radius1 = 108;
   private int radius2 = 152;
   private JMenuBar bar;
   private JMenu jmenu;
   private int count;

   
   public enum STATE {
      Menu,
      Game
   };
   public STATE GameState = STATE.Game;
   
   public Game(JFrame frame) {
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
      JMenuItem jmRules = new JMenuItem("Rules");
      JMenuItem jmClose = new JMenuItem("Close");
      JMenuItem jmPause = new JMenuItem("Pause");
      JMenuItem jmNewGame = new JMenuItem("New Game");
      jmenu.add(jmClose);
      jmenu.add(jmPause);
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

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(score==10){
         menu.render(g,accuracy());
      }
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
   
   public void actionPerformed(ActionEvent e) {
      reset();
   }
   
   public void reset()  {
      int start = 10;
      boolean positive = true;
      if(GameState == STATE.Game) {
         if(s.size()<=5) {
            for(int j= s.size(); j<5; j++) {
            /*try{
               Thread.sleep(2500);
            }
            catch(Exception e) {
            }
            */
            if((r.nextInt(10))%2 == 0){
            start = 1270;
            positive = false;
            }
               Stalin ten = new Stalin(start, r.nextInt(1040-184),r.nextInt(5) + 3, "stalin.png",positive);
               s.add(ten);   
            }
         }
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
   public void mouseClicked(MouseEvent e) {
      Background.changeAmmo(ammo-1);
      ammo--;
      count++;
      for(int i = 0; i<s.size(); i++) {
            Stalin TempStalin = s.get(i);
            if(e.getX() >= TempStalin.getX() - TempStalin.getSpeed() && e.getX() <= TempStalin.getX() + radius1 + TempStalin.getSpeed() && e.getY() >= TempStalin.getY() - TempStalin.getYSpeed() && e.getY() <= TempStalin.getY() + radius2 + TempStalin.getSpeed() && ammo > 0) {
               killStalin(TempStalin);
               score++;
               Background.score(score);
            }
         }
      }
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
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_R) {
         ammo = 6;
         Background.changeAmmo(6);
      }
   }
   public void keyReleased(KeyEvent e) {
   
   }

   public void addStalin(Stalin boo) {
      s.add(boo);
   }
   public void killStalin(Stalin boo) {
      s.remove(boo);   
   }
}