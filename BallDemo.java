import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> balls;
    private Random aleatorio;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        balls = new ArrayList<>();
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        aleatorio = new Random();
        for(int i = 0 ; i < numberOfBalls ; i++)
        {
            balls.add(new BouncingBall(aleatorio.nextInt(250),aleatorio.nextInt(450),aleatorio.nextInt(100),
            new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256)), ground,myCanvas));
        }
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(BouncingBall showBalls: balls)
        {
            showBalls.draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall showBalls: balls)
            {
                showBalls.move();
                   if(showBalls.getXPosition() >= 550)
         {
                finished = true;
            }
            // stop once ball has travelled a certain distance on x axis
         
            }
        }
    }
}
