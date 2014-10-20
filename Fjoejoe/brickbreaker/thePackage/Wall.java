package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The wall is an extra boundary and moves down as the opponent increases their combo
 * @author 60129
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
		parent.fill(97, 54, 32);
		parent.rect(boundary.x, boundary.y, boundary.width, depth);	
	}
	
	/**
	 * Moves wall down and removes the bricks that are out of bound
	 * @param pm a reference to playermanager
	 * @param brickLayers the degree it moves down
	 * @param bricks the bricks
	 */
	public void moveDown( PlayerManager pm, int brickLayers, ArrayList<Brick> bricks )
	{
		if( depth < boundary.height - 80)
			depth += brickLayers * 10;
		
		for(int i=bricks.size()-1 ; i>=0 ; i--)
		{
			Brick b = bricks.get(i);
			if( b.rect.y <= getBottom() )
			{
				bricks.remove(i);
				pm.createBrick();
			}	
		}
	}
	
	/**
	 * Gets the bottom line of the wall	
	 * @return the location in y coordinate
	 */
	public int getBottom(){
		return boundary.y + depth;
	}
	
	public int getHeight(){
		return depth;
	}
}
