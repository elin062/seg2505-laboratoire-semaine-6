package com.ellielin.tutorial6.database;

import android.provider.BaseColumns;

public final class WordContract {
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class WordEntry implements BaseColumns {
        public static final String TABLE_NAME = "words";
        public static final String COLUMN_NAME_WORD = "word";

    }
}
