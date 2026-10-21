package com.ellielin.tutorial6.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.ellielin.tutorial6.Word;

import java.util.ArrayList;
import java.util.List;

public class WordManager {
    SQLiteDatabase database;

    public WordManager(SQLiteDatabase database) {
        this.database = database;
    }

    public boolean addWord(Word word) {
        ContentValues values = new ContentValues();
        values.put(WordContract.WordEntry.COLUMN_NAME_WORD, word.getWord());
        return (database.insert(WordContract.WordEntry.TABLE_NAME, null, values) > 0);
    }

    public Word getWord(String word) {
        Cursor cursor = database.query(
                WordContract.WordEntry.TABLE_NAME,
                new String[]{BaseColumns._ID, WordContract.WordEntry.COLUMN_NAME_WORD},
                WordContract.WordEntry.COLUMN_NAME_WORD + " = ?",
                new String[]{word},
                null,
                null,
                null
        );

        List<Word> words = new ArrayList<Word>();

        while (cursor.moveToNext()) {
            words.add(new Word(cursor.getString(cursor.getColumnIndexOrThrow(WordContract.WordEntry.COLUMN_NAME_WORD))));
        }
        cursor.close();

        if (words.isEmpty()) {
            return new Word("Word not found");
        }

        return words.get(0);
    }

    public List<Word> getAllWords() {
        Cursor cursor = database.query(
                WordContract.WordEntry.TABLE_NAME,
                new String[]{BaseColumns._ID, WordContract.WordEntry.COLUMN_NAME_WORD},
                null,
                null,
                null,
                null,
                null
        );

        List<Word> words = new ArrayList<Word>();

        while (cursor.moveToNext()) {
            words.add(new Word(cursor.getString(cursor.getColumnIndexOrThrow(WordContract.WordEntry.COLUMN_NAME_WORD))));
        }
        cursor.close();

        return words;
    }

    public boolean updateWord(String newWord, Word oldWord) {
        ContentValues values = new ContentValues();

        values.put(WordContract.WordEntry.COLUMN_NAME_WORD, newWord);

        int count = database.update(
                WordContract.WordEntry.TABLE_NAME,
                values,
                WordContract.WordEntry.COLUMN_NAME_WORD + " LIKE ?",
                new String[]{oldWord.getWord()}
        );

        return (count > 0);
    }

    public boolean deleteWord(Word word) {
        int deletedRows = database.delete(
                WordContract.WordEntry.TABLE_NAME,
                WordContract.WordEntry.COLUMN_NAME_WORD + " LIKE ?",
                new String[]{word.getWord()}
        );
        return (deletedRows > 0);
    }
}
