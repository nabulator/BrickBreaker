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
	public static final float RADIUS = 10;
	private float x, y;
	private float dx, dy;
	private Rectangle boundary;
	private Paddle paddle;
	private ArrayList<Brick> bricks;
	
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
		this.x = x + RADIUS;
		this.y = y + RADIUS;
		this.boundary = dimensions;
		this.paddle = paddle;
		this.bricks = bricks;
		
		dx = 3;
		dy = 4;
	}
	
	/**
	 * Repeatedly called in draw method to test if ball hits boundaries, wall or bricks
	 */
	public void hitTest()
	{
		if( x < boundary.x + RADIUS || x > boundary.x + boundary.width - RADIUS)
			dx *= -1;
		if( y < boundary.y + RADIUS || y > boundary.y + boundary.height - RADIUS)
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
	
	private void bricksHitTest()
	{
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
				x = rs - 1;
				bricks.remove(b);
			}
			else if( b.isOverlapping(ls,  y) )
			{
				dx *= -1;
				x = ls + 1;
				bricks.remove(b);
			}
			else if( b.isOverlapping(x, us) )
			{
				dy *= -1;
				y = us - 1;
				bricks.remove(b);
			}
			else if( b.isOverlapping(x, ds) )
			{
				dy *= -1;
				y = ds - 1;
				bricks.remove(b);
			}
				
		}
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
		parent.ellipse(x, y, RADIUS*2, RADIUS*2);
		x += dx;
		y += dy;
	}
	
}
