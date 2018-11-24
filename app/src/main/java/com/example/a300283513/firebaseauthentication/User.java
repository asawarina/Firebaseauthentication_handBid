package com.example.a300283513.firebaseauthentication;

public class User {

    private   String name ;
    private String description;
    private String MinPrice;
    private String startDate ;
    private String startTime;

    public User() {
    }

    public User(String name, String description, String minPrice, String startDate, String startTime) {
        this.name = name;
        this.description = description;
       this.MinPrice = minPrice;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(String minPrice) {
        MinPrice = minPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
