package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView fahrenheit;
    private Button calculation;
    EditText input;                //宣告全域變數
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculation=(Button)findViewById(R.id.calculation);
        input = (EditText)findViewById(R.id.input);                           //取得溫度物件
        calculation = (Button)findViewById(R.id.calculation);             // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少
        fahrenheit= (TextView)findViewById(R.id.fahrenheit);
        // 按下按鈕 觸發事件
        calculation.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {

                String[] account = {"轉換為攝氏"};
                for (int i = 0; i < account.length; i++) { // 用一個迴圈把帳號跟密碼從陣列取出
                    if (!calculation.getText().toString().equals(account[i])) {
                        calculation.setText("轉換為攝氏");
                        fahrenheit.setText("華氏溫度:");
                        float fh = Float.parseFloat(input.getEditableText().toString());      // 取得 溫度輸入值
                        float fresult;                                     // 計算結果
                        TextView result = (TextView)findViewById(R.id.output);// 取得 顯示結果 物件
                        fh = fh*9/5+32;


                        NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                        nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                        fresult = fh;                                // 計算
                        result.setText(nf.format(fh) +"°F");           // 顯示計算結果



                    }
                    else {
                        calculation.setText("轉換為華氏溫度");
                        fahrenheit.setText("攝氏溫度:");
                        float fh = Float.parseFloat(input.getEditableText().toString());      // 取得 溫度輸入值
                        float fresult;                                     // 計算結果
                        TextView result = (TextView)findViewById(R.id.output);// 取得 顯示結果 物件
                        fh = fh;


                        NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                        nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                        fresult = fh;                                // 計算
                        result.setText(nf.format(fh) +"°C");           // 顯示計算結果


                    }
                }
            }
        });
    }
}