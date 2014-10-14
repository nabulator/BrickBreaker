package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Draws the wall and controls the motion of the wall
 * @author 60129
 *
 */
public class Wall
{
	private Rectangle boundary;
	private int depth;
	/**
	 * Creates a wall
	 */
	public Wall(Rectangle bounds)
	{
		this.boundary = bounds;
		
		depth = 20;
	}
	
	/**
	 * Draws the wall
	 * @param parent a reference to PApplet
	 */
	public void draw(PApplet parent)
	{
		parent.fill(23, 45, 34);
		parent.rect(boundary.x, boundary.y, boundary.width, depth);
	}
	
	/**
	 * Moves wall down
	 * @param brickLayers the degree it moves down
	 */
	public void moveDown( int brickLayers, ArrayList<Brick> bricks )
	{
		depth += brickLayers * 20;
		
		for(Brick b : bricks)
			b.rect.y += depth;
	}
	
	/**
	 * Gets the bottom line fo the wall	
	 * @return the location in y coordinate
	 */
	public int getBottom(){
		return boundary.y + depth;
	}
}
