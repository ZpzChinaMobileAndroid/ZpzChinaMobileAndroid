package com.example.allproject;

import com.example.message.R;
import com.example.message.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Grabble extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__grabble);
		
		
		ImageView grable=(ImageView) findViewById(id.imageView1);//语音键
		final TextView content=(TextView) findViewById(id.voice);
		
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
		 startActivity(intent);
		 finish();
		 
	}
}
