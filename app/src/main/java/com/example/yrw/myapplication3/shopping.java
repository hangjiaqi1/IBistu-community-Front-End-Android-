package com.example.yrw.myapplication3;
/*
 * 
 * created by yzy on 2017/11/1
 * ���д����������
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yrw.myapplication3.adapter.MyAdspter;
import com.example.yrw.myapplication3.entity.shoppingdomain;

import java.util.ArrayList;
import java.util.List;

public class shopping extends Activity {
	  
	private List<shoppingdomain> WechatDomain=new ArrayList<shoppingdomain>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.shopping);  
        ListView listView=(ListView)findViewById(R.id.list);
        initFruits();
        MyAdspter adapter=new MyAdspter(shopping.this,R.layout.list,WechatDomain);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				//System.out.println(parent.getItemAtPosition(position));
				
				//String result = parent.getItemAtPosition(position).toString();
				shoppingdomain we=WechatDomain.get(position);//һ��position��Ӧlistview�е�һ��С�������������ж�����һ��С���Ӧһ��WechatDomain��������ֱ�ӵ���get����
				Toast.makeText(shopping.this, "确认订单中...", Toast.LENGTH_LONG).show();
				Intent intent =new Intent(shopping.this,shoppingConfirm.class);
				Bundle bundle=new Bundle();
	    	    //����name����Ϊtinyphp
	    	    bundle.putString("goodsID", we.getName());
	    	    intent.putExtras(bundle);
				startActivity(intent);		
			}
			
		});
    }  
    /*@Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    }  
  
    /*public List<Map<String, Object>> getData(){  
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();  
        for (int i = 0; i < 10; i++) {  
            Map<String, Object> map=new HashMap<String, Object>();  
            map.put("image", R.drawable.ic_launcher);  
            map.put("title", "����һ������"+i);  
            map.put("info", "ѡ����");  
            list.add(map);  
        }  
        return list;  
    }  */
    private void initFruits() {
    	shoppingdomain appleman=new shoppingdomain("可乐",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(appleman);
		shoppingdomain Bananaman=new shoppingdomain("矿泉水",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Bananaman);
		shoppingdomain orangeman=new shoppingdomain("薯片",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(orangeman);
		shoppingdomain Watermelonman=new shoppingdomain("方便面",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman);
		shoppingdomain Watermelonman1=new shoppingdomain("饼干",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman1);
		shoppingdomain Watermelonman2=new shoppingdomain("辣条",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman2);
		shoppingdomain Watermelonman3=new shoppingdomain("面包",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman3);
		shoppingdomain Watermelonman4=new shoppingdomain("士力架",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman4);
		shoppingdomain Watermelonman5=new shoppingdomain("口香糖",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman5);
		shoppingdomain Watermelonman6=new shoppingdomain("棒棒糖",R.drawable.ic_launcher,"点击购买");
		WechatDomain.add(Watermelonman6);
		

	}
}