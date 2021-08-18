package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.FragmentRecyclerViewBinding;
import com.jmzd.ghazal.javamvvm.model.Datamodel;
import com.jmzd.ghazal.javamvvm.utill.Click_item;
import com.jmzd.ghazal.javamvvm.view.adapter.Adapter_RecyclerView;
import com.jmzd.ghazal.javamvvm.viewModel.ViewModel_ListPost;
import com.pnikosis.materialishprogress.ProgressWheel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_RecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_RecyclerView extends Fragment implements Click_item {
    RecyclerView recyclerView ;
    ProgressWheel progress_wheel;
    FragmentRecyclerViewBinding binding; //برای فعال شدن ویو بایندینگ کافی است layout اصلی در فایل xml  را درون یک تگ <layout> قرار دهیم.

    private static final String TAG = "Fragment_RecyclerView";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_RecyclerView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_RecyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_RecyclerView newInstance(String param1, String param2) {
        Fragment_RecyclerView fragment = new Fragment_RecyclerView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment__recycler_view, container, false); // old way
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment__recycler_view,container,false);
        //recyclerView = view.findViewById(R.id.recyclerview);// old way
        recyclerView = binding.recyclerview;
        progress_wheel=binding.progressWheel;
        //return  view ; // old way
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModel_ListPost viewmodel_listpost= ViewModelProviders.of(this).get(ViewModel_ListPost.class);
        MutableLiveData<List<Datamodel>> listMutableLiveData=viewmodel_listpost.mutableLiveData();
        listMutableLiveData.observe(getActivity(), new Observer<List<Datamodel>>() {
            @Override
            public void onChanged(List<Datamodel> datamodels) {

                for (int i = 0; i <datamodels.size() ; i++) {
                    Log.d(TAG , datamodels.get(i).getTitle());
                    Log.d(TAG , datamodels.get(i).getDes());
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                Adapter_RecyclerView adapter=new Adapter_RecyclerView(datamodels,Fragment_RecyclerView.this::Clickitems);//قبلا this کافی بود ولی در mvvm  به این شکل می نویسسم
                recyclerView.setAdapter(adapter);
            }
        });
        viewmodel_listpost.liveData_looging.observe(getActivity(), new Observer<Boolean>() { // progress wheel
            @Override
            public void onChanged(Boolean aBoolean) {
                progress_wheel.setVisibility(View.GONE);
            }
        });
    }


    @Override
    public void Clickitems(Datamodel datamodel) {
        Bundle bundle = new Bundle();
        bundle.putString("id",datamodel.getId()); // می شود فقط id را فرستاد و بقیه موارد را بر اساس id در سمت دیگر دریافت کرد.
        bundle.putString("title",datamodel.getTitle());
        bundle.putString("imageurl",datamodel.getImageurl());
        bundle.putString("view",datamodel.getView());
        bundle.putString("date",datamodel.getDate());
        bundle.putString("des",datamodel.getDes());
        Navigation.findNavController(recyclerView).navigate(R.id.action_fragment_RecyclerView2_to_fragment_Details2,bundle);
    }
}