package com.example.allproject;

import java.util.ArrayList;

import com.example.message.R;
import com.example.message.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class Choosemenu extends Activity {
	
	String string,password,username;
	ArrayList<String> arrayList;
	ArrayList<String >cellphone,company,department,province1,district1,realname;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity__choosemenu);
		
		ImageView voice=(ImageView) findViewById(id.imageView4);//语音搜索
		ImageView advanced=(ImageView) findViewById(id.imageView2);//高级内容搜索
		ImageView map=(ImageView) findViewById(id.imageView3);//地图搜索
		EditText contentEditText=(EditText) findViewById(id.sky);
		contentEditText.setBackgroundDrawable(null);
		
		 //接收传过来的token值
   	    string=getIntent().getStringExtra("token");
   	    System.out.println("消防绿化界面接收到的token值"+string);
        //接收传过来的登录名
   	    username=getIntent().getStringExtra("name");
   	    System.out.println("消防绿化界面收到的用户名"+username);
   	    //接收传过来的登录密码
   	    password=getIntent().getStringExtra("password");
   	    System.out.println("消防绿化界面收到的登录密码"+password);
   	    //接收传过来的手机号
   	    cellphone=getIntent().getStringArrayListExtra("cellphone");
   	     System.out.println("消防绿化界面收到的手机号"+cellphone);
   	    //接收传过来的所属单位
   	     company=getIntent().getStringArrayListExtra("company");
   	     System.out.println("消防绿化界面收到的所属单位"+company);
   	    //接收传过来的职务
   	     department=getIntent().getStringArrayListExtra("department");
   	     System.out.println("消防绿化界面收到的职务"+department);
   	    //接收传过来的区域
		 district1=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district1);
		 //接收传过来的城市
		 province1=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province1);
		 //接收传过来的城市
		 realname=getIntent().getStringArrayListExtra("realname");
		 System.out.println("土地规划接收到的名字"+realname);
		
		
		
		//语音搜索
		voice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
		
				Intent intent=new Intent(Choosemenu.this,Grabble.class);
				 startActivity(intent);
				 finish();	
			}
		});
		
		
		
		//高级内容搜索
		advanced.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Choosemenu.this,Advanced.class);
				 startActivity(intent);
				 finish();	
			}
		});
		
		
		
		//地图搜素
		map.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
	}
	// 设置返回键
		@Override
		public void onBackPressed() {
			// TODO 自动生成的方法存根

			Intent intent = new Intent(Choosemenu.this, Allproject.class);
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
