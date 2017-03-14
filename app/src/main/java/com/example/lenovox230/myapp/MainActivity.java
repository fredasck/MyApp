package com.example.lenovox230.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView printText;
    EditText inputDigital;

    Button btnOk;
    Button btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        inputDigital = (EditText) findViewById(R.id.inputDigital);
        printText = (TextView) findViewById(R.id.printText);
        btnOk = (Button) findViewById(R.id.ok);
        btnCancle = (Button) findViewById(R.id.cancle);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  String s = "Hello World!";
                if (TextUtils.isEmpty(inputDigital.getText().toString())) {
                    return;
                }
                switch ((v.getId())){
                    case R.id.ok:
                        if (!inputDigital.getText().toString().matches("(?i).*[a-zA-Z].*")) {
                            printText.setText(inputDigital.getText().toString());
                        }
                        break;
                    case R.id.cancle:
                        inputDigital.getText().clear();
                        printText.setText(null);
                        break;
                }
            }
        };

        btnCancle.setOnClickListener(onClickListener);
        btnOk.setOnClickListener(onClickListener);
    }
}

