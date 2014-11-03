package com.example.message;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends Activity{

	private	EditText mobliphone;
	private	EditText testing;
	private	EditText password;
	private	EditText repeat;
	private	ImageView register;
	private	 ImageView cancel;

	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				Toast.makeText(Register.this, "ע��ɹ��������µ�½", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Register.this,MainActivity.class);
				startActivity(intent);
				finish();	
			}else if (msg.what==2) {
				Toast.makeText(Register.this, "�û����Ѵ��ڣ�����������ע����Ϣ", Toast.LENGTH_SHORT).show();
			}else if(msg.what==3) {
				Toast.makeText(Register.this, "�Բ�����������������벻ͬ������������", Toast.LENGTH_SHORT).show();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__register);
	
		 mobliphone=(EditText) findViewById(R.id.mobliphone); //����д�ֻ���
		 testing=(EditText) findViewById(R.id.testing);//��������֤��
	     password=(EditText) findViewById(R.id.password);//��һ����������
		 repeat=(EditText) findViewById(R.id.repeat);//�ڶ�����������
		 register=(ImageView) findViewById(R.id.imageview);//ע��
		  cancel=(ImageView) findViewById(R.id.imageview1);//ȡ��
		 
		 //ȡ���Ի����Ե
		mobliphone.setBackgroundDrawable(null);
		testing.setBackgroundDrawable(null);
		password.setBackgroundDrawable(null);
		repeat.setBackgroundDrawable(null);
		
		
		//ע������
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			new Thread(){
				@Override
				public void run() {
					// TODO �Զ����ɵķ������
			//�ж�������û������Ƿ���ͬ
			String firtString=	password.getText().toString(); System.out.println("����1��"+firtString);
			String twoString=	repeat.getText().toString(); System.out.println("����2��"+twoString);
			
			if(firtString.equals(twoString)){
					
				HttpClient httpClient =new DefaultHttpClient();	
				HttpPost httpPost=new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/Register");
				JSONObject jsonObject=new JSONObject();
				try {
					jsonObject.put("userName", mobliphone.getText().toString());
					jsonObject.put("password", password.getText().toString());
					jsonObject.put("DeviceType", "mobile");
					System.out.println("ע���˺ŵ�ƴ��Ϊ��"+jsonObject.toString());
				} catch (JSONException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
		}	
				try {
				   httpPost.addHeader("Content-Type"," application/json; charset=UTF-8");
				   httpPost.setEntity(new StringEntity(jsonObject.toString()));
				   HttpResponse httpResponse=httpClient.execute(httpPost);
				   httpResponse.getStatusLine().getStatusCode();
				   if( httpResponse.getStatusLine().getStatusCode()==200){
					   HttpEntity entity = httpResponse.getEntity();
						String string = EntityUtils.toString(entity);
						System.out.println("ע����յ��ķ���ֵ:" + string);
				   if(string.contains("200")){
					   handler.sendEmptyMessage(1);
				   }else{
					   handler.sendEmptyMessage(2);
				   }
				   }
			} catch (ClientProtocolException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}else if(firtString!=twoString) {
					handler.sendEmptyMessage(3);
				}	
				};
			}.start();	
			}
		});
		
		//ȡ������
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent(Register.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
  }
	//���÷��ؼ�
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		Intent intent=new Intent(Register.this,MainActivity.class);
		startActivity(intent);
		finish();	
	}
}