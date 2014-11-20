package demoscene;

import processing.core.PApplet;

public class Circle {
	
	public int x, y, radius;
	public double sx, sy; //scalar of sine functions
	public double bx, by; //period of sine functions
	public double ax, ay; //offset of sine functions
	
	public int t=0;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		
		sx = Math.random() * 10 - 5;
		sy = Math.random() * 10 - 5;
<<<<<<< HEAD
		bx = Math.random() * 10 - 5;
		by = Math.random() * 10 - 5 ;
		ax = Math.random() * 2 - 1;
		ay = Math.random() * 2 - 1;
	}
	
	public Circle(PApplet p)
	{
		this( 	(int)(Math.random() * p.width), 
				(int)(Math.random() * p.height),
				(int)(Math.random() * 5000) + 10 );
	}
	
	private int vx = (int) (Math.random() * 20-10);
	private int vy = (int) (Math.random() * 20-10 );
	
	public void move(PApplet p)
	{
		this.x += vx;
		this.y += vy;
		
		if( x > p.width || x < 0 )
			vx *= -1;
		if( y > p.height || y < 0 )
			vy *= -1;
		//System.out.println("newx: " + x + "\tNewy " + y);
	}
	
	public void move2()
	{
		this.x += (int)( sx * ( Math.sin(bx * t) + ax ) );
		this.y += (int)( sy * ( Math.sin(by * t) + ay ) );
		t++;
		System.out.println(x + " " + y);
=======
		bx = Math.random() * 0.1 - 0.05;
		by = Math.random() * 0.1 - 0.05;
		ax = Math.random() * 2 - 1;
		ay = Math.random() * 2 - 1;
	}
	
	public Circle(PApplet p)
	{
		this( 	(int)(Math.random() * p.width), 
				(int)(Math.random() * p.height),
				(int)(Math.random() * 2500) + 10 );
	}
	
	private int vx = (int) (Math.random() * 20-10);
	private int vy = (int) (Math.random() * 20-10 );
	
	public void move(PApplet p)
	{
		this.x += vx;
		this.y += vy;
		
		if( x > p.width || x < 0 )
			vx *= -1;
		if( y > p.height || y < 0 )
			vy *= -1;
		//System.out.println("newx: " + x + "\tNewy " + y);
	}
	
	public void move2()
	{
		this.x += (int)( sx * ( Math.sin(bx * t) + ax ) );
		this.y += (int)( sy * ( Math.sin(by * t) + ay ) );
		t++;		
		//System.out.println(x + " " + y);
>>>>>>> branch 'briansbr' of https://github.com/nabulator/BrickBreaker.git
	}

}
