package com.cursoandroid.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //Recuperar valores digitados
        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        boolean camposValidados = validarCampo(precoAlcool, precoGasolina);

        if(camposValidados) {
            //Convertendo string para números
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            /* Fazer cálculo de menor preço
            * Se (valorAlcool/valorGasolina) >= 0.7 é melhor utilizar gasolina
            * Senão é melhor utilizar álcool
            * */

            double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }

        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public boolean validarCampo(String pAlcool, String pGasolina){
        boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
