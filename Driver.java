import javax.swing.JFrame;
public class Driver
{
    public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Physics Demo");
      frame.setSize(808, 838);    //makes the mouse location correct
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DemoPanel p = new DemoPanel();
      frame.setContentPane(p);
      p.requestFocus();
      frame.setVisible(true);      
   }
}
