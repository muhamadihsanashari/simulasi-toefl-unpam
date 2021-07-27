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
import com.ihsanashari.simulasitoefl.testing.FullTestFragment;
import com.ihsanashari.simulasitoefl.testing.IndividualTestFragment;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

public class TestingMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_menu);

        Button btnIndividualTest = findViewById(R.id.btn_individual_test);
        btnIndividualTest.setOnClickListener(this);

        Button btnCompleteTest = findViewById(R.id.btn_complete_test);
        btnCompleteTest.setOnClickListener(this);

        Button btnMainMenu = findViewById(R.id.btn_mainmenu);
        btnMainMenu.setOnClickListener(this);

        Button btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_individual_test){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_testing, new IndividualTestFragment()).commit();
        } else if(v.getId() == R.id.btn_complete_test){
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_testing, new FullTestFragment()).commit();
        } else if(v.getId() == R.id.btn_mainmenu){
            Intent intent = new Intent(TestingMenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.btn_info){
            int textDesc = R.string.practice_description;
            MaterialStyledDialog show = new MaterialStyledDialog.Builder(this)
                    .setTitle("Tentang Testing!")
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