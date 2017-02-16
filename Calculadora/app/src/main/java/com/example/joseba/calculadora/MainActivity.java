package com.example.joseba.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText numeros;
    Button boton;
    boolean primo=true;
    int numeroNP;
    ArrayList<Integer> numerosPrimo = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeros =(EditText) findViewById(R.id.posicion);
        boton=(Button)findViewById(R.id.BotonCalcular);
        textView=(TextView)findViewById(R.id.resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cosa=numeros.toString();
                numeroNP=Integer.parseInt(cosa);
               numerosPrimo=numerosPrimos(numeroNP);

                textView.setText(numerosPrimo.get(numeroNP));
            }
        });


        }


    public  ArrayList<Integer> numerosPrimos(int numeroNP){

        int n=2;

        if(numerosPrimo.size() < numeroNP){
            do{

               primo = true;
            for(int x=2;x<n;x++){

                for(int y=2;y<x;y++){

                    if((x%y)==0){
                        primo=false;
                    }



                }

                if(primo=true){
                    numerosPrimo.add(x);
                }


            }


        }while (numerosPrimo.size()==numeroNP);
        }

        return numerosPrimo;






    }
}
