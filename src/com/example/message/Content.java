package com.example.message;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.message.R.id;
import com.example.myself.Myself;


public class Content extends Activity {
	
	private	 TextView auction,approve,plan,design,plot ,horizon ,foundation ,construct ,afforest,fitment;
	ImageView save,back;
	String string2;
	String string,password,username;
	ImageView sky,sky1, sky2,sky3, sky4,sky5, sky6,sky7, sky8,sky9;
	ArrayList<String >cellphone,company,department,province,district,realname;
	String str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__content);
	
		//接收所有的值并进行传递
	   final ArrayList<String> string1=getIntent().getStringArrayListExtra("one");
	   System.out.println("土地规划接收的值"+string1);
	   final ArrayList<String> string2=getIntent().getStringArrayListExtra("two");
	   System.out.println("项目立项接收的值"+string2);
	   final ArrayList<String> string3=getIntent().getStringArrayListExtra("three");
	   System.out.println("地勘阶段接收的值"+string3);
	   final ArrayList<String> string4=getIntent().getStringArrayListExtra("four");
	   System.out.println("设计阶段接收的值"+string4);
	   final ArrayList<String> string5=getIntent().getStringArrayListExtra("five");
	   System.out.println("出图阶段接收的值"+string5);
	   final ArrayList<String> string6=getIntent().getStringArrayListExtra("six");
	   System.out.println("地平阶段接收的值"+string6);
	   final ArrayList<String> string7=getIntent().getStringArrayListExtra("senven");
	   System.out.println("桩基基坑接收的值"+string7);
	   final ArrayList<String> string8=getIntent().getStringArrayListExtra("six");
	   System.out.println("主体施工接收的值"+string8);
	   final ArrayList<String> string9=getIntent().getStringArrayListExtra("nine");
	   System.out.println("消防绿化接收的值"+string9);
	   final ArrayList<String> string10=getIntent().getStringArrayListExtra("ten");
	   System.out.println("装修阶段接收的值"+string10);

	     //接收传过来的token值
		 string=getIntent().getStringExtra("token");
		 System.out.println("界面接收到的token值"+string);
		 //接收传过来的登录名
		 username=getIntent().getStringExtra("name");
		 System.out.println("界面收到的用户名"+username);
		 //接收传过来的登录密码
		 password=getIntent().getStringExtra("password");
		 System.out.println("界面收到的登录密码"+password);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("界面收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("界面收到的所属单位"+company);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("界面收到的职务"+department);
		 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("界面接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("界面接收到的职务"+province);
		 //接收传过来的用户名
		 realname=getIntent().getStringArrayListExtra("realname");
		 System.out.println("界面接收到的名字"+realname);
		 
		 
		auction=(TextView) findViewById(id.auction);//土地规划/拍卖
		approve=(TextView) findViewById(id.approve);//项目立项
		plan=(TextView) findViewById(id.plan);//地勘阶段
		design=(TextView) findViewById(id.design);//设计阶段
		save=(ImageView) findViewById(R.id.imageView3);//保存项目
		back=(ImageView) findViewById(id.back);//返回回去
		plot=(TextView) findViewById(id.plot);//出图阶段
		horizon =(TextView) findViewById(id.horizon);//地平
		foundation =(TextView) findViewById(id.foundation);//桩基基坑
		construct =(TextView) findViewById(id.construct);//主体施工
		afforest=(TextView) findViewById(id.afforest);//消防/景观绿化
		fitment=(TextView) findViewById(id.fitment);//装修阶段
		sky=(ImageView) findViewById(id.sky);
		sky1=(ImageView) findViewById(id.sky1);
		sky2=(ImageView) findViewById(id.sky2);
		sky3=(ImageView) findViewById(id.sky3);
		sky4=(ImageView) findViewById(id.sky4);
		sky5=(ImageView) findViewById(id.sky5);
		sky6=(ImageView) findViewById(id.sky6);
		sky7=(ImageView) findViewById(id.sky7);
		sky8=(ImageView) findViewById(id.sky8);
		sky9=(ImageView) findViewById(id.sky9);
		
		//土地规划/拍卖 
		auction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Project.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			}
		});
		
		 str=getIntent().getStringExtra("key");
		   System.out.println("sssssssssss"+str);
		   if(str!=null){
			   sky.setVisibility(View.VISIBLE);
		   }
		   str1=getIntent().getStringExtra("key1");
		   System.out.println("sssssssssss"+str1);
		   if(str1!=null){
			   sky1.setVisibility(View.VISIBLE);
		   }
		   str2=getIntent().getStringExtra("key2");
		   System.out.println("sssssssssss"+str2);
		   if(str2!=null){
			   sky2.setVisibility(View.VISIBLE);
		   }
		   str3=getIntent().getStringExtra("key3");
		   System.out.println("sssssssssss"+str3);
		   if(str3!=null){
			   sky3.setVisibility(View.VISIBLE);
		   }
		   str4=getIntent().getStringExtra("key4");
		   System.out.println("sssssssssss"+str4);
		   if(str4!=null){
			   sky4.setVisibility(View.VISIBLE);
		   }
		   str5=getIntent().getStringExtra("key5");
		   System.out.println("sssssssssss"+str5);
		   if(str5!=null){
			   sky5.setVisibility(View.VISIBLE);
		   }
		   str6=getIntent().getStringExtra("key6");
		   System.out.println("sssssssssss"+str6);
		   if(str6!=null){
			   sky6.setVisibility(View.VISIBLE);
		   }
		   str7=getIntent().getStringExtra("key7");
		   System.out.println("sssssssssss"+str7);
		   if(str7!=null){
			   sky7.setVisibility(View.VISIBLE);
		   }
		   str8=getIntent().getStringExtra("key8");
		   System.out.println("sssssssssss"+str8);
		   if(str8!=null){
			   sky8.setVisibility(View.VISIBLE);
		   }
		   str9=getIntent().getStringExtra("key9");
		   System.out.println("sssssssssss"+str9);
		   if(str9!=null){
			   sky9.setVisibility(View.VISIBLE);
		   }
		
		//项目立项
		approve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(Content.this,Approve.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			}
		});
		
		
		//地勘阶段
		plan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Plan.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//设计阶段
		design.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Design.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//出图阶段
		plot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Plot.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//地平
		horizon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Horizon.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//桩基基坑
		foundation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				
				Intent intent=new Intent(Content.this,Foundation.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//主体施工
		construct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Construct.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//消防/景观绿化
		afforest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Afforest.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//装修阶段
		fitment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				
				Intent intent=new Intent(Content.this,Fitment.class);
				intent.putExtra("one",string1);
				intent.putExtra("two",string2);
				intent.putExtra("four",string4);
				intent.putExtra("five",string5);
				intent.putExtra("six",string6);
				intent.putExtra("senven",string7);
				intent.putExtra("eight",string8);
				intent.putExtra("nine", string9);
				intent.putExtra("ten",string10);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		//返回到主界面
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent(Content.this,Homepage.class);
		        intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();	
			}
		});
    }
	
	
	//设置返回键
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		Intent intent=new Intent(Content.this,Homepage.class);
        intent.putExtra("token", string);
		intent.putExtra("name", username);
		intent.putExtra("password", password);
		intent.putExtra("cellphone", cellphone);
		intent.putExtra("company", company);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
		intent.putExtra("realname", realname);
		startActivity(intent);
		finish();	
	}
	
	// 设置菜单键
		@Override
		public boolean onCreateOptionsMenu(Menu arg0) {
			// TODO Auto-generated method stub
			arg0.add(0, 2, 3, "主界面").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {
						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
							AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
						    builder.setIcon(R.drawable.icon48);
						    builder.setTitle("提示");
						    builder.setMessage("是否放弃正在新建的项目");
					     	builder.setPositiveButton("确定",  new AlertDialog. OnClickListener() {
						     @Override
					    	 public void onClick(DialogInterface arg0, int arg1) {
						    // TODO 自动生成的方法存根
							 Intent intent=new Intent(Content.this,Homepage.class);
							 intent.putExtra("token", string);
							 intent.putExtra("name", username);
							 intent.putExtra("password", password);
							 intent.putExtra("cellphone", cellphone);
								intent.putExtra("company", company);
								intent.putExtra("department", department);
							 startActivity(intent);
							 finish();
					}
					});
					       builder.setNegativeButton("取消", null);
					       builder.show();
						             return false;
				}
			});
			arg0.add(0,0, 1, "查看全部任务").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
			AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
		    builder.setIcon(R.drawable.icon48);
		    builder.setTitle("提示");
		    builder.setMessage("是否放弃正在新建的项目");
	     	builder.setPositiveButton("确定",  new AlertDialog. OnClickListener() {
		     @Override
	    	 public void onClick(DialogInterface arg0, int arg1) {
		    // TODO 自动生成的方法存根
			 finish();
	}
	});
	       builder.setNegativeButton("取消", null);
	       builder.show();
		             return false;
						}
					});
			
			arg0.add(0, 3, 4, "退出程序").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

	 	@Override
			public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
		  AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
	      builder.setIcon(R.drawable.icon48);
	      builder.setTitle("提示");
	      builder.setMessage("是否退出");
	      builder.setPositiveButton("确定",  new AlertDialog. OnClickListener() {
									
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
			finish();
			}
		});
	      builder.setNegativeButton("取消", null);
		    builder.show();
		return false;
						}
					});
			
			arg0.add(0,1, 2, "查看本地任务").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
         AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
	     builder.setIcon(R.drawable.icon48);
	     builder.setTitle("提示");
		 builder.setMessage("是否放弃正在新建的项目");
         builder.setPositiveButton("确定",  new AlertDialog. OnClickListener() {
		@Override
	     public void onClick(DialogInterface arg0, int arg1) {
			// TODO 自动生成的方法存根
			Intent intent=new Intent(Content.this,Myself.class);
			startActivity(intent);
			finish();
		}
		});
	     builder.setNegativeButton("取消", null);
		 builder.show();
		   return false;
						}
					});
			
			return super.onCreateOptionsMenu(arg0);
		}
	}