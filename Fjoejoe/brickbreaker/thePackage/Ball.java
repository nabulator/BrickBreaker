package thePackage;

import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;

import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
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
	private Minim m;
	private Rectangle boundary;
	private Paddle paddle;
	private ArrayList<Brick> bricks;
	private Wall wall;
	private Timer respawnTimer;
	private static AudioSample fx1, fx2, fx3;
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
	public Ball(float x, float y, ArrayList<Brick> bricks, Paddle paddle, Wall wall, Rectangle dimensions, Minim m)
	{
		this.x = x;
		this.y = y;
		this.boundary = dimensions;
		this.paddle = paddle;
		this.bricks = bricks;
		this.wall = wall;
		this.m = m;
		
		dx = 9;
		dy = 12;
		
		ActionListener respawnListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serveBall();
			}
		};
		respawnTimer = new Timer(2000, respawnListener);
		isOver = false;
		serveBall();
		
		fx1 = m.loadSample("brickHit.wav");
		//fx2 = m.loadSample("bounce.wav");
		fx3 = m.loadSample("die.wav");
	}
	
	protected void serveBall() {
		//reset position
		x = paddle.getX() + Paddle.width/2;
		y = paddle.getY() - Paddle.height/2 - 1;
		dy = -7;
		dx = (int)(Math.random() * 10 - 5);
		respawnTimer.stop();
	}

	/**
	 * Repeatedly called in draw method to test if ball hits boundaries, wall or bricks
	 */
	private void hitTest(PlayerManager pm)
	{
		if( x < boundary.x + RADIUS || x > boundary.x + boundary.width - RADIUS )
			dx *= -1;

		if( y < boundary.y + RADIUS )
			dy *= -1;

			
		
		//wall
		if( y < wall.getBottom() + RADIUS )
		{
			y = wall.getBottom() + RADIUS + 1;
			dy *= -1;
		}
		
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
			y = paddle.getY() - Paddle.height/2 - 1;
			dy *= -1;
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
		
		
		fx1.trigger();
	}
	
	/**
	 * Freezes the ball's movement
	 */
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
		//draw bricks
		for( int i=bricks.size()-1; i>=0 ; i-- )
		{
			Brick b = bricks.get(i);
			b.draw(parent);
		}
		
		hitTest(pm);
		parent.fill(234, 32, 56);
		parent.noStroke();			
		
		if( !respawnTimer.isRunning() )
			parent.ellipse(x, y, RADIUS*2, RADIUS*2);
		
		if( !inBounds() )
		{
			respawnTimer.start();
			x = paddle.getX() + Paddle.width/2;
			y = paddle.getY() - Paddle.height/2 - 1;
			fx3.trigger();
		}
			
		
		if( ! isOver )
		{
			x += dx;
			y += dy;
		}
	}
	
	private boolean inBounds() 
	{
		return this.y - RADIUS < boundary.y + boundary.height;
	}
	
	/**
	 * Returns x position of ball
	 * @return x position of ball
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * Returns y position of ball
	 * @return y position of ball
	 */
	public float getY()
	{
		return y;
	}
	
}
