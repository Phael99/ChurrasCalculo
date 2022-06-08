package com.example.churrascalculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtTotalCow = findViewById(R.id.txtTotalCow);
        TextView txtTotalPork = findViewById(R.id.txtTotalPork);
        TextView txtTotalChicken = findViewById(R.id.txtTotalChicken);
        TextView txtTotalSausage = findViewById(R.id.txtTotalSausage);
        TextView txtTotalBeer = findViewById(R.id.txtTotalBeer);
        TextView txtTotalSoda = findViewById(R.id.txtTotalSoda);
        TextView txtTotalCoal = findViewById(R.id.txtTotalCoal);
        TextView txtTotalCups = findViewById(R.id.txtTotalCups);
        TextView txtTotalSalt = findViewById(R.id.txtTotalSalt);

        Intent intent = getIntent();
        int qtdMen = intent.getIntExtra("qtdMen", 0);
        int qtdWomen = intent.getIntExtra("qtdWomen", 0);
        int qtdKids = intent.getIntExtra("qtdKids", 0);
        int qtdBeer = intent.getIntExtra("qtdBeer", 0);
        int qtdSoda = intent.getIntExtra("qtdSoda", 0);
        boolean cow = intent.getBooleanExtra("cow", false);
        boolean pork = intent.getBooleanExtra("pork", false);
        boolean chicken = intent.getBooleanExtra("chicken", false);
        boolean sausage = intent.getBooleanExtra("sausage", false);


        //Calculo quantidade de carne
        double qtdMeat = qtdMen * 400;
        qtdMeat += qtdWomen * 300;
        qtdMeat += qtdKids * 150;
        qtdMeat = qtdMeat/1000;//Passa para kg



        //Calculo quantidade de bebidas
        int numBeer = qtdBeer * 4;//qtd de latas
        double numSoda = (qtdSoda * 500)/1000;//qtd em Litro

        //Calculo divisão das carnes
        int meatRatioCow = 13;
        int meatRatioPork = 6;
        int meatRatioChicken = 3;
        int meatRatioSausage = 3;
        int meatTotalRatio = 0;

        if (cow)
            meatTotalRatio += meatRatioCow;
        if (pork)
            meatTotalRatio += meatRatioPork;
        if (chicken)
            meatTotalRatio += meatRatioChicken;
        if (sausage)
            meatTotalRatio += meatRatioSausage;

        double numTotalCow;
        double numTotalPork;
        double numTotalChicken;
        double numTotalSausage;
        if (cow)
            numTotalCow = (qtdMeat * meatRatioCow) / meatTotalRatio;
        else
            numTotalCow = 0;

        if (pork)
            numTotalPork = (qtdMeat * meatRatioPork) / meatTotalRatio;
        else
            numTotalPork = 0;

        if (chicken)
            numTotalChicken = (qtdMeat * meatRatioChicken) / meatTotalRatio;
        else
            numTotalChicken = 0;

        if (sausage)
            numTotalSausage = (qtdMeat * meatRatioSausage) / meatTotalRatio;
        else
            numTotalSausage = 0;
        //Calculo extra carvão/sal grosso/copos
        double coal = (qtdMeat * 0.5);//qtd de carvão em Kg
        double salt = (qtdMeat * 0.1) * 1000;//qtd de sal em grama
        int cups = (qtdSoda*1000)*3/200;



        txtTotalCow.setText("Carne de Boi: " + String.valueOf(editFormat(numTotalCow)) + "Kg");

        txtTotalChicken.setText("Carne de Frango: " + String.valueOf(editFormat(numTotalChicken)) + "Kg");
        txtTotalSausage.setText("Linguiça: " + String.valueOf(editFormat(numTotalSausage)) + "Kg");
        txtTotalBeer.setText(String.valueOf(numBeer) + " latas de cerveja");
        txtTotalSoda.setText(String.valueOf(editFormat(numSoda)) + "L de refrigerante");
        txtTotalCoal.setText(String.valueOf(editFormat(coal)) + "Kg de carvão");
        txtTotalCups.setText(String.valueOf(cups) + " copos descartáveis");
        txtTotalSalt.setText(String.valueOf(editFormat(salt)) + "g de sal grosso");
        txtTotalPork.setText("Carne de Porco: " + String.valueOf(editFormat(numTotalPork)) + "Kg");
    }

    private double editFormat(double d){

        DecimalFormat formato = new DecimalFormat("#.##");
        double formated = Double.valueOf(formato.format(d));


        return formated;
    }
}