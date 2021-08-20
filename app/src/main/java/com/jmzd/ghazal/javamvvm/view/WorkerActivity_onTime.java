package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.workManager.WManager;

public class WorkerActivity_onTime extends AppCompatActivity {
    WorkManager workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_on_time);
        // دو نوع ریکوئست می توانیم داشته باشیم.
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(WManager.class).build();
        workManager = WorkManager.getInstance(this);
        workManager.enqueue(request);
        workManager.getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null) {
                            if (workInfo.getState() == WorkInfo.State.RUNNING) { // به محض اجرای برنامه نوتیفیکیشن و Toast تولید می شود.
                                Toast.makeText(WorkerActivity_onTime.this, "running", Toast.LENGTH_SHORT).show();
                                // Run -> Worker result SUCCESS for Work [ id=2931a7fb-007b-469c-a2b1-b345d03d0f02, tags={ com.jmzd.ghazal.javamvvm.workManager.WManager }
                                // همان طور که در بالا می بینید هر ریکوئست یک id دارد که بر اساس آن می توان آنها را مدیریت و کنسل و.. کرد.
                                workManager.cancelWorkById(request.getId());//یا id  را مستقیما تایپ کنیم حتی

                            }
                        }
                    }
                }
        );

    }
}
