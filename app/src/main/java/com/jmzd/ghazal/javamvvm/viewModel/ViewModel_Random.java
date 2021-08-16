package com.jmzd.ghazal.javamvvm.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

// در صورت ارث بری از AndroidViewModel به جای ViewModel باید این constructor فراخوانی شود که در آن کلمه application همان context را برمی گرداند.
public class ViewModel_Random extends ViewModel {
    private  final String TAG = "ViewModel_Random";
    private  MutableLiveData<String> checkNumber;

    public  MutableLiveData<String> check() {
        if (checkNumber == null) {
            checkNumber = new MutableLiveData<>();
            getNumberRandom();
        }
        return checkNumber;
    }

    public MutableLiveData<String> getNumberRandom() {
        Random random = new Random();
        checkNumber.setValue(String.valueOf(random.nextInt(20 - 4 + 10)));
        return checkNumber;
    }

    public void clickButton(View view) {
        getNumberRandom();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
