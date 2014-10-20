package thePackage;

import processing.core.PApplet;

/**
 * A wrapper class for circle
 * @author 167504
 *
 */
public class Circle {
	
	public int x, y;
	private int radius;
	
	/**
	 * Constructs a circle
	 * @param x center x-cor
	 * @param y center y-cor
	 * @param radius the radius in pixels
	 */
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**
	 * Draws the circle 
	 * @param parent the parent
	 */
	public void draw(PApplet parent)
	{
		parent.fill(0, 255, 45, 128);
		parent.ellipse(x, y, radius, radius);
	}

}
