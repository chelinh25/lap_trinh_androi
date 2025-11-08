package com.example.chelinh_bai4_lich;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_dl;
    TextView txt_al;
    Button btn_chuyen;
    String[] can_arr = {"Canh","Tân","Quý","Ất","Bính","Đinh","Mậu","Kỷ"};
    String[] chi_arr = {"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tụy","Ngọ","Mùi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ánh xạ id
        edt_dl = findViewById(R.id.edt_dl);
        txt_al = findViewById(R.id.txt_al);
        btn_chuyen = findViewById(R.id.btn_chuyen);
        // sự kiện
        btn_chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lấy năm dương lịch
                int DL = Integer.parseInt(edt_dl.getText().toString());
                // khai báo hai biến can , chi
                String can = "", chi ="";
                switch (DL % 10)
                {
                    case  0: can = "Canh"; break;
                    case  1: can = "Tân"; break;
                    case  2: can = "Nhâm"; break;
                    case  3: can = "Quý"; break;
                    case  4: can = "Giáp"; break;
                    case  5: can = "Ất"; break;
                    case  6: can = "Bính"; break;
                    case  7: can = "Đinh"; break;
                    case  8: can = "Mậu"; break;
                    case  9: can = "Kỳ"; break;
                }
                switch  (DL % 12)
                {
                    case  0: chi = "Thân"; break;
                    case  1: chi = "Dậu"; break;
                    case  2: chi = "Tuất"; break;
                    case  3: chi = "Hợi"; break;
                    case  4: chi = "Tí"; break;
                    case  5: chi = "Sửu"; break;
                    case  6: chi = "Dần"; break;
                    case  7: chi = "Mẹo"; break;
                    case  8: chi = "Thìn"; break;
                    case  9: chi = "Tỵ"; break;
                    case  10: chi = "Ngọ"; break;
                    case  11: chi = "Mui"; break;
                }
                txt_al.setText(can+" "+chi);
            }
        });

    }
}