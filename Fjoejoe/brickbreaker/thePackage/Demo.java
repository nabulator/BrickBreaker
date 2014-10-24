package thePackage;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * This class has no functional purpose. 
 * Displays a cool sidescrolling game. 
 * @author 167504
 */
public class Demo {
	
	private ArrayList<Circle> circs = new ArrayList<Circle>();
	private Rectangle bounds;
	private int count, radius;
	
	private int letterCnt;
	public final static String txt = "       Brickbreaker! A Game made by FJoe & Bran :)   Greetz to Matt Stave David Ryab Lucy Depty Hady Cheru Ishan Anish Anurag David Arthur Richard & everyone else! - coding in the morning is hard     ";
	
	public Demo(Rectangle b)
	{
		bounds = b;
		
		count = 30;
		radius = 100;
		letterCnt = 0;
		
		for(int i=0; i<count; i++)
			circs.add( new Circle(bounds.x + bounds.width/2, bounds.y + bounds.height/2, 20) );
		//circs.add( new Circle( (int)(radius * Math.sin(i * Math.PI * 2 /count)) + bounds.x, (int)(radius * Math.cos(i * Math.PI * 2 / count)) + bounds.y, 20) );
	}
	
	//These variables control independent sin() offsets.
	private static int q = 0;
	private static int t = 0;
	private static int space = 50;
	
	public void draw(PApplet parent)
	{
		parent.colorMode(parent.HSB);
		parent.fill( (int)(255 * Math.sin(t/903.0)), 50, 255);
		parent.noStroke();
		parent.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		parent.colorMode(parent.RGB);
		
		/*for(int i=0; i<count; i++)
		{
			Circle c = circs.get(i);
			c.draw(parent);
			c.x += 2 * Math.sin(q / 10.0 );
			c.y += 2 * Math.cos(q / 10.0 );
		}*/
		
		for( int i=letterCnt ; i < letterCnt+10 ; i++ )
		{
			
			double offset = 10 * Math.sin(i);
			double offset2 = 15 * Math.sin(i/5.0*4.0);
			double offset3 = 64 * Math.sin(t /120.0 + i);
			
			parent.textSize( (int)(46 + offset) );
			parent.fill(0);
						
			if( i < txt.length() )
				parent.text(txt.charAt(i), bounds.x + (i+1) * space - q, (int)(bounds.y + bounds.height/2 + offset + offset3) );
		}
		
		q += 2;
		t++;
		
		if( q % space == 0)
			if( letterCnt < txt.length())
				letterCnt++;
			else
			{
				letterCnt=0;
				q = 0;
			}
		
		parent.stroke(0);
	}
}
