package com.jmzd.ghazal.javamvvm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
//این قسمت را میشد با  همان دیتا مدل اصلی هم پیاده سازی کرد ولی جداسازی آن بهتر است...
public class DataShowMore {
    String title;
    String date;
    String view;
    String des;
    public DataShowMore(String title,String date,String view,String des){
        this.title=title;
        this.date=date;
        this.view=view;
        this.des=des;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getView() {
        return view;
    }

    public String getDes() {
        return des;
    }

    @BindingAdapter("imageurl")
    public static void Getimageload(ImageView view, String imageurl){
        Glide.with(view).load(imageurl).into(view);
    }
}
