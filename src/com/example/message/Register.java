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
				Toast.makeText(Register.this, "注册成功，请重新登陆", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Register.this,MainActivity.class);
				startActivity(intent);
				finish();	
			}else if (msg.what==2) {
				Toast.makeText(Register.this, "用户名已存在，请重新填入注册信息", Toast.LENGTH_SHORT).show();
			}else if(msg.what==3) {
				Toast.makeText(Register.this, "对不起，您两次输入的密码不同，请重新输入", Toast.LENGTH_SHORT).show();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__register);
	
		 mobliphone=(EditText) findViewById(R.id.mobliphone); //请填写手机号
		 testing=(EditText) findViewById(R.id.testing);//请输入验证码
	     password=(EditText) findViewById(R.id.password);//第一次输入密码
		 repeat=(EditText) findViewById(R.id.repeat);//第二次输入密码
		 register=(ImageView) findViewById(R.id.imageview);//注册
		  cancel=(ImageView) findViewById(R.id.imageview1);//取消
		 
		 //取消对话框边缘
		mobliphone.setBackgroundDrawable(null);
		testing.setBackgroundDrawable(null);
		password.setBackgroundDrawable(null);
		repeat.setBackgroundDrawable(null);
		
		
		//注册设置
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			new Thread(){
				@Override
				public void run() {
					// TODO 自动生成的方法存根
			//判断输入的用户密码是否相同
			String firtString=	password.getText().toString(); System.out.println("密码1："+firtString);
			String twoString=	repeat.getText().toString(); System.out.println("密码2："+twoString);
			
			if(firtString.equals(twoString)){
					
				HttpClient httpClient =new DefaultHttpClient();	
				HttpPost httpPost=new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/Register");
				JSONObject jsonObject=new JSONObject();
				try {
					jsonObject.put("userName", mobliphone.getText().toString());
					jsonObject.put("password", password.getText().toString());
					jsonObject.put("DeviceType", "mobile");
					System.out.println("注册账号的拼接为："+jsonObject.toString());
				} catch (JSONException e) {
					// TODO 自动生成的 catch 块
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
						System.out.println("注册后收到的返回值:" + string);
				   if(string.contains("200")){
					   handler.sendEmptyMessage(1);
				   }else{
					   handler.sendEmptyMessage(2);
				   }
				   }
			} catch (ClientProtocolException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}else if(firtString!=twoString) {
					handler.sendEmptyMessage(3);
				}	
				};
			}.start();	
			}
		});
		
		//取消设置
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Register.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
  }
	//设置返回键
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		Intent intent=new Intent(Register.this,MainActivity.class);
		startActivity(intent);
		finish();	
	}
}