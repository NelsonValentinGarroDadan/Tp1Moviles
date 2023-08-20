package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp1.databinding.ActivityTraducidoBinding;

public class TraducidoActivity extends AppCompatActivity {

    private TraducidoActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTraducidoBinding binding = ActivityTraducidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String pal = (String)intent.getStringExtra("Palabra");
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraducidoActivityViewModel.class);
        mv.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
            binding.ivLogo.setImageResource(palabra.getLogo());
            binding.tvEsp.setText(pal);
            binding.tvIng.setText(palabra.getTraduccion());
            }
        });
        mv.traducir(pal);
        binding.btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.volver();
            }
        });
    }

}