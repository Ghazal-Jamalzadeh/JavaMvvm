package com.jmzd.ghazal.javamvvm.repostitry;

import android.content.Context;
import android.content.SharedPreferences;

public class Repostitry {
    public static void SetUser_id(Context context, String id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("user",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("user_id",id);
        editor.apply(); // دیگه commit منسوخ شده
    }
    public static String GetUser_id(Context context,String id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("user",0);
        String userid=sharedPreferences.getString("user_id",null);
        return userid;
    }

}
