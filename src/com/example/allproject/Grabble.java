package com.example.allproject;

import java.util.ArrayList;

import com.example.message.R;
import com.example.message.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.iflytek.speech.SpeechRecognizer;
import com.iflytek.speech.SpeechUtility;

public class Grabble extends Activity {
	
	String string,password,username;
	ArrayList<String> arrayList;
	ArrayList<String >cellphone,company,department,province1,district1,realname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__grabble);
		
		
		 //接收传过来的token值
   	    string=getIntent().getStringExtra("token");
   	    System.out.println("接收到的token值"+string);
        //接收传过来的登录名
   	    username=getIntent().getStringExtra("name");
   	    System.out.println("收到的用户名"+username);
   	    //接收传过来的登录密码
   	    password=getIntent().getStringExtra("password");
   	    System.out.println("收到的登录密码"+password);
   	    //接收传过来的手机号
   	    cellphone=getIntent().getStringArrayListExtra("cellphone");
   	     System.out.println("收到的手机号"+cellphone);
   	    //接收传过来的所属单位
   	     company=getIntent().getStringArrayListExtra("company");
   	     System.out.println("收到的所属单位"+company);
   	    //接收传过来的职务
   	     department=getIntent().getStringArrayListExtra("department");
   	     System.out.println("收到的职务"+department);
   	    //接收传过来的区域
		 district1=getIntent().getStringArrayListExtra("district");
		 System.out.println("接收到的职务"+district1);
		 //接收传过来的城市
		 province1=getIntent().getStringArrayListExtra("province");
		 System.out.println("接收到的职务"+province1);
		 //接收传过来的城市
		 realname=getIntent().getStringArrayListExtra("realname");
		 System.out.println("接收到的名字"+realname);
		
		
		ImageView grable=(ImageView) findViewById(id.imageView1);//语音键
		final TextView content=(TextView) findViewById(id.voice);
		
		if(SpeechUtility.getUtility(Grabble.this).queryAvailableEngines()==null||SpeechUtility.getUtility(Grabble.this).queryAvailableEngines().length<=0){
			
		}
		
		//设置申请的应用的appid
		SpeechUtility.getUtility(Grabble.this).setAppid("4d6774d0");
		//初始化识别对象
		
		
		
		
		
		
		
		
		
		
		grable.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			
			content.setText("正在接收内容。。。。。。");	
				
			}
		});
		
		
	}
	 @Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		 
		 Intent intent=new Intent(Grabble.this,Choosemenu.class);
		 intent.putExtra("token", string);
	   	 intent.putExtra("name", username);
		 intent.putExtra("password", password);
		 intent.putExtra("cellphone", cellphone);
		 intent.putExtra("company", company);
		 intent.putExtra("department", department);
		 intent.putExtra("district", district1);
		 intent.putExtra("province", province1);
		 intent.putExtra("realname", realname);
		 startActivity(intent);
		 finish();
		 
	}
}