package thePackage;

import processing.core.PApplet;

/**
 * Displays the user interface along with the game title. 
 * Plays game upon user's request and input
 * @author 60129
 *
 */
public class MainMenu
{
	private PApplet parent;
	private Button p1;
	/**
	 * Initializes the main menu
	 */
	public MainMenu(PApplet parent)
	{
		this.parent = parent;
		p1 = new Button(200, 400);
	}
	
	/**
	 * Draws the main menu
	 */
	public void draw()
	{
		parent.fill(255); //default color
		parent.textSize(32);
		parent.textAlign(parent.LEFT);
		parent.text("BrickBreaker", 100, 200);
		p1.draw(parent);
	}
	
	
}
