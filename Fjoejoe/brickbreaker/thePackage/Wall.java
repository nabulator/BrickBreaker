package thePackage;

import java.awt.Rectangle;
import processing.core.PApplet;

/**
 * Draws the wall and controls the motion of the wall
 * @author 60129
 *
 */
public class Wall
{
	private Rectangle boundary;
	/**
	 * Creates a wall
	 */
	public Wall(Rectangle bounds)
	{
		this.boundary = bounds;
	}
	
	/**
	 * Draws the wall
	 * @param parent a reference to PApplet
	 */
	public void draw(PApplet parent)
	{
		parent.rect(boundary.x, boundary.y, 20, boundary.height);
	}
	
	/**
	 * Moves wall down
	 * @param brickLayers the degree it moves down
	 */
	public void moveDown( int brickLayers )
	{
		
	}
}
