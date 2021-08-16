package com.jmzd.ghazal.javamvvm.model;


import com.google.gson.annotations.SerializedName;

public class Datamodel {

    @SerializedName("id")
    String id;
    @SerializedName("title")
    String  title;
    @SerializedName("imageurl")
    String imageurl;
    @SerializedName("date")
    String date;
    @SerializedName("view")
    String view;
    @SerializedName("des")
    String des;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getDate() {
        return date;
    }

    public String getView() {
        return view;
    }

    public String getDes() {
        return des;
    }
}

