package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;

public class OBJ_Potion extends SuperObject{
	GamePanel gp;
	String effect = "";
	String image_path;
	
	public OBJ_Potion(GamePanel gp) {
		this.gp = gp;
		image_path = "/Items/Potion/TextQuest_Potion_Old.png";
		name = "Potion";
		loadImage();
		
	}
	
	public OBJ_Potion(GamePanel gp, String effect) {
		
		this.gp = gp;
		name = "Potion";
		this.effect = effect;
		switch(effect) {
		case "FireRes":
			image_path = "/Items/Potion/TextQuest_Potion_FireRes_Old.png";
			break;
		case "Health":
			image_path = "/Items/Potion/TextQuest_Potion_Health_Old.png";
			break;
		case "Speed":
			image_path = "/Items/Potion/TextQuest_Potion_Speed_Old.png";
			break;
		default:
			image_path = "/Items/Potion/TextQuest_Potion_Old.png";
			break;
		}
		
		
		loadImage();
	}
	public void loadImage() {
		
		try {
			image = ImageIO.read(getClass().getResource(image_path));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
}



