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
			   Toast.makeText(Modification.this, "�޸�����ɹ�", Toast.LENGTH_SHORT).show();
		   }else if(msg.what==2){
			   Toast.makeText(Modification.this, "�����ԭ�����������������", Toast.LENGTH_SHORT).show();
		   }else if(msg.what==3){
				Toast.makeText(Modification.this, "����������������벻ͬ������������", Toast.LENGTH_SHORT).show();
			}
	   };	
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__modification);
		
		oldpassword=(EditText) findViewById(id.oldpassword);//������
		newpassword=(EditText) findViewById(id.newpassword);//������
		newpasswordtwo=(EditText) findViewById(id.newpassword1);//�ٴ�����������
		result=(ImageView) findViewById(id.result);//���ص�������
		sucess=(ImageView) findViewById(id.sucess);//ȷ���޸�
		
		//ȥ���Ի���
		oldpassword.setBackgroundDrawable(null);
		newpassword.setBackgroundDrawable(null);
		newpasswordtwo.setBackgroundDrawable(null);
		
		//���մ�������tokenֵ
		token=getIntent().getStringExtra("token");
		System.out.println("�޸����������ܵ�tokenֵ:"+token);
		//���մ��������û�����
	    username=getIntent().getStringExtra("username");
		System.out.println("�޸����������ܵ��û�����:"+username);
		//���մ��������û�����
		userpassword=getIntent().getStringExtra("userpassword");
		System.out.println("�޸����������ܵ��û�����:"+userpassword);
		 //���մ��������ֻ���
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("�������յ����ֻ���"+cellphone);
		 //���մ�������������λ
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("�������յ���������λ"+company);
		 //���մ�������ְ��
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("�������յ���ְ��"+department);
		 //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
		
		
		//�޸�����Ĳ���
		sucess.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				new Thread(){
					public void run() {
						
					
						String firString=newpassword.getText().toString();
						String twoString=newpasswordtwo.getText().toString();
						
					
						//�ж����������Ƿ���ͬ	
						if(firString.equals(twoString)){

						HttpClient httpClient=new DefaultHttpClient();
						HttpPut httpPut=new HttpPut("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/");
						//��װ����
						JSONObject jsonObject=new JSONObject();
						try {
							jsonObject.put("oldPassword", oldpassword.getText().toString());
							jsonObject.put("newPassword", newpassword.getText().toString());
							jsonObject.put("token", token);
						} catch (JSONException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
						System.out.println("�޸���������ƴ������:"+jsonObject.toString());
						
						try {
							httpPut.addHeader("Content-Type"," application/json; charset=UTF-8");
							httpPut.setEntity(new StringEntity(jsonObject.toString()));
							HttpResponse httpResponse=httpClient.execute(httpPut);
							httpResponse.getStatusLine().getStatusCode();
							System.out.println("�޸��������������ֵ��"+httpResponse.getStatusLine().getStatusCode());
							if(httpResponse.getStatusLine().getStatusCode()==200){
								HttpEntity httpEntity=httpResponse.getEntity();
								String string=EntityUtils.toString(httpEntity);
								System.out.println("���ܵ��ķ���ֵ"+string);
								if(string.contains("200")){
									handler.sendEmptyMessage(1);
								}else {
									handler.sendEmptyMessage(2);
								}
							}
						} catch (UnsupportedEncodingException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
						
					
					}else if(firString!=twoString){
						handler.sendEmptyMessage(3);
					
					}
					};
				}.start();
				
			}
		});
		
		
		//���ص�������
		result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
	//���÷��ؼ�
	@Override
	public void onBackPressed() {
		// TODO �Զ����ɵķ������
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