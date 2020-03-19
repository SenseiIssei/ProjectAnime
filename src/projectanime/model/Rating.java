package projectanime.model;

import projectanime.controller.ProjectData;

public class Rating {
    private String review;
    private int rating;

    /**
     * Constructor
     *
     * @param rating
     * @param review
     */
    public Rating(int rating, String review) {
        this.review = review;
        this.rating = rating;
    }

    /**
     * Gets the List of Ratings
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     * Adds a Rating to the List
     *
     * @param rating
     */
    public void addRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }
    /**
     * Sets the Review
     *
     * @param review
     */
    public void setReview(String review) {
        this.review += review;
    }

}