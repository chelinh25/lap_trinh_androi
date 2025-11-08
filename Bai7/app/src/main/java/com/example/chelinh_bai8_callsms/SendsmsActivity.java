package com.example.chelinh_bai8_callsms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SendsmsActivity extends AppCompatActivity {
    EditText edtsms;
    ImageButton btnsms;
    Button btnback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sendsms);
        edtsms = findViewById(R.id.edtsms);
        btnsms = findViewById(R.id.btnsms);
        btnback2 = findViewById(R.id.btnback2);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtsms.getText().toString()));
                startActivity(smsintent);
            }
        });
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}