package game;

import entity.Entity;

public class CollisionCheck {
	
	GamePanel gp;
	
	public CollisionCheck(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = (entity.worldX + entity.hitBox.x);
		int entityRightWorldX = (entity.worldX + entity.hitBox.x + entity.hitBox.width);
		int entityTopWorldY = (entity.worldY + entity.hitBox.y);
		int entityBottomWorldY = (entity.worldY + entity.hitBox.y + entity.hitBox.height);
		
		int entityLeftCol = entityLeftWorldX / gp.tileSize;
		int entityRightCol = entityRightWorldX / gp.tileSize;
		int entityTopRow = entityTopWorldY / gp.tileSize;
		int entityBottomRow = entityBottomWorldY / gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow =  (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileManager.tile[tileNum1].collision  || gp.tileManager.tile[tileNum2].collision ) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol =  (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileManager.tile[tileNum1].collision  || gp.tileManager.tile[tileNum2].collision ) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol =  (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileManager.tile[tileNum1].collision  || gp.tileManager.tile[tileNum2].collision ) {
				entity.collisionOn = true;
			}
			break;	
		} 
	}
	public int checkObject(Entity entity, boolean player) {
		int index = -1;
		
		for(int i = 0; i < gp.obj.length; i++) {
				if(gp.obj[i] != null) {
					//Get entity's hitbox 
					entity.hitBox.x = entity.worldX + entity.hitBox.x;
					entity.hitBox.y = entity.worldY + entity.hitBox.y;
					//Get the object's hitbox
					gp.obj[i].hitBox.x = gp.obj[i].worldX + gp.obj[i].hitBox.x;
					gp.obj[i].hitBox.y = gp.obj[i].worldY + gp.obj[i].hitBox.y;
					
					//Hit Box is 0 by default 
					//Code still works if Hit Box values are later altered
					
					
					switch(entity.direction) {
					case "up":
						entity.hitBox.y -= entity.speed;
						if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "down":
						entity.hitBox.y += entity.speed;
						if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "left":
						entity.hitBox.x -= entity.speed;
						if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "right":
						entity.hitBox.x += entity.speed;
						if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					}
				
			
		
			
			
					//Reset hitbox values so they don't go to infity 
					entity.hitBox.x = entity.hitBoxDefaultX;
					entity.hitBox.y = entity.hitBoxDefaultY;
					gp.obj[i].hitBox.x = gp.obj[i].hitBoxDefaultX;
					gp.obj[i].hitBox.y = gp.obj[i].hitBoxDefaultY;
				}
		}
		
		
		
		
		return index;
	}
	
	
	
	
	
}
