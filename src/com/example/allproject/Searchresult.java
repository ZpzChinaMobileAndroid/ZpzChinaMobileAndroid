package com.example.allproject;

import com.example.message.R;
import com.example.message.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Searchresult extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity__searchresult);
	   
	   
	   ListView listView=(ListView) findViewById(id.listview);
	   listView.setAdapter(new MyAdpter());
	   
	   
	   listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自动生成的方法存根
			
		}
	});
	   
	}
	//添加适配器
	class MyAdpter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO 自动生成的方法存根
			return 0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO 自动生成的方法存根
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO 自动生成的方法存根
			return null;
		}
	}
}
