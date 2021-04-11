package com.example.tourplanner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class placeDetailsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String detail, imurl,  name,  offer,  price;

    private String mParam1;
    private String mParam2;

    public placeDetailsFragment() {
        // Required empty public constructor
    }

    public placeDetailsFragment(String detail,String imurl, String name, String offer, String price) {
        this.detail = detail;
        this.imurl = imurl;
        this.name = name;
        this.offer = offer;
        this.price = price;
    }


    public static placeDetailsFragment newInstance(String param1, String param2) {
        placeDetailsFragment fragment = new placeDetailsFragment();
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
        View view =  inflater.inflate(R.layout.fragment_place_details, container, false);

        ImageView  imHolder = view.findViewById(R.id.imHolder);
        TextView nameHolder = view.findViewById(R.id.nameHolder);
        TextView  priceHolder = view.findViewById(R.id.priceHolder);
        TextView  detailHolder = view.findViewById(R.id.detailHolder);
        TextView offerHolder = view.findViewById(R.id.offerHolder);

        nameHolder.setText(name);
        priceHolder.setText(price+" tk");
        detailHolder.setText( detail);
        offerHolder.setText("Including:" +offer);
        Glide.with(getContext()).load(imurl).into(imHolder);

        return view;
    }

    public void onBackPressed(){
        AppCompatActivity myActivity = (AppCompatActivity)getContext();
        myActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerId, new placesFragment()).addToBackStack(null).commit();
    }
}