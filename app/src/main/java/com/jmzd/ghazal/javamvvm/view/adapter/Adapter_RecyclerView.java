package com.jmzd.ghazal.javamvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.ItemsBinding;
import com.jmzd.ghazal.javamvvm.model.Datamodel;

import java.util.List;

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.viewhodler> {
    List<Datamodel> list;
   // Click_items click_items;
    public Adapter_RecyclerView(List<Datamodel> list){ // , Click_items click_items
        this.list=list;
       // this.click_items=click_items;
    }
    @NonNull
    @Override
    public viewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // data binding
        return new viewhodler(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items,parent,false));
    }



    @Override
    public void onBindViewHolder(@NonNull viewhodler holder, int position) {
        Datamodel datamodel=list.get(position);
        holder.binding.setData(datamodel); // we set the data in xml
//        holder.itemView.setOnClickListener(view -> {
//            click_items.Clickitems(datamodel);
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewhodler extends RecyclerView.ViewHolder {
        ItemsBinding binding;
        public viewhodler(@NonNull ItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
