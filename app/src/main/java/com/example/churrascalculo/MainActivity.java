package com.example.churrascalculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    TextView numMen;
    TextView numWomen;
    TextView numKids;
    TextView numBeer;
    TextView numSoda;
    CheckBox cbCow;
    CheckBox cbPork;
    CheckBox cbChicken;
    CheckBox cbSausage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalc);
        numMen = findViewById(R.id.numMen);
        numWomen = findViewById(R.id.numWomen);
        numKids = findViewById(R.id.numChildren);
        numBeer = findViewById(R.id.numBeer);
        numSoda = findViewById(R.id.numSoda);
        cbCow = findViewById(R.id.cbCow);
        cbPork = findViewById(R.id.cbPork);
        cbChicken = findViewById(R.id.cbChicken);
        cbSausage = findViewById(R.id.cbSausage);

        numMen.addTextChangedListener(inputWatcher);
        numWomen.addTextChangedListener(inputWatcher);
        numKids.addTextChangedListener(inputWatcher);
        numBeer.addTextChangedListener(inputWatcher);
        numSoda.addTextChangedListener(inputWatcher);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int qtdMen = Integer.parseInt(numMen.getText().toString());
                int qtdWomen = Integer.parseInt(numWomen.getText().toString());
                int qtdKids = Integer.parseInt(numKids.getText().toString());
                int qtdBeer = Integer.parseInt(numBeer.getText().toString());
                int qtdSoda = Integer.parseInt(numSoda.getText().toString());
                boolean cow = cbCow.isChecked();
                boolean pork = cbPork.isChecked();
                boolean chicken = cbChicken.isChecked();
                boolean sausage = cbSausage.isChecked();


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("qtdMen", qtdMen);
                intent.putExtra("qtdWomen", qtdWomen);
                intent.putExtra("qtdKids", qtdKids);
                intent.putExtra("qtdBeer", qtdBeer);
                intent.putExtra("qtdSoda", qtdSoda);
                intent.putExtra("cow", cow);
                intent.putExtra("pork", pork);
                intent.putExtra("chicken", chicken);
                intent.putExtra("sausage", sausage);

                startActivity(intent);


            }
        });
    }
    private TextWatcher inputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String qtdMen = numMen.getText().toString();
            String qtdWomen = numWomen.getText().toString();
            String qtdKids = numKids.getText().toString();
            String qtdBeer = numBeer.getText().toString();
            String qtdSoda = numSoda.getText().toString();

            btnCalc.setEnabled(!qtdMen.isEmpty() && !qtdWomen.isEmpty() && !qtdKids.isEmpty() &&
                                !qtdBeer.isEmpty() && !qtdSoda.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}