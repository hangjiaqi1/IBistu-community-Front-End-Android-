package com.example.yrw.myapplication3.controller;
/*
 * 
 * created by yzy on 2017/11/1
 * 
 */

import android.os.Handler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SendJsonToServer {
	//final  public  static  String url_Login="http://10.0.2.2:1111/home/Login";
	final  public  static String url_Login="http://120.77.40.242:1111/home/Login";
	//final  public  static  String url_shopping="http://10.0.2.2:1111/home/Market";
	final  public  static String url_shopping="http://120.77.40.242:1111/home/Market";
	//
	final  public  static String url_CheckAll="http://120.77.40.242:1111/home/CheckAll";
	private Handler handler;
	public static final int SEND_SUCCESS=0x123;  
    public static final int SEND_FAIL=0x124;
    public SendJsonToServer(Handler handler) {
        // TODO Auto-generated constructor stub  
        this.handler=handler;  
    }
   
   
    
    //登陆
    private boolean sendjsonRequest(Map<String, String> param, String url, String encoding) throws Exception {
    	JSONObject jsonobject=new JSONObject();
    	jsonobject.put("name", param.get("name"));
    	jsonobject.put("pwd", param.get("pwd"));
    	String content= String.valueOf(jsonobject);
    	HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
    	conn.setConnectTimeout(5000);  
    	// �����������  
    	conn.setDoOutput(true);  
    	conn.setRequestMethod("POST");  
    	// ����User-Agent: Fiddler  
    	conn.setRequestProperty("ser-Agent", "Fiddler");  
    	// ����contentType  
    	conn.setRequestProperty("Content-Type","application/json");  
    	OutputStream os = conn.getOutputStream();
    	os.write(content.getBytes());  
    	os.close();
    	if (conn.getResponseCode()==200) {
    		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
    		String lines;
	        while ((lines = reader.readLine()) != null){
	            System.out.println(lines);
	            //�жϺ�̨������
	            //����0001��������벻��ȷ
	            //�����ص���id,������½�ɹ�
	            JSONObject json=new JSONObject(lines);
	            String code=json.getString("data");
	            //0001��½���벻ƥ��
	            //0002�̳ǿ�治��
	            if(code.equals("0001")||code.equals("0002")){
	            	return false;       	            	
	            }
	        }
	        	return true;  		
    	}
    	return false;
    	
    }
    //商城下单
    private boolean sendshoppingjsonRequest(Map<String, String> param, String url, String encoding) throws Exception {
    	JSONObject jsonobject=new JSONObject();
    	jsonobject.put("goodsID", param.get("goodsID"));
    	jsonobject.put("number", param.get("number"));
    	String content= String.valueOf(jsonobject);
    	HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
    	conn.setConnectTimeout(5000);  
    	// �����������  
    	conn.setDoOutput(true);  
    	conn.setRequestMethod("POST");  
    	// ����User-Agent: Fiddler  
    	conn.setRequestProperty("ser-Agent", "Fiddler");  
    	// ����contentType  
    	conn.setRequestProperty("Content-Type","application/json");  
    	OutputStream os = conn.getOutputStream();
    	os.write(content.getBytes());  
    	os.close();
    	if (conn.getResponseCode()==200) {
    		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
    		String lines;
	        while ((lines = reader.readLine()) != null){
	            System.out.println(lines);
	            //�жϺ�̨������
	            //����0001��������벻��ȷ
	            //�����ص���id,������½�ɹ�
	            JSONObject json=new JSONObject(lines);
	            String code=json.getString("data");
	            //0001��½���벻ƥ��
	            //0002�̳ǿ�治��
	            if(code.equals("0001")||code.equals("0002")){
	            	return false;       	            	
	            }
	        }
	        	return true;  		
    	}
    	return false;
    	
    }



    
    
    
    //��½ģ��
    //һ��ǰ�˽ӿ�дһ��
    public void SendJsonToServer(String name, String pwd){
    	final Map<String, String> map=new HashMap<String, String>();
    	map.put("name", name);
    	map.put("pwd", pwd);
    	//��map��ʽ����ת����json
    	//JSONObject jsonObject = JSONObject.fromObject(map);
    	//���Ѿ�ת�ø�ʽ��jsonת��string������������
    	//String content=String.valueOf(jsonObject);
    	new Thread(new Runnable() {
            @Override
            public void run() {  
                // TODO Auto-generated method stub  
                try {  
                     if(sendjsonRequest(map,url_Login,"utf-8")) {  
                        handler.sendEmptyMessage(SEND_SUCCESS);//֪ͨ���߳����ݷ��ͳɹ�  
                    }else {  
                        //�����ݷ��͸�������ʧ��  
                    	handler.sendEmptyMessage(SEND_FAIL);
                    }  
                } catch (Exception e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }                 
            }  
        }).start();
    	
    }
    
    //�̳�ģ��
    public void SendShoppingJsonToServer(String goodsID, String number){
    	final Map<String, String> map=new HashMap<String, String>();
    	map.put("goodsID", goodsID);
    	map.put("number", number);
    	//��map��ʽ����ת����json
    	//JSONObject jsonObject = JSONObject.fromObject(map);
    	//���Ѿ�ת�ø�ʽ��jsonת��string������������
    	//String content=String.valueOf(jsonObject);
    	new Thread(new Runnable() {
            @Override
            public void run() {  
                // TODO Auto-generated method stub  
                try {  
                     if(sendshoppingjsonRequest(map,url_shopping,"utf-8")) {  
                        handler.sendEmptyMessage(SEND_SUCCESS);//֪ͨ���߳����ݷ��ͳɹ�  
                    }else {  
                        //�����ݷ��͸�������ʧ��  
                    	handler.sendEmptyMessage(SEND_FAIL);
                    }  
                } catch (Exception e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }                 
            }  
        }).start();
    	
    }
    
    
}
