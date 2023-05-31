package com.example.flytoelephant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.flytoelephant.databinding.ActivityGameBinding;
import com.example.flytoelephant.network.Network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {



    private ActivityGameBinding binding;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonHistory.setOnClickListener(v -> {
            Intent intent = new Intent(this, History.class);
            startActivity(intent);
        });

        Button checkButton = findViewById(R.id.checkbutton);
        checkButton.setOnClickListener(v -> {
            Network network = new Network();
            network.checkWord(this, getWord());
        });


        binding.changebutton.setOnClickListener(v -> {

            String Word = getWord();

            try {
                FileOutputStream fos = new FileOutputStream("history.txt");
                byte[] byteword = Word.getBytes();
                fos.write(byteword);
                fos.write("\n".getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




    }

    private String getWord() {
        return binding.letter1.getText().toString() +
                binding.letter2.getText().toString() +
                binding.letter3.getText().toString() +
                binding.letter4.getText().toString() +
                binding.letter5.getText().toString();
    }


}