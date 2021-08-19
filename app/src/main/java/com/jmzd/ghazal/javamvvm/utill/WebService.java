package com.jmzd.ghazal.javamvvm.utill;

import com.jmzd.ghazal.javamvvm.model.Datamodel;
import com.jmzd.ghazal.javamvvm.model.Status;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {


    String baseurl="http://192.168.1.103/javamvvmapi/";
    Api api;
    public WebService(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api= retrofit.create(Api.class);
    }

    public Single<List<Datamodel>> listSingle(){
        return api.Listdatamodel();
    }

    public Single<Status> Sta_login(String m, String p){
        return api.singlestaus(m,p);
    }

    public Single<Status> Single_reg(String n,String m,String e,String p){
        return api.Single_register(n,m,e,p);
    }

}

//Retrofit provides a convenient builder for constructing our required object. It needs the base URL which is going to be used for every service call and a converter factory – which takes care of the parsing of data we're sending and also the responses we get.
//
//In this example, we're going to use the GsonConverterFactory, which is going to map our JSON data to the User class we defined earlier.
