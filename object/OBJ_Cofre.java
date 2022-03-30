package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Cofre extends SuperObject {
	
	public OBJ_Cofre() {
		
		name ="Cofre";
		try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/cofre.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
