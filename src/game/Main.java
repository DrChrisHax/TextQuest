package game;

import javax.swing.JFrame;

import characters.*;
import dungeon.*;
import enemies.*;
import entity.*;
import object.*;
import races.*;
import skills.*;
import tile.*;
import type.*;



public class Main {


	
	public static void main(String[] args) {
		
		
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Text Quest");
		
		//Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\cmanl\\Desktop\\TextQuest Images\\TextQuest.png");
		//window.setIconImage(img);
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH); //Sets fullscreen
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame(); //Loads resources before running 
		gamePanel.startGameThread();
		

	}

}
	
	
