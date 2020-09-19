package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Dot {
	private int x,y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x-1, y-1, 3, 3);
	}
}
