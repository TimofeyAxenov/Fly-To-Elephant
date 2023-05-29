package com.example.flytoelephant.network;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.flytoelephant.History;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private final DictionaryAPI dictionaryAPI;

    public Network() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dictionary.yandex.net//")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dictionaryAPI = retrofit.create(DictionaryAPI.class);
    }

    public void checkWord (Context context, String word){
        String key = "dict.1.1.20230522T141652Z.c9bd5d0a849f776a.8f30560986700616ba8cf530b6f560419494ad82";
        String lang = "ru-en";
        Call<Dictionary> call =  dictionaryAPI.checkWord(key, lang, word);

        call.enqueue(new Callback<Dictionary>() {
            @Override
            public void onResponse(@NonNull Call<Dictionary> call, @NonNull Response<Dictionary> response) {
                if(response.isSuccessful()) {
                    Dictionary dictionary = response.body();
                    if(dictionary.getDef().size() >0) {
                        Toast.makeText(context, "Слово есть", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Слова нет", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "произошла ошибка" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Dictionary> call, @NonNull Throwable t) {
                Toast.makeText(context, "произошла ошибка", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
