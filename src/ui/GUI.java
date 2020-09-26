package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI extends JFrame {
	private JFrame jf;
	private Draw draw;

//Constructor ------------------------------------------------------------------------------------------
	public GUI(){
		setupJFrame();
	}
//run --------------------------------------------------------------------------------------------------
	
//methods ----------------------------------------------------------------------------------------------
	private void setupJFrame() {		
		jf = new JFrame();
		draw = new Draw();
		jf.setSize(400, 430);
		jf.setLocation(-500,50);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(draw);
		jf.setVisible(true);
	}
	
	
//getter-setter ----------------------------------------------------------------------------------------
	
//paint ------------------------------------------------------------------------------------------------
	
}
