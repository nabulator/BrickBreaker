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
	}
	
	/**
	 * Updates the game
	 */
	public void draw()
	{
		clear();
		gm.draw();
	}

	/**
	 * Checks the key
	 */
	public void keyPressed()
	{
		if( this.key == this.CODED )
		{
			if(this.keyCode == this.RIGHT)
			{
				
			}
			else if (this.keyCode == this.LEFT)
			{
				
			}
		}
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
	public void mouseClicked()
	{
		
	}

}
