package com.jmzd.ghazal.javamvvm.roomDb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = UserData.class,version = 1) // وقتی این انوتیشن را قرار می دهیم این کلاس تبدیل به دیتابیس می شود.
public abstract class AppDatabaseRoom extends RoomDatabase { // چون خود RoomDatabase از نوع abstract اسست ما هم باید این کلاس را از نوع Abstract تعریف کنیم در غیر این صورت ارور می دهد.
    public abstract UserDao userdao();

}
