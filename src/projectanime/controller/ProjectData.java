package projectanime.controller;

import projectanime.model.*;
import projectanime.model.Character;

import java.util.ArrayList;
import java.util.List;

public class ProjectData {

    public static List<Anime> animes = fillAnimes();
    public static List<Genre> genres = initGenres();
    public static List<Subtitle> subtitles = initSubtitles();
    public static List<Series> series = fillSeries();

    private static List<Genre> initGenres() {
        Genre action = new Genre("Action");
        Genre adventure = new Genre("Adventure");
        Genre comedy = new Genre("Comedy");
        Genre drama = new Genre("Drama");
        Genre horror = new Genre("Horror");
        Genre romance = new Genre("Romance");
        List<Genre> genres = new ArrayList<>();
        genres.add(action);
        genres.add(adventure);
        genres.add(comedy);
        genres.add(drama);
        genres.add(horror);
        genres.add(romance);
        return genres;
    }

    private static List<Subtitle> initSubtitles() {
        Subtitle ger_sub = new Subtitle("German Subtitle");
        Subtitle eng_sub = new Subtitle("English Subtitle");
        Subtitle esp_sub = new Subtitle("Spanish Subtitle");
        Subtitle jp_sub = new Subtitle("Japanese Subtitle");
        Subtitle chn_sub = new Subtitle("Chinese Subtitle");
        List<Subtitle> subtitles = new ArrayList<>();
        subtitles.add(ger_sub);
        subtitles.add(eng_sub);
        subtitles.add(esp_sub);
        subtitles.add(jp_sub);
        subtitles.add(chn_sub);
        return subtitles;
    }

    private static List<Anime> fillAnimes() {
        Typ ova = Typ.OVA;
        Typ movie = Typ.MOVIE;
        Character asuna_yuki = new Character();
        Character kirito = new Character();
        Character test = new Character();
        test.setName("test");
        kirito.setName("Kirito");
        kirito.setVoice("");
        asuna_yuki.setName("Asuna Yuki");
        asuna_yuki.setVoice("");
        Genre action = new Genre("Action");
        Genre magic = new Genre("Magic");
        Genre superpower = new Genre("SuperPower");
        Subtitle ger_sub = new Subtitle("German Subtitle");
        Subtitle eng_sub = new Subtitle("English Subtitle");
        Rating one = new Rating(1, "");
        Rating three = new Rating(3, "");
        AnimeController anime_1controller = new AnimeController();
        GenreController anime_1genreController = new GenreController();
        Anime anime_1 = new Anime();
        anime_1.setTitle("Sword Art Online: Extra Edition");
        anime_1.setType(ova);
        anime_1.addGenre(action);
        anime_1.setRating(one);
        anime_1.addCharacter(asuna_yuki);
        anime_1.addCharacter(kirito);
        anime_1.addCharacter(test);
        anime_1.addSubtitle(ger_sub);
        AnimeController anime_2controller = new AnimeController();
        GenreController anime_2genreController = new GenreController();
        Anime anime_2 = new Anime();
        anime_2.setTitle("Dungeon ni Deai wo Motomeru no wa Machigatteiru Darou ka: Orion no Ya");
        anime_2.setType(movie);
        anime_2.addGenre(superpower);
        anime_2.addGenre(action);
        anime_2.setRating(three);
        anime_2.addCharacter(new Character("Bell Cranel"));
        anime_2.addSubtitle(eng_sub);
        AnimeController anime_3controller = new AnimeController();
        GenreController anime_3genreController = new GenreController();
        Anime anime_3 = new Anime();
        anime_3.setTitle("Fate/stay night Movie: Heaven's Feel - II. Lost Butterfly");
        anime_3.setType(movie);
        anime_3.addGenre(magic);
        anime_3.setRating(three);
        anime_3.addCharacter(new Character("Shiro Emiya"));
        anime_3.addSubtitle(eng_sub);
        List<Anime> animes = new ArrayList<>();
        animes.add(anime_1);
        animes.add(anime_2);
        animes.add(anime_3);
        return animes;
    }

    private static List<Series> fillSeries() {
        Subtitle ger_sub = new Subtitle("German Subtitle");
        Subtitle eng_sub = new Subtitle("English Subtitle");
        Series onePunchMan = new Series();
        Season onePunchMan1 = new Season();
        Season onePunchMan2 = new Season();
        Episode opm1ep1 = new Episode();
        Episode opm1ep2 = new Episode();
        Episode opm1ep3 = new Episode();
        Episode opm1ep4 = new Episode();
        Episode opm1ep5 = new Episode();
        Episode opm1ep6 = new Episode();
        Episode opm1ep7 = new Episode();
        Episode opm1ep8 = new Episode();
        opm1ep1.setTitle("The Strongest Man");
        opm1ep1.setRating(new Rating(2, ""));
        opm1ep1.addSubtitle(eng_sub);
        opm1ep1.setEpisodeNo(1);
        opm1ep2.setTitle("The Lone Cyborg");
        opm1ep2.setRating(new Rating(3, ""));
        opm1ep2.addSubtitle(ger_sub);
        opm1ep2.setEpisodeNo(2);
        opm1ep3.setTitle("The Obsessive Scientist");
        opm1ep3.setRating(new Rating(3, ""));
        opm1ep3.addSubtitle(ger_sub);
        opm1ep3.setEpisodeNo(3);
        opm1ep4.setTitle("The Modern Ninja");
        opm1ep4.setRating(new Rating(2, ""));
        opm1ep4.addSubtitle(ger_sub);
        opm1ep4.setEpisodeNo(4);
        opm1ep5.setTitle("The Ultimate Mentor");
        opm1ep5.setRating(new Rating(3, ""));
        opm1ep5.addSubtitle(ger_sub);
        opm1ep6.setTitle("The Terrifying City");
        opm1ep6.setRating(new Rating(3, ""));
        opm1ep6.addSubtitle(ger_sub);
        opm1ep7.setTitle("The Ultimate Displice");
        opm1ep7.setRating(new Rating(2, ""));
        opm1ep7.addSubtitle(ger_sub);
        opm1ep8.setTitle("The Deep Sea King");
        opm1ep8.setRating(new Rating(3, ""));
        opm1ep8.addSubtitle(ger_sub);
        onePunchMan1.addEpisode(opm1ep1);
        onePunchMan1.addEpisode(opm1ep2);
        onePunchMan1.addEpisode(opm1ep3);
        onePunchMan1.addEpisode(opm1ep4);
        onePunchMan1.setSeasonName("One Punch Man");
        onePunchMan2.setSeasonName("One Punch Man 2nd Season");
        onePunchMan.addSeason(onePunchMan1);
        onePunchMan.addSeason(onePunchMan2);
        onePunchMan.setSeriesname("One Punch Man");
        List<Series> series = new ArrayList<>();
        series.add(onePunchMan);
        return series;
    }

}
