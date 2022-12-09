package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class Activity3a extends AppCompatActivity {
    private EditText diopter;
    private EditText mmChange;
    private TextView effectivePower;
    private boolean isMinus = true;
    private boolean isFarther = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3a);

        //button to calculate compensated rx
        Button compensate = (Button) findViewById(R.id.btnVertCompensate);



        //function output value
        effectivePower = (TextView) findViewById(R.id.tvEP);

        //user input values
        diopter = (EditText) findViewById(R.id.etDiopter);
        mmChange = (EditText) findViewById(R.id.etMillimeter);

        ToggleButton toggleLens = (ToggleButton) findViewById(R.id.togLens);
        toggleLens.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isMinus = true;
                } else {
                    isMinus = false;
                }
            }
        });

        ToggleButton toggleChange = (ToggleButton) findViewById(R.id.togMove);
        toggleChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    isFarther = true;
                } else {
                    // The toggle is disabled
                    isFarther = false;
                }
            }
        });

        //button function
        compensate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float diopterOrig = Float.parseFloat(diopter.getText().toString());
                int mmMoved = Integer.parseInt(mmChange.getText().toString());
                float diopterNewEP;

                diopterOrig = Math.abs(diopterOrig);
                diopterNewEP = (diopterOrig*diopterOrig) / 1000;
                diopterNewEP = diopterNewEP * mmMoved;

                //depending on lens movement
                if(isFarther) {
                    diopterNewEP = diopterOrig - diopterNewEP;
                }
                else {
                    diopterNewEP = diopterOrig + diopterNewEP;
                }

                //depending on lens type
                if(isMinus) {
                    diopterNewEP = diopterNewEP * (-1);
                }



                effectivePower.setText("Effective Power = " + String.valueOf(diopterNewEP));
                }


        });

    }
}