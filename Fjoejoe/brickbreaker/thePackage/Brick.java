package thePackage;

import java.awt.Rectangle;
import processing.core.PApplet;

/**
 * Displays a brick and disappears when hit
 * @author 60129
 *
 */
public class Brick
{
	public final Rectangle rect;
	
	/**
	 * Creates a brick
	 * @param xinit - the initial x-coordinate of the center of brick
	 * @param yinit - the initial y-coordinate of the center of brick
	 */
	public Brick(int xinit, int yinit)
	{
		rect = new Rectangle(xinit, yinit, 32, 20);
	}
	
	/**
	 * Causes damage to brick
	 * Brick may disappear if health is 0
	 * @oaram xP the hit point of x
	 * @param xP the hit point of y
	 */
	public boolean isOverlapping (float xP, float yP)
	{
		return rect.contains(xP, yP);
	}
	
	/**
	 * Draws the brick
	 * @param parent PApplet parent
	 */
	public void draw(PApplet parent)
	{
		parent.fill(0, 125, 255);
		parent.stroke(255);
		parent.rect(rect.x, rect.y, rect.width, rect.height);
	}
	
}
