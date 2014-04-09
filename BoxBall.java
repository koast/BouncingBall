import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private int xSpeed =  1;
    private int ySpeed = 1;   
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private Random aleatorio;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        aleatorio = new Random();
        
        int posicionAleatoria;
        posicionAleatoria = aleatorio.nextInt(2);
        
        if(posicionAleatoria == 0)
        {
            xSpeed = -xSpeed;
        }
        posicionAleatoria = aleatorio.nextInt(2);
        
        if(posicionAleatoria == 0)
        {
            ySpeed = -ySpeed;
        }
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        erase();

        xPosition += xSpeed;
        yPosition += ySpeed;

        if(yPosition <= BoxBounce.MINIMA_Y || yPosition + diameter >= BoxBounce.MAXIMA_Y) 
        {
            ySpeed = -ySpeed; 
        }

        if(xPosition <= BoxBounce.MINIMA_X || xPosition + diameter >= BoxBounce.MAXIMA_X) 
        {
            xSpeed = -xSpeed; 
        }
        draw();   
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

