package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button btnVertComp = findViewById(R.id.btnVertex);
        Button btnTiltComp = findViewById(R.id.btnTilt);

        btnVertComp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) { openActivity3a(); }
        });

        btnTiltComp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) { openActivity3b(); }
        });
    }

    public void openActivity3a() {
        android.content.Intent intent = new android.content.Intent(this, Activity3a.class);
        startActivity(intent);
    }

    public void openActivity3b() {
        android.content.Intent intent = new android.content.Intent(this, Activity3b.class);
        startActivity(intent);
    }
}