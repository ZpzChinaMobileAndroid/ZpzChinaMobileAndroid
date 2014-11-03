 package com.example.allproject;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.message.Homepage;
import com.example.message.R;
import com.example.message.R.id;
import com.example.myself.Preserve;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Allproject extends Activity {
	ProgressDialog dialog;
	 String tokenkey;
		String string,username,password;
		 ArrayList<String >cellphone,company2,department,province,district,realname;
			JSONArray jsonArray,jsonArray2,jsonArray3;
			int investment= 0;
			int areaOfStructure=0;
		 ArrayList<String>arrayList=new ArrayList<String>();
	/*
	 * 为了避免内存溢出 软引用 作用：凡是存入软引用的Bitmap对象，系统会自动根据剩余的内存情况来决定是否要释放资源
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__allproject);
		
		//接收传过来的token值
		string=getIntent().getStringExtra("token");
		System.out.println("桩基界面接收到的token值"+string);
		//接收传过来的登录名
		username=getIntent().getStringExtra("name");
		System.out.println("桩基界面收到的用户名"+username);
		//接收传过来的登录密码
		password=getIntent().getStringExtra("password");
		System.out.println("桩基界面收到的登录密码"+password);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("桩基界面收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company2=getIntent().getStringArrayListExtra("company");
		 System.out.println("桩基界面收到的所属单位"+company2);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("桩基界面收到的职务"+department);
		 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
		 //接收传过来的城市
		 realname=getIntent().getStringArrayListExtra("realname");
		 System.out.println("土地规划接收到的职务"+realname);
		
	

        ListView listView = (ListView) findViewById(id.list);
		ImageView backImageView = (ImageView) findViewById(id.imageView3);
		ImageView save = (ImageView) findViewById(id.imageView2);
		ImageView advaced = (ImageView) findViewById(id.imageView1);
		
		//适配器
		listView.setAdapter(new MyAdpter());
		
		
		
		  
		// 一级列表的点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
			}
		});
		
		
		
		//进行高级搜索键
		advaced.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Allproject.this,Choosemenu.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
			}
		});
			
				
	
		new Thread(){
			public void run(){
				//加载内容
				
		// 网络连接

				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet("http://eipqas.zhongjichina.com/ZPZChina.svc/projects/"+string+"?startIndex=0&pageSize=10");
				try {
					httpGet.addHeader("Content-Type",	"application/json; charset=UTF-8");
					HttpResponse response = httpClient.execute(httpGet);
					response.getStatusLine().getStatusCode();
					if (response.getStatusLine().getStatusCode() == 200) {
						HttpEntity httpEntity = response.getEntity();
						String string = EntityUtils.toString(httpEntity);
						System.out.println("全部项目是否有返回值" + string);
						analysis(string);
					}
					
				} catch (ClientProtocolException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		
			
			// 解析方法
			private void analysis(String string) {
				// TODO 自动生成的方法存根
				try {
					JSONObject jsonObject = new JSONObject(string);
					JSONObject jsonObject1 = jsonObject.getJSONObject("d");// 第一层名字
					 jsonArray = jsonObject1.getJSONArray("data");// 第二层名字
				
			
					 
				for(int i=0;i<jsonArray.length();i++){
					
				
					JSONObject jsonObject2 = jsonArray.getJSONObject(i);
					
					if (jsonObject2.has("baseContacts")) {
					
					 jsonArray2 = jsonObject2.getJSONArray("baseContacts");//第三层

					 //解析出需要的值
					 if (jsonObject2.has("investment")) {
							investment = (int) jsonObject2.getLong("investment");
						}
					 
					 System.out.println(investment);
					 
				for(int i1=0;i1<jsonArray2.length();i1++){
						
						JSONObject jsonObject3 = jsonArray2.getJSONObject(i1);
					
						 jsonArray3 = jsonObject3.getJSONArray("data");//第四层
						 
						 
						for(int i2=0;i2<jsonArray3.length();i2++){
							
							JSONObject jsonObject4 = jsonArray3.getJSONObject(i2);
							
							
				        	
						  }
					  }
			        }	
			   	  }		 
				} catch (JSONException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			};
		}.start();
		
		
		//返回到主页
		backImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Allproject.this,Homepage.class);
				    intent.putExtra("token", string);
					intent.putExtra("name", username);
					intent.putExtra("password", password);
					intent.putExtra("cellphone", cellphone);
					intent.putExtra("company", company2);
					intent.putExtra("department", department);
					intent.putExtra("district", district);
					intent.putExtra("province", province);
					intent.putExtra("realname", realname);
				startActivity(intent);
				finish();
			}
		});
	}

	// 创建适配器
	class MyAdpter extends BaseAdapter {
		LayoutInflater inflater;
		Context context;
		TextView name, one, two, three, four, five, six, nine, ten;
		ImageView photo, senven, eight, elevent;

		@Override
		public int getCount() {
			// TODO 自动生成的方法存根
			return arrayList.size();
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
			View view = getLayoutInflater().inflate(R.layout.test,null);

			name = (TextView) view.findViewById(id.name);
			one = (TextView) view.findViewById(id.one);
			two = (TextView) view.findViewById(id.two);
			three = (TextView) view.findViewById(id.three);
			four = (TextView) view.findViewById(id.four);
			five = (TextView) view.findViewById(id.five);
			six = (TextView) view.findViewById(id.six);
			nine = (TextView) view.findViewById(id.nine);
			ten = (TextView) view.findViewById(id.ten);
			photo = (ImageView) view.findViewById(id.photo);
			senven = (ImageView) view.findViewById(id.senven);
			eight = (ImageView) view.findViewById(id.eight);
			elevent = (ImageView) view.findViewById(id.elevent);

			name.setText("上海中技桩业项目名称");
			one.setText("投资额");
			two.setText("建筑面积");
//			three.setText(investment);
//			four.setText(areaOfStructure);
			five.setText("2014-10-30");
			six.setText("2014-11-01");
			senven.setBackgroundResource(R.drawable.h4);
			eight.setBackgroundResource(R.drawable.h2);
			nine.setText("华南区");
			ten.setText("上海市汶水路928号");
			elevent.setBackgroundResource(R.drawable.h3);
			
			return view;
		}
	}
	//返回键设置
	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		Intent intent=new Intent(Allproject.this,Homepage.class);
		    intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company2);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			intent.putExtra("province", province);
		startActivity(intent);
		finish();
	}
}
