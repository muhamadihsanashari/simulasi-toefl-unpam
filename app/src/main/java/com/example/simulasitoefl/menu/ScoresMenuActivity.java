package com.example.simulasitoefl.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.simulasitoefl.MainActivity;
import com.example.simulasitoefl.R;
import com.example.simulasitoefl.practice.listening.ListeningFragment;
import com.example.simulasitoefl.practice.reading.ReadingFragment;
import com.example.simulasitoefl.practice.structure.StructureFragment;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

public class ScoresMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_menu);

        Button btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(this);

        Button btnMenu = findViewById(R.id.btn_mainmenu);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_info){
            int textDesc = R.string.practice_desc;
            MaterialStyledDialog show = new MaterialStyledDialog.Builder(this)
                    .setTitle("Tentang Scores!")
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
        } else if (v.getId() == R.id.btn_mainmenu){
            Intent intent = new Intent(ScoresMenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}