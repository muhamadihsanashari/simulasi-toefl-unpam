package com.ihsanashari.simulasitoefl.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ihsanashari.simulasitoefl.MainActivity;
import com.ihsanashari.simulasitoefl.R;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.ihsanashari.simulasitoefl.scores.ScoreStructureScoreActivity;
import com.ihsanashari.simulasitoefl.testing.TestingStructureSectionActivity;

public class ScoresMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private TextView textViewHighscore;
    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_menu);

        textViewHighscore = findViewById(R.id.tv_high_score);
        loadHighScore();

        Button btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(this);

        Button btnMenu = findViewById(R.id.btn_mainmenu);
        btnMenu.setOnClickListener(this);

        Button btnListeningScore = findViewById(R.id.btn_listening_score);
        btnListeningScore.setOnClickListener(this);

        Button btnReadingScore = findViewById(R.id.btn_reading_score);
        btnReadingScore.setOnClickListener(this);

        Button btnStructureScore = findViewById(R.id.btn_structure_score);
        btnStructureScore.setOnClickListener(this);
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
        } else if (v.getId() == R.id.btn_structure_score) {

//            SCORE RESULT

            Intent intent = new Intent(ScoresMenuActivity.this, ScoreStructureScoreActivity.class);
            startActivityForResult(intent, REQUEST_CODE_QUIZ);
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(TestingStructureSectionActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighScore(score);
                }
            };
        }
    }

    private void loadHighScore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighScore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}



