package com.example.happytailapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ImageSlider homeBanner;

    ArrayList<SlideModel> homeImages = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeBanner = view.findViewById(R.id.homeBanner);

        homeImages.add(new SlideModel(R.drawable.home_card1, ScaleTypes.FIT));
        homeImages.add(new SlideModel(R.drawable.home_card2, ScaleTypes.FIT));
        homeImages.add(new SlideModel(R.drawable.home_card3, ScaleTypes.FIT));

        homeBanner.setImageList(homeImages, ScaleTypes.FIT);

        return view;
    }
}