package com.example.chelinh_bai7_intent4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edta, edtb;
    //Button btnyeucau;
    Button btnresquest_tong, btnresquest_hieu;
    TextView txtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edta=findViewById(R.id.edta);
        edtb=findViewById(R.id.edtb);
        txtkq=findViewById(R.id.txtkq);
        btnresquest_hieu=findViewById(R.id.btnresquesthieu);
        btnresquest_tong=findViewById(R.id.btnresquestTong);
        //btnyeucau=findViewById(R.id.btnYeucau);

        /*btnyeucau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(MainActivity.this, sub.class);
                // lấy dữ liệu a , b
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                //đẩy dữ liệu vào intent
                myintent.putExtra("soa",a);
                myintent.putExtra("sob",b);
                //khoi dong intent
                startActivityForResult(myintent,99);
            }
        });*/
        btnresquest_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(MainActivity.this, sub.class);
                // lấy dữ liệu a , b
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                //đẩy dữ liệu vào intent
                myintent.putExtra("soa",a);
                myintent.putExtra("sob",b);
                myintent.setAction("1");
                //khoi dong intent
                startActivityForResult(myintent,99);
            }
        });
        btnresquest_hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(MainActivity.this, sub.class);
                // lấy dữ liệu a , b
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                //đẩy dữ liệu vào intent
                myintent.putExtra("soa",a);
                myintent.putExtra("sob",b);
                myintent.setAction("2");
                //khoi dong intent
                startActivityForResult(myintent,99);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99 && resultCode==33)
        {
            int sum= data.getIntExtra("kq",0);
            txtkq.setText("Tổng của phép tính là: "+sum);
        }
        if (resultCode==34 && requestCode==99)
        {
            int sub = data.getIntExtra("kq",0);
            txtkq.setText("Hiệu của phép tính là: "+sub);

        }
    }

}