package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.happytailapp.databinding.ActivityHomeBinding;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Home extends AppCompatActivity {
    CarouselView carouselView;

    ActivityHomeBinding binding;

    int[] homeImages = {R.drawable.home_card1, R.drawable.home_card2, R.drawable.home_card3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        carouselView = findViewById(R.id.carouselView);

        carouselView.setPageCount(homeImages.length);
        carouselView.setImageListener(imageListener);

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

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(homeImages[position]);
        }
    };
}
