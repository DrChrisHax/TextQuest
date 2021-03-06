package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;

public class OBJ_Door extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_Door(GamePanel gp) {
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResource("/Items/TextQuest_Door_Old.png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}