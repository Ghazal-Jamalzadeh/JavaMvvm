package com.jmzd.ghazal.javamvvm.utill;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AdapterBinding {
    @BindingAdapter("image")
    public static void Image(ImageView view, String url){ // اگر AdapterBinding هایی که تعریف می کنید از نوع static نباشند ارور می گیرید.
        Glide.with(view).load(url).into(view);
    }
}
