package thePackage;

import processing.core.PApplet;

/** 
 * Paddle controlled by an artificial intelligence
 * @author 60129
 *
 */
public class AIPaddle extends Paddle
{
	/**
	 * Creates an artificial-intelligent controlled paddle
	 * @param xinit - the initial x-coordinate of the center of paddle
	 * @param yinit - the initial y-coordinate of the center of the paddle1
	 */
	public AIPaddle(float x, float y) 
	{
		super( x, y );
	}
	
	/**
	 * Moves the paddle based on the position of the ball
	 * @param ball a reference to the ball
	 */
	public void move( Ball ball )
	{
		
	}
}
