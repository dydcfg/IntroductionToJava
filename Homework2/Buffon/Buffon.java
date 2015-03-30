/*
 * Author: Nettle
 */

 
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Buffon extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new Buffon();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 600, 600 );
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(0, 0, 600, 600);
		
		int a = 30;
		// draw line
		g.setColor(Color.BLACK);
		for (int i = 1; i <= 20; ++i)
			g.drawLine(0, (int) (i * a), getSize().width, (int) (i * a));
			
		// dropNeedle
		double tot = 0, cover = 0;
		g.setColor(Color.RED);
		while (true) {
			boolean isCover = true;
			double x = Math.random() * getSize().height, y = Math.random() * getSize().width;
			double theta = Math.random() * 180;
			int x1 = (int) (x + a / 4 * Math.sin(theta)), x2 = (int) (x - a / 4 * Math.sin(theta));
			if (x1 / ((int) a) == x2 / ((int) a)) isCover = false;
			g.drawLine((int) (y + a / 4 * Math.cos(theta)), x1, (int) (y - a / 4 * Math.cos(theta)), x2);
			if (isCover) cover += 1;
			tot += 1;
			System.out.println("PI = " + (tot / cover));
			try{ Thread.sleep(50); }catch(Exception ex){}
		}
	}
}