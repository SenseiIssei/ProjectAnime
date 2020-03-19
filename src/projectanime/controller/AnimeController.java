package projectanime.controller;

import projectanime.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeController {

    public void delAllAnimes() {
        ProjectData.animes.clear();
    }

    public void delAnime(Anime anime) {
        ProjectData.animes.remove(anime);
    }

    public void fillAnimeList(List<Anime> animes) {
        ProjectData.animes.addAll(animes);
    }

    public List<Anime> getAnimeList() {
        return ProjectData.animes;
    }

    public void addAnimeToList(Anime anime) {
        ProjectData.animes.add(anime);
    }

    public List<String> getAnimeTitles() {
        List<String> animeTitles = new ArrayList<>();
        for (Anime value: getAnimeList()) {
            animeTitles.add(value.getTitle());
        }
        return animeTitles;
    }

    //Function for adding Rating currently not usable

//    public void addRating(){
//        Rating rating = null;
//        int ratingString = InputCheck.readInt();
//        if (ratingString > 0 && ratingString < 6) {
//            System.out.println("Review your Rating (else leave it empty)");
//            String review = InputCheck.readConsole();
//            rating = new Rating(ratingString, review);
//        } else {
//            System.out.println("Try Again!");
//        }
//    }
}