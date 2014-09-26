package thePackage;

import processing.core.PApplet;

/**
 * Keeps track of the number of points scored. Creates bricks in correct position 
 * and sets up environment
 * @author 60129
 *
 */
public class PlayerManager 
{
	private PApplet parent;
	private Paddle paddle;
	private Ball ball;
	private Brick[] bricks;
	
	/**
	 * Creates a player that takes input by either UI or AI
	 * @param parent the PApplet parent
	 * @param playerType the type of player
	 */
	public PlayerManager(PApplet parent, String playerType, int playerNum)
	{
		this.parent = parent;
		if(playerType.equals("AI"))
			paddle = new AIPaddle(playerNum * 25, playerNum * 25);
		else if(playerType.equals("UI"))
			paddle = new AIPaddle(playerNum * 25, playerNum * 25);
		
		
			
	}
	
	/**
	 * Returns a list of bricks in the game
	 * @return List of bricks
	 */
	public Brick[] getBricks()
	{
		return bricks;
	}
	
	/**
	 * Constructs a brick onto the game
	 */
	public void createBrick()
	{
		
		
	}
}
