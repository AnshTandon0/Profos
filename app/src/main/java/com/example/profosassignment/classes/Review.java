package com.example.profosassignment.classes;

import java.io.Serializable;

public class Review implements Serializable {

    private String customerName = "";
    private String ratingStars = "";
    private String Date = "";

    public Review ()
    {

    }

    public Review(String customerName, String ratingStars, String date) {
        this.customerName = customerName;
        this.ratingStars = ratingStars;
        Date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(String ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
