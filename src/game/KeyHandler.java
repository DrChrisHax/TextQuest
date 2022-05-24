package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); //Returns number of key pressed 
		
		if(code == KeyEvent.VK_W){
			upPressed = true;
		}
		if(code == KeyEvent.VK_S){
			downPressed = true;
		}
		if(code == KeyEvent.VK_A){
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D){
			rightPressed = true;
		}
		//Cheats
		if(code == KeyEvent.VK_P) {
			gp.collisionOff();
		}
		if(code == KeyEvent.VK_T) {
			gp.player.worldX = gp.tileSize * 23;
			gp.player.worldY = gp.tileSize * 21;
			gp.player.spriteCounter = 1;
			gp.player.direction = "down";
		}
		if(code == KeyEvent.VK_O) {
			gp.backgroundMusic.stop();
		}
		if(code == KeyEvent.VK_UP) {
			gp.player.speed++;
		}
		if(code == KeyEvent.VK_DOWN) {
			gp.player.speed--;
		}
		if(code == KeyEvent.VK_F3) {
			if(gp.ui.debugOn) {
				gp.ui.debugOn = false;
			}
			else {
				gp.ui.debugOn = true;
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W){
			upPressed = false;
		}
		if(code == KeyEvent.VK_S){
			downPressed = false;
		}
		if(code == KeyEvent.VK_A){
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D){
			rightPressed = false;
		}
	}
}
