 import java.awt.*;
    public class Ball extends Polkadot
   {
      private double dx;
      private double dy;
      private double ax, ay;
      private double mass;
      private double KE, U, E;
      private final double LOSS = 1;
       public Ball()
      {
         super(200, 200, 50, Color.BLACK);
         dx = Math.random() * 4 - 2;
         dy = Math.random() * 4 - 2;
         ax = 0;
         ay = 0;
         mass = 1;
         KE = (0.5)*mass*(dx*dx + dy*dy);
         U = mass*Math.abs(ay)*getY();
         E = KE + U;
      }
       public Ball(double x, double y, double dia, Color c)
      {
         super(x, y, dia, c);
         dx = Math.random()* 12 - 6;
         dy = Math.random() * 12 - 6;
         ax = 0;
         ay = 0;
         mass = 1;
      }
       public void setdx(double x)        
      {
         dx = x;
      }
       public void setdy(double y)
      {
         dy = y;
      }
       public double getdx()             
      {
         return dx;
      }
       public double getdy()
      {
         return dy;
      }
      
      public void setax(double x)        
      {
         ax = x;
      }
       public void setay(double y)
      {
         ay = y;
      }
       public double getax()             
      {
         return ax;
      }
       public double getay()
      {
         return ay;
      }
      public double getKE()
      {
         return KE;
      }
      public double getU()
      {
         return U;
      }
      public double getE()
      {
         return E;
      }
     //instance methods
       public void move(double rightEdge, double bottomEdge)
      {
         
         
         setX(getX()+ dx + 0.5*ax); 
         setY(getY()+ dy + 0.5*ay);       
         setdx(getdx() + ax);
         setdy(getdy() + ay);            // x = x + dx
         
         //setX(getX() + getdx()*t + (0.5)*getax()*t*t);
         //setY(getY() + getdy()*t + (0.5)*getay()*t*t);
         //
        // check for left & right edge bounces
         if(getX() >= rightEdge - getRadius())     //hits the right edge
         {
            setX(rightEdge - getRadius());
            dx = dx * -1; 
         }
         else if(0 >= getX() - getRadius())
         {
            setX(getRadius());
            dx = dx * -1; 
         }
         else if(getY() >= bottomEdge - getRadius())
         {
            setY(bottomEdge - getRadius());
            dy = dy * -1; 
         }
         else if(0 >= getY() - getRadius())
         {
            setY(getRadius());
            dy = dy * -1 * LOSS;
            U = mass*Math.abs(ay)*getY();
            double newvel = Math.sqrt((2*(E-U))/(mass));
            double ratio = newvel/Math.sqrt(dx*dx + dy*dy);
            dx *= (ratio*LOSS);
            dy *= (ratio*LOSS); 
         }
         KE = (0.5)*mass*(dx*dx + dy*dy);
         U = mass*Math.abs(ay)*getY();
         E = KE + U;
      }
   }
