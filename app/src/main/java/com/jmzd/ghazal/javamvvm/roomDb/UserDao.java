package com.jmzd.ghazal.javamvvm.roomDb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao // زمانی که این انوتسشن را اضافه کنیم این اینترفیس تبدیل به Dao می شود
public interface UserDao {

    @Query("select * from tbl_user ")
    List<UserData> Getlist();

    @Insert
    void Insertdata(UserData user_data);

}