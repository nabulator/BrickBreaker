package thePackage;

import processing.core.PApplet;
import ddf.minim.*;

public class BrickBreaker extends PApplet 
{
	//sound stuff
	private Minim m;
	
	private MainMenu mm;
	private GameManager gm;
	private int mode;
	
	/**f
	 * Setup the game
	 */
	public void setup()
	{
		size(960, 680);
		m = new Minim(this);
		mm = new MainMenu(this, m);
		gm = new GameManager(this, m, "UI");
		
		mode = 0;
		mm.startMusic();
		
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
	 * Exits the game
	 */
	public void exit()
	{
		m.stop();
		mm.exit();
		gm.exit();
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
		gm.mousePressed();
	}
	
	/**
	 * Checks if the mouse has
	 */
	public void mouseReleased()
	{
		mm.mouseReleased();
		gm.mouseReleased();
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
		this.clear();
		
		mm.exit();
		gm.exit();
		
		//change the mode
		switch( mode )
		{
			case 0:
				mm = new MainMenu(this, m);
				mm.startMusic();
				break;
			case 1:
				gm = new GameManager(this, m, "AI");
				gm.startMusic();
				break;
			case 2:
				gm = new GameManager(this, m, "UI");
				gm.startMusic();
				break;
			default:
				throw new IllegalArgumentException("Invalid mode");
		}
	}

}
