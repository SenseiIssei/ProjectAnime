package projectanime.controller;

import projectanime.model.Anime;
import projectanime.util.InputCheck;

public class UniversalCode {

    public void setTitle(Anime anime) {
        String name = InputCheck.readConsole();
        anime.setTitle(name);
    }

    public void setDescription(Anime anime) {
        String desc = InputCheck.readConsole();
        anime.setDescription(desc);
    }

    public void setFsk(Anime anime) {
        int consoleinput = InputCheck.readInt();
        switch (consoleinput) {
            case 1:
                anime.setFsk(0);
                break;
            case 2:
                anime.setFsk(6);
                break;
            case 3:
                anime.setFsk(12);
                break;
            case 4:
                anime.setFsk(16);
                break;
            case 5:
                anime.setFsk(18);
                break;
        }
    }

//    public void createAnime(Anime anime) {
//        fill.addNameMenu();
//        setTitle(anime);
//        String title = anime.getTitle();
//        fill.addDescMenu();
//        setDescription(anime);
//        fill.addFskMenu();
//        setFsk(anime);
//        genreController.addGenreToAnime(anime);
//        anime.setRating();
//        if (anime.getRating() == null) {
//            fill.addRatingMenu();
//        }
//        subtitleController.addSubtitleToAnime(anime);
//        fill.addCharacterMenu(title);
//        characterController.addCharactersToAnime(anime);
//    }
}
