package com.ihsanashari.simulasitoefl;

import android.provider.BaseColumns;

public final class ToeflContract {

    private ToeflContract(){

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "toefl_question";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NUM = "answer_num";
        public static final String COLUMN_DIFFICULTY = "difficulty";
    }
}
