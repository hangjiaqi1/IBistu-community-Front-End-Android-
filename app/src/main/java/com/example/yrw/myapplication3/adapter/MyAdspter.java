package com.example.yrw.myapplication3.adapter;
/*
 * 
 * created by yzy on 2017/11/1
 * 
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yrw.myapplication3.R;
import com.example.yrw.myapplication3.entity.shoppingdomain;

import java.util.List;

public class MyAdspter extends ArrayAdapter {
	private final int resourceId;
	public MyAdspter(Context context, int textViewResourceId, List<shoppingdomain> objects) {
        super(context, textViewResourceId, objects);  
        resourceId = textViewResourceId;  
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	shoppingdomain fruit = (shoppingdomain) getItem(position);
    	View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//ʵ����һ������
            //zujian.image=(ImageView)convertView.findViewById(R.id.image); 
    		ImageView img=(ImageView) view.findViewById(R.id.image);
            //zujian.title=(TextView)convertView.findViewById(R.id.title); 
    		TextView name = (TextView) view.findViewById(R.id.title);//��ȡ�ò����ڵ��ı���ͼ
            //  zujian.view=(Button)convertView.findViewById(R.id.view);  
            //zujian.info=(TextView)convertView.findViewById(R.id.info); 
    		TextView submit = (TextView) view.findViewById(R.id.info);
    		img.setImageResource(fruit.getImgId());
    		name.setText(fruit.getName());
    		submit.setText(fruit.getSubmit());
        return view;  
    }  
  
}