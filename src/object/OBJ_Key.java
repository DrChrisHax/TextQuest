package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;

public class OBJ_Key extends SuperObject{
	
		GamePanel gp;
		
		public OBJ_Key(GamePanel gp) {
			
			name = "Key";
			try {
				image = ImageIO.read(getClass().getResource("/Items/TextQuest_Key_Old.png"));
				image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			}catch(IOException e) {
				e.printStackTrace();
			}
			collision = true;
		}
		

}
