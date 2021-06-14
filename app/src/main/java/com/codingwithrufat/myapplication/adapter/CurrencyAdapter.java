package com.codingwithrufat.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.myapplication.R;

import java.util.ArrayList;
import java.util.Map;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>{

    private ArrayList<Map.Entry<String, Double>> currencies;
    private Context context;

    public CurrencyAdapter(Map<String, Double> mCurrencies, Context context) {
        currencies = new ArrayList<>(mCurrencies.entrySet());
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.ViewHolder holder, int position) {
        final Map.Entry<String, Double> entry = currencies.get(position);
        holder.currency.setText(entry.getKey() + ": " + entry.getValue());
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView currency;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currency = itemView.findViewById(R.id.txtCurrency);
        }
    }
}
