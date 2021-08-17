package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jmzd.ghazal.javamvvm.LifecycleObserver;
import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ActivityMainBinding;
import com.jmzd.ghazal.javamvvm.viewModel.ViewModel_Random;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    LifecycleObserver lifecycleObserver ;
    ViewModel_Random viewModel_random ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

        lifecycleObserver = new LifecycleObserver();
        lifecycleObserver.onCreate();

        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this , R.layout.activity_main);

       // viewModel_random = new ViewModel_Random(); -> classic way -> data lost
        viewModel_random = ViewModelProviders.of(this).get(ViewModel_Random.class);
//        Log.d(TAG , viewModel_random.check());

        activityMainBinding.setViewModel(viewModel_random); // name attribute in xml file = setViewmode

        MutableLiveData<String> observer = viewModel_random.check();
        observer.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG , "onChanged: " + s );
                viewModel_random.check();
            }
        });

    }

    //Activity LIfe Cycle
    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleObserver.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleObserver.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleObserver.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleObserver.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleObserver.onResume();
    }
}