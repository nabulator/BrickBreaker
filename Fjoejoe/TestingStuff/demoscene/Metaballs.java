package demoscene;

import processing.core.PApplet;

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
