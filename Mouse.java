import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;

public class Mouse extends JFrame implements MouseMotionListener{
 
   private Image dbImage;
   private Graphics dbg;
  
   boolean mouseDragged;
  
   int x,y;
  
   public Mouse(){
      setSize(1000,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addMouseMotionListener(this);
   }
   
   public void paint(Graphics g){
      dbImage = createImage(getWidth(), getHeight());
      dbg = dbImage.getGraphics();
      paintComponent(dbg);
      g.drawImage(dbImage, 0, 0, this);
   }
  
   public void paintComponent(Graphics g){
      if(mouseDragged){
         g.setColor(Color.RED);
         g.fillRect(0,0,getWidth(),getHeight());
         g.setColor(Color.WHITE);
         g.fillRect(x,y,20,20);
      }
      else{
         g.setColor(Color.WHITE);
         g.fillRect(0,0,getWidth(),getHeight());
         g.setColor(Color.RED);
         g.fillRect(x,y,20,20);
      }
      repaint();
   }
  
   public static void main(String[] args){
      Mouse mouse = new Mouse();
   }
    public void mouseDragged(MouseEvent e){
      x = e.getX()-10;
      y = e.getY()-10;
      mouseDragged = true;
      e.consume();
   }
  
   public void mouseMoved(MouseEvent e){
      x = e.getX();
      y = e.getY();
      mouseDragged = false;
      e.consume();
   }

}