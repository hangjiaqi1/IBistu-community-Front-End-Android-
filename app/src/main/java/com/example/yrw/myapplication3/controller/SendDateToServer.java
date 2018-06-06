package com.example.yrw.myapplication3.controller;
/*
 * 
 * created by yzy on 2017/11/1
 * 
 */

import android.os.Handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SendDateToServer {
	//120.77.40.242
	//ע��url
	final  public  static String url="http://120.77.40.242:1111/home/GetMSG";
	//final  public  static  String url="http://10.0.2.2:1111/home/GetMSG";
	//��½url
	//final  public  static  String url_Login="http://10.0.2.2:1111/home/Login";
	final  public  static String url_Login="http://120.77.40.242:1111/home/Login";
	public static final int SEND_SUCCESS=0x123;  
    public static final int SEND_FAIL=0x124;
    private Handler handler;
    public SendDateToServer(Handler handler) {
        // TODO Auto-generated constructor stub  
        this.handler=handler;  
    }
    
    
    //һ��������Ӧһ��http����
    public void SendDataToServer(String phone, String name, String eid, String pwd) {
        // TODO Auto-generated method stub  
        final Map<String, String> map=new HashMap<String, String>();
        map.put("phone", phone);
        map.put("name", name);  
        map.put("eid", eid);
        map.put("pwd", pwd);  
        new Thread(new Runnable() {
            @Override
            public void run() {  
                // TODO Auto-generated method stub  
                try {  
                     if (sendPostRequest(map,url,"utf-8")) {  
                        handler.sendEmptyMessage(SEND_SUCCESS);//֪ͨ���߳����ݷ��ͳɹ�  
                    }else {  
                    	handler.sendEmptyMessage(SEND_FAIL);//�����ݷ��͸�������ʧ��  
                    }  
                } catch (Exception e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }                 
            }  
        }).start();  
    }
    
    
    //sendpostRequest�������Դ������ã�����ֱ����keyvalue��ʽ����ֵ����Ҫ��дһ����json��ʽ�ķ�����
    private  boolean sendPostRequest(Map<String, String> param, String url, String encoding) throws Exception {
    	//����map�е����ݡ�����stringBuffer�ַ�����Ȼ�����byte[]����
        StringBuffer sb=new StringBuffer(url);
        if (!url.equals("")&!param.isEmpty()) {    //�ж�url�ʹ��β�Ϊ��   
            sb.append("?");  
            for (Map.Entry<String, String>entry:param.entrySet()) {   //��map�е�Ԫ�ط���entry��
                sb.append(entry.getKey()+"=");                
                sb.append(URLEncoder.encode(entry.getValue(), encoding));
                sb.append("&");  
            }  
            sb.deleteCharAt(sb.length()-1);//ɾ���ַ������ һ���ַ���&��  
        }  
        //����url�������
        System.out.println(sb.toString());
        //ת��Ϊ������
        byte[]data=sb.toString().getBytes();  
        //������url�������
        System.out.println(Arrays.toString(data));
        //����http����
        HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
        conn.setConnectTimeout(5000);  
        conn.setRequestMethod("POST");//��������ʽΪPOST  
        conn.setDoOutput(true);//������⴫������  
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// ���ô������ݱ���Ϊ����/ֵ��  
        conn.setRequestProperty("Content-Length", data.length+"");  
        OutputStream outputStream=conn.getOutputStream();//�򿪷�������������
        outputStream.write(data);//������д�뵽�������������  
        outputStream.flush();  
        if (conn.getResponseCode()==200) {  //״̬��=200������ɹ�����������
        	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
        	String lines;
        	        while ((lines = reader.readLine()) != null){
        	            System.out.println(lines);
        	            //�жϺ�̨������
        	            //����0000�����������ͬע����Ϣ��ǰ����ʾע��ʧ��
        	            //�����ص���id,�����ע��ɹ�
        	            if(lines.equals("0000")){
        	            	return false;       	            	
        	            }
        	        }
        	return true;        
        }       
        return false;

    }
}
