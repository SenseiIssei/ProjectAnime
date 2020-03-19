package projectanime.controller;

import projectanime.model.Episode;
import projectanime.model.Season;
import projectanime.model.Series;
import projectanime.util.InputCheck;

import java.util.ArrayList;
import java.util.List;

public class SeriesController {

    public void setSeriesTitle(Series series) {
        String name = InputCheck.readConsole();
        series.setSeriesname(name);
    }

    public String getSeriesTitle(Series series) {
        return series.getSeriesname();
    }

    public void setSeasonTitle(Season season) {
        String name = InputCheck.readConsole();
        season.setSeasonName(name);
    }

    public String getSeasonTitle(Season season) {
        return season.getSeasonName();
    }

    public List<Series> getSeriesList() {
        return ProjectData.series;
    }

    public List<String> getSeriesTitles() {
        List<String> seriesTitles = new ArrayList<>();
        for (Series series: getSeriesList()) {
            seriesTitles.add(series.getSeriesname());
        }
        return seriesTitles;
    }
}
//
//    public void createSeries() {
//        boolean seasonsloop = true;
//        boolean episodeloop = true;
//        Series series = new Series();
//        Season season = new Season();
//        Episode episode = new Episode();
//        fill.addSeriesMenu();
//        String selection = InputCheck.readConsole();
//        if (selection.equals("1")) {
//            fill.addSeriesNameMenu();
//            setSeriesTitle(series);
//            while (seasonsloop) {
//                fill.addSeasonsMenu();
//                String seasonsselection = InputCheck.readConsole();
//                if (seasonsselection.equals("1")) {
//                    fill.addSeasonsNameMenu();
//                    setSeasonTitle(season);
//                } else if (seasonsselection.equals("2")) {
//                    seasonsloop = false;
//                    while (episodeloop) {
//                        universalCode.createAnime(episode);
//                        fill.episodeMenu();
//                        String anotherepisodestring = InputCheck.readConsole();
//                        if (anotherepisodestring.equals("1")) {
//                            season.addEpisode(episode);
//                        } else if (anotherepisodestring.equals("2")) {
//                            episodeloop = false;
//                            series.addSeason(season);
//                        }
//                    }
//                }
//            }
//        } else if (selection.equals("2")) {
//            fill.addSeasonToExistingSeries(this);
//            String seriesselection = InputCheck.readConsole();
//        }
//    }
//}