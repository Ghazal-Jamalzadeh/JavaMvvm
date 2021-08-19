package com.jmzd.ghazal.javamvvm.utill;

import android.content.Context;
import android.content.Intent;

public class Set_Intent {
    public static void Set(Context context, Class cls){
        context.startActivity(new Intent(context,cls));
    }
}
