import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Stalin {
   private int x,y;
   private BufferedImage image;
   
   public Stalin(int x, int y) {
      try {                
          image = ImageIO.read(new File("/stalin.jpg"));
       } catch (IOException ex) {}
      this.x = x;
      this.y = y;
     }
   
   public void changeCoordinates(int x, int y) {
      this.x+= x;
      this.y+= y;
   }
   
   
   
   public void render(Graphics g) {
      g.drawImage(image,x,y,null);
   }
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
}