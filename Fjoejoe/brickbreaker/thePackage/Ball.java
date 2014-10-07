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
		boundary = dimensions;
		this.paddle = paddle;
		dx = 3;
		dy = 2;
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
		
		/*
		//left paddle collision
		if( x + RADIUS == paddle.getX() && 
				y > paddle.getY() && y < paddle.getY() + Paddle.height)
			dx *= -1;
		//right paddle collision
		if( x - RADIUS == paddle.getX() + Paddle.width && 
				y > paddle.getY() && y < paddle.getY() + Paddle.height)
			dx *= -1;
		*/
		
		//vertical collision
		if( x >= paddle.getX() && x <= paddle.getX() + Paddle.width
				&& y > paddle.getY() - RADIUS && y < paddle.getY() + RADIUS + Paddle.height)
		{
			dy *= -1;
			dx = 10 * ( x - paddle.getX() - Paddle.width/2 ) / Paddle.width;
		}
		

	}
	
	/**
	 * Checks if the ball hits the paddle
	 */
	public void paddleHitTest()
	{
		
	}
	
	/**
	 * Draws the ball
	 * @param parent a reference to PApplet
	 */
	public void draw(PApplet parent)
	{
		hitTest();
		parent.ellipse(x, y, RADIUS*2, RADIUS*2);
		x += dx;
		y += dy;
	}
	
}
