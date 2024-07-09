package com.product.prod.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private int rating;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String comment;

    public Review () {
        
    }

    public Review (int rating, String comment) {
        
        setRating(rating);
        setComment(comment);
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review: "
        + "rating: " + getRating()
        + " comment: " +getComment();
        
    }
}
