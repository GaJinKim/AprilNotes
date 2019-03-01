package april_notes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	// Game Screen Image Resources 
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("/images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("/images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("/images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpaceImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image gameBackground = new ImageIcon(Main.class.getResource("/images/gameBackground.png")).getImage();
	
	private Image scorePanel = new ImageIcon(Main.class.getResource("/images/scorePanel.png")).getImage();
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadSpaceImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	
	
	// Defines Strings 
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	// Establishes Image Locations
	public void screenDraw(Graphics2D g) {
		g.drawImage(gameBackground, 0, 0, null);
		g.drawImage(noteRouteSImage, 278, 30, null);
		g.drawImage(noteRouteDImage, 382, 30, null);
		g.drawImage(noteRouteFImage, 486, 30, null);
		g.drawImage(noteRouteSpaceImage, 590, 30, null);
		g.drawImage(noteRouteJImage, 694, 30, null);
		g.drawImage(noteRouteKImage, 798, 30, null);
		g.drawImage(noteRouteLImage, 902, 30, null);
		g.drawImage(noteRouteLineImage, 274, 30, null);
		g.drawImage(noteRouteLineImage, 378, 30, null);
		g.drawImage(noteRouteLineImage, 482, 30, null);
		g.drawImage(noteRouteLineImage, 586, 30, null);
		g.drawImage(noteRouteLineImage, 690, 30, null);
		g.drawImage(noteRouteLineImage, 794, 30, null);
		g.drawImage(noteRouteLineImage, 898, 30, null);
		g.drawImage(noteRouteLineImage, 1002, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null); // [NOTE] Judgment Line is 40 Pixels high

		for (int i = 0; i < noteList.size(); i++) 
		{
			// [NOTE] Following 12 Lines are Not Original Code
			Note note = noteList.get(i);
			if(note.getY() > 660) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judgeX.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}

		// Establishes Location & Color of Game Info
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact,", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Impact", Font.BOLD, 26));
		g.setColor(Color.WHITE);
		g.drawString("S", 322, 610);
		g.drawString("D", 426, 610);
		g.drawString("F", 530, 610);
		g.drawString("Space", 607, 610);
		g.drawString("J", 738, 610);
		g.drawString("K", 841, 610);
		g.drawString("L", 945, 610);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.BOLD, 45));
		g.drawString("D E M O", 568, 710); // Will Change to Score Board Later In Development
		// g.drawString("000000", 566, 710);
		
		g.drawImage(scorePanel, 1024, 50, null); // scorePanel
		g.drawImage(judgeImage, 1047, -2, null); // Note Judgment
		g.drawImage(keyPadDImage, 382, 580,null);
		g.drawImage(keyPadFImage, 486, 580,null);
		g.drawImage(keyPadSpaceImage, 590, 580,null);
		g.drawImage(keyPadJImage, 694, 580,null);
		g.drawImage(keyPadKImage, 798, 580,null);
		g.drawImage(keyPadLImage, 902, 580,null);

	}

	// When "S" is Pressed or Held, "Basic" transforms into "Pressed"
	// When "S" is Pressed, "drum.mp3" plays
	// When "S" is Pressed or Held, key Highlight "Basic" transforms into "Pressed"
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		// Syntax is (File.mp3, isLoop)
		new Music("drum.mp3", false).start(); 
	}

	// When "S" is Released, "Pressed" reverts back into "Basic"
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpaceImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSpaceImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpaceImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadSpaceImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
		new Music("drum.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
	}

	// If Game is TRUE, dropNotes() is TRUE
	@Override
	public void run() {
		dropNotes(this.titleName);

	}

	// If Game is FALSE, current gameMusic is FALSE
	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		// Associates titleName (nowSelected) & difficulty with a Drop Pattern
		if (titleName.equals("Beethoven Virus") & difficulty.equals("Easy")) {
			// Interrupts startTime
			int startTime = Main.REACH_TIME;
			// Establishes time between notes (experimental value)
			int gap = 79;
			
			// Song is written in 4/4 (1 Measure = 16 gaps of 79 milliseconds)
			// [NOTE] 1/16 Note - gap = 1
			// [NOTE] 1/8  Note - gap = 2
			// [NOTE] 1/4  Note - gap = 4
			
			// Drop Pattern
			beats = new Beat[] { 
					// Measure -2 
					new Beat(startTime + gap * 0, "F"), new Beat(startTime + gap * 0, "J"), 
					new Beat(startTime + gap * 6, "D"), new Beat(startTime + gap * 6, "K"),
 
				    // Measure -1

					// Measure 1
					new Beat(startTime + gap * 32, "F"), new Beat(startTime + gap * 32, "J"), 
					new Beat(startTime + gap * 38, "D"), new Beat(startTime + gap * 38, "K"),

				    // Measure 2

					// Measure 3
					new Beat(startTime + gap * 64, "J"),
					new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 72, "D"),
					new Beat(startTime + gap * 74, "D"),
					new Beat(startTime + gap * 76, "L"),
					new Beat(startTime + gap * 78, "D"), 

					// Measure 4
					new Beat(startTime + gap * 80, "D"), 
					new Beat(startTime + gap * 82, "K"),
					new Beat(startTime + gap * 84, "D"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "J"),
					new Beat(startTime + gap * 90, "D"),
					new Beat(startTime + gap * 92, "D"),
					new Beat(startTime + gap * 94, "K"), 

					// Measure 5
					new Beat(startTime + gap * 96, "J"), 
					new Beat(startTime + gap * 98, "D"),
					new Beat(startTime + gap * 100, "D"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 104, "D"),
					new Beat(startTime + gap * 106, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 110, "D"),

					// Measure 6
					new Beat(startTime + gap * 112, "D"), 
					new Beat(startTime + gap * 114, "J"),
					new Beat(startTime + gap * 116, "D"),
					new Beat(startTime + gap * 118, "D"), 
					new Beat(startTime + gap * 120, "F"),
					new Beat(startTime + gap * 122, "S"),
					new Beat(startTime + gap * 124, "D"),
					new Beat(startTime + gap * 126, "F"),

					// Measure 7
					new Beat(startTime + gap * 128, "J"), 
					new Beat(startTime + gap * 134, "K"),
					new Beat(startTime + gap * 136, "J"),
					new Beat(startTime + gap * 142, "S"), new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 142, "J"), new Beat(startTime + gap * 142, "L"),

					// Measure 8 
					new Beat(startTime + gap * 144, "D"), new Beat(startTime + gap * 144, "K"), 
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 155, "D"),
					new Beat(startTime + gap * 156, "F"), 
					new Beat(startTime + gap * 157, "S"), 
					new Beat(startTime + gap * 158, "D"), 
					new Beat(startTime + gap * 159, "F"), 

					// Measure 9
					new Beat(startTime + gap * 160, "J"), new Beat(startTime + gap * 160, "L"), 
					new Beat(startTime + gap * 164, "J"), new Beat(startTime + gap * 164, "L"), 
					new Beat(startTime + gap * 168, "J"), new Beat(startTime + gap * 168, "L"), 
					new Beat(startTime + gap * 172, "J"), new Beat(startTime + gap * 172, "L"),

					// Measure 10
					new Beat(startTime + gap * 176, "J"), new Beat(startTime + gap * 176, "L"), 
					new Beat(startTime + gap * 188, "S"),
					new Beat(startTime + gap * 190, "F"),

					// Measure 11 
					new Beat(startTime + gap * 192, "J"), new Beat(startTime + gap * 192, "L"), 
					new Beat(startTime + gap * 200, "D"),
					new Beat(startTime + gap * 204, "S"),
					new Beat(startTime + gap * 206, "F"),

					// Measure 12
					new Beat(startTime + gap * 208, "J"), new Beat(startTime + gap * 208, "L"), 
					new Beat(startTime + gap * 216, "D"),
					new Beat(startTime + gap * 220, "S"),				
					new Beat(startTime + gap * 222, "F"),

					// Measure 13
					new Beat(startTime + gap * 224, "K"),
					new Beat(startTime + gap * 230, "L"),
					new Beat(startTime + gap * 232, "J"),
					new Beat(startTime + gap * 238, "K"),

					// Measure 14 
					new Beat(startTime + gap * 240, "J"), 
					new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 252, "D"),
					new Beat(startTime + gap * 254, "F"),

					// Measure 7 (2nd Run)
					new Beat(startTime + gap * 256, "J"), 
					new Beat(startTime + gap * 262, "K"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 270, "S"), new Beat(startTime + gap * 270, "F"), new Beat(startTime + gap * 270, "J"), new Beat(startTime + gap * 142, "L"),

					// Measure 8 (2nd Run)
					new Beat(startTime + gap * 272, "D"), new Beat(startTime + gap * 272, "K"), 
					new Beat(startTime + gap * 282, "S"),
					new Beat(startTime + gap * 283, "D"),
					new Beat(startTime + gap * 284, "F"), 
					new Beat(startTime + gap * 285, "S"), 
					new Beat(startTime + gap * 286, "D"), 
					new Beat(startTime + gap * 287, "F"), 

					// Measure 9 (2nd Run)
					new Beat(startTime + gap * 288, "J"), new Beat(startTime + gap * 288, "L"), 
					new Beat(startTime + gap * 292, "J"), new Beat(startTime + gap * 292, "L"), 
					new Beat(startTime + gap * 296, "J"), new Beat(startTime + gap * 296, "L"), 
					new Beat(startTime + gap * 300, "J"), new Beat(startTime + gap * 300, "L"),

					// Measure 10 (2nd Run)
					new Beat(startTime + gap * 304, "J"), new Beat(startTime + gap * 304, "L"), 
					new Beat(startTime + gap * 316, "S"),
					new Beat(startTime + gap * 318, "F"),

					// Measure 11 (2nd Run)
					new Beat(startTime + gap * 320, "J"), new Beat(startTime + gap * 320, "L"), 
					new Beat(startTime + gap * 328, "D"),
					new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 334, "F"),

					// Measure 12 (2nd Run)
					new Beat(startTime + gap * 336, "J"), new Beat(startTime + gap * 336, "L"), 
					new Beat(startTime + gap * 344, "D"),
					new Beat(startTime + gap * 348, "S"),				
					new Beat(startTime + gap * 350, "F"),

					// Measure 13 (2nd Run)
					new Beat(startTime + gap * 352, "K"),
					new Beat(startTime + gap * 358, "L"),
					new Beat(startTime + gap * 360, "J"),
					new Beat(startTime + gap * 366, "K"),

					// Measure 15 
					new Beat(startTime + gap * 368, "J"),
					new Beat(startTime + gap * 378, "F"),
					new Beat(startTime + gap * 380, "S"),
					new Beat(startTime + gap * 382, "D"),

					// Measure 16
			//		new Beat(startTime + gap * 384, "Space"),
					};
			
			
		} else if (titleName.equals("Beethoven Virus") & difficulty.equals("Hard")) {
			int startTime = Main.REACH_TIME;;
			int gap = 79;
			beats = new Beat[] { new Beat(startTime, "Space"), 
					new Beat(startTime + gap * 16, "D"),
					new Beat(startTime + gap * 32, "D"),
					new Beat(startTime + gap * 48, "D"),
			
			};
					
		} else if (titleName.equals("Jerry C - Canon Rock") & difficulty.equals("Easy")) {
			int startTime = Main.REACH_TIME;;
			beats = new Beat[] { new Beat(startTime, "Space"), 
					
			};
			
		} else if (titleName.equals("Jerry C - Canon Rock") & difficulty.equals("Hard")) {
			int startTime = Main.REACH_TIME;;
			beats = new Beat[] { new Beat(startTime, "Space"), 
					
			};
			
		} else if (titleName.equals("DJ Okawari - Flower Dance") & difficulty.equals("Easy")) {
			int startTime = Main.REACH_TIME;;
			beats = new Beat[] { new Beat(startTime, "Space"), 
					
			};
			
		} else if (titleName.equals("DJ Okawari - Flower Dance") & difficulty.equals("Hard")) {
			int startTime = Main.REACH_TIME;;
			beats = new Beat[] { new Beat(startTime, "Space"), 
					
			};
			
		}
	
		// [NOTE] I had someone help me write this part of the code
		int i = 0;
		gameMusic.start();
		while (i < beats.length & !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		}
		
	// [NOTE] Following 6 Lines of code are Not Original
		public void judge(String input) {
			for(int i = 0; i < noteList.size(); i++) {
				Note note = noteList.get(i);
				if(input.equals(note.getNoteType())) {
					judgeEvent(note.judge());
					break;
				}
		}
	}
		// Draws Score Icon on Game Screen
		public void judgeEvent(String judge) {
			if(judge.equals("X")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judgeX.png")).getImage();
			}
			if(judge.equals("50")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judge50.png")).getImage();
			}
			if(judge.equals("100")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judge100.png")).getImage();
			}
			if(judge.equals("200")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judge200.png")).getImage();
			}
			if(judge.equals("300")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judge300.png")).getImage();
			}
			if(judge.equals("300!")) {
				judgeImage = new ImageIcon(Main.class.getResource("/images/judge300!.png")).getImage();
			}
			
		}
}

