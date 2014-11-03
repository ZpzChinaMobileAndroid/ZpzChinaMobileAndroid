package com.example.myself;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.allproject.jJ;
import com.example.message.Homepage;
import com.example.message.R;
import com.example.message.R.id;
import com.example.sqlite.Information;




		public class Issue extends Activity {

			TextView name, one, two, three, four, five, six, nine, ten;
			ImageView photo, senven, eight, elevent;
			String string,username,password;
			ArrayList<String >cellphone,company,department;
			ArrayList<Information>arrayList=new ArrayList<Information>();
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__commonality);
		
		 //接收传过来的token值
		 string=getIntent().getStringExtra("token");
		 System.out.println("本地项目界面接收到的token值"+string);
		 //接收传过来的登录名
		 username=getIntent().getStringExtra("name");
		 System.out.println("本地项目界面收到的用户名"+username);
		 //接收传过来的登录密码
		 password=getIntent().getStringExtra("password");
		 System.out.println("本地项目界面收到的登录密码"+password);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("主界面收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("主界面收到的所属单位"+company);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("主界面收到的职务"+department);
		 
		 
		
		//添加假数据
		senven = (ImageView)findViewById(id.senven);
	
		senven.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			
		Intent intent=new Intent(Issue.this,jJ.class);		
		startActivity(intent);
		finish();
			}
		});
	 }
		
//		ListView listView=(ListView) findViewById(id.list);
//		listView.setAdapter(new MyAdpter());
//		
//		
//		//一级列表的点击事件
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO 自动生成的方法存根
//				
//			//选项设置
//				AlertDialog.Builder builder=new AlertDialog.Builder(Issue.this);
//				builder.setTitle("选项");
//				builder.setItems(new String[]{"发布项目","查看详情"}, new AlertDialog.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface arg0, int arg1) {
//						// TODO 自动生成的方法存根
//					
//						//发布项目
//						if(arg1==0){
//							
//						}
//						//查看详情
//						else if(arg1==1){
//							
//						}
//					}
//				});
//				builder.setNegativeButton("返回", null);
//				builder.show();
//			}
//		});
//	}
//		//添加适配器
//		class MyAdpter extends BaseAdapter{
//
//			@Override
//			public int getCount() {
//				// TODO 自动生成的方法存根
//				return arrayList.size();
//			}
//
//			@Override
//			public Object getItem(int arg0) {
//				// TODO 自动生成的方法存根
//				return null;
//			}
//			
//
//			@Override
//			public long getItemId(int arg0) {
//				// TODO 自动生成的方法存根
//				return 0;
//			}
//
//			@Override
//			public View getView(int arg0, View arg1, ViewGroup arg2) {
//				// TODO 自动生成的方法存根
//				
//				View view = getLayoutInflater().inflate(R.layout.activity__commonality,null);
//
//				name = (TextView) view.findViewById(id.name);
//				one = (TextView) view.findViewById(id.one);
//				two = (TextView) view.findViewById(id.two);
//				three = (TextView) view.findViewById(id.three);
//				four = (TextView) view.findViewById(id.four);
//				five = (TextView) view.findViewById(id.five);
//				six = (TextView) view.findViewById(id.six);
//				nine = (TextView) view.findViewById(id.nine);
//				ten = (TextView) view.findViewById(id.ten);
//				photo = (ImageView) view.findViewById(id.photo);
//				senven = (ImageView) view.findViewById(id.senven);
//				eight = (ImageView) view.findViewById(id.eight);
//				elevent = (ImageView) view.findViewById(id.elevent);
//
//			
//				
//				
//				
//				return view;
//			}
		
		//返回键设置
			@Override
			public void onBackPressed() {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(Issue.this,Homepage.class);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				startActivity(intent);
				finish();
			}
	}