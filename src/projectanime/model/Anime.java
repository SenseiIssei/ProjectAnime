package projectanime.model;

import java.util.ArrayList;
import java.util.List;

public class Anime {
    private static int count = 0;
    private List<Genre> genres;
    private String title;
    private Typ type;
    private String description = "";
    private Rating rating;
    private List<Character> characters;
    private List<Subtitle> subtitles;
    private int fsk;

    /**
     * Constructor
     */
    public Anime() {
        genres = new ArrayList<>();
        characters = new ArrayList<>();
        subtitles = new ArrayList<>();
        count += 1;
    }

    /**
     * Gets the Title
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the Title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the Description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Type
     *
     * @return
     */
    public Typ getType() {
        return type;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    /**
     * Sets the Type
     *
     * @param type
     */
    public void setType(Typ type) {
        this.type = type;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * Gets the List of Rating
     *
     * @return
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets the Rating
     *
     * @param rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    public void addSubtitle(Subtitle subtitle) {
        this.subtitles.add(subtitle);
    }
}