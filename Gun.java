import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Gun extends MouseInputAdapter{
   private JFrame frame;
   private BufferedImage crosshair;
   private Graphics g;
   
   public Gun(JFrame frame) throws IOException{
      this.frame = frame;
      /*
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.setSize(new Dimension(1000,300));
      frame.setTitle("A frame");
      frame.setVisible(true);
      */
      g = frame.getGraphics();
      
      crosshair = ImageIO.read(getClass().getResource("/download.png"));
      
      
      frame.addMouseListener(this);
      frame.addMouseMotionListener(this);
      
   }
   public void mouseMoved(MouseEvent event){
      //g.drawImage(crosshair, event.getX(), event.getY(), null);
   }
   
  
  }