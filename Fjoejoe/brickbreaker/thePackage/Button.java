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
	private boolean mouseDown, isClicked;
	private String text;
	
	/**
	 * Creates a button
	 * @param parent - the parent
	 * @param xinit - the initial x-coordinate of the center of button
	 * @param yinit - the initial y-coordinate of the center of the button
	 * 
	 */
	public Button (PApplet parent, int xinit, int yinit, String text)
	{
		this.parent = parent;
		this.text = text;
		bounds = new Rectangle(xinit, yinit, 210, 36);
		mouseDown = false;
	}

	/**
	 * draws the button
	 * @param parent a reference to PApplet
	 */
	public void draw ()
	{
		//handles mouse hover and click
		if(mouseOver())
		{
			if( mouseDown )
				parent.fill(100, 255, 255);
			else
				parent.fill(200, 255, 255);
		}
			
		else
			parent.fill(255);
		
		parent.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		
		//text
		parent.fill(100);
		parent.textSize(16);
		parent.textAlign(parent.CENTER);
		parent.text(this.text, bounds.x + bounds.width/2, bounds.y + bounds.height/2 + 7);
		
		//graphics
		parent.stroke(100);
		parent.strokeWeight(3);
		parent.line(350, 60, 350, 580);
	}
	
	/**
	 * Checks if the mouse is over the button
	 * @return true if button mouse is over button
	 */
	private boolean mouseOver ()
	{
		return parent.mouseX > bounds.x && parent.mouseX < bounds.x + bounds.width
				&& parent.mouseY > bounds.y && parent.mouseY < bounds.y + bounds.height;
	}
	
	/**
	 * Tells button the mouse is pressed 
	 */
	public void mousePressed()
	{
		mouseDown = true;
	}
	
	/**
	 * tells button the mouse is released
	 */
	public void mouseReleased()
	{
		mouseDown = false;
		
		if( this.mouseOver() )
			isClicked = true;
	}
	
	/**
	 * Checks if button is pressed
	 * @return button
	 */
	public boolean isPressed()
	{
		if(isClicked)
		{
			isClicked = false;
			return true;
		}
		else
			return false;
	}
}
