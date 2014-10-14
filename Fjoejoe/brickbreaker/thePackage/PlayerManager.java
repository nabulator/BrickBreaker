package thePackage;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

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
	private Wall wall;
	private ArrayList<Brick> bricks;
	private Rectangle boundary;
	private int score;
	private int comboCount;
	private Timer comboTimer;
	private static boolean gameOver;
	private String playerType;

	/**
	 * Creates a player that takes input by either UI or AI
	 * @param parent the PApplet parent
	 * @param playerType the type of player
	 * @param playerSide which half of the screen player is on
	 */
	public PlayerManager(PApplet parent, String playerType, Rectangle boundary)
	{
		this.parent = parent;
		this.paddle = new Paddle(boundary);
		this.bricks = new ArrayList<Brick>();
		this.boundary = boundary;
		this.wall = new Wall(this.boundary);
		this.ball = new Ball(paddle.getX(), paddle.getY() - paddle.height, bricks, paddle, wall, boundary);
		
		ActionListener comboListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				comboTimeout();
			}
			
		};
		comboTimer = new Timer(1000, comboListener);
		
		for(int i=0; i<10; i++)
			createBrick();
		
		this.playerType = playerType;
		
		score = 0;
		comboCount = 0;
		gameOver = false;
		
	}
	
	protected void comboTimeout() {
		comboTimer.stop();
		wall.moveDown(1, bricks);
		comboCount = 0;
	}
	
	protected void comboIncrease() {
		if( comboTimer.isRunning() )
			comboTimer.restart();
		else
			comboTimer.start();
		
		comboCount++;
		
		
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
		int yBrick = (int)(Math.random()* (boundary.height - wall.getHeight() ) + boundary.y + wall.getHeight());
		
		Brick b = new Brick(xBrick, yBrick);
		bricks.add(b);
	}
	
	public void moveAI()
	{
		float yDif = paddle.getY() - ball.getY();
		float xDif = Math.abs(paddle.getX() - ball.getX());
		
		if( (ball.getY() < boundary.y + boundary.height) && 
				((yDif > 15 && yDif < 100) || xDif > 80) &&
				!(paddle.getX() < ball.getX() && paddle.getX() + Paddle.width > ball.getX()))
			
			if(paddle.getX() < ball.getX())
				paddle.pushRight();
			
			else if(paddle.getX() > ball.getX())
				paddle.pushLeft();
	}
	
	/**
	 * draws the objects of player manager
	 */
	public void draw()
	{
		for( Brick b: bricks )
			b.draw(parent);
		
		if(bricks.size() < 20)
		{
			createBrick();
			score += 50;
		}
		
		
		ball.draw(parent, this);

		if(playerType.equals("AI") && Math.random() > 0.5)
		{
			moveAI();
		}
		
		paddle.draw(parent);
		wall.draw(parent);
		
		if(gameOver)
		{
			parent.fill(0, 122);
			parent.rect(boundary.x, boundary.y, boundary.width, boundary.height);
		}
		
		//Draw score
		parent.fill( 255, 0, 255 );
		//PFont taho = new PApplet().loadFont("Tahoma.ttf");
		//parent.textFont(taho, 32);
		parent.textSize(50);
		parent.text(score, (float) boundary.getCenterX(), 600);
		parent.text(comboCount, boundary.x + 60, boundary.y + 60);
		parent.fill( 255 );

	}
	
	public void endGame()
	{
		gameOver = true;
		ball.stop();
	}
	
	public Paddle getPaddle()
	{
		return this.paddle;
	}
}
