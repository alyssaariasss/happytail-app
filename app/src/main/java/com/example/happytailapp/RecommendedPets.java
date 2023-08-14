package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.happytailapp.databinding.ActivityRecommendedPetsBinding;

import java.util.ArrayList;

public class RecommendedPets extends AppCompatActivity {
    Button profileBtn;
    RecyclerView recoPetsView;

    ActivityRecommendedPetsBinding binding;

    GenerateRecommendedPets[] petsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecommendedPetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profileBtn = findViewById(R.id.profileButton);
        recoPetsView = findViewById(R.id.recommendedPetsView);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecommendedPets.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.pets:
                    replaceFragment(new PetsFragment());
                    break;
                case R.id.shelter:
                    replaceFragment(new SheltersFragment());
                    break;
                case R.id.blog:
                    replaceFragment(new BlogsFragment());
                    break;
            }

            return true;
        });

        displayPets();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void displayPets() {
        petsArrayList = new GenerateRecommendedPets[] {
                new GenerateRecommendedPets("Young", "Max", "0.5 km away", "Male", R.drawable.pet_max),
                new GenerateRecommendedPets("Adult", "Alexis", "1 km away", "Female", R.drawable.pet_alexis),
                new GenerateRecommendedPets("Adult", "Suzie", "1 km away", "Female", R.drawable.pet_suzie),
                new GenerateRecommendedPets("Young", "Chok", "1.5 km away", "Male", R.drawable.pet_chok),
                new GenerateRecommendedPets("Young", "Ralph", "1.5 km away", "Male", R.drawable.pet_ralph),
                new GenerateRecommendedPets("Adult", "Choleng", "2 km away", "Female", R.drawable.pet_choleng),
                new GenerateRecommendedPets("Adult", "Chini", "2 km away", "Female", R.drawable.pet_chini),
                new GenerateRecommendedPets("Young", "Coby", "2.5 km away", "Male", R.drawable.pet_coby)
        };

        RecoPetsRecyclerView adapter = new RecoPetsRecyclerView(petsArrayList);
        recoPetsView.setHasFixedSize(true);
        recoPetsView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        recoPetsView.setAdapter(adapter);
    }
}
