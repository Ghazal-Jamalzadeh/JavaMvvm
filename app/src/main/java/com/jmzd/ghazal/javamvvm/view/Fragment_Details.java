package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.jmzd.ghazal.javamvvm.R;
import com.jmzd.ghazal.javamvvm.databinding.FragmentDetailsBinding;
import com.jmzd.ghazal.javamvvm.model.DataShowMore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Details extends Fragment {
    TextView tvBundle;
    FragmentDetailsBinding binding ;
    ImageView ImBack ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Details.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Details newInstance(String param1, String param2) {
        Fragment_Details fragment = new Fragment_Details();
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
       // View view = inflater.inflate(R.layout.fragment__details, container, false);
//        tvBundle = view.findViewById(R.id.tvBundle);
//        tvBundle.setText(getArguments().getString("title"));
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment__details,container,false);
        binding.setDataShow(new DataShowMore(getArguments().getString("title"),getArguments().getString("date"),getArguments().getString("view"),getArguments().getString("des")));
        binding.setImageurl(getArguments().getString("imageurl"));
        ImBack=binding.ImBack;
        ImBack.setOnClickListener(view -> {
            Navigation.findNavController(ImBack).popBackStack();
        });
        return  binding.getRoot();
       // return  view ;
    }
}