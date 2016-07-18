import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
 public class DemoPanel extends JPanel
{
   private static final int FRAME1 = 800;
   private static final int FRAME2 = 800;
   //private double tick = 0;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Timer t; 
     //constructor   
    public DemoPanel()
   {
      myImage =  new BufferedImage(FRAME1, FRAME2, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME1,FRAME2);
      ball = new Ball(FRAME1/2,FRAME2/2, 50, Color.BLACK);
      //ball.setay(-0.19);
      ball.setay(-1);

      t = new Timer(1, new Listener());
      t.start();
   }
    public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
    private class Listener implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0,0,FRAME1,FRAME2);
         /*
         ball.setdx(ball.getdx() + ball.getax());
         ball.setdy(ball.getdy() + ball.getay());
         ball.setX(ball.getX() + ball.getdx());
         ball.setX(ball.getY() + ball.getdy());
         */
         //tick++;
         ball.move(FRAME1,FRAME2);
         ball.draw(myBuffer,FRAME2); 
         //
         myBuffer.setFont(new Font("Serif",Font.PLAIN,20));
         myBuffer.setColor(Color.BLACK);
         myBuffer.drawString("Kinetic Energy: " + ball.getKE(), 10, 20);
         myBuffer.drawString("Potential Energy: " + ball.getU(), 10, 50);
         myBuffer.drawString("Total Energy: " + ball.getE(), 10, 80);
         //
         repaint();
      }
   }   
}