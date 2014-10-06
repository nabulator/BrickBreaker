package thePackage;

import java.awt.Rectangle;
import processing.core.PApplet;

/**
 * Draws a button and takes user input
 * @author 60129
 *
 */
public class Button
{
	private PApplet parent;
	private Rectangle bounds;
	
	/**
	 * Creates a button
	 * @param xinit - the initial x-coordinate of the center of button
	 * @param yinit - the initial y-coordinate of the center of the button
	 */
	public Button (int xinit, int yinit)
	{
		bounds = new Rectangle(xinit, yinit, 100, 40);
	}

	/**
	 * draws the button
	 * @param parent a reference to PApplet
	 */
	public void draw ()
	{
		//handles mouse hover and click
		if(isClicked())
		{
			
			parent.fill(200, 255, 255);
		}
			
		else
			parent.fill(255);
		
		parent.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		
		//text
		parent.fill(100);
		parent.textAlign(parent.CENTER);
		parent.text("asdf", bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	/**
	 * Checks if the mouseclick is over the button
	 * @return true if button successfully clicked
	 */
	public boolean isClicked ()
	{
		return parent.mouseX > bounds.x && parent.mouseX < bounds.x + bounds.width
				&& parent.mouseY > bounds.y && parent.mouseY < bounds.y + bounds.height;
	}
}
