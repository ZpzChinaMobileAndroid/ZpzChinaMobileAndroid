package com.example.allproject;

import java.util.ArrayList;

import com.example.message.R;
import com.example.message.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Searchresult extends Activity {

	
	String string,password,username;
	ArrayList<String> arrayList;
	ArrayList<String >cellphone,company,department,province1,district1,realname;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity__searchresult);
	   
	   
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
	 @Override
		public void onBackPressed() {
			// TODO 自动生成的方法存根
			 
			 Intent intent=new Intent(Searchresult.this,Allproject.class);
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
