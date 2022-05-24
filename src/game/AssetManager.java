package game;

import object.*;

public class AssetManager {
	
	GamePanel gp;
	
	public AssetManager(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new SuperObject();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 21 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(gp);
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 7 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key(gp);
		gp.obj[2].worldX = 23 * gp.tileSize;
		gp.obj[2].worldY = 40 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Key(gp);
		gp.obj[3].worldX = 38 * gp.tileSize;
		gp.obj[3].worldY = 9 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door(gp);
		gp.obj[4].worldX = 10 * gp.tileSize;
		gp.obj[4].worldY = 11 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door(gp);
		gp.obj[5].worldX = 10 * gp.tileSize;
		gp.obj[5].worldY = 15 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Door(gp);
		gp.obj[6].worldX = 8 * gp.tileSize;
		gp.obj[6].worldY = 26 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Chest(gp);
		gp.obj[7].worldX = 10 * gp.tileSize;
		gp.obj[7].worldY = 7 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Potion(gp, "Speed");
		gp.obj[8].worldX = 35 * gp.tileSize;
		gp.obj[8].worldY = 40 * gp.tileSize;

		
	}

}