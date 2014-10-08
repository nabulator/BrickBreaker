package thePackage;

import processing.core.PApplet;

public class BrickBreaker extends PApplet 
{
	private MainMenu mm;
	private GameManager gm;
	
	/**
	 * Setup the game
	 */
	public void setup()
	{
		size(960, 680);
		gm = new GameManager(this, "UI");
		mm = new MainMenu(this);
	}
	
	/**
	 * Updates the game
	 */
	public void draw()
	{
		clear();
		//this.fill(0);
		gm.draw();
		//mm.draw();
	}

	/**
	 * Checks the key
	 */
	public void keyPressed()
	{
		gm.keyPressed(this.keyCode);
		
	}
	
	/**
	 * Checks if the key is released
	 */
	public void keyReleased()
	{
		gm.keyReleased(this.keyCode);
	}
	
	/**
	 * Checks if the mouse has clicked on anything vaguely important
	 */
	public void mousePressed()
	{
		mm.mousePressed();
	}
	
	/**
	 * Checks if the mouse has
	 */
	public void mouseReleased()
	{
		mm.mouseReleased();
	}

}
