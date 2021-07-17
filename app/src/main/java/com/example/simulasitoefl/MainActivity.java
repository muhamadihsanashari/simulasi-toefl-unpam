package com.example.simulasitoefl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simulasitoefl.menu.PracticeMenuActivity;
import com.example.simulasitoefl.menu.ScoresMenuActivity;
import com.example.simulasitoefl.menu.TestingMenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPractice = findViewById(R.id.btn_practice);
        btnPractice.setOnClickListener(this);

        Button btnTesting = findViewById(R.id.btn_testing);
        btnTesting.setOnClickListener(this);

        Button btnScores = findViewById(R.id.btn_scores);
        btnScores.setOnClickListener(this);

        Button btnPreTest = findViewById(R.id.btn_pre_test);
        btnPreTest.setOnClickListener(this);

        Button btnPostTest = findViewById(R.id.btn_post_test);
        btnPostTest.setOnClickListener(this);

        Button btnDownload = findViewById(R.id.btn_download_materi);
        btnDownload.setOnClickListener(this);

        Button btnAbout = findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_practice){
            Intent intent = new Intent(MainActivity.this, PracticeMenuActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_testing){
            Intent intent = new Intent(MainActivity.this, TestingMenuActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_scores){
            Intent intent = new Intent(MainActivity.this, ScoresMenuActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_pre_test){

        }else if (v.getId() == R.id.btn_post_test){

        }else if (v.getId() == R.id.btn_testing){

        }else if (v.getId() == R.id.btn_about){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
}