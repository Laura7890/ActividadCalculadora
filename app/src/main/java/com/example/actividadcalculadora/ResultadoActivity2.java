package com.example.actividadcalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.WindowCompat;

import androidx.appcompat.app.AppCompatActivity;
public class ResultadoActivity2 extends AppCompatActivity {


    TextView rnumero1, rnumero2, rOperacion, rResultado;
    Button btnRepertir;
    int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_resultado2);

        rnumero1 = findViewById(R.id.rNumero1);
        rnumero2 = findViewById(R.id.rNumero2);
        rOperacion = findViewById(R.id.rOperacion);
        rResultado = findViewById(R.id.rResultado);
        btnRepertir = findViewById(R.id.btnRepetir);

        //Recuperar datos

        int _n1 = Integer.valueOf(getIntent().getExtras().getString("numero1"));
        int _n2 = Integer.valueOf(getIntent().getExtras().getString("numero2"));
        String _op = getIntent().getExtras().getString("operacion");

        //Log.d("numero 1:::", _n1);

        //Evaluar la operacion

        switch (_op.toLowerCase()){
            case "suma":
                resultado = _n1 + _n2;
                break;
            case "resta":
                resultado = _n1 - _n2;
                break;
            case "multiplicacion":
                resultado = _n1 * _n2;
                break;
            case "division":
                resultado = _n1 / _n2;
                break;

            default:
                resultado=0;
                break;
        }

        //Display o mostrar
        rnumero1.setText("Número 1:"+_n1);
        rnumero2.setText("Número 2:"+_n2);
        rOperacion.setText(_op+"");
        rResultado.setText(String.valueOf(resultado));

        btnRepertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CalculadoraActivity2.class));
                finish();
            }
        });

    }
}