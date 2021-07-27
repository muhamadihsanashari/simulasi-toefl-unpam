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
import com.ihsanashari.simulasitoefl.R;
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
            int textDesc = R.string.practice_description;
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