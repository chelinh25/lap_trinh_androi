package com.example.chelinh_bai6_thongtincanhan;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageButton btnexit;
    Button btnguithongtin;;
    EditText edthoten, edtcmnd, edtbosung;
    RadioButton radtrungcap,radcaodang, raddaihoc;
    CheckBox chkdocsach, chkdocbao, chkcoding;
    RadioGroup idgroup;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ánh xạ id
        btnexit = findViewById(R.id.btnexit);
        btnguithongtin = findViewById(R.id.btnguithongtin);
        edthoten = findViewById(R.id.edthoten);
        edtcmnd = findViewById(R.id.edtcmnd);
        edtbosung = findViewById(R.id.edtbosung);
        radtrungcap = findViewById(R.id.radtrungcap);
        radcaodang = findViewById(R.id.radcaodang);
        raddaihoc = findViewById(R.id.raddaihoc);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkcoding = findViewById(R.id.chkcoding);
        idgroup = findViewById(R.id.idgroup);


        // sự kiện
        btnguithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten= edthoten.getText().toString();
                String cmnd = edtcmnd.getText().toString();
                if(hoten.length() <= 3)
                {
                    Toast.makeText(MainActivity.this,"Họ tên phải có trên 3 kí tự", Toast.LENGTH_LONG).show();
                    edthoten.selectAll();
                    edthoten.requestFocus();
                    return;
                }
                if(cmnd.length() != 9)
                {
                    Toast.makeText(MainActivity.this,"CMND phải đủ 9 số", Toast.LENGTH_LONG).show();
                    edtcmnd.selectAll();
                    edtcmnd.requestFocus();
                    return;
                }
                // lay thong tin bang cap
                String bangcap ="";
                if(radcaodang.isChecked())
                {
                    bangcap = radcaodang.getText().toString();
                }
                else if(raddaihoc.isChecked())
                {
                    bangcap = raddaihoc.getText().toString();
                }
                else {
                    bangcap= radtrungcap.getText().toString();
                }
                // lay thong tin so thich
                String sothich = "";
                if(chkdocsach.isChecked())
                {
                    sothich += chkdocsach.getText().toString()+"-";
                }
                if(chkdocbao.isChecked())
                {
                    sothich += chkdocbao.getText().toString()+"-";
                }
                if(chkcoding.isChecked())
                {
                    sothich += chkcoding.getText().toString()+"";
                }
                // lay thong tin bo sung
                String bosung = edtbosung.getText().toString();
                // tong hop thong tin
                String tonghop = hoten+"\n"+cmnd+"\n"+bangcap+"\n"+sothich+"\n";
                    tonghop+="----Thông tin bổ sung -------\n";
                    tonghop += bosung+"\n";
                AlertDialog.Builder mydailog = new AlertDialog.Builder(MainActivity.this);
                mydailog.setTitle("Thông Tin Cá Nhân");
                mydailog.setMessage(tonghop);
                mydailog.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydailog.create().show();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                //btnexit.setImageResource(R.drawable.exit);
                call_dialog();

            }
        });

    }

    private void call_dialog() {
        // tạo dialog
        AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
        mydialog.setTitle("Cảnh báo");
        mydialog.setMessage("Bạn có chắc muốn thoát ứng dụng không");
        mydialog.setIcon(R.drawable.sos);
        // tạo button yes
        mydialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        mydialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        mydialog.create().show();
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        call_dialog();
    }
}
