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

public class Activity2 extends AppCompatActivity {

    private EditText aMonoPD;
    private EditText oMonoPD;
    private EditText aOptCent;
    private EditText oOptCent;
    private EditText lensPower;
    private boolean isOD = true;
    private TextView prismHorizD;
    private TextView prismVertD;
    private TextView horizBase;
    private TextView vertBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //button
        Button calculate = (Button) findViewById(R.id.btnCalcPrism);

        //output
        prismHorizD = (TextView) findViewById(R.id.tvHorizPrismDiopters);
        prismVertD = (TextView) findViewById(R.id.tvVertPrismDiopters);
        horizBase = (TextView) findViewById(R.id.tvInOrOut);
        vertBase = (TextView) findViewById(R.id.tvUpOrDown);

        //input
        aMonoPD = (EditText) findViewById(R.id.etActualPD);
        oMonoPD = (EditText) findViewById(R.id.etOrderPD);
        aOptCent = (EditText) findViewById(R.id.etActualOC);
        oOptCent = (EditText) findViewById(R.id.etOrderOC);
        lensPower = (EditText) findViewById(R.id.etLensPower);

        ToggleButton toggleODorOS = (ToggleButton) findViewById(R.id.togODorOS);
        toggleODorOS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isOD = true;
                }
                else {
                    isOD = false;
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                float diopterLens = Float.parseFloat(lensPower.getText().toString());
                int mmActual = Integer.parseInt(aMonoPD.getText().toString());
                int mmOrdered = Integer.parseInt(oMonoPD.getText().toString());
                int ocActual = Integer.parseInt(aOptCent.getText().toString());
                int ocOrdered = Integer.parseInt(oOptCent.getText().toString());
                float mmDifference;
                float prismDiopters;
                String bI = "Base In";
                String bO = "Base Out";
                String bU = "Base Up";
                String bD = "Base Down";
                Double rounded = Math.ceil(diopterLens * 4) / 4;
                diopterLens = rounded.floatValue();

                mmDifference = (mmActual - mmOrdered);
                prismDiopters = Math.abs((mmDifference/10) * diopterLens);

                //horizontal prism
                if (diopterLens == 0) {
                    prismHorizD.setText("No Induced");
                    horizBase.setText("Horiz Prism");
                    prismVertD.setText("No Induced");
                    vertBase.setText("Vert Prism");
                }
                else {
                    //Plus lens
                    if (diopterLens > 0) {
                        if (mmDifference == 0) {
                            prismHorizD.setText("No Induced");
                            horizBase.setText("Horiz Prism");
                        } else if (mmDifference > 0) {
                            prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                            horizBase.setText(bI);
                        } else {
                            prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                            horizBase.setText(bO);
                        }
                    } else {
                        //minus lens
                        if (mmDifference == 0) {
                            prismHorizD.setText("No Induced");
                            horizBase.setText("Horiz Prism");
                        } else if (mmDifference > 0) {
                            prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                            horizBase.setText(bO);
                        } else {
                            prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                            horizBase.setText(bI);
                        }
                    }
                }

                //vertical prism
                mmDifference = (ocActual - ocOrdered);
                prismDiopters = Math.abs((mmDifference/10) * diopterLens);
                if (diopterLens>0) {
                    if (mmDifference == 0) {
                        prismVertD.setText("No Induced");
                        vertBase.setText("Vert Prism");
                    } else if (mmDifference > 0) {
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bD);
                    } else {
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bU);
                    }
                } else {
                    //minus lens
                    if (mmDifference == 0) {
                        prismVertD.setText("No Induced");
                        vertBase.setText("Horiz Prism");
                    } else if (mmDifference > 0) {
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bU);
                    } else {
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bD);
                    }
                }
                }


                    //prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394" + String.valueOf(mmDifference));
/*
                    if (isOD) {
                        prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                        horizBase.setText(bI);
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bU);
                    } else {
                        prismHorizD.setText(String.valueOf(prismDiopters) + "\u0394");
                        horizBase.setText(bO);
                        prismVertD.setText(String.valueOf(prismDiopters) + "\u0394");
                        vertBase.setText(bD);
                    }
*/



        });



    }
}