package com.jmzd.ghazal.javamvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ItemsViewPagerBinding;
import com.jmzd.ghazal.javamvvm.model.ModelViewPager;

import java.util.List;

public class Adapeter_Pager extends PagerAdapter {
    ItemsViewPagerBinding binding;
    List<ModelViewPager> list;
    public Adapeter_Pager(List<ModelViewPager> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.items_view_pager,container,false);
        binding.setData(list.get(position));
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
