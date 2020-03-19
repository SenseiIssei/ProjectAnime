package projectanime.controller;

import projectanime.menu.AdditonalOptions;
import projectanime.menu.MenuEntry;
import projectanime.model.*;
import projectanime.util.InputCheck;
import projectanime.view.MenuView;

import java.util.List;

public class fillMenu {
    private Anime anime = new Anime();
    AnimeController animeController = new AnimeController();
    GenreController genreController = new GenreController();
    SubtitleController subtitleController = new SubtitleController();
    CharacterController characterController = new CharacterController();
    RatingController ratingController = new RatingController();
    private final MenuEntry exit = new MenuEntry("Exit");
    private final MenuEntry back = new MenuEntry("Back");

    public fillMenu() {
        exit.setAdditonalOptions(AdditonalOptions.EXIT);
        back.setAdditonalOptions(AdditonalOptions.BACK);
    }

    public MenuView mainMenu() {
        MenuView menu = new MenuView("Welcome to the Project Anime! Please choose one option:");
        MenuView addAnime = animeMenu();
        MenuView editAnime = editMenu();
        MenuView delAnime = deleteMenu();
        MenuView listAnime = listMenu();
        menu.addEntryToList(addAnime);
        menu.addEntryToList(editAnime);
        menu.addEntryToList(delAnime);
        menu.addEntryToList(listAnime);
        menu.addEntryToList(exit);
        return menu;
    }

    public MenuView animeMenu() {
        MenuView addAnime = new MenuView("Add Anime");
        addAnime.setMenuTitle("Which type of Anime would you like to add?");
        MenuEntry series = new MenuEntry("Series") {
            @Override
            public void run() {
                anime.setType(Typ.SERIES);
            }
        };
        MenuEntry movie = new MenuEntry("Movie") {
            @Override
            public void run() {
                anime.setType(Typ.MOVIE);
                addMenu().run();
            }
        };
        MenuEntry ova = new MenuEntry("OVA") {
            @Override
            public void run() {
                anime.setType(Typ.OVA);
                addMenu().run();
            }
        };
        addAnime.addEntryToList(series);
        addAnime.addEntryToList(movie);
        addAnime.addEntryToList(ova);
        addAnime.addEntryToList(back);
        return addAnime;
    }

    public MenuView addMenu() {
        MenuView addMenu = new MenuView("Adding Menu");
        addMenu.setMenuTitle("Select what you want to add to your Anime:");
        MenuEntry title = new MenuEntry("Title") {
            @Override
            public void run() {
                System.out.println("Type in the title of your Anime:");
                String title = InputCheck.readConsole();
                anime.setTitle(title);
            }
        };
        MenuEntry description = new MenuEntry("Description") {
            @Override
            public void run() {
                System.out.println("Type in the description of your Anime:");
                String description = InputCheck.readConsole();
                anime.setDescription(description);
            }
        };
        MenuView fsk = addFskMenu();
        MenuView genre = addGenreMenu(anime.getTitle(), genreController.getGenres());
        MenuEntry rating = new MenuEntry("Rating") {
            @Override
            public void run() {
                ratingController.addRating(anime);
            }
        };
        MenuView subtitle = addSubtitleMenu(anime.getTitle(), subtitleController.getSubtitles());
        MenuView character = addCharacterMenu(anime.getTitle());
        addMenu.addEntryToList(title);
        addMenu.addEntryToList(description);
        addMenu.addEntryToList(fsk);
        addMenu.addEntryToList(genre);
        addMenu.addEntryToList(rating);
        addMenu.addEntryToList(subtitle);
        addMenu.addEntryToList(character);
        addMenu.addEntryToList(back);
        return addMenu;
    }

    public MenuView addFskMenu() {
        MenuView addFsk = new MenuView("Add Fsk");
        addFsk.setMenuTitle("Choose the Fsk for your Anime:");
        MenuEntry fsk0 = new MenuEntry("Fsk 0") {
            @Override
            public void run() {
                anime.setFsk(0);
                addMenu().run();
            }
        };
        MenuEntry fsk6 = new MenuEntry("Fsk 6") {
            @Override
            public void run() {
                anime.setFsk(6);
                addMenu().run();
            }
        };
        MenuEntry fsk12 = new MenuEntry("Fsk 12") {
            @Override
            public void run() {
                anime.setFsk(12);
                addMenu().run();
            }
        };
        MenuEntry fsk16 = new MenuEntry("Fsk 16") {
            @Override
            public void run() {
                anime.setFsk(16);
                addMenu().run();
            }
        };
        MenuEntry fsk18 = new MenuEntry("Fsk 18") {
            @Override
            public void run() {
                anime.setFsk(18);
                addMenu().run();
            }
        };
        addFsk.addEntryToList(fsk0);
        addFsk.addEntryToList(fsk6);
        addFsk.addEntryToList(fsk12);
        addFsk.addEntryToList(fsk16);
        addFsk.addEntryToList(fsk18);
        return addFsk;
    }

    public MenuView addGenreMenu(String name, List<Genre> genres) {
        MenuView genreView = new MenuView("Add Genre");
        genreView.setMenuTitle("Select the Genre for " + name + ":");
        for (Genre genre: genres) {
            MenuEntry genreEntry = new MenuEntry(genre.getName()) {
                @Override
                public void run() {
                    genreController.addGenre(anime, genre);
                }
            };
            genreView.addEntryToList(genreEntry);
        }
        genreView.addEntryToList(back);
        return genreView;
    }

    public MenuView addSubtitleMenu(String name, List<Subtitle> subtitles) {
        MenuView subtitleView = new MenuView("Add Subtitles");
        subtitleView.setMenuTitle("Anime: " + name + "\n\n    Choose one option for the current Anime:");
        for (Subtitle subtitle: subtitles) {
            MenuEntry subtitleEntry = new MenuEntry(subtitle.getName()) {
                @Override
                public void run() {
                    subtitleController.addSubtitle(anime, subtitle);
                }
            };
            subtitleView.addEntryToList(subtitleEntry);
        }
        subtitleView.addEntryToList(back);
        return subtitleView;
    }

    public MenuView addCharacterMenu(String name) {
        MenuView characterView = new MenuView("Add Character");
        characterView.setMenuTitle("Add Characters for: " + name);
        MenuEntry addcharandvoice = new MenuEntry("Add Character Name and Voice") {
            @Override
            public void run() {
                characterController.addCharactersToAnime(anime);
                newCharacterMenu().run();
            }
        };
        characterView.addEntryToList(addcharandvoice);
        characterView.addEntryToList(back);
        return characterView;
    }

    public MenuView newCharacterMenu() {
        MenuView addCharacterView = new MenuView("Add new Character and Voice");
        MenuView done = addMenu();
        MenuView addanother = addCharacterMenu(anime.getTitle());
        addCharacterView.addEntryToList(addanother);
        addCharacterView.addEntryToList(done);
        addCharacterView.addEntryToList(back);
        return addCharacterView;
    }

    public MenuView deleteMenu() {
        MenuView delAnime = new MenuView("Delete Anime");
        MenuView selectedAnime = deleteSelectedAnimeMenu();
        MenuView searchbyname = deleteSelectedNameMenu();
        MenuView deleteall = deleteAllMenu();
        delAnime.setMenuTitle("Choose one option to delete the Anime:");
        delAnime.addEntryToList(selectedAnime);
        delAnime.addEntryToList(searchbyname);
        delAnime.addEntryToList(deleteall);
        delAnime.addEntryToList(back);
        return delAnime;
    }

    public MenuView deleteSelectedAnimeMenu() {
        MenuView delselAnime = new MenuView("Delete selected Anime");
        delselAnime.setMenuTitle("Choose the Anime you want to delete:");
        for (Anime anime: ProjectData.animes) {
            MenuEntry delsel = new MenuEntry(anime.getTitle()) {
                @Override
                public void run() {
                    ProjectData.animes.remove(anime);
                }
            };
            delselAnime.addEntryToList(delsel);
        }
        delselAnime.addEntryToList(back);
        return delselAnime;
    }

    public MenuView deleteSelectedNameMenu() {
        MenuView delnameAnime = new MenuView("Delete by Name");
        delnameAnime.setMenuTitle("Type in the Name of the Anime you want to delete:");
        delnameAnime.addEntryToList(back);
        return delnameAnime;
    }

    public MenuView showDeleteSelectNamesMenu(String sortName) {
        MenuView delselectedNames = new MenuView("");
        for (Anime anime: ProjectData.animes) {
            if (anime.getTitle().contains(sortName)) {
                MenuEntry getTitles = new MenuEntry(anime.getTitle());
                delselectedNames.addEntryToList(getTitles);
            }
        }
        delselectedNames.addEntryToList(back);
        return delselectedNames;
    }

    public MenuView deleteAllMenu() {
        MenuView delall = new MenuView("Delete All");
        delall.setMenuTitle("\"Are you sure you want to delete all Anime(s)? \\n\\n\\t\\t/\\tYes\\t/\\tNo\\t/\"");
        for (Anime anime: ProjectData.animes) {
            MenuEntry getTitles = new MenuEntry(anime.getTitle());
            delall.addEntryToList(getTitles);
        }
        delall.addEntryToList(back);
        return delall;
    }

    public MenuView listMenu() {
        MenuView listAnime = new MenuView("List Anime");
        listAnime.setMenuTitle("Choose an option how to list your Anime(s):");
        MenuView listall = listallMenu();
        MenuView searchbygenre = listByGenreMenu();
        MenuView searchbyname = listSearchNameMenu();
        listAnime.addEntryToList(listall);
        listAnime.addEntryToList(searchbygenre);
        listAnime.addEntryToList(searchbyname);
        listAnime.addEntryToList(back);
        return listAnime;
    }

    public MenuView listallMenu() {
        MenuView listallAnimes = new MenuView("List all");
        listallAnimes.setMenuTitle("A list of the existing Animes:");
        for (Anime anime: ProjectData.animes) {
            MenuEntry getTitles = new MenuEntry(anime.getTitle());
            listallAnimes.addEntryToList(getTitles);
        }
        listallAnimes.addEntryToList(back);
        return listallAnimes;
    }

    public MenuView listByGenreMenu() {
        MenuView listbygenre = new MenuView("List by Genre");
        listbygenre.setMenuTitle("Select the Genre you want:");
        for (Genre genre: ProjectData.genres) {
            MenuEntry genreEntry = new MenuEntry(genre.getName());
            listbygenre.addEntryToList(genreEntry);
        }
        listbygenre.addEntryToList(back);
        return listbygenre;
    }

    public MenuView listSearchNameMenu() {
        MenuView listSearchByName = new MenuView("List by searched Name");
        listSearchByName.setMenuTitle("Type in the name of your Anime:");
        listSearchByName.addEntryToList(back);
        return listSearchByName;
    }

    public MenuView addSeriesMenu() {
        MenuView addSeries = new MenuView("Add Series");
        addSeries.setMenuTitle("Select an option below:");
        MenuView newseries = addSeriesNameMenu();
        MenuView addseasonstoexistinganime = addSeasonsMenu();
        addSeries.addEntryToList(newseries);
        addSeries.addEntryToList(addseasonstoexistinganime);
        addSeries.addEntryToList(back);
        return addSeries;
    }

    public MenuView addSeriesNameMenu() {
        MenuView addSeriesName = new MenuView("Add Series Name");
        addSeriesName.setMenuTitle("Type in the name of the Anime you want to add:");
        addSeriesName.addEntryToList(back);
        return addSeriesName;
    }

    public MenuView addSeasonsMenu() {
        MenuView addSeasons = new MenuView("Add Seasons");
        addSeasons.setMenuTitle("Select an option below:");
        MenuView addseason = addSeasonsNameMenu();
        MenuView done = episodeMenu();
        addSeasons.addEntryToList(addseason);
        addSeasons.addEntryToList(done);
        addSeasons.addEntryToList(back);
        return addSeasons;
    }

    public MenuView addSeasonsNameMenu() {
        MenuView addSeasonsName = new MenuView("Add Seasons Name");
        addSeasonsName.setMenuTitle("Type in the name of the Anime you want to add:");
        addSeasonsName.addEntryToList(back);
        return addSeasonsName;
    }

    public MenuView episodeMenu() {
        MenuView episodesMenu = new MenuView("Episode");
        episodesMenu.setMenuTitle("Do you want to add another Episode ?");
        MenuView yes = episodesMenu;
        MenuView no = mainMenu();
        episodesMenu.addEntryToList(yes);
        episodesMenu.addEntryToList(no);
        return episodesMenu;
    }

    public MenuView addSeasonToExistingSeries() {
        MenuView addSeasonToExistingAnime = new MenuView("Add Season to existing Anime");
        addSeasonToExistingAnime.setMenuTitle("Select an existing Anime you want to add a Season to:");
        for (Series serie: ProjectData.series) {
            MenuEntry getTitles = new MenuEntry(serie.getSeriesname());
            addSeasonToExistingAnime.addEntryToList(getTitles);
        }
        addSeasonToExistingAnime.addEntryToList(back);
        return addSeasonToExistingAnime;
    }

    public MenuView editMenu() {
        MenuView editMenu = new MenuView("Edit");
        editMenu.setMenuTitle("Select the Anime you want to edit:");
        MenuView anime = editAnimeMenu();
        MenuView series = editSeriesMenu();
        editMenu.addEntryToList(anime);
        editMenu.addEntryToList(series);
        editMenu.addEntryToList(back);
        return editMenu;
    }

    public MenuView editAnimeMenu() {
        MenuView editAnime = new MenuView("Edit Anime");
        editAnime.setMenuTitle("Select the Anime you want to edit:");
        for (Anime anime: ProjectData.animes) {
            MenuEntry getTitles = new MenuEntry(anime.getTitle()) {
                @Override
                public void run() {
                    editSelectMenu(anime).run();
                }
            };
            editAnime.addEntryToList(getTitles);
        }
        editAnime.addEntryToList(back);
        return editAnime;
    }

    public MenuView editSeriesMenu() {
        MenuView editSeries = new MenuView("Edit Series");
        editSeries.setMenuTitle("Select the Series you want to edit:");
        for (Series serie: ProjectData.series) {
            MenuEntry getTitles = new MenuEntry(serie.getSeriesname());
            editSeries.addEntryToList(getTitles);
        }
        editSeries.addEntryToList(back);
        return editSeries;
    }

    public MenuView editSelectMenu(Anime anime) {
        MenuView editSelect = new MenuView("Selection Edit");
        editSelect.setMenuTitle("Please select what you want to edit:");
        MenuEntry title = new MenuEntry("Title") {
            @Override
            public void run() {
                System.out.println("Type in the title of your Anime:");
                String title = InputCheck.readConsole();
                anime.setTitle(title);
            }
        };
        MenuEntry description = new MenuEntry("Description") {
            @Override
            public void run() {
                System.out.println("Type in the description of your Anime:");
                String description = InputCheck.readConsole();
                anime.setDescription(description);
            }
        };
        MenuView fsk = addFskMenu();
        MenuView genre = addGenreMenu(anime.getTitle(), ProjectData.genres);
        MenuView subtitle = addSubtitleMenu(anime.getTitle(), ProjectData.subtitles);
        MenuEntry rating = new MenuEntry("Edit Rating") {
            @Override
            public void run() {
                ratingController.addRating(anime);
            }
        };
        MenuView character = addCharacterMenu(anime.getTitle());
        editSelect.addEntryToList(title);
        editSelect.addEntryToList(description);
        editSelect.addEntryToList(fsk);
        editSelect.addEntryToList(genre);
        editSelect.addEntryToList(subtitle);
        editSelect.addEntryToList(rating);
        editSelect.addEntryToList(character);
        editSelect.addEntryToList(back);
        return editSelect;
    }
}