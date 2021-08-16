package com.jmzd.ghazal.javamvvm.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jmzd.ghazal.javamvvm.model.Datamodel;
import com.jmzd.ghazal.javamvvm.utill.WebService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ViewModel_ListPost extends ViewModel {

    private MutableLiveData<List<Datamodel>> listMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_looging=new MutableLiveData<>();
    //این در واقع یک ناظر هستت بر کاارهای ما و زمانی که کارهای مورد نظر ما انجام شد و observer را دریافت کردیم و LiveData ما را بر میگرداند کارهایی را انجام میدهد. و بعد در متد onCleared آن را پاک میکنیم. یعنی یه جور ماظر یک بار مصرف هست.
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MutableLiveData<List<Datamodel>> mutableLiveData(){
        liveData_looging.setValue(true);
        WebService web=new WebService();
        compositeDisposable.add(web.listSingle()
                .subscribeOn(Schedulers.newThread())//  از طریق یک ترد مجزا داده ها را دریافت می کنیم. و به این طریق از بلاک شدن ترد اصلی main در ui جلوگیری می کنیم.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Datamodel>>() { // یک single obsserver باید برگردانده شود.
                    @Override// response
                    public void onSuccess(List<Datamodel> datamodels) {
                        liveData_looging.setValue(false);
                        listMutableLiveData.setValue(datamodels); // اینجا liveData را با datamodel مقدار دهی میکنیم
                    }
                    @Override
                    public void onError(Throwable e) {
                        liveData_looging.setValue(false);
                    }
                })
        );
        return listMutableLiveData;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}

