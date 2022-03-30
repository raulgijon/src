package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed;
	public boolean downPressed;
	public boolean leftPressed;
	public boolean rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getExtendedKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			upPressed =true;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed=true;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed=true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code =e.getKeyCode();

		if(code == KeyEvent.VK_UP) {
			upPressed =false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed=false;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed=false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed=false;
		}
	}

}
