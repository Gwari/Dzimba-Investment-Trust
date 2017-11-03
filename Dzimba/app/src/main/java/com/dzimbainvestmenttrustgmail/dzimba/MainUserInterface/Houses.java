package com.dzimbainvestmenttrustgmail.dzimba.MainUserInterface;

/**
 * Created by gwari on 10/7/2017.
 */


//To create instance of a house class, create a model class denoting the house properties like mHouseName, numOfBeds(Number of beds in the house)
// and cover image.
// So create a class named Album.java and add the below code

public class Houses {

    private String mHouseName;
    private String mCity;
    private int numOfBeds;
    private int thumbnail;

    public Houses() {}
//Create constructor for variables that will show up in the cardviews
    public Houses(String mHouseName, String mCity, int numOfBeds, int thumbnail) {
        this.mHouseName = mHouseName;
        this.mCity = mCity;
        this.numOfBeds = numOfBeds;
        this.thumbnail = thumbnail;
    }


    //Create getters and Setters
    public String getHouseName() {
        return mHouseName;
    }

    public void setHouseName(String houseName) {
        this.mHouseName = houseName;
    }


    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
