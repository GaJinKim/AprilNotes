package april_notes;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	// Note Properties
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("/images/noteBasic.png")).getImage();
	private int x, y;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	// noteType Properties
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 278;
		}
		else if(noteType.equals("D")) {
			x = 382;
		}
		else if(noteType.equals("F")) {
			x = 486;
		}
		else if(noteType.equals("Space")) {
			x = 590;
		}
		else if(noteType.equals("J")) {
			x = 694;
		}
		else if(noteType.equals("K")) {
			x = 798;
		}
		else if(noteType.equals("L")) {
			x = 902;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage,  x, y, null);
		}
		else
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
	}
	
	// Note Drop Properties (Animation & Accuracy)
	public void drop() {
		y += Main.NOTE_SPEED;
		if (y>660) {
			System.out.println("X"); // Miss
			close();
		}
	}
	
	// [NOTE] I DID NOT WRITE THE FOLLOWING CONTROL STATEMENT
	// Interrupts Note Drop Animation
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME); 
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage()); 
		}
	}
	
	// [NOTE] Score System Inspired by [osu!]
	public String judge() {
		if(y >= 650) {
			System.out.println("50"); // Error Margin 10
			close();
			return "50";
		}
		else if(y >= 630) {
			System.out.println("100"); // Error Margin 20
			close();
			return "100";
		}
		else if(y >= 605) {
			System.out.println("200"); // Error Margin 25
			close();
			return "200";
		}
		else if(y >= 590) {
			System.out.println("300"); // Error Margin 15
			close();
			return "300";
		}
		else if(y >= 570) {
			System.out.println("300!"); // Error Margin 10 (20 for both sides)
			close();
			return "300!";
		}
		else if(y >= 555) {
			System.out.println("300"); // Error Margin 15
			close();
			return "300";
		}
		else if(y >= 530) {
			System.out.println("200"); //Error Margin 25
			close();
			return "200";
		}
		else if(y >= 510) {
			System.out.println("100"); // Error Margin 20
			close();
			return "100";
		}
		else if(y >= 500) {
			System.out.println("50"); // Error Margin 10
			close();
			return "50";
		}
		return "None";
	}
	
	// Retrieves Y-Value
	public int getY() {
		return y;
	}
}
