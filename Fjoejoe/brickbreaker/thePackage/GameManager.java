package thePackage;

import java.awt.Rectangle;
import java.util.HashMap;

import processing.core.PApplet;

/**
 * Initiates a game based on user input
 * @author 60129
 *
 */
public class GameManager 
{
	private PApplet parent;
	private PlayerManager p1, p2;
	private Rectangle p1Bounds, p2Bounds;
	
	/**
	 * Creates a game manager based on the game mode
	 * @param parent the PApplet parent
	 * @param gameMode the type of game mode
	 */
	public GameManager(PApplet parent, String gameMode)
	{
		this.parent = parent;
		
		p1Bounds = new Rectangle(10, 10, 400, 200);
		p2Bounds = new Rectangle(410, 10, 400, 200);
		
		p1 = new PlayerManager(parent, null, p1Bounds);
		p2 = new PlayerManager(parent, null, p2Bounds);
		
		initKeyMaps();
	}
	
	/**
	 * Maps the controls
	 */
	private void initKeyMaps() {
		
	}

	/**
	 * Will tell the players if they won and their stats
	 * Will produce GUI to return player to main menu
	 */
	public void endGame()
	{
		
	}
	
	
	
	/**
	 * Creates a button to return to main menu when game is over
	 */
	public void draw()
	{
		if( ) //TODO:	check boolean array
			p1.getPaddle().pushLeft();
		else if ( )
			p1.getPaddle().pushRight();

		
		parent.rect(p1Bounds.x, p1Bounds.y, p1Bounds.width, p1Bounds.height);
		parent.rect(p2Bounds.x, p2Bounds.y, p2Bounds.width, p2Bounds.height);
		
		p1.draw();
		p2.draw();
				
	}
	
	/**
	 * checks if key is pressed
	 * @param keyCode the keyCode of keyPressed
	 */
	public void keyPressed(int keyCode)
	{
		
	}
	
	/**
	 * checks if key is released
	 * @param keyCode
	 */
	public void Released(int keyCode)
	{
		
	}
	
}
