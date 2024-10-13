package com.edu.fateczl.fuelcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 *@author Adriano M Sanchez
 * */
public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtRa;

    private EditText etGasoline;
    private EditText etEthanol;

    private TextView txtResult;

    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName = findViewById(R.id.txtName);
        txtRa = findViewById(R.id.txtRa);

        etGasoline = findViewById(R.id.etGasoline);
        etEthanol = findViewById(R.id.etEthanol);

        txtResult = findViewById(R.id.txtResult);

        btCalc = findViewById(R.id.btCalc);

        btCalc.setOnClickListener(e -> calculateBestChoice());

    }

    private void calculateBestChoice(){
        double priceGasoline = Double.parseDouble(etGasoline.getText().toString());
        double priceEthanol = Double.parseDouble(etEthanol.getText().toString());
        String result = getString(R.string.str_result_gasoline);
        if(priceEthanol <= priceGasoline * 0.7)
            result = getString(R.string.str_result_ethanol);

        txtResult.setText(String.format("%s %s", getString(R.string.txt_result), result));
    }
}