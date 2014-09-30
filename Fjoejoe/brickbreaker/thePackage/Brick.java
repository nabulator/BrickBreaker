package thePackage;

import processing.core.PApplet;

/**
 * Displays a brick and disappears when hit
 * @author 60129
 *
 */
public class Brick
{
	private float x, y;
	
	/**
	 * Creates a brick
	 * @param xinit - the initial x-coordinate of the center of brick
	 * @param yinit - the initial y-coordinate of the center of brick
	 */
	public Brick(float xinit, float yinit)
	{
		this.x = xinit;
		this.y = yinit;
	}
	
	/**
	 * Causes damage to brick
	 * Brick may disappear if health is 0
	 */
	public void isHit()
	{
		
	}
	
	/**
	 * Draws the brick
	 * @param parent PApplet parent
	 */
	public void draw(PApplet parent)
	{
		parent.rect(x, y, 25, 15);
	}
	
}
