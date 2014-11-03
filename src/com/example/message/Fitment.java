package com.example.message;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.message.R.id;
import com.example.myself.Myself;
import com.example.sqlite.Information;
import com.example.sqlite.Sqlite;

public class Fitment extends Activity {
	
	String[] str={"招标","正在施工","施工完成"};
	String[] str1={"无装修","简单全装修","部分装修","精装修"};
	 ArrayList<String> arrayList,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	 String string,password,username;
	 ArrayList<String >cellphone,company,department,province,district;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__fitment);
		
		
		TextView fitment=(TextView) findViewById(id.jump);//返回到之前界面
		ImageView save=(ImageView) findViewById(id.imageView3);//保存项目
    	ImageView back=(ImageView) findViewById(id.back);//返回界面
    	TextView current=(TextView) findViewById(id.current);//弱点安装
    	TextView condition=(TextView) findViewById(id.condition);//装修情况
    	TextView schedule=(TextView) findViewById(id.schedule);//装修进度
    	final TextView show=(TextView) findViewById(id.show);//显示弱点
    	final TextView shower=(TextView) findViewById(id.shower);//情况
    	final TextView showers=(TextView) findViewById(id.showers);//进度
    	ImageView camera=(ImageView) findViewById(id.camera);//相机
		
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
       
        //接收传过来的token值
        string=getIntent().getStringExtra("token");
     	System.out.println("装修界面接收到的token值"+string);
        //接收传过来的登录名
        username=getIntent().getStringExtra("name");
        System.out.println("装修界面收到的用户名"+username);
      	//接收传过来的登录密码
      	password=getIntent().getStringExtra("password");
      	System.out.println("装修界面收到的登录密码"+password);
        //接收传过来的手机号
     	 cellphone=getIntent().getStringArrayListExtra("cellphone");
     	 System.out.println("装修界面收到的手机号"+cellphone);
   	     //接收传过来的所属单位
   	    company=getIntent().getStringArrayListExtra("company");
   	    System.out.println("装修界面收到的所属单位"+company);
     	 //接收传过来的职务
     	 department=getIntent().getStringArrayListExtra("department");
     	 System.out.println("装修界面收到的职务"+department);
     	 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
     
        	 
        //保存到本地
 	   save.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View arg0) {
 			// TODO 自动生成的方法存根
 		arrayList=new ArrayList<String>();
	    arrayList.add(show.getText().toString());
		arrayList.add(shower.getText().toString());
		arrayList.add(showers.getText().toString());
 			  
 		Intent intent=new Intent(Fitment.this,Myself.class);
 		intent.putExtra("ten", arrayList);
 		intent.putExtra("one", arrayList2);
 		intent.putExtra("two", arrayList3);
 		intent.putExtra("three", arrayList4);
 		intent.putExtra("four", arrayList5);
 		intent.putExtra("five", arrayList6);
 		intent.putExtra("six", arrayList7);
 		intent.putExtra("senven", arrayList8);
 		intent.putExtra("eight", arrayList9);
 		intent.putExtra("nine", arrayList10);
 		intent.putExtra("token", string);
 		intent.putExtra("name", username);
 		intent.putExtra("password", password);
 		intent.putExtra("cellphone", cellphone);
		intent.putExtra("company", company);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
// 		intent.putExtra("user", arrayList111);
// 		intent.putExtra("user1", arrayList112);
// 		intent.putExtra("user2", arrayList113);
// 		intent.putExtra("user3", arrayList114);
 		
 		startActivity(intent);
 		finish();
 		 Toast.makeText(Fitment.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
 		}
 	});
    
    	//照相机
      	 camera.setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View arg0) {
      				// TODO 自动生成的方法存根
      				
      				 Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      				 startActivityForResult(intent, 1);
      				 ImageView	 im=new ImageView(Fitment.this);
      				 setContentView(im);
      				// finish();
      				 
      				 /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      				 // TODO Auto-generated method stub
      				 super.onActivityResult(requestCode, resultCode, data);
      				 if(requestCode==1&&resultCode==Activity.RESULT_OK){
      				 	if(data!=null){
      				 		Bitmap bit=(Bitmap) data.getExtras().get("data");
      				 		im.setImageBitmap(bit);
      				 	}
      				 }
      				 }*/
      			}
      		});
      	    
      	//返回到之前界面
      	fitment.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO 自动生成的方法存根
    				
    			    arrayList=new ArrayList<String>();
    				arrayList.add(show.getText().toString());
    				arrayList.add(shower.getText().toString());
    				arrayList.add(showers.getText().toString());
    				
    				Intent intent=new Intent(Fitment.this,Content.class);
    				intent.putExtra("key9", "1");
       				intent.putExtra("ten", arrayList);
    				intent.putExtra("one", arrayList2);
       				intent.putExtra("two", arrayList3);
       				intent.putExtra("three", arrayList4);
       				intent.putExtra("four", arrayList5);
       				intent.putExtra("five", arrayList6);
       				intent.putExtra("six", arrayList7);
       				intent.putExtra("senven", arrayList8);
       				intent.putExtra("eight", arrayList9);
       				intent.putExtra("nine", arrayList10);
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
      	
    	 arrayList11=new ArrayList<String>();
         arrayList11=getIntent().getStringArrayListExtra("ten");	
         System.out.println("jiesho"+arrayList11);
         String string3=new String();String string1=new String();String string2=new String();
         if(arrayList11!=null){
        	 string3=arrayList11.get(0);  show.setText(string3);
        	 string1=arrayList11.get(1);  shower.setText(string1);
        	 string2=arrayList11.get(2);  showers.setText(string2);
      //返回到之前界面
      	back.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO 自动生成的方法存根
    				
    			    arrayList=new ArrayList<String>();
    				arrayList.add(show.getText().toString());
    				arrayList.add(shower.getText().toString());
    				arrayList.add(showers.getText().toString());
    				
    				Intent intent=new Intent(Fitment.this,Content.class);
    				intent.putExtra("key9", "1");
       				intent.putExtra("ten", arrayList);
    				intent.putExtra("one", arrayList2);
       				intent.putExtra("two", arrayList3);
       				intent.putExtra("three", arrayList4);
       				intent.putExtra("four", arrayList5);
       				intent.putExtra("five", arrayList6);
       				intent.putExtra("six", arrayList7);
       				intent.putExtra("senven", arrayList8);
       				intent.putExtra("eight", arrayList9);
       				intent.putExtra("nine", arrayList10);
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
      	
         }
      	//弱点安装
      	current.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO 自动生成的方法存根
   				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
   				builder.setItems(str,new AlertDialog.OnClickListener() {
   					
   					@Override
   					public void onClick(DialogInterface arg0, int arg1) {
   						// TODO 自动生成的方法存根
   					
   							for(int i=0;i<str.length;i++){
   								if(i==arg1){
   						
   						         //显示弱点安装
   				                  show.setText(str[arg1]);	
   				                  arg0.dismiss();
   								}
   							}
   					}
   				});
   				builder.show();
   			}
   		});
       	
       
   	//装修情况
      	condition.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO 自动生成的方法存根
   				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
   				builder.setItems(str1, new AlertDialog.OnClickListener() {
   					@Override
   					public void onClick(DialogInterface arg0, int arg1) {
   						// TODO 自动生成的方法存根
   					
   							for(int i=0;i<str1.length;i++){
   								if(i==arg1){
   						
   						         //显示装修情况
   				                  shower.setText(str1[arg1]);	
   				                  arg0.dismiss();
   								}
   							}
   					}
   				});
   				builder.show();
   			}
   		});
      
		
	//装修进度
      	schedule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
				builder.setItems(str,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //显示装修进度
				                  showers.setText(str[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
	}
    
	//设置返回键
			@Override
			public void onBackPressed() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Fitment.this,Content.class);
				intent.putExtra("key9", "1");
				intent.putExtra("ten", arrayList);
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
   				intent.putExtra("five", arrayList6);
   				intent.putExtra("six", arrayList7);
   				intent.putExtra("senven", arrayList8);
   				intent.putExtra("eight", arrayList9);
   				intent.putExtra("nine", arrayList10);
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