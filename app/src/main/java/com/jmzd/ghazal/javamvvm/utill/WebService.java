package com.jmzd.ghazal.javamvvm.utill;

import com.jmzd.ghazal.javamvvm.model.Datamodel;

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
}
