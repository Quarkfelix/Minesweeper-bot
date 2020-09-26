package main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

//https://minesweeper.online/game/425466669

public class Bot {
	private BufferedImage screenshot;
	private Robot robot;
	
	private ArrayList<Dot> dots = new ArrayList<>();
	private int[][] field = new int[16][16];

	private Color one = new Color(0, 0, 255);
	private Color two = new Color(0, 128, 0);
	private Color three = new Color(255, 0, 0);
	private Color four = new Color(0, 0, 128);
	private Color mine = new Color(189, 191, 191);

	public Bot() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		takeScreenshot();
		markAllNumbers();
	}

	//the middle pixel in every field gets converted into an number in an array
	private void markAllNumbers() {
		for (int y = 12; y < 390; y += 24) {
			for (int x = 12; x < 390; x += 24) {
				field[(x-12)/24][(y-12)/24] = 0;
				Color pixelcolor = new Color(screenshot.getRGB(x, y));
				if (pixelcolor.getBlue() == one.getBlue()) {
					dots.add(new Dot(x, y));
					field[(x-12)/24][(y-12)/24] = 1;
				} 
				if (pixelcolor.getGreen() == two.getGreen()) {
					if (pixelcolor.getBlue() == two.getBlue()) {
						if (pixelcolor.getRed() == two.getRed()) {
							dots.add(new Dot(x, y));
							field[(x-12)/24][(y-12)/24] = 2;
						}
					}
				} 
				if (pixelcolor.getRed() == three.getRed()) {
					dots.add(new Dot(x, y));
					field[(x-12)/24][(y-12)/24] = 3;
				}
				if (pixelcolor.getGreen() == four.getGreen()) {
					if (pixelcolor.getBlue() == four.getBlue()) {
						if (pixelcolor.getRed() == four.getRed()) {
							dots.add(new Dot(x, y));
							field[(x-12)/24][(y-12)/24] = 4;
						}
					}
				}
				if (pixelcolor.getGreen() == mine.getGreen()) {
					if (pixelcolor.getBlue() == mine.getBlue()) {
						if (pixelcolor.getRed() == mine.getRed()) {
							dots.add(new Dot(x, y, "mine"));
							field[(x-12)/24][(y-12)/24] = 8;
						}
					}
				}
			}
		}
		
		
		//array ausgeben
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				System.out.print(field[j][i] + " | ");
			}
			System.out.println();
		}
		
	}

	public void takeScreenshot() {
		screenshot = robot.createScreenCapture(new Rectangle(-1160, 290, 390, 390));
	}

	public void paint(Graphics2D g) {
		g.drawImage(screenshot, 0, 0, null);
		for (Dot dot : dots) {
			dot.paint(g);
		}
	}
}
