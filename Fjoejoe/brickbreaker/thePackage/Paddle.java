package thePackage;

import processing.core.PApplet;

/**
 * A paddle that draws itself and moves left and right
 * @author 60129
 *
 */
public class Paddle
{
	
	private float x, y;
	public static final int height = 20, width = 60;
	
	/**
	 * Creates a paddle
	 * @param xinit - the initial x-coordinate of the center of paddle
	 * @param yinit - the intiial y-coordinate of the center of the paddle
	 */
	public Paddle (float xinit, float yinit)
	{
		x = xinit;
		y = yinit;
	}
	
	/**
	 * Update the position of the paddle
	 * @param parent a reference to the paddle
	 */
	public void draw(PApplet parent)
	{
		parent.fill( parent.color(255, 0, 0) );
		parent.rect(x, y, width, height);
		parent.fill( parent.color(255) );
	}
	
	/**
	 * Pushes the paddle slightly to the left
	 */
	public void pushLeft()
	{
		this.x -=5;
	}
	
	/**
	 * Pushes the paddle slightly to the right
	 */
	public void pushRight()
	{
		this.x +=5;
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
