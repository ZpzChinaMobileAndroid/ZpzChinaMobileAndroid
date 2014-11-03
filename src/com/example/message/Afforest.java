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

public class Afforest extends Activity {
	
	String[] str={"招标","正在施工","施工完成"}; 
	String string,password,username;
	ArrayList<String> arrayList;
	ArrayList<String >cellphone,company,department,province,district;
	ArrayList<String> arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__afforest);
		
		TextView afforest=(TextView) findViewById(id.jump);//返回到之前界面
		ImageView  back=(ImageView) findViewById(id.back);//返回到之前界面
		ImageView save=(ImageView) findViewById(id.save);//保存到本地
    	TextView control=(TextView) findViewById(id.control);//消防
    	TextView landscape=(TextView) findViewById(id.landscape);//景观绿化
    	final TextView show=(TextView) findViewById(id.show);//显示消防阶段
    	final TextView shower=(TextView) findViewById(id.shower);//显示景观绿化阶段
    	ImageView camera=(ImageView) findViewById(id.camera);//照相机
    	
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
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
    	
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
        arrayList11=new ArrayList<String>();
        arrayList11=getIntent().getStringArrayListExtra("ten");	
        
    	
    	//返回到之前界面
   	    afforest.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO 自动生成的方法存根
   				
   				arrayList=new ArrayList<String>();
   				arrayList.add(show.getText().toString());
   				arrayList.add(shower.getText().toString());
   				
   				
   				Intent intent=new Intent(Afforest.this,Content.class);
   				intent.putExtra("key8", "1");
   				intent.putExtra("nine", arrayList);
   				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
   				intent.putExtra("five", arrayList6);
   				intent.putExtra("six", arrayList7);
   				intent.putExtra("senven", arrayList8);
   				intent.putExtra("eight", arrayList9);
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
   	    
   	    //保存到项目到本地
   	 save.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View arg0) {
 			// TODO 自动生成的方法存根
 			
 		arrayList=new ArrayList<String>();
		arrayList.add(show.getText().toString());
		arrayList.add(shower.getText().toString());	
 			
 		Intent intent=new Intent(Afforest.this,Myself.class);
 		intent.putExtra("one", arrayList2);
 		intent.putExtra("two", arrayList3);
 		intent.putExtra("three", arrayList4);
 		intent.putExtra("four", arrayList5);
 		intent.putExtra("five", arrayList6);
 		intent.putExtra("six", arrayList7);
 		intent.putExtra("senven", arrayList8);
 		intent.putExtra("eight", arrayList9);
 		intent.putExtra("nine", arrayList);
 		intent.putExtra("ten", arrayList11);
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
 		 Toast.makeText(Afforest.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
 		}
 	});
   	    
   	//返回到之前界面
   	    back.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO 自动生成的方法存根
   				
   				arrayList=new ArrayList<String>();
   				arrayList.add(show.getText().toString());
   				arrayList.add(shower.getText().toString());
   				
   				
   				Intent intent=new Intent(Afforest.this,Content.class);
   				intent.putExtra("key8", "1");
   				intent.putExtra("nine", arrayList);
   				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
   				intent.putExtra("five", arrayList6);
   				intent.putExtra("six", arrayList7);
   				intent.putExtra("senven", arrayList8);
   				intent.putExtra("eight", arrayList9);
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
   	    
   	 arrayList10=new ArrayList<String>();
     arrayList10=getIntent().getStringArrayListExtra("nine");	
     String string=new String();  String string2=new String();
     if(arrayList10!=null){
    	 string=arrayList10.get(0);    show.setText(string);
         string2=arrayList10.get(1);   shower.setText(string2);
       	    
     }
     
   	//照相机
   	 camera.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO 自动生成的方法存根
   				
   				 Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
   				 startActivityForResult(intent, 1);
   				 ImageView	 im=new ImageView(Afforest.this);
   				 setContentView(im);
   			}
   		});
   	    
   	//消防阶段
   	 control.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder=new AlertDialog.Builder(Afforest.this);
				builder.setItems(str, new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //显示是否参与
				                  show.setText(str[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
    	
    
	//景观绿化阶段
   	landscape.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder=new AlertDialog.Builder(Afforest.this);
				builder.setItems(str, new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //显示是否参与
				                  shower.setText(str[arg1]);	
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
			
			Intent intent=new Intent(Afforest.this,Content.class);
		    	intent.putExtra("key8", "1");
		    	intent.putExtra("nine", arrayList);
				intent.putExtra("one", arrayList2);
				intent.putExtra("two", arrayList3);
				intent.putExtra("three", arrayList4);
				intent.putExtra("four", arrayList5);
				intent.putExtra("five", arrayList6);
				intent.putExtra("six", arrayList7);
				intent.putExtra("senven", arrayList8);
				intent.putExtra("eight", arrayList9);
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