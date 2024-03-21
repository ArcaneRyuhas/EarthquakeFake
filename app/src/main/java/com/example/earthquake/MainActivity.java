package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.earthquake.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("eq", "Se entro");

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getEqList().observe(this, eqList ->{
            for(Earthquake eq : eqList){
                Log.d("eq", eq.getMagnitude() + " " + eq.getPlace());
            }
        });

        viewModel.getEarthquakes();
    }
}