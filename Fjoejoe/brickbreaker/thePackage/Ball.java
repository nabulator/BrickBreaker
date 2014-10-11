package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Controls the motion of the ball and handles collision
 * @author 60129
 *
 */
public class Ball
{
	public static final int RADIUS = 10;
	private int x, y;
	private int dx, dy;
	private Rectangle boundary;
	private Paddle paddle;
	private ArrayList<Brick> bricks;
	private int timer;
	
	/**
	 * Construct a ball
	 * @param x xinit
	 * @param y yinit
	 * @param bricks An array of bricks
	 * @param paddle a reference to the paddle
	 * @param wall a reference to the wall
	 * @param dimensions the size of the screen
	 */
	public Ball(int x, int y, ArrayList<Brick> bricks, Paddle paddle, Wall wall, Rectangle dimensions)
	{
		this.x = x + RADIUS;
		this.y = y + RADIUS;
		this.boundary = dimensions;
		this.paddle = paddle;
		this.bricks = bricks;
		timer = 0;
		dx = 3;
		dy = 5;
	}
	
	/**
	 * Repeatedly called in draw method to test if ball hits boundaries, wall or bricks
	 */
	public void hitTest()
	{
		if( x < boundary.x + RADIUS || x > boundary.x + boundary.width - RADIUS)
			dx *= -1;
		if( y < boundary.y + RADIUS )
			dy *= -1;
		
		paddleHitTest();
		bricksHitTest();
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
			y = (int) (paddle.getY() - Paddle.height/2.0 - 1);
			dx = (int) (10 * ( x - paddle.getX() - Paddle.width/2.0 ) / Paddle.width);
		}
		
		//ball collide on right
		/*if( Math.abs( x + Ball.RADIUS - paddle.getX() - Paddle.width/2 ) < RADIUS && y + Ball.RADIUS
		> paddle.getY() - Paddle.height/2)
		{
			dx *= -1;
			x -= dx;
		}*/
		
	}
	
	private void bricksHitTest()
	{
		//relative to ball
		float rs = this.x + RADIUS; //right side
		float ls = this.x - RADIUS; //left side
		float us = this.y - RADIUS; //Top side
		float ds = this.y + RADIUS; //bottom side
		
		
		
		for( int i=bricks.size()-1 ; i>=0; i-- )
		{
			Brick b = bricks.get(i);
			
			if( b.isOverlapping(rs, y)  )
			{
				dx *= -1;        
				hitDaBrick(b);
			}
			if( b.isOverlapping(ls,  y) )
			{	
				dx *= -1;
				hitDaBrick(b);
			}
			if( b.isOverlapping(x, us) )
			{
				dy *= -1;
				hitDaBrick(b);
			}
			if( b.isOverlapping(x, ds) )
			{
				dy *= -1;
				hitDaBrick(b);
			}
				
		}
	}

	private boolean inBounds()
	{
		return !(y > boundary.y + boundary.height);
	}
	
	private void hitDaBrick(Brick b)
	{
		b.takeHit();
		if( b.getHP() <= 0 )
			bricks.remove(b);

	}
	
	/**
	 * Draws the ball
	 * @param parent a reference to PApplet
	 */
	public void draw(PApplet parent)
	{
		hitTest();
		parent.fill(234, 32, 56);
		parent.noStroke();
		if(inBounds())
		{
			parent.ellipse(x, y, RADIUS*2, RADIUS*2);
			timer = 0;
		}
		else if(timer <= 10)
			timer++;
		else
		{
			x = paddle.getX();
			y = paddle.getY() - 10;
			dy = -4;
		}
		x += dx;
		y += dy;
	}
	
}
