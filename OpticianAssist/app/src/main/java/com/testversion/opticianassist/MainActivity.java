package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button ANSI = findViewById(R.id.btnANSI);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity4();
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity5();
            }
        });

        ANSI.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Uri uri = Uri.parse("https://opticiannow.com/2021/04/12/new-ansi-recommendations-for-prescription-ophthalmic-lenses-released/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }



    public void openActivity2() {
        android.content.Intent intent = new android.content.Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        android.content.Intent intent = new android.content.Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void openActivity4() {
        android.content.Intent intent = new android.content.Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void openActivity5() {
        android.content.Intent intent = new android.content.Intent(this, Activity5.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}