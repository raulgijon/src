package main;

import object.OBJ_Boots;
import object.OBJ_Cofre;
import object.OBJ_Key;
import object.OBJ_Puerta;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 8 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 40 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldX = 40 * gp.tileSize;
		gp.obj[2].worldY = 21 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Puerta();
		gp.obj[3].worldX = 7 * gp.tileSize;
		gp.obj[3].worldY = 13 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Puerta();
		gp.obj[4].worldX = 15 * gp.tileSize;
		gp.obj[4].worldY = 22 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Cofre();
		gp.obj[6].worldX = 7 * gp.tileSize;
		gp.obj[6].worldY = 10 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Boots();
		gp.obj[7].worldX = 10 * gp.tileSize;
		gp.obj[7].worldY = 40 * gp.tileSize;
	}
}
