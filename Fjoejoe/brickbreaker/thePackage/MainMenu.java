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
	private BrickBreaker parent;
	private Button p1, p2;
	
	/**
	 * Initializes the main menu
	 */
	public MainMenu (BrickBreaker parent)
	{
		this.parent = parent;
		p1 = new Button(parent, 65, 450, "1 Player");
		p2 = new Button(parent, 65, 500, "2 Player");
	}
	
	/**
	 * Draws the main menu
	 */
	public void draw()
	{
		parent.fill(255); //default color
		parent.textSize(36);
		parent.textAlign(parent.CENTER);
		parent.text("BrickBreaker", 170, 110);
		p1.draw();
		p2.draw();
		
		if( p1.isPressed() )
			parent.switchMode(1);
		
		if( p2.isPressed() )
			parent.switchMode(2);
		
	}
	
	public void mousePressed()
	{
		p1.mousePressed();
		p2.mousePressed();
	}
	
	public void mouseReleased()
	{
		p1.mouseReleased();
		p2.mouseReleased();
	}
	
}
