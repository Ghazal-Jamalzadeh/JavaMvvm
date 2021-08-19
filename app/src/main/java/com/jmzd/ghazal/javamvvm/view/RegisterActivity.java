package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ActivityRegisterBinding;
import com.jmzd.ghazal.javamvvm.viewModel.ViewModel_Register;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_register);
        ViewModel_Register vmodereg= ViewModelProviders.of(this).get(ViewModel_Register.class);
        binding.setDataReg(vmodereg);

//        MutableLiveData<String> StrEmpty =vmodereg.StrEmpty;
//        StrEmpty.observe(this,em->{
//            Toast.makeText(this, em, Toast.LENGTH_SHORT).show();
//        });
//
//        MutableLiveData<Boolean> Bol_logincheck =vmodereg.Bol_logincheck;
//
//        MutableLiveData<String> Userid =vmodereg.Userid;
//
//        Bol_logincheck.observe(this,b->{
//            if(b){
//                SetIntent.Set(Register_Acitivty.this, Acitivty_Login.class);
//            }
//        });
//
//        Userid.observe(this,id->{
//            Repositry.SetUser_id(Register_Acitivty.this,id);
//        });
    }
}
