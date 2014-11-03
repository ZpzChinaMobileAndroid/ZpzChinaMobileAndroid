package com.example.allproject;

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
	
}
