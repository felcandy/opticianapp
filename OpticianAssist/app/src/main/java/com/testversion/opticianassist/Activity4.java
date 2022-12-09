package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    private EditText sph1;
    private EditText cyl1;
    private EditText ax1;
    private EditText add1;
    private TextView sph2;
    private TextView cyl2;
    private TextView ax2;
    private TextView add2;
    private double rounded;


    public Activity4() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //user input values
        sph1 = (EditText) findViewById(R.id.etSph1);
        cyl1 = (EditText) findViewById(R.id.etCyl1);
        ax1 = (EditText) findViewById(R.id.etAxis1);
        add1 = (EditText) findViewById(R.id.etAdd1);

        //program output values
        sph2 = (TextView) findViewById(R.id.tvSph2);
        cyl2 = (TextView) findViewById(R.id.tvCyl2);
        ax2 = (TextView) findViewById(R.id.tvAxis2);
        add2 = (TextView) findViewById(R.id.tvAdd2);

        //buttons for functions
        Button transpose = (Button) findViewById(R.id.btnTranspose);
        Button near = (Button) findViewById(R.id.btnNear);
        Button intermediate = (Button) findViewById(R.id.btnInterm);

        transpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float sphere1 = Float.parseFloat(sph1.getText().toString());
                float cylinder1 = Float.parseFloat(cyl1.getText().toString());
                int axis1 = Integer.parseInt(ax1.getText().toString());
                float addstr1 = Float.parseFloat(add1.getText().toString());
                float sphere2 = 0;
                float cylinder2 = 0;
                int axis2 = 0;


                if (axis1 > 180 || axis1 < 1) {
                    if (axis1 > 180) {
                        axis2 = (axis1 - 180);
                        sphere2 = sphere1 + cylinder1;
                        cylinder2 = (-1) * cylinder1;
                        if (axis2 > 90) {
                            axis2 = axis2 - 90;
                        } else {
                            axis2 = axis2 + 90;
                        }
                    } else {
                        //noinspection ConstantConditions
                        if (axis1 < 1) {
                            axis2 = (axis1 + 180);
                            sphere2 = sphere1 + cylinder1;
                            cylinder2 = (-1) * cylinder1;
                            if (axis2 > 90) {
                                axis2 = axis2 - 90;
                            } else {
                                axis2 = axis2 + 90;
                            }
                        }
                    }

                    sphere2 = sphere1 + cylinder1;
                    cylinder2 = (-1) * cylinder1;
                    if (axis1 > 90) {
                        axis2 = axis1 - 90;
                    } else {
                        axis2 = axis1 + 90;
                    }
                } else {
                    sphere2 = sphere1 + cylinder1;
                    cylinder2 = (-1) * cylinder1;
                    if (axis1 > 90) {
                        axis2 = axis1 - 90;
                    } else {
                        axis2 = axis1 + 90;
                    }
                }

                rounded = Math.ceil(sphere2 * 4) / 4;
                sph2.setText("S: " + String.valueOf(rounded));
                rounded = Math.ceil(cylinder2 * 4) / 4;
                cyl2.setText("C: " + String.valueOf(rounded));
                ax2.setText("A: " + String.valueOf(axis2));
                add2.setText("+" + String.valueOf(addstr1));

            }
        });

        near.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float sphere1 = Float.parseFloat(sph1.getText().toString());
                float cylinder1 = Float.parseFloat(cyl1.getText().toString());
                int axis1 = Integer.parseInt(ax1.getText().toString());
                float addstr1 = Float.parseFloat(add1.getText().toString());
                float sphere2 = sphere1 + addstr1;

                rounded = Math.ceil(sphere2 * 4) / 4;
                sph2.setText("S: " + String.valueOf(rounded));
                rounded = Math.ceil(cylinder1 * 4) / 4;
                cyl2.setText("C: " + String.valueOf(rounded));
                ax2.setText("A: " + String.valueOf(axis1));
                add2.setText("+" + String.valueOf(0));

            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float sphere1 = Float.parseFloat(sph1.getText().toString());
                float cylinder1 = Float.parseFloat(cyl1.getText().toString());
                int axis1 = Integer.parseInt(ax1.getText().toString());
                float addstr1 = Float.parseFloat(add1.getText().toString());
                float sphere2 = sphere1 + (addstr1 / 2);

                rounded = Math.ceil(sphere2 * 4) / 4;
                sph2.setText("S: " + String.valueOf(rounded));
                rounded = Math.ceil(cylinder1 * 4) / 4;
                cyl2.setText("C: " + String.valueOf(rounded));
                ax2.setText("A: " + String.valueOf(axis1));
                add2.setText("+" + String.valueOf(0));

            }
        });
    }
}