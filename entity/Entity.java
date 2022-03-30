package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Entity {
	//NPC MONSTRUOS Y PERSONAJE
	public int worldX,worldY;
	public int speed;
	public BufferedImage bea_front, bea_up1, bea_up2, bea_back, bea_down1, bea_down2, bea_right, bea_right1, bea_right2, bea_left, bea_left1, bea_left2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum=1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn= false;

}
