package com.example.flytoelephant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    private String Letter1;
    private String Letter2;
    private String Letter3;
    private String Letter4;
    private String Letter5;

    private String Word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<String> moves = new ArrayList<>();
        HistoryAdapter adapter = new HistoryAdapter(moves);
        recyclerView.setAdapter(adapter);

        Button backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(v -> {
            finish();
        });

        Intent intentReceived = getIntent();

        Bundle letters = intentReceived.getExtras();
        Letter1 = letters.get("letter1").toString();
        Letter2 = letters.get("letter2").toString();
        Letter3 = letters.get("letter3").toString();
        Letter4 = letters.get("letter4").toString();
        Letter5 = letters.get("letter5").toString();
        Word = Letter1 + Letter2 + Letter3 + Letter4 + Letter5;

        moves.add(Word);

    }


}