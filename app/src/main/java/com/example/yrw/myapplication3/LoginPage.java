package com.example.yrw.myapplication3;
/*
 * 
 * created by yzy on 2017/11/1
 * 
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import com.example.yrw.myapplication3.controller.SendDateToServer;
import com.example.yrw.myapplication3.controller.SendJsonToServer;


public class LoginPage extends Activity {
	EditText editText1,editText2;
	Button bt1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
        setContentView(R.layout.loginpage);
        editText1=(EditText)findViewById(R.id.edit1);
        editText2=(EditText)findViewById(R.id.edit2);
        bt1=(Button)findViewById(R.id.register_text);
        bt1.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	String phone=editText1.getText().toString();
            	String pwd=editText2.getText().toString();
            	if("".equals(editText1.getText().toString().trim())&&"".equals(editText2.getText().toString().trim())){
                		Toast.makeText(LoginPage.this, "请填写账户及密码", Toast.LENGTH_SHORT).show();
                		
                }
            	else{
                	new SendJsonToServer(handler).SendJsonToServer(phone,pwd);
                }

            }			
		});
        
	}
	Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {  
            case SendDateToServer.SEND_SUCCESS:  
                Toast.makeText(LoginPage.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(LoginPage.this,Main1Activity.class);
                startActivity(intent);
                break;  
            case SendDateToServer.SEND_FAIL:  
                Toast.makeText(LoginPage.this, "密码不匹配", Toast.LENGTH_SHORT).show();
                break;    
            default:  
                break;  
            }  
        };        
    };
}
