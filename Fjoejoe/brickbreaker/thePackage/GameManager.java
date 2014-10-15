package thePackage;

import java.awt.Rectangle;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Initiates a game based on user input
 * @author 60129
 * 
 */
public class GameManager 
{
	private BrickBreaker parent;
	private Minim m;
	private PlayerManager p1, p2;
	private Rectangle p1Bounds, p2Bounds;
	private Clock timer;
	private Button resetBtn;
	private static boolean endGame;
	private static AudioPlayer themeSong;
	private boolean[] keysPressed;
	
	/**
	 * Creates a game manager based on the game mode
	 * @param parent the PApplet parent
	 * @param gameMode the type of game mode
	 */
	public GameManager(BrickBreaker parent, Minim m, String gameMode)
	{
		this.parent = parent;
		this.m = m;
		
		p1Bounds = new Rectangle(40, 40, 420, 600);
		p2Bounds = new Rectangle(500, 40, 420, 600);
		
		p1 = new PlayerManager(parent, this, m, "UI", p1Bounds, 2);
		p2 = new PlayerManager(parent, this, m, gameMode, p2Bounds, 1);
		timer = new Clock(parent, this);
		resetBtn = new Button(parent, 480-105, 600, "Menu");

		if(gameMode.equals("UI"))
			keysPressed = new boolean[4];
		else if(gameMode.equals("AI"))
			keysPressed = new boolean[2];
		for(int i = 0; i < keysPressed.length; i++)
			keysPressed[i] = false;
		
		endGame = false;
		
		themeSong = m.loadFile("StreetFighterKen.mp3");
		
	}

	/**
	 * Will tell the players if they won and their stats
	 * Will produce GUI to return player to main menu
	 */
	public void endGame()
	{
		endGame = true;
		p1.endGame();
		p2.endGame();
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
		
		timer.draw();
		
		if(endGame)
			resetBtn.draw();
		if( resetBtn.isPressed() )
			parent.switchMode(0);
			
	}
	
	/**
	 * checks if key is pressed
	 * @param keyCode the keyCode of keyPressed
	 */
	public void keyPressed(int keyCode)
	{
		switch(keyCode)
		{
			case 65: keysPressed[0] = true; break;
			case 68: keysPressed[1] = true; break;	
		}
		if(keysPressed.length == 4)
		{
			switch(keyCode)
			{
				case 37: keysPressed[2] = true; break;
				case 39: keysPressed[3] = true; break;
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
			case 65: keysPressed[0] = false; break;
			case 68: keysPressed[1] = false; break;	
		}
		if(keysPressed.length == 4)
		{
			switch(keyCode)
			{
				case 37: keysPressed[2] = false; break;
				case 39: keysPressed[3] = false; break;
			}
		}
	}
	
	public void startMusic()
	{
		themeSong.play();
	}
	
	public void exit()
	{
		m.stop();
		p1.exit();
		p2.exit();
	}
	
	public void mousePressed()
	{
		resetBtn.mousePressed();
	}
	
	public void mouseReleased()
	{
		resetBtn.mouseReleased();
	}
	
	/**
	 * Precondition: i must be 1 or 2 and nothing 
	 * @param i the player number
	 * @return a ref to wall
	 */
	public Wall getWall( int i )
	{
		if( i==1 )
			return p1.getWall();
		else if ( i==2 )
			return p2.getWall();
		else
			return null;
	}
	
}
