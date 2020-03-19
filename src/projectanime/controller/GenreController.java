package projectanime.controller;

import projectanime.model.Anime;
import projectanime.model.Genre;
import projectanime.util.InputCheck;

import java.util.ArrayList;
import java.util.List;

public class GenreController {

    public Anime delGenres(Anime anime) {
        anime.getGenres().clear();
        return anime;
    }

    public List<Genre> getGenres() {
        return ProjectData.genres;
    }

    public List<String> getGenreTitles() {
        List<String> genreTitles = new ArrayList<>();
        for (int i = 0;i < getGenres().size();i++) {
            genreTitles.add(getGenres().get(i).getName());
        }
        return genreTitles;
    }

    public Anime addGenre(Anime anime, Genre genre) {
        if (anime.getGenres().contains(genre)) {
            System.out.println("Removing Genre");
            anime.getGenres().remove(genre);
        } else {
            System.out.println("Adding Genre");
            anime.getGenres().add(genre);
        }
        return anime;
    }

//    public List<Genre> addGenres(List<Genre> genres) {
//        boolean formatCorrect = false;
//        List<Genre> genreList = new ArrayList<>();
//        List<Integer> indexList = new ArrayList<>();
//        while (!formatCorrect) {
//            indexList.clear();
//            String input = InputCheck.readConsole();
//            input = input.replaceAll(" ", "");
//            String[] inputresult = input.split(",");
//            if (inputresult.length > 0 && inputresult.length < genres.size()) {
//                boolean allValid = true;
//                for (String s: inputresult) {
//                    try {
//                        Integer value = Integer.parseInt(s);
//                        if (value >= 0 && value < genres.size()) {
//                            if (!indexList.contains(value))
//                                indexList.add(value);
//                        } else {
//                            allValid = false;
//                            break;
//                        }
//                    } catch (NumberFormatException ex) {
//                        allValid = false;
//                        break;
//                    }
//                }
//                formatCorrect = allValid;
//                if (!formatCorrect) {
//                    System.out.println("Format incorrect! Please try again.");
//                }
//            }
//        }
//        for (int i: indexList) {
//            Genre selectedGenre = genres.get(i);
//            genreList.add(selectedGenre);
//        }
//        return genreList;
//    }
}
