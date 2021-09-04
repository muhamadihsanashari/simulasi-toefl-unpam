package com.ihsanashari.simulasitoefl.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ihsanashari.simulasitoefl.MainActivity;
import com.ihsanashari.simulasitoefl.practice.PracticeListeningFragment;
import com.ihsanashari.simulasitoefl.R;
import com.ihsanashari.simulasitoefl.practice.PracticeReadingFragment;
import com.ihsanashari.simulasitoefl.practice.PracticeStructureFragment;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

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

        Button btnMainMenu = findViewById(R.id.btn_mainmenu);
        btnMainMenu.setOnClickListener(this);

        Button btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_listening){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new PracticeListeningFragment()).commit();
        } else if(v.getId() == R.id.btn_reading){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new PracticeReadingFragment()).commit();
        } else if(v.getId() == R.id.btn_structure){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments, new PracticeStructureFragment()).commit();
        } else if(v.getId() == R.id.btn_mainmenu){
            Intent intent = new Intent(PracticeMenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.btn_info){
            int textDesc = R.string.practice_description;
            MaterialStyledDialog show = new MaterialStyledDialog.Builder(this)
                    .setTitle("Tentang Practice!")
                    .setDescription(textDesc)
                    .setHeaderColor(R.color.primary_color)
                    .setIcon(R.drawable.ic_info_baseline)
                    .setScrollable(true, 10)
                    .setPositiveText("OK")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            Log.d("MaterialStyledDialogs", "Do something!");
                        }
                    })
                    .show();
        }
    }
}