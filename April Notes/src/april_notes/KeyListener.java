package april_notes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	// Press Key Event (S,D,F,Space,J,K,L)
	@Override
	public void keyPressed(KeyEvent e) {
		if (AprilNote.game == null) 
			return;
		if (e.getKeyCode() == KeyEvent.VK_S) {
			AprilNote.game.pressS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			AprilNote.game.pressD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			AprilNote.game.pressF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			AprilNote.game.pressSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			AprilNote.game.pressJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			AprilNote.game.pressK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			AprilNote.game.pressL();
		}
	}

	// Release Key Event (S,D,F,Space,J,K,L)
	@Override
	public void keyReleased(KeyEvent e) {
		if (AprilNote.game == null)
			return;
		if (e.getKeyCode() == KeyEvent.VK_S) {
			AprilNote.game.releaseS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			AprilNote.game.releaseD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			AprilNote.game.releaseF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			AprilNote.game.releaseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			AprilNote.game.releaseJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			AprilNote.game.releaseK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			AprilNote.game.releaseL();
		}
	}
}
