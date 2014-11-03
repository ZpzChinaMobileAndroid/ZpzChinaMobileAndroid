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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity__choosemenu);
		
		ImageView voice=(ImageView) findViewById(id.imageView4);//��������
		ImageView advanced=(ImageView) findViewById(id.imageView2);//�߼���������
		ImageView map=(ImageView) findViewById(id.imageView3);//��ͼ����
		EditText contentEditText=(EditText) findViewById(id.sky);
		contentEditText.setBackgroundDrawable(null);
		
		//��������
		voice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
		
				Intent intent=new Intent(Choosemenu.this,Grabble.class);
				 startActivity(intent);
				 finish();	
			}
		});
		
		
		
		//�߼���������
		advanced.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent(Choosemenu.this,Advanced.class);
				 startActivity(intent);
				 finish();	
			}
		});
		
		
		
		//��ͼ����
		map.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
			}
		});
		
	}
	
}
