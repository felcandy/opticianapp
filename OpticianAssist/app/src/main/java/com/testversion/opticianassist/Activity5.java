package com.testversion.opticianassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
            Button sendEmail = (Button) findViewById(R.id.sendBtn);
            EditText subjectLine = (EditText) findViewById(R.id.subject);
            EditText messageBody = (EditText) findViewById(R.id.message);

            sendEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = "OpticianAppHelpDesk@gmail.com";
                    String subj = subjectLine.getText().toString();
                    String msg = messageBody.getText().toString();

                    String[] emailto = email.split(",");

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,emailto);
                    intent.putExtra(Intent.EXTRA_SUBJECT,subj);
                    intent.putExtra(Intent.EXTRA_TEXT,msg);

                    if(intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Activity5.this, "No App is Installed", Toast.LENGTH_SHORT).show();
                    }

                }
            });

    }
}