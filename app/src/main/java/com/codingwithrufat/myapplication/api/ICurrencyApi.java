package com.codingwithrufat.myapplication.api;

import com.codingwithrufat.myapplication.models.Answer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICurrencyApi {

    @GET("latest?")
    Call<Answer> getCurrencyInformations(@Query("access_key") String api_key);

}
