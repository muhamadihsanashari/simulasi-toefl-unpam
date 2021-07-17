package com.example.simulasitoefl.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simulasitoefl.ListeningFragment;
import com.example.simulasitoefl.R;
import com.example.simulasitoefl.ReadingFragment;
import com.example.simulasitoefl.StructureFragment;

public class PracticeMenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_menu);

        Button btnListening = findViewById(R.id.btn_listening);
        btnListening.setOnClickListener(this);

        Button btnReading = findViewById(R.id.btn_reading);
        btnReading.setOnClickListener(this);

        Button btnStructure = findViewById(R.id.btn_structure);
        btnStructure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_listening){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new ListeningFragment()).commit();
        } else if(v.getId() == R.id.btn_reading){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new ReadingFragment()).commit();
        } else if(v.getId() == R.id.btn_structure){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new StructureFragment()).commit();
        }
    }
}