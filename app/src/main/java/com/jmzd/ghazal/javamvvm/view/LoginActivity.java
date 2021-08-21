package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ActivityLoginBinding;
import com.jmzd.ghazal.javamvvm.viewModel.ViewModel_Login;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        ViewModel_Login viewmodel_login=  ViewModelProviders.of(this).get(ViewModel_Login.class);
        binding.setDataLogin(viewmodel_login);

        MutableLiveData<String> str=viewmodel_login.StrEmpty;
        MutableLiveData<Boolean> Checklogin=viewmodel_login.Bol_logincheck;

        str.observe(this,strcheck->{ // میشد با new Observer فراخوانی کرد ک یک string بر می گرداند یا می شود به این شکل به لامبدا نوشت
            Toast.makeText(this, strcheck, Toast.LENGTH_SHORT).show();
        });

        Checklogin.observe(this,check->{
            if(check){
                Toast.makeText(this, "رمز عبور صحیح ست", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "رمز عبور اشتباه ست دوباره تلاش کنید..", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
