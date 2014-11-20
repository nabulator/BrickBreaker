package demoscene;

import processing.core.PApplet;

<<<<<<< HEAD
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * MetaBall Effect .
 * @author 167504
 */
public class Metaballs {
	
	private PApplet p;
	private ArrayList<Circle> circles; 
	
	public Metaballs(PApplet parent)
	{
		p = parent;
		circles = new ArrayList<Circle>();
		
		for(int i=0 ; i<3 ; i++)
		{
			Circle z = new Circle(p);
			circles.add(z);
			System.out.println("X: " + z.x + "\tY: " + z.y + "\tradius: " + z.radius);
			
		}
	}
	
	public void draw()
	{
		for( int x=0 ; x < p.width ; x++ )
		{
			for( int y=0 ; y < p.height ; y++ )
			{
				double result = 0;
				for(Circle z : circles )
					result += z.radius / ( Math.pow(x-z.x, 2) + Math.pow(y-z.y, 2) );
				
				if( result > 0.95 && result < 1.05 )
					p.set(x, y, p.color( (int)(result*0xfffff) )) ;
					//p.set(x, y, p.color( (int)(result*255 % 255), 255, 255));
					//p.set(x, y, 255);
					
				//System.out.println("X: " + x + " Y: " + y + " Result: " + result);
			}
		}
		
		//for( Circle c : circles )
		//	c.move2();
		
		traceCircles();
		//System.out.println("draw");
=======
import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * MetaBall Effect .
 * @author 167504
 */
public class Metaballs {
	
	private PApplet p;
	private Circle[] circles; 
	
	public Metaballs(PApplet parent)
	{
		p = parent;
		circles = new Circle[4];
		
		for(int i=0 ; i<circles.length ; i++)
		{
			Circle z = new Circle(p);
			circles[i] = z;
			//System.out.println("X: " + z.x + "\tY: " + z.y + "\tradius: " + z.radius);
		}
	}
	
	private static int boxSize = 10;
	
	public void draw()
	{
		for( int xBox=0 ; xBox < p.width/boxSize ; xBox++ )
		{
			for( int yBox=0 ; yBox < p.height/boxSize ; yBox++ )
			{
				float sample = getResult(xBox * boxSize + boxSize/2, yBox * boxSize + boxSize/2);
				if( sample > 0.6f && sample < 2.35f )
				{
					for( int x=xBox * boxSize ; x < xBox * boxSize + boxSize ; x++ )
					{
						for( int y=yBox * boxSize ; y < yBox * boxSize + boxSize ; y++ )
						{
							float result = getResult(x, y);
							//System.out.println("X: " + x + " Y: " + y + " Result: " + result);
							
							if( result > 0.75f && result < 1.25f )
								//p.set(x, y, p.color( (int)(result*0xfffff) )) ;
								p.set(x, y, p.color( (int)(result*255 % 255), 255, 255));
								//p.set(x, y, 0xFFFFFF);
						}
					}
				}
				else
				{
					//p.fill( p.color(221, 23, 140) );
					//p.rect(xBox * boxSize, yBox * boxSize, boxSize, boxSize);
					//System.out.println("Xbox: " + xBox + " Ybox: " + yBox );
				}
			
			}
		}
		
		
		
		for( Circle c : circles )
			c.move(p);
		
		//traceCircles();
		//System.out.println("draw");
	}
	
	public float getResult(int x, int y)
	{
		float result = 0;
		for(Circle z : circles )
			result += z.radius / ( Math.pow(x-z.x, 2) + Math.pow(y-z.y, 2) );
		return result;
>>>>>>> branch 'briansbr' of https://github.com/nabulator/BrickBreaker.git
	}
	
	public void traceCircles()
	{
		for( Circle c : circles )
		{
			p.fill(255);
			p.ellipse(c.x, c.y, 10, 10);
			c.move(p);
		}
	}
	
}
