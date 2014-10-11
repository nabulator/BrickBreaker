package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

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
	private int score;
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
		this.paddle = new Paddle(boundary);
		this.bricks = new ArrayList<Brick>();
		this.boundary = boundary;
		this.ball = new Ball(boundary.x, boundary.y, bricks, paddle, null, boundary);

		for(int i=0; i<10; i++)
			createBrick();
		
		score = 0;
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
		int xBrick = (int)(Math.random()*(boundary.width-32) + boundary.x);
		int yBrick = (int)(Math.random()*boundary.height* 0.8 + boundary.y);
		
		Brick b = new Brick(xBrick, yBrick);
		bricks.add(b);
	}
	
	/**
	 * draws the objects of player manager
	 */
	public void draw()
	{
		for( Brick b: bricks )
			b.draw(parent);
		
		if(bricks.size() < 10)
		{
			createBrick();
			score+= 50;
		}
		ball.draw(parent);
		paddle.draw(parent);
		
		//Draw score
		parent.fill( 255, 0, 255 );
		//PFont taho = new PApplet().loadFont("Tahoma.ttf");
		//parent.textFont(taho, 32);
		parent.text(score, (float) boundary.getCenterX(), 600);
		parent.fill( 255 );
	}
	
	
	public Paddle getPaddle()
	{
		return this.paddle;
	}
}
