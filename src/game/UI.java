package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
	
	GamePanel gp;
	Font arial_40, arial_80_B;
	
	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageTimer = 0;
	public boolean gameFinished = false;
	
	//DEBUG VARIABLES
	boolean debugOn = false;
	//Playtime

	double playTime = 0;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	String playTimeText;
	
	//FPS
	String FPSText = "FPS: 120";
	int FPS = 120;
	
	//Drawtime
	String drawTime;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80_B = new Font("Arial", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key(gp);
		keyImage = key.image;
	}
	
	public void showMessage(String message) {
		this.message = message;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		
		if(gameFinished == true) {
			
			String finishMessage;
			int finishMessageLength;
			int x, y;
			
			g2.setFont(arial_80_B);
			g2.setColor(Color.BLACK);
			finishMessage ="You Win!";
			finishMessageLength = (int)g2.getFontMetrics().getStringBounds(finishMessage, g2).getWidth();
			x = gp.screenWidth / 2 - finishMessageLength / 2;
			y = gp.screenHeight / 2 - (gp.tileSize * 3);
			g2.drawString(finishMessage, x, y);
			
			//System.out.println(playTime);
			
			gp.gameThread = null;
			
		}
		else {
			
			g2.setFont(arial_40);
			g2.setColor(Color.WHITE);
			g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + (gp.player.keyCount), 80, 60);
			
			//DEBUG
			//Game Time
			playTime += (double)1/120;
			if(debugOn) {
				playTimeText = "Game Time: " + dFormat.format(playTime);
				g2.drawString(playTimeText, gp.screenWidth - (int)g2.getFontMetrics().getStringBounds(playTimeText, g2).getWidth() , 120);
			
			//FPS
				g2.drawString("FPS: " + FPS, gp.screenWidth - (int)g2.getFontMetrics().getStringBounds(FPSText, g2).getWidth(), 60);
			
			//Draw Time
				drawTime = "Draw Time: " + (long)gp.getDrawTime()/100000 + "ms";
				g2.drawString(drawTime, gp.screenWidth - (int)g2.getFontMetrics().getStringBounds(drawTime, g2).getWidth(), 180);	
			}
			
			//Message
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);
				
				messageTimer++;
				
				if(messageTimer > 180) {
					messageTimer = 0;
					messageOn = false;
				}
			}			

		}
	}
	public void setFPS(int FPS) {
		this.FPS = FPS;
	}
}
