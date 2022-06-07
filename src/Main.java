// Hang Pham - P3

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT= 700; 
	
	
	public Main(){
		super("Pong");
		setSize(WIDTH,HEIGHT); 
		Game play = new Game(); 
		
		((Component)play).setFocusable(true);
		setBackground(Color.BLACK);
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		
		
	
	public static void main(String[] args) {
		
		Main run = new Main(); 
		
	}

	
	
	
}
