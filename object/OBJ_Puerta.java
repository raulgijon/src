package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Puerta extends SuperObject {

	public OBJ_Puerta() {
		
		name ="Puerta";
		try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/puerta.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
