package thePackage;

import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * A paddle that draws itself and moves left and right
 * @author 60129
 *
 */
public class Paddle
{
	
	private float x, y;
	private float xVel; //x Velocity
	private float acceleration, friction;
	private Rectangle bounds;
	public static final int height = 20, width = 60;
	
	/**
	 * Creates a paddle
	 * @param xinit - the initial x-coordinate of the center of paddle
	 * @param yinit - the initial y-coordinate of the center of the paddle
	 */
	public Paddle (Rectangle bounds)
	{
		x = bounds.x + bounds.x/2;
		y = bounds.y + bounds.height - Paddle.height;
		this.bounds = bounds;
		
		xVel = 0;
		acceleration = 1.2f;
		friction = 0.9f;
	}
	
	/**
	 * Update the position of the paddle
	 * @param parent a reference to the paddle
	 */
	public void draw(PApplet parent)
	{
		parent.noStroke();
		parent.fill( 255, 0, 0 );
		parent.rect(x, y, width, height);
		parent.fill( parent.color(255) );
		
		this.x += xVel;
		
		if( Math.abs(xVel) > 0.05 )
			xVel *= friction;
		
		if( x < bounds.x )
		{
			xVel *= -1.2;
			x = bounds.x + 3;
		}
		else if (x + xVel > bounds.x + bounds.width- Paddle.width )
		{
			xVel *= -1.2;
			x = bounds.x + bounds.width - Paddle.width - 3;
		}
			

	}
	
	/**
	 * Pushes the paddle slightly to the left
	 */
	public void pushLeft()
	{
		if( Math.abs(xVel) < 5 )
			xVel -= acceleration;
	}
	
	/**
	 * Pushes the paddle slightly to the right
	 */
	public void pushRight()
	{
		if( Math.abs(xVel) < 5 )
			xVel += acceleration;
	}
	
	/**
	 * returns x coord
	 * @return x coord
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * returns the y coordinate 
	 * @return the y coordinate
	 */
	public float getY()
	{
		return y;
	}
}
