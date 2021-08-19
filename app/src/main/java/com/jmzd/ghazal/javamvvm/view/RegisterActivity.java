package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ActivityRegisterBinding;
import com.jmzd.ghazal.javamvvm.repostitry.Repostitry;
import com.jmzd.ghazal.javamvvm.utill.Set_Intent;
import com.jmzd.ghazal.javamvvm.viewModel.ViewModel_Register;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_register);
        ViewModel_Register vmodereg= ViewModelProviders.of(this).get(ViewModel_Register.class);
        binding.setDataReg(vmodereg);

        MutableLiveData<String> StrEmpty =vmodereg.StrEmpty;
        StrEmpty.observe(this,em->{
            Toast.makeText(this, em, Toast.LENGTH_SHORT).show();
        });

        MutableLiveData<Boolean> Bol_logincheck =vmodereg.Bol_logincheck;

        MutableLiveData<String> Userid =vmodereg.Userid;

        Bol_logincheck.observe(this,b->{
            if(b){
                Set_Intent.Set(RegisterActivity.this, LoginActivity.class);
            }
        });

        Userid.observe(this,id->{
            Repostitry.SetUser_id(RegisterActivity.this,id);
        });
    }
}
