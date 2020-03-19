package projectanime.view;

import projectanime.menu.MenuEntry;
import projectanime.model.*;
import projectanime.model.Character;

import java.util.ArrayList;
import java.util.List;

public class ProjectAnimeViews {

    private List<MenuEntry> entries = new ArrayList<>();

    public void showSingleAnime(Anime anime) {
        String genreNames = getCurrentGenres(anime);
        String characterNames = getCurrentCharacters(anime);
        String subtitles = getCurrentSubtitles(anime);
        Rating currentRating = anime.getRating();
        String review = currentRating.getReview();
        int rating = currentRating.getRating();
        StringBuilder allEntries = new StringBuilder();
        int index = 0;
        for (MenuEntry entry: entries) {
            allEntries.append("\t").append(++index).append(". -> ").append(entry.getName()).append("\n");
        }
        String footer = "\n-----------------------------------------------------------------------------------------------";
        String body = "\n Title: " + anime.getTitle() + "\n\n Description: "
                + anime.getDescription() + "\n\n Type: " + anime.getType().toNormalCase() +
                "\n\n Character: " + characterNames + "\n\n Genres: " + genreNames
                + "\n\n Rating: " + rating + "/5" + "\n\n Review: " + review
                + "\n\n Subtitle: " + subtitles
                + "\n\n Fsk: " + anime.getFsk();
        String header = "-----------------------------------------------------------------------------------------------\n"
                + "|									                                                         |\n"
                + "| 		                             Project Anime			                                 |\n"
                + "|									                                                         |\n"
                + "-----------------------------------------------------------------------------------------------\n";
        String menu = header + body + "\n" + allEntries + footer;
        System.out.println(menu);
    }

    private String getCurrentCharacters(Anime anime) {
        String characterNames = "";
        List<Character> currentCharacters = anime.getCharacters();
        //Abfrage ob Null oder 1 oder n
        if (currentCharacters == null) {
            characterNames = "";
        } else if (currentCharacters.size() == 1) {
            characterNames = currentCharacters.get(0).getName();
        } else {
            for (int i = 0;i < currentCharacters.size() - 1;i++) {
                characterNames += currentCharacters.get(i).getName() + ", ";
            }
            characterNames += currentCharacters.get(currentCharacters.size() - 1).getName();
        }
        return characterNames;
    }

    private String getCurrentGenres(Anime anime) {
        List<Genre> currentGenres = anime.getGenres();
        String genreNames = "";
        if (currentGenres == null) {
            genreNames = "";
        } else if (currentGenres.size() == 1) {
            genreNames = currentGenres.get(0).getName();
        } else {
            for (int i = 0;i < currentGenres.size() - 1;i++) {
                genreNames += currentGenres.get(i).getName() + ", ";
            }
            genreNames += currentGenres.get(currentGenres.size() - 1).getName();
        }
        return genreNames;
    }

    private String getCurrentSubtitles(Anime anime){
        List<Subtitle> currentSubtitles = anime.getSubtitles();
        String subtitles = "";
        if(currentSubtitles == null){
            subtitles = "";
        }
        else if(currentSubtitles.size() == 1){
            subtitles = currentSubtitles.get(0).getName();
        } else {
            for(int i = 0;i < currentSubtitles.size() - 1;i++){
                subtitles += currentSubtitles.get(i).getName() + ", ";
            }
            subtitles += currentSubtitles.get(currentSubtitles.size() - 1).getName();
        }
        return subtitles;
    }
}
