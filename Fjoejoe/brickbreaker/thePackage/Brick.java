package thePackage;

import java.awt.Color;
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
	public static Color[] palette = { new Color(0, 125, 255), 
									  new Color(125, 0, 255) };
	
	private int hp;
	
	/**
	 * Creates a brick
	 * @param xinit - the initial x-coordinate of the center of brick
	 * @param yinit - the initial y-coordinate of the center of brick
	 */
	public Brick(int xinit, int yinit)
	{
		rect = new Rectangle(xinit, yinit, 32, 20);
		hp = (int)(Math.random() * 2 + 1);
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
	 * Get hit points
	 * @return hit points
	 */
	public int getHP()
	{
		return hp; 
	}
	
	/**
	 * hit the brick 
	 */
	public void takeHit()
	{
		hp--;
	}
	
	/**
	 * Draws the brick
	 * @param parent PApplet parent
	 */
	public void draw(PApplet parent)
	{
		Color col = palette[hp-1];
		parent.fill( col.getRed(), col.getGreen(), col.getBlue() );
		parent.stroke(255);
		parent.rect(rect.x, rect.y, rect.width, rect.height);
	}
	
}
