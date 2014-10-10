package thePackage;

import processing.core.PApplet;

public class BrickBreaker extends PApplet 
{
	private MainMenu mm;
	private GameManager gm;
	private int mode;
	
	/**
	 * Setup the game
	 */
	public void setup()
	{
		size(960, 680);
		mm = new MainMenu(this);
		mode = 0;
	}
	
	/**
	 * Updates the game
	 */
	public void draw()
	{
		clear();
		//this.fill(0);
		switch( mode )
		{
			case 0:
				mm.draw();
				break;
			case 1:
				gm.draw();
				break;
			case 2:
				gm.draw();
				break;
			default:
				//draw nothing
		}
		
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
	
	/**
	 * switches the mode
	 * 0 - main menu
	 * 1 - 1 player
	 * 2 - 2 player
	 * @param mode the desired mode
	 */
	public void switchMode(int mode)
	{
		this.mode = mode;
		
		//change the mode
		switch( mode )
		{
			case 0:
				mm = new MainMenu(this);
				break;
			case 1:
				gm = new GameManager(this, "AI");
				break;
			case 2:
				gm = new GameManager(this, "UI");
				break;
			default:
				throw new IllegalArgumentException("Invalid mode");
		}
	}

}
