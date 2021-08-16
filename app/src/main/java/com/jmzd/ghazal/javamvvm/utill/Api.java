package com.jmzd.ghazal.javamvvm.utill;

import com.jmzd.ghazal.javamvvm.model.Datamodel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("index.php")
    Single<List<Datamodel>> Listdatamodel();
}
    //میتوانستیم به جای single از observable استفاده کنیم و فرقی نمی کرد.