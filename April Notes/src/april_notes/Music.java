// [NOTE] Everything in this Class was NOT ORIGINAL CODE
// [NOTE] I wrote everything here, but I had help

package april_notes;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private InputStream fis;
	// Stores InputStream argument for Later
	private BufferedInputStream bis;

	// Syntax (FileName.mp3, Loops?)
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			fis = Main.class.getResourceAsStream("/music/" + name);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = Main.class.getResourceAsStream("/music/" + getName());
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
