package projectanime.model;

public class Episode extends Anime {
    private int episodeno;

    /**
     * Constructor
     */
    public Episode() {
    }

    /**
     * Gets the Episode Number
     *
     * @return
     */
    public int getEpisodeNo() {
        return episodeno;
    }

    /**
     * Sets the Episode Number
     *
     * @param episodeno
     */
    public void setEpisodeNo(int episodeno) {
        this.episodeno = episodeno;
    }
}
