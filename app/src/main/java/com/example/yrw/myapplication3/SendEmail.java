package com.example.yrw.myapplication3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendemail);
        this.setTitle("邮件服务");
        Button button;

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editText1,editText2,editText3;
                editText2=(EditText)findViewById(R.id.editText2);//邮件主题
                editText3=(EditText)findViewById(R.id.editText3);//邮件内容
                editText1=(EditText)findViewById(R.id.editText1);//收件人邮箱
                //editText1=(EditText)findViewById(R.id.editText4);
                final String a=editText1.getText().toString();//收件人邮箱
                final String b=editText2.getText().toString();//邮件主题
                final String c=editText3.getText().toString();

                Intent i = new Intent(Intent.ACTION_SEND);
                 //i.setType("text/plain"); //模拟器请使用这行
                i.setType("message/rfc822"); // 真机上使用这行
                i.putExtra(Intent.EXTRA_EMAIL, new String[] {a});
                i.putExtra(Intent.EXTRA_SUBJECT, b);
                i.putExtra(Intent.EXTRA_TEXT, c);
                startActivity(Intent.createChooser(i,
                        "Select email application."));
            }
        });

    }
}
