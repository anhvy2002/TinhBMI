package com.test.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextChieuCao, editTextCanNang;
    Button btDanhGia;
    TextView textViewBMI, textViewDanhGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDanhGia = (Button) findViewById(R.id.btDanhGia);
        editTextChieuCao = (EditText) findViewById(R.id.editTextChieuCao);
        editTextCanNang = (EditText) findViewById(R.id.editTextCanNang);
        textViewBMI = (TextView) findViewById(R.id.textViewBMI);
        textViewDanhGia = (TextView) findViewById(R.id.textViewDanhGia);

        btDanhGia.setOnClickListener(view -> {
            textViewBMI.setText("");
            textViewDanhGia.setText("");
            if(editTextChieuCao.getText().toString().isEmpty() && editTextCanNang.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Chưa nhập chiều cao và cân nặng !!!", Toast.LENGTH_SHORT).show();
                editTextChieuCao.requestFocus();
            }else if (editTextChieuCao.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Chưa nhập chiều cao !!!", Toast.LENGTH_SHORT).show();
                editTextChieuCao.requestFocus();
            }else if (editTextCanNang.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Chưa nhập cân nặng !!!", Toast.LENGTH_SHORT).show();
                editTextCanNang.requestFocus();
            }else{
                double cc = Double.parseDouble(editTextChieuCao.getText()+"");
                double cn = Double.parseDouble(editTextCanNang.getText()+"");
                DecimalFormat dcf =new DecimalFormat("0.00");
                double BMI = cn / Math.pow(cc, 2);
                if(cc==0 || cn==0)
                    Toast.makeText(MainActivity.this, "Chiều cao, cân nặng phải khác 0 !!!", Toast.LENGTH_SHORT).show();
                else{
                    textViewBMI.setText("Chỉ số BMI của bạn: " + dcf.format(BMI));
                    if(BMI < 18)
                        textViewDanhGia.setText("Người gầy");
                    else if(18 <= BMI && BMI <= 24.9)
                        textViewDanhGia.setText("Người bình thường");
                    else if(24.9 < BMI && BMI <= 29.9)
                        textViewDanhGia.setText("Người béo phì độ 1");
                    else if(29.9 < BMI && BMI <= 34.9)
                        textViewDanhGia.setText("Người béo phì độ 2");
                    else
                        textViewDanhGia.setText("Người béo phì độ 3");
                }
            }
        });

    }
}