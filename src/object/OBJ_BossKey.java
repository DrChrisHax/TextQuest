package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;


public class OBJ_BossKey extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_BossKey(GamePanel gp) {
		
		name = "BossKey";
		try {
			image = ImageIO.read(getClass().getResource("/Items/TextQuest_BossKey_Old.png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
