package com.example.yrw.myapplication3;
/*
 * 
 * created by yzy on 2017/11/1
 * ���Ҳ���������涪��
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yrw.myapplication3.controller.SendDateToServer;
import com.example.yrw.myapplication3.controller.SendJsonToServer;

public class shoppingConfirm extends Activity {
    EditText editText1,editText2;
	Button bt1;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.shoppingconfirm);
        editText1=(EditText)findViewById(R.id.shuliang);
        editText2=(EditText)findViewById(R.id.dizhi);
        bt1=(Button)findViewById(R.id.shoppingsubmit);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String goodsName=bundle.getString("goodsID");
        final String goodsID;
        //���д����������
        if(goodsName.equals("可乐")){
        	goodsID="1";	
        }
        else if(goodsName.equals("棒棒糖")){
        	goodsID="10";	
        }
        else if(goodsName.equals("矿泉水")){
        	goodsID="2";	
        }
        else if(goodsName.equals("薯片")){
        	goodsID="3";	
        }
        else if(goodsName.equals("方便面")){
        	goodsID="4";	
        }
        else if(goodsName.equals("饼干")){
        	goodsID="5";	
        }
        else if(goodsName.equals("辣条")){
        	goodsID="6";	
        }
        else if(goodsName.equals("面包")){
        	goodsID="7";	
        }
        else if(goodsName.equals("士力架")){
        	goodsID="8";	
        }
        else{
        	goodsID="9";        	
        }
        System.out.println(goodsID);
        bt1.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	String number=editText1.getText().toString();
            	if("".equals(editText1.getText().toString().trim())&&"".equals(editText2.getText().toString().trim())){
                		Toast.makeText(shoppingConfirm.this, "请完善信息", Toast.LENGTH_SHORT).show();
                		
                }
            	else{
            		System.out.println(goodsID);
                	new SendJsonToServer(handler).SendShoppingJsonToServer(goodsID,number);
                }            		            	            	            	
            }			
		});
    }
	Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {  
            case SendDateToServer.SEND_SUCCESS:  
                Toast.makeText(shoppingConfirm.this, "订单派送中,返回选购页", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(shoppingConfirm.this,shopping.class);
                startActivity(intent);
                break;  
            case SendDateToServer.SEND_FAIL:  
                Toast.makeText(shoppingConfirm.this, "库存不足", Toast.LENGTH_SHORT).show();
                break;    
            default:  
                break;  
            }  
        };        
    };
}
