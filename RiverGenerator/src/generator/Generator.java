package generator;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.Random;

public class Generator extends JFrame{
	public static int HEIGHT = 960;
	public static int WIDTH = 960;
	public static final int ORIGIN_X = 8;
	//public static final int ORIGIN_Y = 31;
	public static final int ORIGIN_Y = 25;
	private int riverLength;
	private int riverWidth;
	private int riverAngle;
	
	public Generator(int riverLength, int riverWidth, int riverAngle) {
		this.riverLength = riverLength;
		this.riverWidth = riverWidth;
		this.riverAngle = riverAngle;
		setTitle("RiverGenerator");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		
		super.paintComponents(g);
		
		Random rand = new Random();
		int startValue = 400;
		int startValueX = ORIGIN_X + startValue;
		int startValueY = ORIGIN_Y;

		int minY = 1;
		int maxY = 30;
		int minX = -5;
		int maxX = 5;
		
		int currentLength = 0;

		int valueX = startValueX;
		int valueX2 = startValueX + rand.nextInt((maxX - minX) + 1) + minX;
		int valueY = startValueY;
		int valueY2 = startValueY + rand.nextInt((maxY - minY) + 1) + minY;
		
		//g.drawLine(8, ORIGIN_Y, 8, newLineY);
		g.drawLine(valueX, valueY, valueX2, valueY2);
		
		while(currentLength <= this.riverLength) {		
			valueX = valueX2;
			valueY = valueY2;
			
			valueX2 += rand.nextInt((maxX - minX) + 1) + minX;
			valueY2 += rand.nextInt((maxY - minY) + 1) + minY;
			
			g.drawLine(valueX, valueY, valueX2, valueY2);
			
			currentLength += valueY2;
		}
		 
		int newStartValueY = startValueY - 16;
		currentLength = 0;
		
		valueX = startValueX + this.riverWidth;
		valueX2 = startValueX + rand.nextInt((maxX - minX) + 1) + minX + this.riverWidth;
		valueY = newStartValueY;
		valueY2 = newStartValueY + rand.nextInt((maxY - minY) + 1) + minY;
		
		while(currentLength <= this.riverLength) {		
			valueX = valueX2;
			valueY = valueY2;
			
			valueX2 += rand.nextInt((maxX - minX) + 1) + minX;
			valueY2 += rand.nextInt((maxY - minY) + 1) + minY;
			
			g.drawLine(valueX, valueY, valueX2, valueY2);
			
			currentLength += valueY2;
		}
	}
}
