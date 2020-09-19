package main;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import ui.GUI;

public class Main extends JFrame{
	public static Bot bot;
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		bot = new Bot();
	}

}

