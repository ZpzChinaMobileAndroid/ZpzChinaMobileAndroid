package com.example.message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.message.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Modification extends Activity{

	ImageView result,sucess;
	EditText oldpassword,newpassword,newpasswordtwo;
	String token,userpassword,username;
	ArrayList<String >cellphone,company,department,province,district;
	
	Handler handler=new Handler(){
	   public void handleMessage(android.os.Message msg) {
		   if(msg.what==1){
			   Intent intent=new Intent(Modification.this,Homepage.class);
				intent.putExtra("token", token);
				intent.putExtra("name", username);
				intent.putExtra("password", userpassword);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
			   startActivity(intent);
			   finish();
			   Toast.makeText(Modification.this, "修改密码成功", Toast.LENGTH_SHORT).show();
		   }else if(msg.what==2){
			   Toast.makeText(Modification.this, "输入的原密码错误，请重新输入", Toast.LENGTH_SHORT).show();
		   }else if(msg.what==3){
				Toast.makeText(Modification.this, "您输入的两次新密码不同，请重新输入", Toast.LENGTH_SHORT).show();
			}
	   };	
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__modification);
		
		oldpassword=(EditText) findViewById(id.oldpassword);//旧密码
		newpassword=(EditText) findViewById(id.newpassword);//新密码
		newpasswordtwo=(EditText) findViewById(id.newpassword1);//再次输入新密码
		result=(ImageView) findViewById(id.result);//返回到主界面
		sucess=(ImageView) findViewById(id.sucess);//确认修改
		
		//去掉对话框
		oldpassword.setBackgroundDrawable(null);
		newpassword.setBackgroundDrawable(null);
		newpasswordtwo.setBackgroundDrawable(null);
		
		//接收传过来的token值
		token=getIntent().getStringExtra("token");
		System.out.println("修改密码界面接受的token值:"+token);
		//接收传过来的用户密码
	    username=getIntent().getStringExtra("username");
		System.out.println("修改密码界面接受的用户密码:"+username);
		//接收传过来的用户密码
		userpassword=getIntent().getStringExtra("userpassword");
		System.out.println("修改密码界面接受的用户密码:"+userpassword);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("主界面收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("主界面收到的所属单位"+company);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("主界面收到的职务"+department);
		 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
		
		
		//修改密码的操作
		sucess.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				new Thread(){
					public void run() {
						
					
						String firString=newpassword.getText().toString();
						String twoString=newpasswordtwo.getText().toString();
						
					
						//判断两次密码是否相同	
						if(firString.equals(twoString)){

						HttpClient httpClient=new DefaultHttpClient();
						HttpPut httpPut=new HttpPut("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/");
						//分装数据
						JSONObject jsonObject=new JSONObject();
						try {
							jsonObject.put("oldPassword", oldpassword.getText().toString());
							jsonObject.put("newPassword", newpassword.getText().toString());
							jsonObject.put("token", token);
						} catch (JSONException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("修改密码界面的拼接数据:"+jsonObject.toString());
						
						try {
							httpPut.addHeader("Content-Type"," application/json; charset=UTF-8");
							httpPut.setEntity(new StringEntity(jsonObject.toString()));
							HttpResponse httpResponse=httpClient.execute(httpPut);
							httpResponse.getStatusLine().getStatusCode();
							System.out.println("修改密码的网络连接值："+httpResponse.getStatusLine().getStatusCode());
							if(httpResponse.getStatusLine().getStatusCode()==200){
								HttpEntity httpEntity=httpResponse.getEntity();
								String string=EntityUtils.toString(httpEntity);
								System.out.println("接受到的返回值"+string);
								if(string.contains("200")){
									handler.sendEmptyMessage(1);
								}else {
									handler.sendEmptyMessage(2);
								}
							}
						} catch (UnsupportedEncodingException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					
					}else if(firString!=twoString){
						handler.sendEmptyMessage(3);
					
					}
					};
				}.start();
				
			}
		});
		
		
		//返回到主界面
		result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Modification.this,Homepage.class);
				intent.putExtra("token", token);
				  intent.putExtra("name", username);
				intent.putExtra("password", userpassword);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				startActivity(intent);
				finish();
			}
		});

  }
	//设置返回键
	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		Intent intent=new Intent(Modification.this,Homepage.class);
		intent.putExtra("token", token);
		intent.putExtra("name", username);
		intent.putExtra("password", userpassword);
		intent.putExtra("cellphone", cellphone);
		intent.putExtra("company", company);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
		startActivity(intent);
		finish();
	}
}