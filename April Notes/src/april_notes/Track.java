package april_notes;

// Wraps Images and Music into a series of Getters and Setters
public class Track {

	// Defines Strings
	private String titleImage;
	private String startImage;
	private String gameImage;
	private String startMusic;
	private String gameMusic;
	private String titleName;
	private String lockImage;

	// Associates an Image or Music File with a String (or Value)
	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getLockImage() {
		return lockImage;
	}

	public void setLockImage(String lockImage) {
		this.lockImage = lockImage;
	}

	// trackList Syntax - (titleImage, startImage, gameImage, startMusic, gameMusic,
	// titleName, lockImage)
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic,
			String titleName, String lockImage) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
		this.lockImage = lockImage;
	}

}
