import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements ActionListener, MouseListener, MouseMotionListener  {
   
   public ArrayList<Stalin> s = new ArrayList<Stalin>();
   private Stalin temp;
   private Stalin communistBackground;
   private Random r;
   private Menu menu = new Menu();
   private int score = 0;
   private int stalinX = 100;
   private int stalinY = 100;
   private int stalinYSpeed = 0;
   private int stalinXSpeed = -7;
   private int diameterX = 108;
   private int diameterY = 152;
   
   public enum STATE {
      Menu, Game;
   }
   public STATE GameState = STATE.Game;
   
   public Game() {
      r = new Random();
      communistBackground = new Stalin(0,0,"sovietflag.jpg");
      setBackground(Color.WHITE);     
      setFocusable(true);
      addMouseListener(this);
      Timer timer = new Timer(1000/60, this);
      timer.start();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(score==10){
         menu.render(g);
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
      if(GameState == STATE.Game) {
         if(s.size()<10) {
            for(int j=s.size(); j<10; j++) {
               s.add(new Stalin(1000, r.nextInt(1040-184), "stalin.png"));
               if(r.nextInt(2)==1){
                  stalinXSpeed *= -1;
               }
            }
         }
         for(int i = 0; i<s.size(); i++) {
            Stalin TempStalin = s.get(i);
            if(s.get(i).getX() >= 1280-108){
               killStalin(TempStalin);
               Background.score();
            }
            else if(s.get(i).getX()<=0){
               killStalin(TempStalin);
               Background.score();
            }
            if(s.get(i).getY() <=0){
               killStalin(TempStalin);
               Background.score();
            }
            else if(s.get(i).getY() >= 1040-152){
               killStalin(TempStalin);
               Background.score();
            }
            TempStalin.changeCoordinates(stalinXSpeed,stalinYSpeed);
         }
      }
   }
   public void mouseClicked(MouseEvent e) {
      if(GameState == STATE.Menu)
         GameState = STATE.Game;
      if(GameState == STATE.Game) {
         for(int i = 0; i<s.size(); i++) {
            Stalin TempStalin = s.get(i);
            if(e.getX() >= TempStalin.getX() && e.getX() <= TempStalin.getX() + diameterX && e.getY() >= TempStalin.getY() && e.getY() <= TempStalin.getY() + diameterY ) {
               killStalin(TempStalin);
               Background.score();
               score = Background.getScore();
            }
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
   public void mouseDragged(MouseEvent e) {                      
   
   }
   public void mouseMoved(MouseEvent e) {
                                                                                                                           
   }
   public void addStalin(Stalin boo) {
      s.add(boo);
   }
   public void killStalin(Stalin boo) {
      s.remove(boo);   
   }
}