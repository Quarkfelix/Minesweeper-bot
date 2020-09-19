package ui;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import main.Main;

public class Draw extends JPanel implements Runnable {
	private Thread t;
	private boolean running = true;
	private long time1 = 0;
	private long drawTime = 0;
	
//Constructor ----------------------------------------------------------------------------
	public Draw() {		
		t = new Thread(this);
		t.start();
	}
	
	
//run --------------------------------------------------------------------------------------
	@Override

	public void run() {
		while(running) {
			super.repaint();
		}
	}

//methods ---------------------------------------------------------------------------------
	@Override
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D)graphics;
		try {
			Main.bot.paint(g);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
