package com.jmzd.ghazal.javamvvm.utill;

import com.jmzd.ghazal.javamvvm.model.Datamodel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("index.php")
    Single<List<Datamodel>> Listdatamodel();
}
  //  The @GET annotation tells the client which HTTP method to use and on which resource, so for example, by providing a base URL of “https://api.github.com” it will send the request to “https://api.github.com/users”.
//میتوانستیم به جای single از observable استفاده کنیم و فرقی نمی کرد.
//Observer is a behavioral design pattern that allows some objects to notify other objects about changes in their state.
//RxJava (and its derivatives like RxGroovy & RxScala) has developed an Observable variant called “Single.”
//
//A Single is something like an Observable, but instead of emitting a series of values — anywhere from none at all to an infinite number — it always either emits one value or an error notification.
//
//For this reason, instead of subscribing to a Single with the three methods you use to respond to notifications from an Observable (onNext, onError, and onCompleted), you only use two methods to subscribe:
//
//onSuccess
//a Single passes this method the sole item that the Single emits
//onError
//a Single passes this method the Throwable that caused the Single to be unable to emit an item
//A Single will call only one of these methods, and will only call it once. Upon calling either method, the Single terminates and the subscription to it ends.