package com.example.chelinh_bai7_intent4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sub extends AppCompatActivity {

    EditText edtAA,edtBB;
    Button btnkq;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        btnkq=findViewById(R.id.btnkq);
        edtAA=findViewById(R.id.edtAA);
        edtBB=findViewById(R.id.edtBB);
        myintent = getIntent();
        int a = myintent.getIntExtra("soa",0);
        int b = myintent.getIntExtra("sob",0);
        edtBB.setText(b+"");
        edtAA.setText(a+"");
        int action = Integer.parseInt(myintent.getAction());
        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action ==1){
                    myintent.putExtra("kq",a+b);
                    setResult(33,myintent);
                }
                else {
                    myintent.putExtra("kq",a-b);
                    setResult(34,myintent);
                }
                finish();
            }
        });
        /*btnTOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xu ly ket qua
                int sum = a+b;
                // day ket qua vao intent
                myintent.putExtra("kq",sum);
                //tra intent tro ve
                setResult(33,myintent);
                // thoat activity
                finish();
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sub = a-b;
                myintent.putExtra("kq",sub);
                setResult(34,myintent);
                finish();
            }
        });*/

    }
}