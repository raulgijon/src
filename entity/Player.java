package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2- (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX =solidArea.x;
		solidAreaDefaultY =solidArea.y;
		solidArea.width = 30;
		solidArea.height = 30;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction="down";
	}
	public void getPlayerImage() {
		
		try {
			bea_front = ImageIO.read(getClass().getResourceAsStream("/player/bea.png"));
			bea_up1 = ImageIO.read(getClass().getResourceAsStream("/player/bea_up_1.png"));
			bea_up2 = ImageIO.read(getClass().getResourceAsStream("/player/bea_up_2.png"));
			bea_back = ImageIO.read(getClass().getResourceAsStream("/player/bea_back.png"));
			bea_down1 = ImageIO.read(getClass().getResourceAsStream("/player/bea_down_1.png"));
			bea_down2 = ImageIO.read(getClass().getResourceAsStream("/player/bea_down_2.png"));
			bea_right = ImageIO.read(getClass().getResourceAsStream("/player/bea_right.png"));
			bea_right1 = ImageIO.read(getClass().getResourceAsStream("/player/bea_right_1.png"));
			bea_right2 = ImageIO.read(getClass().getResourceAsStream("/player/bea_right_2.png"));
			bea_left = ImageIO.read(getClass().getResourceAsStream("/player/bea_left.png"));
			bea_left1 = ImageIO.read(getClass().getResourceAsStream("/player/bea_left_1.png"));
			bea_left2 = ImageIO.read(getClass().getResourceAsStream("/player/bea_left_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed==true || keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true){
			if(keyH.upPressed == true) {
				direction ="up";	
			}else if(keyH.downPressed == true) {
				direction ="down";
			}else if(keyH.leftPressed == true) {
				direction ="left";
			}else if(keyH.rightPressed == true) {
				direction ="right";
			}
			//COMPRUEBA LA COLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			
			//COMPUREBA QUE LOS OBJETOS TENGAN COLISION
			
			int objIndex =gp.cChecker.checkObject(this,true);
			pickUpObject(objIndex);
			//SI LA COLISION ES FALSE EL JUGADOR NO SE PUEDE MOVER
			
			if(collisionOn == false) {
				switch(direction) {
				case "up": worldY-= speed; break;
				case "down": worldY+=speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX +=speed; break;
				
				}
			}
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum==1) {
					spriteNum=2;
				}else if(spriteNum == 2) {
					spriteNum =3;
				}else if(spriteNum == 3){
					spriteNum= 2;
				}
				spriteCounter=0;
			}
			}
	
		
	}
	public void pickUpObject (int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				gp.ui.showMessage("Has conseguido una llave");
				break;
			case "Puerta":
				gp.playSE(2);
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("Has habierto la puerta");
				}else {
					gp.ui.showMessage("necesitas una llave");
				}
				break;
			case "Boots":
				speed += 1;
				gp.obj[i] = null;
				gp.ui.showMessage("ahora corres mas rapido");
				break;
			case "Cofre":
				gp.ui.gameFinished = true;
		//		gp.stopMusic();
		//		gp.playSE(0);  
				break;
			}
		}
		
	}
	public void draw(Graphics2D g2) {
	//	g2.setColor(Color.white);
	//	g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image= bea_back;
			}
			if(spriteNum == 2) {
				image= bea_up1;
			}
			if(spriteNum == 3) {
				image= bea_up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image= bea_front;
			}
			if(spriteNum == 2) {
				image= bea_down1;
			}
			if(spriteNum == 3) {
				image= bea_down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image= bea_left;
			}
			if(spriteNum == 2) {
				image= bea_left1;
			}
			if(spriteNum == 3) {
				image= bea_left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image= bea_right;
			}
			if(spriteNum == 2) {
				image= bea_right1;
			}
			if(spriteNum == 3) {
				image= bea_right2;
			}
			break;
		}
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		
		
		
		
	}
}
