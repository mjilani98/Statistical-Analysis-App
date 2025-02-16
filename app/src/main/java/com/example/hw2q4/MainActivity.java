package com.example.hw2q4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    StatisticalAnalysis calculator ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calculate();


    }

    public void calculate()
    {
        //creating a button handler object
        ButtonHandler handler = new ButtonHandler();

        //creating a sum button
        Button btnSum = findViewById(R.id.btnSum);
        btnSum.setOnClickListener(handler);

        //creating a mean button
        Button btnMean = findViewById(R.id.btnMean);
        btnMean.setOnClickListener(handler);

        //creating a median button
        Button btnMedian = findViewById(R.id.btnMedian);
        btnMedian.setOnClickListener(handler);

        //creating a stdv button
        Button  btnStdv= findViewById(R.id.btnStdv);
        btnStdv.setOnClickListener(handler);

        //creating a min button
        Button btnMin = findViewById(R.id.btnMinimum);
        btnMin.setOnClickListener(handler);

        //creating a maximum button
        Button btnMax = findViewById(R.id.btnMaximum);
        btnMax.setOnClickListener(handler);
    }


    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get hold of the text view for output
            TextView resultView = findViewById(R.id.ResultTextView);

            //get the string from the input
            EditText input = findViewById(R.id.numbersInput);
            String strNumbers = input.getText().toString();

            //create a calculator
            calculator = new StatisticalAnalysis(strNumbers);

            //get the id of the button that was clicked
            int id = v.getId();

            //if the button is sum
            if(id == R.id.btnSum)
            {
                double sum = calculator.getSum();
                resultView.setText(""+sum);
            }
            //if the button is mean
            else if(id == R.id.btnMean)
            {
                double mean = calculator.getMean();
                resultView.setText(""+mean);
            }
            //if the button is median
            else if(id == R.id.btnMedian)
            {
                double median  = calculator.getMedian();
                resultView.setText(""+median);
            }
            //if the button is standard deviation
            else if(id == R.id.btnStdv)
            {
                double stdv = calculator.getStandardDeviation();
                resultView.setText(""+stdv);
            }
            //if the button is minimum
            else if(id == R.id.btnMinimum)
            {
                double min = calculator.getMinimum();
                resultView.setText(""+min);
            }
            //if the button is maximum
            else if(id == R.id.btnMaximum)
            {
                double max  = calculator.getMaximum();
                resultView.setText(""+max);
            }

        }
    }
}