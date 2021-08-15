package com.jmzd.ghazal.javamvvm.viewModel;

import androidx.lifecycle.ViewModel;

import java.util.Random;

// در صورت ارث بری از AndroidViewModel به جای ViewModel باید این constructor فراخوانی شود که در آن کلمه application همان context را برمی گرداند.
public class ViewModel_Random extends ViewModel{
    private static final String TAG = "ViewModel_Random";
    private  String checkNumber;

    public String check() {
        if (checkNumber == null) {
            getNumberRandom();
        }
        return checkNumber ;
    }

    public String getNumberRandom() {
        Random random = new Random();
        checkNumber = String.valueOf(random.nextInt(20 - 4 + 10));
        return checkNumber;
    }

}
