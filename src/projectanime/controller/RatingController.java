package projectanime.controller;

import projectanime.model.Anime;
import projectanime.model.Rating;
import projectanime.util.InputCheck;

public class RatingController {


    public Anime addRating(Anime anime) {
        Rating rating = null;
        System.out.println("Rate your Anime from 1 - 5 Stars:");
        int ratingString = InputCheck.readInt();
        if (ratingString > 0 && ratingString < 6) {
            System.out.println("Review your Rating (else leave it empty)");
            String review = InputCheck.readConsole();
            rating = new Rating(ratingString, review);
            anime.setRating(rating);
        } else {
            System.out.println("Try Again!");
        }
        return anime;
    }
}
