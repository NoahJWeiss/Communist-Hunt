import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Client{
   public static void main(String[] args)throws IOException{
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.setSize(new Dimension(1000, 300));
      JLabel label = new JLabel();
      label.setText("0");
      frame.add(label,BorderLayout.NORTH);
      frame.setVisible(true);
      Gun gun = new Gun(frame);
      Detail det = new Detail(frame);
      
      
      
      
      
   }
   
}