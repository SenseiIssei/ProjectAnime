package projectanime.model;

import projectanime.controller.ProjectData;

public class Subtitle {
    private String name;

    /**
     * Constuctor for Subtitle
     *
     * @param name
     */
    public Subtitle(String name) {
        this.name = name;
    }

    /**
     * Gets the Subtitle
     *
     * @return
     */
    public String getName() {
        return name;
    }

}