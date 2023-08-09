package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestComplete extends AppCompatActivity {
    Button recoBtn, homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_complete);

        recoBtn = findViewById(R.id.recommendedButton);
        homeBtn = findViewById(R.id.homepageButton);

        recoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestComplete.this, RecommendedPets.class);
                startActivity(intent);
                finish();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestComplete.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}