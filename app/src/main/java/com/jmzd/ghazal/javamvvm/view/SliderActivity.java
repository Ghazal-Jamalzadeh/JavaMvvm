package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ActivitySliderBinding;
import com.jmzd.ghazal.javamvvm.model.ModelViewPager;
import com.jmzd.ghazal.javamvvm.view.adapter.Adapeter_Pager;

import java.util.ArrayList;
import java.util.List;

public class SliderActivity extends AppCompatActivity {
    ActivitySliderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_slider);
        binding.setHandler(this);
        binding.setFrmManager(getSupportFragmentManager());
    }

    @BindingAdapter("bind:handler")
    public static void bindViepaerview(final ViewPager viewPager, final SliderActivity slider){
        List<ModelViewPager> model_viewpagers=new ArrayList<>();
        model_viewpagers.add(new ModelViewPager("دوره دیجی کالا","https://homeandroid.ir/wp-content/uploads/2018/08/digikala-application-android-studio-cover.jpg"));
        model_viewpagers.add(new ModelViewPager("دوره mvvm","https://homeandroid.ir/wp-content/uploads/2020/04/mvvm-java-android-studio-small-cover.jpg"));
        model_viewpagers.add(new ModelViewPager("دوره کاتلین","https://homeandroid.ir/wp-content/uploads/2019/04/kotlin-android-cover_home_page.jpg"));
        Adapeter_Pager adapter=new Adapeter_Pager(model_viewpagers);
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("bind:pager")
    public static void bindtablayout(final TabLayout tabLayout, final ViewPager viewPager){ // مقداردهی tab layout
        tabLayout.setupWithViewPager(viewPager,true);
    }
}
