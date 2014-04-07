import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BoxBounce - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BoxBounce   
{
    private Canvas myCanvas;
    private ArrayList<BoxBall> balls;
    private Random aleatorio;
    /**
     * Create a BoxBounce object. Creates a fresh canvas and makes it visible.
     */
    public BoxBounce()
    {
        balls = new ArrayList<>();
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 600;   // position of the ground line
        myCanvas.setVisible(true);
        aleatorio = new Random();
        for(int i = 0 ; i < numberOfBalls ; i++)
        {
            balls.add(new BoxBall(aleatorio.nextInt(250),aleatorio.nextInt(450),aleatorio.nextInt(100),
                    new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256)), ground,myCanvas));
        }
        // draw the ground
        myCanvas.drawLine(0,ground,600,ground);
        myCanvas.drawLine(600,ground,600,0);
        myCanvas.drawLine(600,0,0,0);
        myCanvas.drawLine(0, 0,0,ground);
        // crate and show the balls
        for(BoxBall showBalls: balls)
        {
            showBalls.draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall showBalls: balls)
            {
                showBalls.move();
                // stop once ball has travelled a certain distance on x axis

            }
        }
    }
}