package com.ellielin.tutorial6;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Word> testList = new ArrayList<>();

        testList.add(new Word("test"));
        testList.add(new Word("ᓀᐦᐃᔭᐍᐏᐣ"));
        testList.add(new Word("Does it work?"));
        testList.add(new Word("Wow"));
        testList.add(new Word("ᐯᔭᐠ"));
        testList.add(new Word("ᓃᓱ"));
        testList.add(new Word("ᓂᐢᑐ"));
        testList.add(new Word("ᓀᐓ"));
        testList.add(new Word("ᓂᔮᓇᐣ"));
        testList.add(new Word("ᓂᐠᑤᓯᐠ"));
        testList.add(new Word("ᑌᐸᑯᐦᑊ"));
        testList.add(new Word("ᐊᔦᓈᓀᐤ"));
        testList.add(new Word("ᑫᑳ ᒥᑖᑕᐦᐟ"));
        testList.add(new Word("ᒥᑖᑕᐦᐟ"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter adapter = new TestAdapter(testList);
        recyclerView.setAdapter(adapter);
    }
}