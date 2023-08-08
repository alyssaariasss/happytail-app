package com.example.happytailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    Button backBtn, nextBtn, skipBtn;
    RadioButton choice1, choice2, choice3, choice4;
    ProgressBar stepProgress;

    GenerateQuestion generateQuestion = new GenerateQuestion();

    private int quesNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suitability_test);

        stepIndicator = findViewById(R.id.stepIndicator);
        questionTitle = findViewById(R.id.questionTitle);
        questionText = findViewById(R.id.questionText);

        questionIcon = findViewById(R.id.questionIcon);

        backBtn = findViewById(R.id.backButton);
        nextBtn = findViewById(R.id.nextButton);
        skipBtn = findViewById(R.id.skipButton);

        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);

        stepProgress = findViewById(R.id.stepProgress);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentProgress = stepProgress.getProgress();
                String currentStep = String.valueOf(quesNum);

                stepIndicator.setText(currentStep + " out of 10");
                stepProgress.setProgress(currentProgress+10);
                UpdateQuestion();
            }
        });

    }

    private void UpdateQuestion() {
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
}