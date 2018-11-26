package com.auction.asawari;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class AuctionObject implements Serializable {

    private String name ;
    private String description;
    private String MinPrice;
    private String startDate ;
    private String startTime;
    private String CreatedBy;
    private String Lastbid="placeholder";
    private String completed="0";



    public AuctionObject()  {
    }

    public AuctionObject(String name, String description, String minPrice, String startDate, String startTime, String createdBy) {
        this.name = name;
        this.description = description;
        MinPrice = minPrice;
        this.startDate = startDate;
        this.startTime = startTime;
        CreatedBy = createdBy;
    }

    @Override
    public String toString() {
        return "AuctionObject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", MinPrice='" + MinPrice + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", CreatedBy='" + CreatedBy + '\'' +
                '}';
    }

    public String getLastbid() {
        return Lastbid;
    }

    public void setLastbid(String lastbid) {
        Lastbid = lastbid;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
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

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}
