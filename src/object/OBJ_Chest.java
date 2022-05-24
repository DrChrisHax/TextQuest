package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;

public class OBJ_Chest extends SuperObject{
	
		GamePanel gp;
		
		public OBJ_Chest(GamePanel gp) {
			
			name = "Chest";
			try {
				image = ImageIO.read(getClass().getResource("/Items/TextQuest_Chest_Old.png"));
				image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			}catch(IOException e) {
				e.printStackTrace();
			}
			collision = true;
		}
		

}
