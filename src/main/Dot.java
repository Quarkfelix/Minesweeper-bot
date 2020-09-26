package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Dot {
	private int x,y;
	private String kennung = "number";

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Dot(int x, int y, String kennung) {
		this.x = x;
		this.y = y;
		this.kennung = kennung;
	}
	
	
	public void paint(Graphics2D g) {
		
		switch (kennung) {
		case "number":
			g.setColor(Color.YELLOW);
			break;
		case "mine":
			g.setColor(Color.RED);
			break;
		default:
			g.setColor(Color.WHITE);
			break;
		}
		
		
		g.fillRect(x-2, y-2, 4, 4);
	}
}
