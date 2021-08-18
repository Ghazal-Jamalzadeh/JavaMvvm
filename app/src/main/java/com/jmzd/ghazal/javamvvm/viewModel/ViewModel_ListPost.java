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
    public MutableLiveData<Boolean> liveData_looging=new MutableLiveData<>();// progress wheel
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

//Mutable Live Data
//LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

//The advantages of using LiveData:
//1-Ensures your UI matches your data state
//2-No memory leaks
//3-No crashes due to stopped activities
//4-No more manual lifecycle handling
//5-Always up to date data
//6-Proper configuration changes
//If an activity or fragment is recreated due to a configuration change, like device rotation, it immediately receives the latest available data.
//7-Sharing resources

//Work with LiveData objects
//Follow these steps to work with LiveData objects:
//Create an instance of LiveData to hold a certain type of data. This is usually done within your ViewModel class.
//Create an Observer object that defines the onChanged() method, which controls what happens when the LiveData object's held data changes. You usually create an Observer object in a UI controller, such as an activity or fragment.
//Attach the Observer object to the LiveData object using the observe() method. The observe() method takes a LifecycleOwner object. This subscribes the Observer object to the LiveData object so that it is notified of changes. You usually attach the Observer object in a UI controller, such as an activity or fragment.

//LiveData which publicly exposes setValue(T) and postValue(T) method.
//Public methods
//void	postValue(T value)
//Posts a task to a main thread to set the given value.
//
//void	setValue(T value)
//Sets the value.

//==================================================
//CompositeDisposable is just a class to keep all your disposables in the same place to you can dispose all of then at once. Like:
//Composite disposable makes disposing (think cancelling early easier). Say you have an activity that has multiple api calls happening at once:
//
//var disposable = api.call1(arg1, arg2).subscribe(...)
//var disposable2 = api.call2(arg1).subscribe(...)
//var disposable3 = api.call3().subscribe()
//If you need to prematurely dispose (e.g. the user navigating away from the activity) then you'd need to do this:
//
//disposable.dispose()
//disposable2.dispose()
//disposable3.dispose()
//If you instead use a CompositeDisposable you can store all of the disposables in it. Like so:
//
//val composite = CompositeDisposable()
//composite.add(api.call1(arg1, arg2).subscribe(...))
//composite.add(api.call2(arg1).subscribe(...))
//composite.add(api.call3().subscribe())
//And then you can make one dispose call instead:
//
//composite.dispose()

//
