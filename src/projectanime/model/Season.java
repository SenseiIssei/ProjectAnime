package projectanime.model;

import projectanime.model.Episode;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private final List<Episode> episodes = new ArrayList<>();
    private String name;

    public Season() {
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public String getSeasonName() {
        return name;
    }

    public void setSeasonName(String name) {
        this.name = name;
    }
}
