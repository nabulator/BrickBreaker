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
		//this.ellipse(23, 24, 14, 14);
		
		gm = new GameManager(this, null);
		mm = new MainMenu(this);
	}
	
	/**
	 * Updates the game
	 */
	public void draw()
	{
		clear();
		//gm.draw();
		this.fill(0);
		mm.draw();
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
