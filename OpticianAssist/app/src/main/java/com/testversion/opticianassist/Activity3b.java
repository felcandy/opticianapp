package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Activity3b extends AppCompatActivity {

    private EditText angle;
    private TextView dropOC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3b);

        //button to calculate OC drop
        Button calculateDrop = (Button) findViewById(R.id.btnTiltDrop);

        //output value
        dropOC = (TextView) findViewById(R.id.tvDropOC);

        //user input value
        angle = (EditText) findViewById(R.id.etAngle);

        //button function
        calculateDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int drop = 0;
                int angleOfTilt = Integer.parseInt(angle.getText().toString());

                if (angleOfTilt > 30) {
                    dropOC.setText("Invalid.");
                }
                else {
                    drop = angleOfTilt / 2;
                    dropOC.setText(String.valueOf(drop) + "mm");
                }
            }
        });
    }
}