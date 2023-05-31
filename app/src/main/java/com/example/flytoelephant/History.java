package com.example.flytoelephant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

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

        InputStream inputStream = getResources().openRawResource(R.raw.history);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String word = line;
                moves.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        backButton.setOnClickListener(v -> {
            finish();
        });



    }


}