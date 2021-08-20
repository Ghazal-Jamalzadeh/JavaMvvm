package com.jmzd.ghazal.javamvvm.workManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.jmzd.ghazal.javamvvm.R;

import org.jetbrains.annotations.NotNull;

public class WManager extends Worker {


    public WManager(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) { // automatic
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() { //این متد می تواند ارور یا success برگرداند.
        Data data=getInputData();
        Shownotificationmanager("Start downoad file...",data.getString("manager"));
        return Result.success();
    }

    void Shownotificationmanager(String title,String des){ // برای نمایش نوتیفیکیشن در اندرویدهای ۸ به بعد نیاز به تعریف notification channel داریم.
        NotificationManager notificationManager=(NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        String channelid="homeandroidid";
        if(Build.VERSION.SDK_INT>=26){
            NotificationChannel channel=new NotificationChannel(channelid,"home",NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder notificationCompat=new
                NotificationCompat.Builder(getApplicationContext(),channelid)
                .setContentText(des)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(1,notificationCompat.build());

    }
}
