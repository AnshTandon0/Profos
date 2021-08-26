package com.example.profosassignment.classes;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

    private String id = "";
    private int price = 0;
    private int ratingStars = 0;
    private String details = "";
    private String name = "";
    private List<String> imageUrl;
    private List<Review> Reviews;

    public Item ()
    {

    }

    public Item(String id, int price, int ratingStars, String details, String name, List<String> imageUrl, List<Review> reviews) {
        this.id = id;
        this.price = price;
        this.ratingStars = ratingStars;
        this.details = details;
        this.name = name;
        this.imageUrl = imageUrl;
        Reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(List<Review> reviews) {
        Reviews = reviews;
    }
}
