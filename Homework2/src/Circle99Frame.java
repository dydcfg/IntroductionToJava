import java.awt.*;
import javax.swing.*;

public class Circle99Frame extends JFrame
{
	
	public void paint(Graphics g)
	{
		g.drawString("circle 99", 20, 20);
		
		int x0 = getSize().width /2;
		int y0 = getSize().height /2;
		
		for( int r=0 ; r<getSize().height/2; r++ )
		{
			g.setColor( getRandomColor() );
			g.drawOval( x0,y0, r*2, r*2 );
			//try{ Thread.sleep(20); }catch(Exception ex){}
		} 
		//this.setTitle("aaa");
	}
	Color getRandomColor()
	{
		return new Color(
			(int)( Math.random() * 256 ),
			(int)( Math.random() * 256 ),
			(int)( Math.random() * 256 )
		);
	}
}	