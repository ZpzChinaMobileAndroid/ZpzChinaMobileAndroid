package com.example.message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.message.Project.MyAdpter;
import com.example.message.R.id;
import com.example.myself.Myself;
import com.slidingmenu.lib.SlidingMenu;

public class Construct extends Activity {
	
	 ArrayList<String> arrayList,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	 String string,password,username;
	 ArrayList<String >cellphone,company,department,province,district;
	 GridView gird;
		boolean bo = true;
		static List<Bitmap> list = new LinkedList<Bitmap>();
		SlidingMenu menu ;
		MyAdpter myAdpter=new MyAdpter();
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__construct);
		
	
		 ImageView  save=(ImageView) findViewById(id.imageView3);//保存项目
		 ImageView  back=(ImageView) findViewById(id.back);//返回界面
		 TextView jumpTextView=(TextView) findViewById(id.jump);//跳转回去
		 gird = (GridView) findViewById(R.id.girdview);
		 gird.setAdapter(myAdpter);
		  //中转我的值
		  //中转我的值
	 	    arrayList2=new ArrayList<String>();
	        arrayList2=getIntent().getStringArrayListExtra("one");	
	        arrayList3=new ArrayList<String>();
	        arrayList3=getIntent().getStringArrayListExtra("two");	
	        arrayList4=new ArrayList<String>();
	        arrayList4=getIntent().getStringArrayListExtra("three");	
	        arrayList5=new ArrayList<String>();
	        arrayList5=getIntent().getStringArrayListExtra("four");	
	        arrayList6=new ArrayList<String>();
	        arrayList6=getIntent().getStringArrayListExtra("five");	
	        arrayList7=new ArrayList<String>();
	        arrayList7=getIntent().getStringArrayListExtra("six");	
	        arrayList8=new ArrayList<String>();
	        arrayList8=getIntent().getStringArrayListExtra("seven");	
	        arrayList9=new ArrayList<String>();
	        arrayList9=getIntent().getStringArrayListExtra("eight");	
	        arrayList10=new ArrayList<String>();
	        arrayList10=getIntent().getStringArrayListExtra("nine");	
	        arrayList11=new ArrayList<String>();
	        arrayList11=getIntent().getStringArrayListExtra("ten");		
	       
	      //接收传过来的token值
			string=getIntent().getStringExtra("token");
			System.out.println("主体施工界面接收到的token值"+string);
			//接收传过来的登录名
			username=getIntent().getStringExtra("name");
			System.out.println("主体施工界面收到的用户名"+username);
			//接收传过来的登录密码
			password=getIntent().getStringExtra("password");
			System.out.println("主体施工界面收到的登录密码"+password);
			 //接收传过来的手机号
			 cellphone=getIntent().getStringArrayListExtra("cellphone");
			 System.out.println("主体施工界面收到的手机号"+cellphone);
			 //接收传过来的所属单位
			 company=getIntent().getStringArrayListExtra("company");
			 System.out.println("主体施工界面收到的所属单位"+company);
			 //接收传过来的职务
			 department=getIntent().getStringArrayListExtra("department");
			 System.out.println("主体施工界面收到的职务"+department);
			 //接收传过来的区域
			 district=getIntent().getStringArrayListExtra("district");
			 System.out.println("土地规划接收到的职务"+district);
			 //接收传过来的城市
			 province=getIntent().getStringArrayListExtra("province");
			 System.out.println("土地规划接收到的职务"+province);
			 
			 
			 
			 //跳转回去到选择界面
			 back.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
						
						Intent intent=new Intent(Construct.this,Content.class);
						intent.putExtra("key7", "1");
						intent.putExtra("one", arrayList2);
		   				intent.putExtra("two", arrayList3);
		   				intent.putExtra("three", arrayList4);
		   				intent.putExtra("four", arrayList5);
		   				intent.putExtra("five", arrayList6);
		   				intent.putExtra("six", arrayList7);
		   				intent.putExtra("senven", arrayList8);
		   				intent.putExtra("eight", arrayList9);
		   				intent.putExtra("nine", arrayList10);
		   				intent.putExtra("ten", arrayList11);
		   				intent.putExtra("token", string);
		   				intent.putExtra("name", username);
		   				intent.putExtra("password", password);
		   				intent.putExtra("cellphone", cellphone);
		   				intent.putExtra("company", company);
		   				intent.putExtra("department", department);
		   				intent.putExtra("district", district);
		   				intent.putExtra("province", province);
						startActivity(intent);
						overridePendingTransition(R.anim.onout,R.anim.inout);
						
						finish();
					}
				});
			
			 
			  //保存到本地
			   save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 自动生成的方法存根
					  
				Intent intent=new Intent(Construct.this,Myself.class);
				intent.putExtra("one", arrayList);
				intent.putExtra("two", arrayList3);
				intent.putExtra("three", arrayList4);
				intent.putExtra("four", arrayList5);
				intent.putExtra("five", arrayList6);
				intent.putExtra("six", arrayList7);
				intent.putExtra("senven", arrayList8);
				intent.putExtra("eight", arrayList9);
				intent.putExtra("nine", arrayList10);
				intent.putExtra("ten", arrayList11);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
//				intent.putExtra("user", arrayList111);
//				intent.putExtra("user1", arrayList112);
//				intent.putExtra("user2", arrayList113);
//				intent.putExtra("user3", arrayList114);
				
				startActivity(intent);
				finish();
				 Toast.makeText(Construct.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
				}
			});
			 
		 //跳转回去到选择界面
		 jumpTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Construct.this,Content.class);
				intent.putExtra("key7", "1");
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
   				intent.putExtra("five", arrayList6);
   				intent.putExtra("six", arrayList7);
   				intent.putExtra("senven", arrayList8);
   				intent.putExtra("eight", arrayList9);
   				intent.putExtra("nine", arrayList10);
   				intent.putExtra("ten", arrayList11);
   				intent.putExtra("token", string);
   				intent.putExtra("name", username);
   				intent.putExtra("password", password);
   				intent.putExtra("cellphone", cellphone);
   				intent.putExtra("company", company);
   				intent.putExtra("department", department);
   				intent.putExtra("district", district);
   				intent.putExtra("province", province);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
			}
		});
		 
		
//		 
//		//照相机
//		 camera.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					// TODO 自动生成的方法存根
//					
//					 Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//					 startActivityForResult(intent, 1);
//					 ImageView	 im=new ImageView(Construct.this);
//					 setContentView(im);
//				}
//			});
		 
		 
		 
    }
	 
	    
	    class MyAdpter extends BaseAdapter{
	    	@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size()+1;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				
				return position>=list.size()?null:list.get(position);
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (position>=list.size()) {
					convertView = getLayoutInflater().inflate(R.layout.abcd, null);
					convertView.findViewById(R.id.imageView4).setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//							intent.putExtra("outputX", 170);
//					        intent.putExtra("outputY", 170);
							startActivityForResult(intent, 1);
						}
					});
				}else{
					convertView = getLayoutInflater().inflate(R.layout.item, null);
					ImageView image = (ImageView) convertView.findViewById(R.id.imageView1);
					image.setImageBitmap(list.get(position));
				}
				return convertView;
			
		}

		}
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			Bundle bundle = data.getExtras();
			Bitmap bitmap = (Bitmap) bundle.get("data");
			list.add(list.size(),bitmap);
			myAdpter.notifyDataSetChanged();

		}
	 
	//设置返回键
			@Override
			public void onBackPressed() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Construct.this,Content.class);
				intent.putExtra("key7", "1");
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
   				intent.putExtra("five", arrayList6);
   				intent.putExtra("six", arrayList7);
   				intent.putExtra("senven", arrayList8);
   				intent.putExtra("eight", arrayList9);
   				intent.putExtra("nine", arrayList10);
   				intent.putExtra("ten", arrayList11);
   				intent.putExtra("token", string);
   				intent.putExtra("name", username);
   				intent.putExtra("password", password);
   				intent.putExtra("cellphone", cellphone);
   				intent.putExtra("company", company);
   				intent.putExtra("department", department);
   				intent.putExtra("district", district);
   				intent.putExtra("province", province);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
			}
	}