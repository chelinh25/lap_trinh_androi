package com.example.chelinh_bai9_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay, btnStop;
    Boolean flag =true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btnplay);
        btnStop =findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                startService(intent1);
                if(flag==true){
                    btnPlay.setImageResource(R.drawable.pause);
                    flag =false;
                }
                else{
                    btnPlay.setImageResource(R.drawable.play );
                    flag= true;
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                stopService(intent2);
                btnPlay.setImageResource(R.drawable.play );
                flag= true;

            }
        });
    }
}