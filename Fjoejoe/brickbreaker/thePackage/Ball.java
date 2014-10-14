package thePackage;

import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;
import processing.core.PApplet;

/**
 * Controls the motion of the ball and handles collision
 * @author 60129
 *
 */
public class Ball
{
	public static final float RADIUS = 10;
	private float x, y;
	private float dx, dy;
	private Rectangle boundary;
	private Paddle paddle;
	private ArrayList<Brick> bricks;
	private Wall wall;
	private Timer respawnTimer;
	private static boolean isOver;

	
	/**
	 * Construct a ball
	 * @param x xinit
	 * @param y yinit
	 * @param bricks An array of bricks
	 * @param paddle a reference to the paddle
	 * @param wall a reference to the wall
	 * @param dimensions the size of the screen
	 */
	public Ball(float x, float y, ArrayList<Brick> bricks, Paddle paddle, Wall wall, Rectangle dimensions)
	{
		this.x = x;
		this.y = y;
		this.boundary = dimensions;
		this.paddle = paddle;
		this.bricks = bricks;
		this.wall = wall;
		
		dx = 5;
		dy = 6;
		
		ActionListener respawnListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serveBall();
			}
		};
		respawnTimer = new Timer(2000, respawnListener);
		isOver = false;
		serveBall();
	}
	
	protected void serveBall() {
		//reset position
		x = (int) paddle.getX();
		y = (int) (paddle.getY() - 10);
		dy = -4;
		dx = (int)(Math.random() * 4 - 2);
		respawnTimer.stop();
	}

	/**
	 * Repeatedly called in draw method to test if ball hits boundaries, wall or bricks
	 */
	private void hitTest(PlayerManager pm)
	{
		if( x < boundary.x + RADIUS || x > boundary.x + boundary.width - RADIUS)
			dx *= -1;
		if( y < boundary.y + RADIUS || y < wall.getBottom() + RADIUS)
			dy *= -1;
		
		paddleHitTest();
		bricksHitTest(pm);
	}
	
	/**
	 * Checks if the ball hits the paddle
	 */
	private void paddleHitTest()
	{	
		//vertical collision
		if( x >= paddle.getX() && x <= paddle.getX() + Paddle.width
				&& y > paddle.getY() - Ball.RADIUS && y < paddle.getY() + Ball.RADIUS + Paddle.height)
		{
			dy *= -1;
			y = paddle.getY() - Paddle.height/2 - 1;
			dx = 10 * ( x - paddle.getX() - Paddle.width/2 ) / Paddle.width;
		}
		
		//ball collide on right
		/*if( Math.abs( x + Ball.RADIUS - paddle.getX() - Paddle.width/2 ) < RADIUS && y + Ball.RADIUS
		> paddle.getY() - Paddle.height/2)
		{
			dx *= -1;
			x -= dx;
		}*/
		
	}
	
	private void bricksHitTest(PlayerManager pm)
	{
		//relative to ball
		float rs = this.x + RADIUS; //right side
		float ls = this.x - RADIUS; //left side
		float us = this.y + RADIUS; //Top side
		float ds = this.y - RADIUS; //bottom side
		
		for( int i=bricks.size()-1 ; i>=0; i-- )
		{
			Brick b = bricks.get(i);
			
			if( b.isOverlapping(rs, y)  )
			{
				dx *= -1;
				hitDaBrick(b);
				pm.comboIncrease();
			}
			else if( b.isOverlapping(ls,  y) )
			{
				dx *= -1;
				hitDaBrick(b);
				pm.comboIncrease();
			}
			else if( b.isOverlapping(x, us) )
			{
				dy *= -1;
				hitDaBrick(b);
				pm.comboIncrease();
			}
			else if( b.isOverlapping(x, ds) ) //works
			{
				dy *= -1;
				hitDaBrick(b);
				pm.comboIncrease();
			}
				
		}
	}
	
	private void hitDaBrick(Brick b)
	{
		b.takeHit();
		if( b.getHP() <= 0 )
			bricks.remove(b);
	}
	
	public void stop()
	{	
		isOver = true;
	}
	
	/**
	 * Draws the ball
	 * @param parent a reference to PApplet
	 * @param pm the playerManger
	 */
	public void draw(PApplet parent, PlayerManager pm)
	{
		hitTest(pm);
		parent.fill(234, 32, 56);
		parent.noStroke();
		
		if( !respawnTimer.isRunning() )
			parent.ellipse(x, y, RADIUS*2, RADIUS*2);
		
		if( !inBounds() )
			respawnTimer.start();
		
		if( ! isOver )
		{
			x += dx;
			y += dy;
		}
	}

	private boolean inBounds() {
		return this.y - RADIUS < boundary.y + boundary.height;
	}
	
}
