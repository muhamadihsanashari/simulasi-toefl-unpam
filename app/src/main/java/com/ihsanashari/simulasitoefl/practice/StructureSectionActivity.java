package com.ihsanashari.simulasitoefl.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ihsanashari.simulasitoefl.Question;
import com.ihsanashari.simulasitoefl.R;
import com.ihsanashari.simulasitoefl.ToeflDbHelper;

import java.util.List;

public class StructureSectionActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionQount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button btnNext;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_section);

        textViewQuestion = findViewById(R.id.tv_question);
        textViewScore = findViewById(R.id.tv_score);
        textViewQuestionQount = findViewById(R.id.tv_question_number);
        textViewCountDown = findViewById(R.id.tv_count_down);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button_1);
        rb2 = findViewById(R.id.radio_button_2);
        rb3 = findViewById(R.id.radio_button_3);
        rb4 = findViewById(R.id.radio_button_4);
        btnNext = findViewById(R.id.btn_next);

        ToeflDbHelper dbHelper = new ToeflDbHelper(this);
        questionList = dbHelper.getAllQuestions();

    }
}