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

//Gson @SerializedName
//        In this Gson @SerializedName example, learn to change the name of fields between json and java objects while serialization and deserialization process.
//
//        1. @SerializedName
//By default, we assume the Java model class and the JSON will exactly same field names. But sometimes, it is not the case and certain names differ. Now we have to map the someName in json to someOtherName in Java class. This is where @SerializedName annotation helps.
//
//@SerializedName annotation indicates the annotated member should be serialized to JSON with the provided name value as its field name. This annotation will override any FieldNamingPolicy, including the default field naming policy, that may have been using the GsonBuilder class.
//
//        Note that the value you specify in this annotation must be a valid JSON field name.


//Java class example:
//
//public class Person {
//
//    @SerializedName("name")
//    private String personName;
//
//    @SerializedName("bd")
//    private String birthDate;

//}
//This class has two fields that represent the person name and birth date of a person. These fields are annotated with the @SerializedName annotation. The parameter (value) of this annotation is the name to be used when serialising and deserialising objects. For example, the Java field personName is represented as name in JSON.