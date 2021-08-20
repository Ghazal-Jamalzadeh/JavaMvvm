package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.workManager.WManager;

import java.util.concurrent.TimeUnit;

public class WorkerActivity extends AppCompatActivity {

    WorkManager workManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker); // برای اعمال انواع محدودیت ها روی work manager
        Data.Builder data=new Data.Builder().putString("manager","downoadfile");
        Constraints constraints=new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();// به جز محدودیت setRequiredNetworkType محدودیت های دیگری از جمله بر اساس درصد باتری و... هم می توان اعمال کرد.
        PeriodicWorkRequest request=new PeriodicWorkRequest.Builder(WManager.class,1, TimeUnit.MINUTES).setInputData(data.build()).setConstraints(constraints).build();// نوع دوم ریکوئست هاست
        workManager = WorkManager.getInstance(this);
        workManager.enqueue(request);
        workManager.getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                if(workInfo!=null){
                    if(workInfo.getState()==WorkInfo.State.RUNNING){
                        workManager.cancelWorkById(request.getId());
                    }
                }
            }
            // خروجی نوتیفیکشنی که به محض متصل شدن به اینترنت روی گوشی کاربر ایجاد می شود و هر یک دقیقه تکرار می شود و می توان به صورت آپشنال دیتایی را هم به آن pus stirng  و الحاق کرد. می توان این دیتا را از api و ... گرفت

        });
    }
}