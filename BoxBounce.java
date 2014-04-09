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
    public final static int MINIMA_X = 50;
    public final static int MINIMA_Y = 50;
    public final static int MAXIMA_X = 550;
    public final static int MAXIMA_Y = 450;

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
        myCanvas.setVisible(true);
        aleatorio = new Random();
        int diameter;      

        for(int i = 0 ; i < numberOfBalls ; i++)
        {
            Color ballColor = new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256));
            
            do
            {
                diameter = aleatorio.nextInt(60) + 20;
            }
            while(diameter%2 == 0);
            
            int xBola = aleatorio.nextInt(400 - diameter) + MINIMA_X + diameter;
            int yBola = aleatorio.nextInt(300 - diameter) + MINIMA_Y + diameter;
            
            balls.add(new BoxBall(xBola,yBola,diameter,ballColor,myCanvas));
        }

        myCanvas.drawLine(MINIMA_X,MAXIMA_Y,MAXIMA_X,MAXIMA_Y);
        myCanvas.drawLine(MAXIMA_X,MAXIMA_Y,MAXIMA_X,MINIMA_Y);
        myCanvas.drawLine(MAXIMA_X,MINIMA_Y,MINIMA_X,MINIMA_Y);
        myCanvas.drawLine(MINIMA_X,MINIMA_Y,MINIMA_X,MAXIMA_Y);

        for(BoxBall showBalls: balls)
        {
            showBalls.draw();
        }

        boolean finished =  false;
        
        while(!finished) 
        {
            myCanvas.wait(30);

            for(BoxBall showBalls: balls)
            {
                showBalls.move();
            }
        }
    }
}