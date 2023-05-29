package com.example.flytoelephant.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DictionaryAPI {
    @GET("/api/v1/dicservice.json/lookup")
    Call<Dictionary> checkWord(
            @Query("key") String key,
            @Query("lang") String lang,
            @Query("text") String text
    );
}
