package com.ellielin.tutorial6;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellielin.tutorial6.database.WordDatabaseHelper;
import com.ellielin.tutorial6.database.WordManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WordDatabaseHelper databaseHelper = new WordDatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        WordManager manager = new WordManager(database);

        manager.addWord(new Word("test"));
        manager.addWord(new Word("ᓀᐦᐃᔭᐍᐏᐣ"));
        manager.addWord(new Word("Does it work?"));
        manager.addWord(new Word("Wow"));
        manager.addWord(new Word("ᐯᔭᐠ"));
        manager.addWord(new Word("ᓃᓱ"));
        manager.addWord(new Word("ᓂᐢᑐ"));
        manager.addWord(new Word("ᓀᐓ"));
        manager.addWord(new Word("ᓂᔮᓇᐣ"));
        manager.addWord(new Word("ᓂᐠᑤᓯᐠ"));
        manager.addWord(new Word("ᑌᐸᑯᐦᑊ"));
        manager.addWord(new Word("ᐊᔦᓈᓀᐤ"));
        manager.addWord(new Word("ᑫᑳ ᒥᑖᑕᐦᐟ"));
        manager.addWord(new Word("ᒥᑖᑕᐦᐟ"));

        List<Word> testList = manager.getAllWords();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter adapter = new TestAdapter(testList);
        recyclerView.setAdapter(adapter);
    }
}