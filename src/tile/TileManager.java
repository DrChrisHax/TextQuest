package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.UTools;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	boolean collisionOn = true;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[7]; //Number of different Tiles
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldCol];
		
		getTileImage();
		loadMap("/maps/TestWorldMap.txt");
	}
	
	public void getTileImage() {
		

			setup(0, "Grass_Old",	 false);
			setup(1, "StoneWall_Old",true);
			setup(2, "Water_Old",	 true);
			setup(3, "Path_Old",	 false);
			setup(4, "Tree_Old",	 true);
			setup(5, "Sand_Old",	 false);
			setup(6, "Lava_Old",	 true);
	}
	public void setup(int index, String imageName, boolean collision) {
		UTools u = new UTools();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/TextQuest_" + imageName + ".png"));
			tile[index].image = u.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		}catch(IOException e) { e.printStackTrace(); }
	}

	public void loadMap(String textFile) {
		
		try {
			InputStream is = getClass().getResourceAsStream(textFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();	
		}
		catch(Exception e) {}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(		worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY 
					) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}	
	}

	public void collisionOff() {
		if(collisionOn == true) {
			for(int i = 0; i < tile.length; i++) {
				tile[i].collision = false;
			}
			collisionOn = false;
		}
		else {
			getTileImage(); //Reloads all collision tiles
			collisionOn = true;
		}
	}
	
	
	
}
