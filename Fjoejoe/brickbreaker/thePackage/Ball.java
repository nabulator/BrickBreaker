package thePackage;

import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * Controls the motion of the ball and handles collision
 * @author 60129
 *
 */
public class Ball
{
	private float x, y;
	private float dx, dy;
	private Rectangle boundary;
	
	/**
	 * Construct a ball
	 * @param x xinit
	 * @param y yinit
	 * @param bricks An array of bricks
	 * @param paddle a reference to the paddle
	 * @param wall a reference to the wall
	 * @param dimensions the size of the screen
	 */
	public Ball(float x, float y, Brick[] bricks, Paddle paddle, Wall wall, Rectangle dimensions)
	{
		this.x = x;
		this.y = y;
		boundary = dimensions;
		dx = 3;
		dy = 2;
	}
	
	/**
	 * Repeatedly called in draw method to test if ball hits boundaries, wall or bricks
	 */
	public void hitTest()
	{
		
	}
	
	/**
	 * Checks if the ball hits the paddle
	 */
	public void paddleHitTest()
	{
		
	}
	
	/**
	 * Draws the ball
	 * @param parent a reference to PApplet
	 */
	public void draw(PApplet parent)
	{
		parent.ellipse(x, y, 20, 20);
		x += dx;
		y += dy;
		
		if(x < boundary.x || x > boundary.x + boundary.width)
			dx *= -1;
		if( y < boundary.y || y > boundary.y + boundary.height)
			dy *= -1;
	}
	
}
