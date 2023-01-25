package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double convertedWeight;
    double WeightEnter;
    final double CONVERSION_RATE = 2.2;
    String text = "not diabetic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight = findViewById(R.id.editTextWeight);
        RadioButton rdKgToLbs = findViewById(R.id.rdBtnKgToLb);
        RadioButton rdLbsToKg = findViewById(R.id.rdBtnLbToKg);
        CheckBox checkBox = findViewById(R.id.checkBoxDiabetic);
        Button button = findViewById(R.id.btnConvert1);
        TextView output = findViewById(R.id.txtOutput);

        checkBox.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {



        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("");
                DecimalFormat format = new DecimalFormat("#.#");
                WeightEnter = Double.parseDouble(weight.getText().toString());
                if(rdKgToLbs.isChecked())
                {
                    text = "diabetic";
                    if(WeightEnter > 225)
                    {
                        Toast.makeText(MainActivity.this,
                                "weight entered should be less than 225", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        convertedWeight = WeightEnter * CONVERSION_RATE;
                        output.setText(format.format(convertedWeight) + "lbs" + "and patient is" + text);
                    }
                }

                if (rdLbsToKg.isChecked())
                {
                    if(WeightEnter > 500)
                    {
                        Toast.makeText(MainActivity.this,
                                "weight entered should be less than 500", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        convertedWeight = WeightEnter / CONVERSION_RATE;
                        output.setText(format.format(convertedWeight) + "kgs" + "and patient is" + text);
                    }
                }

            }
        });



    }
}