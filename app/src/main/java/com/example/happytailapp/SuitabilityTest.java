package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SuitabilityTest extends AppCompatActivity {
    TextView stepIndicator, questionTitle, questionText;
    ImageView questionIcon;
    Button nextBtn, skipBtn;
    RadioButton choice1, choice2, choice3, choice4;
    ProgressBar stepProgress;

    GenerateQuestion generateQuestion = new GenerateQuestion();

    private int quesNum = 1;

    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suitability_test);

        stepIndicator = findViewById(R.id.stepIndicator);
        questionTitle = findViewById(R.id.questionTitle);
        questionText = findViewById(R.id.questionText);

        questionIcon = findViewById(R.id.questionIcon);

        nextBtn = findViewById(R.id.nextButton);
        skipBtn = findViewById(R.id.skipButton);

        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);

        stepProgress = findViewById(R.id.stepProgress);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkAnswer()) {
                    int currentProgress = stepProgress.getProgress();
                    stepProgress.setProgress(currentProgress+10);

                    updateQuestion();

                    String currentStep = String.valueOf(quesNum);
                    stepIndicator.setText(currentStep + " out of 10");

                    if (quesNum == 10) {
                        Intent intent = new Intent(SuitabilityTest.this, TestComplete.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuitabilityTest.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateQuestion() {
        questionTitle.setText(generateQuestion.getCategories(quesNum));
        questionIcon.setImageResource(generateQuestion.getIcons(quesNum));
        questionText.setText(generateQuestion.getQuestions(quesNum));
        choice1.setText(generateQuestion.getChoice1(quesNum));
        choice2.setText(generateQuestion.getChoice2(quesNum));
        choice3.setText(generateQuestion.getChoice3(quesNum));
        choice4.setText(generateQuestion.getChoice4(quesNum));

        quesNum++;

        if (quesNum == 10) {
            nextBtn.setText(R.string.complete);
        }
    }

    private boolean checkAnswer() {
        // for storing answers to database
        if (choice1.isChecked()) {
            answer = choice1.getText().toString().trim();
            return false;
        } if (choice2.isChecked()) {
            answer = choice2.getText().toString().trim();
            return false;
        } if (choice3.isChecked()) {
            answer = choice3.getText().toString().trim();
            return false;
        } if (choice4.isChecked()) {
            answer = choice4.getText().toString().trim();
            return false;
        } else {
            Toast.makeText(SuitabilityTest.this, "Select your answer.", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}