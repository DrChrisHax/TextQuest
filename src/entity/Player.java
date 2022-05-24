package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.KeyHandler;
import game.UTools;
import type.*;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	Type type;
	
	public final int screenX;
	public final int screenY;
	
	public int keyCount = 0;
	public int bossKeyCount = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		//type = new Warrior();
		
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		//Hitbox Size
		hitBox = new Rectangle(); //Base hitbox
		//Can be changed in the getPlayerImage method based on character type
		hitBox.x = 8;
		hitBox.y = 16;
		hitBoxDefaultX = hitBox.x;
		hitBoxDefaultY = hitBox.y;
		hitBox.width = 30;
		hitBox.height = 30;
		
		setDefaultValues();
		getPlayerImage(type); //Pass the type (character class) so the correct Sprite is used
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 2; //2 is default
		
		direction = "down";
	}
	public void getPlayerImage(Type type) {
		//Creates the correct sprite based on character type
		if(type != null && type.getType() == "Wizard") {

				up1 = setup("TextQuest_BlueWizard_Right");
				up2 = setup("TextQuest_BlueWizard_Right");
				down1 = setup("TextQuest_BlueWizard_Right");
				down2 = setup("TextQuest_BlueWizard_Right");
				left1 = setup("TextQuest_BlueWizard_Right");
				left2 = setup("TextQuest_BlueWizard_Right");
				right1 = setup("TextQuest_BlueWizard_Right");
				right2 = setup("TextQuest_BlueWizard_Right");
			
		}
		else if(type != null && type.getType() == "Warrior") {

				up1 = setup("TextQuest_GreenKnight_Right");
				up2 = setup("TextQuest_GreenKnight_Right");
				down1 = setup("TextQuest_GreenKnight_Right");
				down2 = setup("TextQuest_GreenKnight_Right");
				left1 = setup("TextQuest_GreenKnight_Right");
				left2 = setup("TextQuest_GreenKnight_Right");
				right1 = setup("TextQuest_GreenKnight_Right");
				right2 = setup("TextQuest_GreenKnight_Right");

		}
		else {
			
				up1 = setup("boy_up_1");
				up2 = setup("boy_up_2");
				down1 = setup("boy_down_1");
				down2 = setup("boy_down_2");
				left1 = setup("boy_left_1");
				left2 = setup("boy_left_2");
				right1 = setup("boy_right_1");
				right2 = setup("boy_right_2");
		}
		
	}
	public BufferedImage setup(String imageName) {
		
		UTools u = new UTools();
		BufferedImage scaledImage = null;
		
		try {
			scaledImage = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
			scaledImage = u.scaleImage(scaledImage, gp.tileSize, gp.tileSize);
			
		}
		catch(IOException e) { e.printStackTrace(); }
		
		return scaledImage;
	}
	public void update() {
		//IMPORTANT
		//Make sure to uncomment direction up and direction down
		//when added up and down sprites to the game
		
		if(keyH.upPressed == true || keyH.downPressed  == true || keyH.rightPressed  == true|| keyH.leftPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			if(keyH.downPressed == true) {
				direction = "down";
			}
			if(keyH.leftPressed == true) {
				direction = "left";
			}
			if(keyH.rightPressed == true) {
				direction = "right";
			}
			
			
			//Check Tile Collision
			collisionOn = false;
			gp.cc.checkTile(this);
			
			//Check Object Collision
			int objIndex = gp.cc.checkObject(this, true);
			objectInteraction(objIndex);
			
			
			//If Collision is false, Player can move
			if(collisionOn == false) {
				switch(direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
				}
			}
			
			
			spriteCounter++;
			if(spriteCounter > 24) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2){
					spriteNum = 1;
				}
				spriteCounter = 0;				
			}	
		}
		else {
			standCounter++;
			
			if(standCounter >= 40) {
				spriteNum = 1;
				standCounter = 0;
			}
		}
	}
	public void objectInteraction(int i) {
		
		if(i != -1) {
			
			String objectName = gp.obj[i].name;
			//Door takes Boss Key
			//Chest takes normal key
			//Later make Door key, Chest key, and Boss key
			switch(objectName){
				case "Key":
					gp.playSoundEffect(1);
					keyCount++;
					gp.obj[i] = null;
					gp.ui.showMessage("You got a key!");
					break;
				case "Door":
					if(keyCount > 0) {
						gp.obj[i] = null;
						keyCount--;
					}
					else { gp.ui.showMessage("The door is locked!"); }
					break;
				case "Potion":
					//gp.playSoundEffect(2);
					effect(gp.obj[i].getEffect());
					gp.obj[i] = null;
					
					break;
				case "Chest":
					gp.ui.gameFinished = true;
					gp.stopMusic();
					gp.playSoundEffect(2);
					gp.obj[i] = null;
					break;
				default:
					gp.obj[i] = null;
					//gp.ui.showMessage("Error");
					break;
			}
		}	
	}
	
	public void effect(String effect) {
		switch(effect) {
		case "FireRes":
			//FireRes
			break;
		case "Health":
			//Health
			break;
		case "Speed":
			speed += 1;
			gp.ui.showMessage("Speed increased!");
			break;
		default:
			break;
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
			image = up1;}
			if(spriteNum == 2) {
				image = up2;}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;}
				if(spriteNum == 2) {
					image = down2;}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;}
				if(spriteNum == 2) {
					image = left2;}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;}
				if(spriteNum == 2) {
					image = right2;}
			break;
		}
		g2.drawImage(image, screenX, screenY, null);
	}
	
	
	
	public void setType(Type type) {
		this.type = type;
	}
	public Type getType() {
		return type;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
