package com.jmzd.ghazal.javamvvm.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jmzd.ghazal.javamvvm.model.Status;
import com.jmzd.ghazal.javamvvm.utill.WebService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ViewModel_Login extends ViewModel {
    public MutableLiveData<String> StrEmpty=new MutableLiveData<>();
    public MutableLiveData<Boolean> Bol_logincheck=new MutableLiveData<>();
    public MutableLiveData<String> Userid=new MutableLiveData<>();

    CompositeDisposable disposable=new CompositeDisposable();
    public  String mobile=null;
    public String pass=null;

    public void Click_Send_data(View view){
        if(mobile==null){
            StrEmpty.setValue("لطفا شماره موبایل را وارد کنید...");
        }
        else if(pass==null){
            StrEmpty.setValue("لطفا رمز عبور را وارد کنید...");

        }else {
           // Bol_logincheck.setValue(true);
            WebService web=new WebService();
            disposable.add(web.Sta_login(mobile,pass)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<Status>() {
                        @Override
                        public void onSuccess(Status status) {
                            if(status.getStatus().equals("ok")){
                                Bol_logincheck.setValue(true);
                                Userid.setValue(status.getUser_id());
                            }
                            else
                            {   Bol_logincheck.setValue(false);

                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Bol_logincheck.setValue(false);
                        }
                    }));
        }
    }

    @Override
    protected void onCleared() {
        disposable.clear();
        super.onCleared();
    }
}

