package com.jmzd.ghazal.javamvvm.model;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("status")
    String status;

    @SerializedName("user_id")
    String user_id;

    public String getStatus() {
        return status;
    }

    public String getUser_id() { //جای token کار را انجام میدهدد
        return user_id;
    }
}
// زمانی که داده را با متد پست به فایل login.php میفرستیم خروجی را به شکل زیر دریافت می کنیم.
//{"status":"error"}
//در صورتی که ok باشد یک user_id هم بر میگرداند.
