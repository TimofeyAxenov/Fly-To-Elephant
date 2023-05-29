package com.example.flytoelephant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.flytoelephant.databinding.ActivityGameBinding;
import com.example.flytoelephant.network.Network;

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
            Intent History = new Intent();
            Bundle Letters = new Bundle();
            Letters.putString("letter1", binding.letter1.getText().toString());
            Letters.putString("letter2", binding.letter2.getText().toString());
            Letters.putString("letter3", binding.letter3.getText().toString());
            Letters.putString("letter4", binding.letter4.getText().toString());
            Letters.putString("letter5", binding.letter5.getText().toString());
            History.putExtras(Letters);
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