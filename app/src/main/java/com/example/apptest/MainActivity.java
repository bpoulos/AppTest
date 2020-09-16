package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//
public class MainActivity extends AppCompatActivity {
public double multToMile = 1.609; //number needed to multiply/divde the miles/kilometers for calculation
public boolean toKilom = true; //miles to kilometers
public boolean toMile = false; //kilometers to miles
public double res = 0; //this will be the solution for converting miles to kilometers, and other way around
public int calcNum = 0; //number of calculations(logged at end of pressClick() method)
    public void pressClick(View view) {
        calcNum+=1; //increases number for logs
        TextView textToEdit = (TextView)findViewById(R.id.textEdit3); //input
        EditText editText9 = (EditText)findViewById(R.id.textView4); //output
        //Toast.makeText(MainActivity.this,textToEdit.getText().toString(),Toast.LENGTH_LONG).show(); //shows input on UI, taken out of program
        //Toast.makeText(MainActivity.this,editText9.getText().toString(),Toast.LENGTH_LONG).show(); //shows output on UI, taken out of program
        //
        //Below starts calculation process
        //
        if(toKilom = true){ //if miles to kilometers is selected
            String fCon = textToEdit.getText().toString(); //Input text set to string
            double afCon = Double.parseDouble(fCon); //sets string fCon to Double
            double res = afCon*multToMile; //Multiplies afCon(input) by the number needed to obtain miles(multToMile)
            editText9.setText(res+""); //sets outpout(editText9) to res(afCon*multToMile)
        }
        else if(toMile = true){ //if miles to kilometers is selected
            String fCon = textToEdit.getText().toString();
            double afCon = Double.parseDouble(fCon);
            res = afCon/multToMile; //Divides afCon(input) by the number needed to obtain kilometers(multToMile)
            editText9.setText(res+""); //sets outpout(editText9) to res(afCon/multToMile)
        }
        else{ //if, for some reason, the app bugs and sets both booleans(toKilom, toMile) to false
            Log.i("Error Log", "Booleans toKilom & toMile = false; Unable To Calculate"); //logs the error in Logcat
            Toast.makeText(MainActivity.this, "Logged Error: Unable To Decide", Toast.LENGTH_LONG).show(); //partially shows error on UI
        }
        //double res = afCon/multToMile; Kilometers to Miles
        Log.i("Information Log", "Calculation Finished("+calcNum+")"); //logs how many calculations were made in Logcat
    }
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}