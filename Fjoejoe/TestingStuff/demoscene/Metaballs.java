package demoscene;

import processing.core.PApplet;

import java.awt.geom.*;
import java.util.ArrayList;

/**
 * MetaBall Effect
 * @author 167504
 *
 */
public class Metaballs {
	
	private PApplet p;
	private ArrayList<Circle> circles; 
	public static double R = 3;
	
	public Metaballs(PApplet parent)
	{
		p = parent;
		circles = new ArrayList<Circle>();
		
		for(int i=0 ; i<4 ; i++)
		{
			Circle z = new Circle(p);
			circles.add(z);
			System.out.println("X: " + z.x + " Y: " + z.y);
		}
	}
	
	public void draw()
	{
		//p.loadPixels();
		for( int x=0 ; x < p.width ; x++ )
		{
			for( int y=0 ; y < p.height ; y++ )
			{
				double result = 0;
				for(Circle z : circles )
				{
					result = z.radius / Math.sqrt( Math.pow(x-z.x, 2) + Math.pow(y-z.y, 2) );
				}
				
				//if( result > 0.9 && result < 1.1 )
					p.set(x, y, (int)(result * 0xFFFFFF) );
				//System.out.println("X: " + x + " Y: " + y + " Result: " + result);
			}
		}
		//p.updatePixels();
	}
	
}
