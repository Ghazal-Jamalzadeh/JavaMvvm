package com.jmzd.ghazal.javamvvm;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleObserver implements androidx.lifecycle.LifecycleObserver {
    private static final String TAG = "LifecycleObserver";
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public  void onCreate(){
        Log.d(TAG , "-> onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public  void onPause(){
        Log.d(TAG , "-> ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public  void onStop(){
        Log.d(TAG , "-> ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public  void onStart(){
        Log.d(TAG , "-> ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public  void onResume(){
        Log.d(TAG , "-> ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public  void onDestroy(){
        Log.d(TAG , "-> ON_DESTROY");
    }
}
