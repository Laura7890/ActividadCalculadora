package com.example.actividadcalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class CalculadoraActivity2 extends AppCompatActivity {


    EditText n1, n2;
    RadioButton opSuma, opRestar, opMulti, opDivision;
    Button btnCalcular;
    String operacion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora2);

        n1 = findViewById(R.id.numero1);
        n2 = findViewById(R.id.numero2);

        opSuma= findViewById(R.id.opSuma);
        opRestar= findViewById(R.id.opRestar);
        opMulti= findViewById(R.id.opMulti);
        opDivision= findViewById(R.id.opDivision);


        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n1.getText().toString().length()<1){
                    Toast.makeText(getApplicationContext(), "ingrese un valor en numero 1:", Toast.LENGTH_LONG).show();

            }else if (n2.getText().toString().length()<1) {
                    Toast.makeText(getApplicationContext(),"ingrese un valor en numero 2:", Toast.LENGTH_LONG).show();
                }else {

                if(opSuma.isChecked())
                    operacion = "suma";
                if(opRestar.isChecked())
                        operacion = "resta";
                if(opMulti.isChecked())
                        operacion = "multiplicacion";
                if(opDivision.isChecked())
                        operacion = "division";

                    Intent i = new  Intent(getApplicationContext(), ResultadoActivity2.class);
                    i.putExtra("numero1", n1.getText().toString());
                    i.putExtra("numero2",n2.getText().toString());
                    i.putExtra("operacion",operacion);
                    startActivity(i);
                    finish();
                }

        }

        });




    }
}