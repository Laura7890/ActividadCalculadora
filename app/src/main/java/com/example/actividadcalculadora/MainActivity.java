package com.example.actividadcalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        btnEnter = findViewById(R.id.btnEnter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            WindowInsetsCompat systemBars = insets;
            v.setPadding(
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            );

            return insets;
        });


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    Intent i = new Intent(getApplicationContext(),CalculadoraActivity2.class);
                    startActivity(i);
                    finish();
            }
        });
    }

}