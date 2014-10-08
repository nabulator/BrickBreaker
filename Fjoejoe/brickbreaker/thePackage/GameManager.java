package thePackage;

import java.awt.Rectangle;

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
	private boolean[] keysPressed;
	
	/**
	 * Creates a game manager based on the game mode
	 * @param parent the PApplet parent
	 * @param gameMode the type of game mode
	 */
	public GameManager(PApplet parent, String gameMode)
	{
		this.parent = parent;
		
		p1Bounds = new Rectangle(50, 30, 400, 450);
		p2Bounds = new Rectangle(500, 30, 400, 450);
		
		p1 = new PlayerManager(parent, "UI", p1Bounds);
		p2 = new PlayerManager(parent, gameMode, p2Bounds);
		
		if(gameMode.equals("UI"))
			keysPressed = new boolean[4];
		else if(gameMode.equals("AI"))
			keysPressed = new boolean[2];
		for(int i = 0; i < keysPressed.length; i++)
			keysPressed[i] = false;
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
		
			if(keysPressed[0])
				p1.getPaddle().pushLeft();
			else if (keysPressed[1])
				p1.getPaddle().pushRight();
			
			if(keysPressed.length == 4)
			{
				if(keysPressed[2])
					p2.getPaddle().pushLeft();
				else if(keysPressed[3])
					p2.getPaddle().pushRight();
			}
			
		
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
		switch(keyCode)
		{
			case 37: keysPressed[0] = true; break;
			case 39: keysPressed[1] = true; break;
		}
		if(keysPressed.length == 4)
		{
			switch(keyCode)
			{
				case 65: keysPressed[2] = true; break;
				case 68: keysPressed[3] = true; break;	
			}
		}
	}
	
	/**
	 * checks if key is released
	 * @param keyCode
	 */
	public void keyReleased(int keyCode)
	{
		switch(keyCode)
		{
			case 37: keysPressed[0] = false; break;
			case 39: keysPressed[1] = false; break;
		}
		if(keysPressed.length == 4)
		{
			switch(keyCode)
			{
				case 65: keysPressed[2] = false; break;
				case 68: keysPressed[3] = false; break;	
			}
		}
	}
	
}
