import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * Stalin.java
 * Assignment: Communist Hunt
 * Summary: Creates a Buffered image that can interact
 * with user input and other classes.
 * @version 06/21/16
 * @authors Noah Weiss, Grifin Craft, Cooper Chia
 */
public class Stalin {
   private int x,y,speed;
   private int count = 0;
   private int ySpeed = 1;
   private BufferedImage image;
   
   //Initializes the "Stalin" which is a buffered image. we give it a starting speed, a point, the file it uses for
   //for the picture, and a boolean that represents a direction.
   public Stalin(int x, int y,int speed, String fileLocation, boolean positive) {
      try {                
          image = ImageIO.read(new File(fileLocation));
       } catch (IOException ex) {}
      this.x = x;
      this.y = y;
      if(positive){
         this.speed = speed;
      }
      if(!positive){this.speed = -speed;}
     }
   
   //The render method draws the buffered image.
   public void render(Graphics g) {
      g.drawImage(image,x,y,null);
   }
   
   //Returns the current x cordinate.
   public int getX() {
      return x;
   }
   
   //Returns the current y cordinate.
   public int getY() {
      return y;
   }
   
   //Moves the buffered image by speed when called.
   public void speed(){
      this.x += speed;
      if(count%50 == 0){
         this.ySpeed *= -1;
      }
      this.y += speed * ySpeed;
      count++;
   }
   
   //Returns the speed of the Stalin.
   public int getSpeed(){
      return speed;
   }
   
   //Returns the speed of the stalin going up or down.
   public int getYSpeed(){
      return speed*ySpeed;
   }
   
}