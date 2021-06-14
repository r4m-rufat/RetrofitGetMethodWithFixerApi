package com.codingwithrufat.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.codingwithrufat.myapplication.adapter.CurrencyAdapter;
import com.codingwithrufat.myapplication.models.Answer;
import com.codingwithrufat.myapplication.api.ApiClient;
import com.codingwithrufat.myapplication.api.ICurrencyApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Answer answer;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ICurrencyApi iCurrencyApi = new ApiClient().getRetrofit().create(ICurrencyApi.class);

        Call<Answer> answerCall = iCurrencyApi.getCurrencyInformations("824cde6e63acd4b72b9a477076482195");

        answerCall.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                if (response.isSuccessful()){
                    answer = response.body();
                    CurrencyAdapter currencyAdapter = new CurrencyAdapter(answer.getRates(), getApplicationContext());
                    recyclerView.setAdapter(currencyAdapter);
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}