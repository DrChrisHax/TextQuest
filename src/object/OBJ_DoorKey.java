package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;


public class OBJ_DoorKey extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_DoorKey(GamePanel gp) {
		
		name = "DoorKey";
		try {
			image = ImageIO.read(getClass().getResource("/Items/TextQuest_BossKey_Old.png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
