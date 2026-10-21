package com.ellielin.tutorial6.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ellielin.tutorial6.Word;

public class WordManager {
    SQLiteDatabase database;
    ContentValues values = new ContentValues();

    public WordManager(SQLiteDatabase database) {
        this.database = database;
    }

    public long addWord(Word word) {
        values.put(WordContract.WordEntry.COLUMN_NAME_WORD, word.getWord());
        return database.insert(WordContract.WordEntry.TABLE_NAME, null, values);
    }

    public Word getWord(String word) {

    }
}
