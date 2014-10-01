package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

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
	private ArrayList<Brick> bricks;
	private Rectangle boundary;
	
	/**
	 * Creates a player that takes input by either UI or AI
	 * @param parent the PApplet parent
	 * @param playerType the type of player
	 * @param playerSide which half of the screen player is on
	 */
	public PlayerManager(PApplet parent, String playerType, Rectangle boundary)
	{
		this.parent = parent;
		/*if(playerType.equals("AI"))
			paddle = new AIPaddle(playerNum * 25, playerNum * 25);
		else if(playerType.equals("UI"))
			paddle = new AIPaddle(playerNum * 25, playerNum * 25);
		*/
		//temp for paddle init
		this.paddle = new UIPaddle(boundary.x + boundary.x/2 , boundary.y + boundary.height - Paddle.height);
		
		this.boundary = boundary;
		this.ball = new Ball(boundary.x, boundary.y, null, null, null, boundary);
		
		bricks = new ArrayList<Brick>();
		for(int i=0; i<10; i++)
			bricks.add( new Brick((float)(Math.random()*boundary.width + boundary.x), (float)(Math.random()*boundary.height + boundary.y)));
		
	}
	
	/**
	 * Returns a list of bricks in the game
	 * @return List of bricks
	 */
	public ArrayList<Brick> getBricks()
	{
		return bricks;
	}
	
	/**
	 * Constructs a brick onto the game
	 */
	public void createBrick()
	{
		
		
	}
	
	/**
	 * draws the objects of player manager
	 */
	public void draw()
	{
		
		for( Brick b: bricks )
			b.draw(parent);
		
		ball.draw(parent);
		paddle.draw(parent);
	}
	
	public Paddle getPaddle()
	{
		return this.paddle;
	}
}
