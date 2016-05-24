import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Gun extends MouseInputAdapter{

   private BufferedImage crosshair;
   private Graphics g;
   private JLabel label;
   
   public Gun( JFrame frame) throws IOException{
      //hit = new Hit(stal);
      g = frame.getGraphics();
      crosshair = ImageIO.read(getClass().getResource("/download.png"));
      frame.addMouseListener(this);
      frame.addMouseMotionListener(this);
      label = new JLabel();
      label.setText("hi");
      frame.add(label);

     
   }
    public void mouseMoved(MouseEvent event){
    label.setText(event.getX() + ", " + event.getY());
    
    }
   
    public void mouseClicked(MouseEvent event){
      //boolean cross = hit.hitOrMiss(event.getX(), event.getY());
      System.out.println(event.getX() + ", " + event.getY());
      
   }
  }