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
	 * @param parent PApplet parent
	 * @param ball the location of the ball
	 */
	public AIPaddle(PApplet parent, Ball ball) 
	{
		super(parent);
	}
}
