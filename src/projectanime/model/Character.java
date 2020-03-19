package projectanime.model;

public class Character {
    private String name;
    private String voice;

    /**
     * Constructor
     */
    public Character() {

    }

    public Character(String name) {
        this.name = name;
    }

    /**
     * Gets the List of Characters + Voices
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set Character
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}