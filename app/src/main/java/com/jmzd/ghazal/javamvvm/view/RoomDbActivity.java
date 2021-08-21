package com.jmzd.ghazal.javamvvm.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.roomDb.AppDatabaseRoom;
import com.jmzd.ghazal.javamvvm.roomDb.UserData;

import java.util.List;

public class RoomDbActivity extends AppCompatActivity {
    private static final String TAG = "RoomDbActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);
        // روش اول برای بلاک نشدن در main thread
//        AppDatabaseRoom db = Room.databaseBuilder(this , AppDatabaseRoom.class , "homeDb" ).allowMainThreadQueries().build(); // اگر allowMainThreadQueries()  را نزنیم main thread در این صورت بلاک می کند thread مربوط به db  را و ارور می گیریم در اجرا
//        UserData user = new UserData();
//        user.name = "ghazal";
//        user.family = "jamalzadeh";
//        db.userdao().Insertdata(user);

        // روش دوم برای بلاک نشدن در main thread
        AsyncTask.execute( () -> {
                    AppDatabaseRoom db = Room.databaseBuilder(this , AppDatabaseRoom.class , "homeDb" ).build();                    UserData user = new UserData();
                    user.name = "ghazal";
                    user.family = "jamalzadeh";
                    db.userdao().Insertdata(user);

                    List<UserData> userDataInfo = db.userdao().Getlist();
                    Log.d(TAG , userDataInfo.get(0).name + " " + userDataInfo.get(0).family); // /RoomDbActivity: ghazal jamalzadeh
                }
                );



    }
}