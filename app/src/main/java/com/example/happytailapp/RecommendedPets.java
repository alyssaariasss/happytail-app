package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.happytailapp.databinding.ActivityRecommendedPetsBinding;

public class RecommendedPets extends AppCompatActivity {
    Button profileBtn;

    ActivityRecommendedPetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecommendedPetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profileBtn = findViewById(R.id.profileButton);

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
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
