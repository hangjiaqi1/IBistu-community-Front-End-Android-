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

public class MainActivity extends Activity {
	EditText editText1,editText2,editText3,editText4,editText5;
	Button bt1,bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);
		editText1=(EditText)findViewById(R.id.user_phone_input);
		editText2=(EditText)findViewById(R.id.user_name_input);
		editText3=(EditText)findViewById(R.id.user_id_card_input);
		editText4=(EditText)findViewById(R.id.user_password_input);
		editText5=(EditText)findViewById(R.id.user_password_input_d);
		//ע��button
		bt1=(Button)findViewById(R.id.register_button);
		//��½button
		bt2=(Button)findViewById(R.id.register_text);
		bt1.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	String phone=editText1.getText().toString();
            	String name=editText2.getText().toString();
            	String eid=editText3.getText().toString();
            	//System.out.println(editText3.getText().toString());
            	String pwd=editText4.getText().toString();
            	String pwdA=editText5.getText().toString();
            	if(!editText4.getText().toString().trim().equals(editText5.getText().toString().trim())){
            		Toast.makeText(MainActivity.this, "密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
            		//清空
            		editText4.setText("");
            		editText5.setText("");
        		}
            	else if(phone.length()!=10){
            		
            		Toast.makeText(MainActivity.this, "请输入10位正确学生证号码", Toast.LENGTH_SHORT).show();
            	}
				else if("".equals(name)){

					Toast.makeText(MainActivity.this, "请输入昵称", Toast.LENGTH_SHORT).show();
				}
				else if("".equals(pwd)){

					Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
				}

				else if("".equals(pwdA)){

					Toast.makeText(MainActivity.this, "请输入确认密码", Toast.LENGTH_SHORT).show();
				}

            	/*else if("".equals(editText1.getText().toString().trim())&&"".equals(editText2.getText().toString().trim())&&"".equals(editText4.getText().toString().trim())&&"".equals(editText5.getText().toString().trim())){
                		Toast.makeText(MainActivity.this, "请完善个人信息", Toast.LENGTH_SHORT).show();
                		
                }*/
            	else{
                	new SendDateToServer(handler).SendDataToServer(phone,name,eid,pwd);

                }

            }			
		});
		bt2.setOnClickListener(new Button.OnClickListener(){//创建监听
	        public void onClick(View v) {
	        	//点击输入框按钮跳转到登陆界面
	    		Intent intent =new Intent(MainActivity.this,LoginPage.class);
				//因为这里在做测试，所以跳转到了商城界面
	        	//Intent intent =new Intent(MainActivity.this,shopping.class);
	            startActivity(intent);
	        }    
	    });
	}
	Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {  
            case SendDateToServer.SEND_SUCCESS:  
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
				Intent intent =new Intent(MainActivity.this,Main1Activity.class);
				startActivity(intent);
                break;  
            case SendDateToServer.SEND_FAIL:  
                Toast.makeText(MainActivity.this, "用户名已存在，请重新输入", Toast.LENGTH_SHORT).show();
                break;    
            default:  
                break;  
            }  
        };        
    };
	
	
	
}
