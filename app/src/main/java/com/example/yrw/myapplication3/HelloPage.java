package com.example.yrw.myapplication3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class HelloPage extends Activity {
	Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellopage);
		/*bt=(Button)findViewById(R.id.jumpbutton);
		bt.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	 Intent intent=new Intent(HelloPage.this,MainActivity.class);
            	 startActivity(intent);
            }			
		});*/
		 final Intent it = new Intent(this, MainActivity.class); //��Ҫת���Activity
		    Timer timer = new Timer();
		    TimerTask task = new TimerTask() {
		      @Override
		      public void run() {   
		      startActivity(it); //ִ��  
		       }  
		     }; 
		    timer.schedule(task, 1000 * 3); //8���


	}

}