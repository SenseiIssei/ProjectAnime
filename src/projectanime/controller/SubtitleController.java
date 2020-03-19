package projectanime.controller;

import projectanime.model.Anime;
import projectanime.model.Genre;
import projectanime.model.Subtitle;
import projectanime.util.InputCheck;

import java.util.ArrayList;
import java.util.List;

public class SubtitleController {


    public List<Subtitle> getSubtitles() {
        return ProjectData.subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        ProjectData.subtitles = subtitles;
    }

    public List<String> getSubtitleNames() {
        List<String> subtitleNames = new ArrayList<>();
        for (int i = 0;i < getSubtitles().size();i++) {
            subtitleNames.add(getSubtitles().get(i).getName());
        }
        return subtitleNames;
    }

    public Anime addSubtitle(Anime anime, Subtitle subtitle) {
        if (anime.getSubtitles().contains(subtitle)) {
            System.out.println("Removing Subtitle");
            anime.getSubtitles().remove(subtitle);
        } else {
            System.out.println("Adding Subtitle");
            anime.getSubtitles().add(subtitle);
        }
        return anime;
    }
}
