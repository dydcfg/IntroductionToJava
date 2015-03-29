import java.awt.*;

import javax.swing.*;

import java.math.*;

public class FuMa extends JFrame{
	public int[]hist;
	public int maxHeight;
	public static void main(String[]argv)
	{	

		FuMa frame = new FuMa();
		frame.work(10000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 600, 600 );
		frame.setVisible(true);
	}
	
	public void work(int time){
		int []score = new int[100];
		int t,p;
		maxHeight = 0;
		hist = new int[100];
		for (int i=0;i<100;i++){
			hist[i] = 0;
		}
		for (int tc=0;tc<time;tc++){
			for (int k=0;k<100;k++){
				score[k] = k;
			}
			for (int k=0;k<100;k++){
				p = (int) Math.floor((Math.random()*100));
				if (p>99) p = 99;
				t = score[k];
				score[k] = score[p];
				score[p] = t;
			}
			for (int i=0;i<100;i++){
				t = -1;
				for (int j=0;j<i;j++){
					if (score[j]>t)
						t = score[j];
				}
				for (int j=i;j<100;j++){
					if (score[j]>t || (j==99 && t<0)){
						if (score[j]==99) hist[i]++;
						if (hist[i]>maxHeight) maxHeight = hist[i];
						break;
					}
				}
				
			}
			
		}
		return;
	}
	Color getRandomColor(int r)
	{
		return new Color(
			(int)(hist[r] * 255/maxHeight),
			(int)(0),
			(int)(0)
		);
	}
	
	public void paint(Graphics g)
	{
		g.drawString("circle 99", 20, 20);
		
		int x0 = getSize().width/100;
		int y0 = getSize().height/2;
		
		for( int r=0 ; r<100; r++ )
		{
			g.setColor( getRandomColor(r) );
			g.fillRect(r*x0, getSize().height-hist[r]*y0/maxHeight , x0, hist[r]*y0/maxHeight);
			//try{ Thread.sleep(20); }catch(Exception ex){}
		} 
		//this.setTitle("aaa");
	}
	
	
}
