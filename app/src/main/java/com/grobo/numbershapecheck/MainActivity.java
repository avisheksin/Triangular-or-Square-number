package com.grobo.numbershapecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class ShapeCheck {

        int value;

        public boolean isSquare() {

            Double squareRoot = Math.sqrt(value);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular(){

            int x = 1;
            int tn = 1;

            while (tn < value) {
                x++;
                tn = tn + x;
            }

            if (tn == value) { return true; }
            else { return false; }

        }

    }

    public void checkNumber(View view){

        String message = "";

        EditText numberInput = (EditText) findViewById(R.id.numberInput);

        if (numberInput.getText().toString().isEmpty()) {
            message = "Please enter a Number!";

        } else {

            ShapeCheck myNumber = new ShapeCheck();
            myNumber.value = Integer.parseInt(numberInput.getText().toString());

            if (myNumber.isTriangular() && myNumber.isSquare()) {
                message = myNumber.value + " is both Triangular and Square Number.";
            } else if (myNumber.isTriangular() && !myNumber.isSquare()) {
                message = myNumber.value + " is only a Triangular Number";
            } else if (!myNumber.isTriangular() && myNumber.isSquare()) {
                message = myNumber.value + " is only a Square Number.";
            } else {
                message = myNumber.value + " is neither Triangular nor Square Number.";
            }
        }

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
