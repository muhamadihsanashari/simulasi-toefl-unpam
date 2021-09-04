package com.ihsanashari.simulasitoefl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ihsanashari.simulasitoefl.ToeflContract.*;

import java.util.ArrayList;
import java.util.List;

public class ToeflDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SimulasiToefl.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public ToeflDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("John Butterfield _____ the Southern Overland Mail Company with two stagecoaches in 1858.", "he set up", "setting up", "set up","the setup", 3);
        addQuestion(q1);
        Question q2 = new Question("The radiation piercing the atmosphere _____ of tanning or burning in humans.", "it is the cause", "causing it", "is the cause","the cause", 3);
        addQuestion(q2);
        Question q3 = new Question("The _____ during an earthquake are caused by seismic waves.", "actually vibrate", "actual vibrations", "vibrations happen","from the actual vibrations", 2);
        addQuestion(q3);
        Question q4 = new Question("During the Middle Ages, _____, large sets of bells with as many as 70 bells, first became popular.", "with carillons", "carillons are", "carillons have","carillons", 4);
        addQuestion(q4);
        Question q5 = new Question("The tea plant, an evergreen shrub pruned to three to five feet high, _____ mild, semitropical climate in which to grow.", "the need for", "it needs", "to need","needs a", 4);
        addQuestion(q5);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getAnswerNumber());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNumber(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
