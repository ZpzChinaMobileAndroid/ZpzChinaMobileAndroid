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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__grabble);
		
		
		ImageView grable=(ImageView) findViewById(id.imageView1);//������
		final TextView content=(TextView) findViewById(id.voice);
		
		grable.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			
			content.setText("���ڽ������ݡ�����������");	
				
			}
		});
		
		
	}
	 @Override
	public void onBackPressed() {
		// TODO �Զ����ɵķ������
		 
		 Intent intent=new Intent(Grabble.this,Choosemenu.class);
		 startActivity(intent);
		 finish();
		 
	}
}
