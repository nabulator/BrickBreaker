package thePackage;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
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
	private GameManager gm;
	private Minim m;
	private Paddle paddle;
	private Ball ball;
	private Wall wall;
	private ArrayList<Brick> bricks;
	private Rectangle boundary;
	private int score;
	private int comboCount;
	private int secretId;
	private Timer comboTimer;
	private static boolean gameOver;
	private static AudioSample fxWall;
	private String playerType;

	/**
	 * Creates a player that takes input by either UI or AI
	 * @param parent the PApplet parent
	 * @param playerType the type of player
	 * @param playerSide which half of the screen player is on
	 */
	public PlayerManager(PApplet parent, GameManager gm, Minim m, String playerType, Rectangle boundary, int i)
	{
		this.parent = parent;
		this.gm = gm;
		this.m = m;
		this.paddle = new Paddle(boundary);
		this.bricks = new ArrayList<Brick>();
		this.boundary = boundary;
		this.secretId = i;
		this.wall = new Wall(this.boundary);
		this.ball = new Ball(paddle.getX(), paddle.getY() - paddle.height, bricks, paddle, wall, boundary, m);
		
		ActionListener comboListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				comboTimeout();
			}
			
		};
		comboTimer = new Timer(500, comboListener);
		fxWall = m.loadSample("wallMove.wav");
		
		for(int j=0; j<20; j++)
			createBrick();
		
		this.playerType = playerType;
		
		score = 0;
		comboCount = 0;
		gameOver = false;
		
	}
	
	protected void comboTimeout() {
		comboTimer.stop();
		if(comboCount >= 4)
		{
			gm.getWall(secretId).moveDown(this, comboCount/4, bricks);
			fxWall.trigger();
		}
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
		int yBrick = (int)(Math.random()* (boundary.height - wall.getHeight() - 80)  + boundary.y + wall.getHeight());
		
		Brick b = new Brick(xBrick, yBrick);
		bricks.add(b);
	}
	
	public void moveAI()
	{
		if(paddle.getY() - ball.getY() > 30 && paddle.getY() - ball.getY() < 200)
			if(paddle.getX() + (0.5 * Paddle.width) < ball.getX())
				paddle.pushRight();
			
			else if(paddle.getX() + (0.5 * Paddle.width) > ball.getX())
				paddle.pushLeft();
	}
	
	private double c = Math.random() * 255;
	/**
	 * draws the objects of player manager
	 */
	public void draw()
	{
		c = (c + 0.05f) % 255;
		parent.colorMode(parent.HSB);
		parent.fill( (int) c, 122, 202 );
		parent.rect(boundary.x, boundary.y, boundary.width, boundary.height);
		parent.colorMode(parent.RGB);
		//Draw score
		//PFont taho = new PApplet().loadFont("Tahoma.ttf");
		//parent.textFont(taho, 32);
		parent.fill( 255, 122.0f );
		parent.textSize(100);
		parent.text(score, (float) boundary.getCenterX(), 400);
		
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
			
			//TODO print winner or loser
		}
		
		parent.fill(0, 144, 244);
		parent.textSize(20);
		parent.text("Combo: " + comboCount, boundary.x + 100, boundary.y - 10);
		parent.fill( 255 );

	}
	
	public void exit()
	{
		m.stop();
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
	
	public Wall getWall()
	{
		return this.wall;
	}
}
