package thePackage;

import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * Controls the motion of the ball and handles collision
 * @author 60129
 *
 */
public class Ball extends Sprite
{
	/**
	 * Creates a ball
	 * @param parent PApplet parent
	 * @param bricks An array of bricks
	 * @param paddle a reference to the paddle
	 * @param wall a reference to the wall
	 * @param dimensions the size of the screen
	 */
	public Ball(PApplet parent, Brick[] bricks, Paddle paddle, Wall wall, Rectangle dimensions)
	{
		super(parent, 0.0f, 0.0f);
	}
	
	/**
	 * Repeatedly called in draw method to test if ball hits paddle, boundaires, wall or bricks
	 */
	public void hitTest()
	{
		
	}
	
	/**
	 * Causes the ball to bounce
	 * @param x x point of bounce
	 * @param y y point of bounce
	 */
	public void bounce(float x, float y)
	{
		
	}
	
	/**
	 * Draws the ball
	 */
	public void draw()
	{
		
	}
	
}
