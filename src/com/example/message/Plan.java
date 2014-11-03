package com.example.message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.message.Project.MyAdpter;
import com.example.message.R.id;
import com.example.myself.Myself;
import com.slidingmenu.lib.SlidingMenu;

public class Plan extends Activity {
	
	String[] strings={"项目负责人"};
	 ArrayList<String>arrayList, arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11,arrayList111,arrayList112,arrayList113,arrayList114;
	 String string,password,username;
	 ArrayList<String >cellphone,company2,department,province,district;
	   private EditText name , phone, companys , addressimage;
	   private	 TextView  station,showsss ,nameone,nametwo,namethree;
	   private ImageView saveimage;
		GridView gird;
		boolean bo = true;
		static List<Bitmap> list = new LinkedList<Bitmap>();
		SlidingMenu menu ;
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__plan);
		
		
	  ImageView choose=(ImageView) findViewById(id.choose);//增加用户信息
	  TextView result=(TextView) findViewById(id.jump);//返回前一界面
	  TextView company=(TextView) findViewById(id.company);//增加信息
	  ImageView save=(ImageView) findViewById(id.imageView3);//保存项目
	  ImageView back=(ImageView) findViewById(id.back);//返回界面
	  nameone=(TextView) findViewById(id.nameone);//显示名字
	  nametwo=(TextView) findViewById(id.nametwo);//显示名字2
	  namethree=(TextView) findViewById(id.namethree);//显示名字3
	  gird = (GridView) findViewById(R.id.gridView1);
	  gird.setAdapter(new myAdpter());
	  
	  arrayList111=new ArrayList<String>();
	  arrayList112=new ArrayList<String>();
	  arrayList113=new ArrayList<String>();
	  arrayList114=new ArrayList<String>();
	  
	  
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
      System.out.println("地勘阶段界面接收到的token值"+string);
      //接收传过来的登录名
      username=getIntent().getStringExtra("name");
      System.out.println("地勘阶段界面收到的用户名"+username);
      //接收传过来的登录密码
      password=getIntent().getStringExtra("password");
      System.out.println("地勘阶段界面收到的登录密码"+password);
      //接收传过来的手机号
 	 cellphone=getIntent().getStringArrayListExtra("cellphone");
 	 System.out.println("地勘阶段界面收到的手机号"+cellphone);
 	 //接收传过来的所属单位
 	 company2=getIntent().getStringArrayListExtra("company");
 	 System.out.println("地勘阶段界面收到的所属单位"+company);
 	 //接收传过来的职务
 	 department=getIntent().getStringArrayListExtra("department");
 	 System.out.println("地勘阶段界面收到的职务"+department);
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
			  
		Intent intent=new Intent(Plan.this,Myself.class);
		intent.putExtra("one", arrayList2);
		intent.putExtra("two", arrayList3);
		intent.putExtra("three", arrayList);
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
		intent.putExtra("company", company2);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
//		intent.putExtra("user", arrayList111);
//		intent.putExtra("user1", arrayList112);
//		intent.putExtra("user2", arrayList113);
//		intent.putExtra("user3", arrayList114);
		
		startActivity(intent);
		finish();
		 Toast.makeText(Plan.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
		}
	});
	 
	 
	 
	//增加用户信息
	 choose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plan.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				companys=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Plan.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO 自动生成的方法存根
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //显示岗位名称
				                 showsss.setText(strings[arg1]);	
				                 String fiveString =showsss.getText().toString();
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
				
					}
				});
				//保存
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					
						
						//添加电话
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Plan.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plan.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plan.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Plan.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList111.size()<16){
					     	arrayList111.add(name.getText().toString());                
					    	arrayList111.add(phone.getText().toString());                   
						    arrayList111.add(showsss.getText().toString());              
						    arrayList111.add(companys.getText().toString());               
						    arrayList111.add(addressimage.getText().toString()); 
						}
						System.out.println("储存的数据"+arrayList111);
						String stringone=new String();  
						
						if(arrayList111!=null&&arrayList111.size()==5){
							stringone=arrayList111.get(0);    
						    nameone.setText(stringone);  
						}  else if(arrayList111!=null&&arrayList111.size()==10){
							stringone=arrayList111.get(5);
						 	nametwo.setText(stringone); 
							}
						else if(arrayList111!=null&&arrayList111.size()==15){
							stringone=arrayList111.get(10);{
							namethree.setText(stringone);
				      
					 }
		    	  }
	     	   }
		    }
		});
				 builder.show();
			}
		});
	 
	 
	//返回前一界面 
	 result.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			arrayList=new ArrayList<String>();
	//		arrayList.add(object);
			
			Intent intent=new Intent(Plan.this,Content.class);
			    intent.putExtra("key2","1");
			    intent.putExtra("three", arrayList);
			    intent.putExtra("one", arrayList2);
				intent.putExtra("two", arrayList3);
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
				intent.putExtra("company", company2);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
			startActivity(intent);
			overridePendingTransition(R.anim.onout,R.anim.inout);
			finish();
			
		}
	});
	 
	 
	//返回前一界面 
		 back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				arrayList=new ArrayList<String>();
		//		arrayList.add(object);
				
				Intent intent=new Intent(Plan.this,Content.class);
				    intent.putExtra("key2", "1");
				    intent.putExtra("three", arrayList);
				    intent.putExtra("one", arrayList2);
					intent.putExtra("two", arrayList3);
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
					intent.putExtra("company", company2);
					intent.putExtra("department", department);
					intent.putExtra("district", district);
					intent.putExtra("province", province);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
				
			}
		});
	 //用于保存信息的显示
	 ArrayList<String>arrayList1=new ArrayList<String>();
	 arrayList1=getIntent().getStringArrayListExtra("one");
	 System.out.println("地勘阶段收到的保存值"+arrayList1);
	 String string=new String(); String string1=new String();
	 
	 if(arrayList1!=null){
		 string=arrayList1.get(0);
		 string1=arrayList1.get(1);
	 }
	 
	 
	//增加信息
	  company.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plan.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				companys=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Plan.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO 自动生成的方法存根
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //显示岗位名称
				                 showsss.setText(strings[arg1]);	
				                 String fiveString =showsss.getText().toString();
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
				
					}
				});
				//保存
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					
						
						//添加电话
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Plan.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plan.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plan.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Plan.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList111.size()<16){
					     	arrayList111.add(name.getText().toString());                
					    	arrayList111.add(phone.getText().toString());                   
						    arrayList111.add(showsss.getText().toString());              
						    arrayList111.add(companys.getText().toString());               
						    arrayList111.add(addressimage.getText().toString()); 
						}
						System.out.println("储存的数据"+arrayList111);
						String stringone=new String();  
						
						if(arrayList111!=null&&arrayList111.size()==5){
							stringone=arrayList111.get(0);    
						    nameone.setText(stringone);  
						}  else if(arrayList111!=null&&arrayList111.size()==10){
							stringone=arrayList111.get(5);
						 	nametwo.setText(stringone); 
							}
						else if(arrayList111!=null&&arrayList111.size()==15){
							stringone=arrayList111.get(10);{
							namethree.setText(stringone);
				      
					 }
		    	  }
	     	   }
		    }
		});
				 builder.show();
			}
		});
	 
	  
	//修改三位联系人  第一位
		nameone.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plan.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				companys=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList112.size()==0){
					string1=arrayList111.get(0);   name.setText(string1);
					string2=arrayList111.get(1);   phone.setText(string2);
					string3=arrayList111.get(2);   showsss.setText(string3);
					string4=arrayList111.get(3);   companys.setText(string4);
					string5 =arrayList111.get(4);  addressimage.setText(string5);
				}else if(arrayList112.size()==5){
					System.out.println("sssss"+arrayList112);
					string1=arrayList112.get(0);   name.setText(string1);
					string2=arrayList112.get(1);   phone.setText(string2);
				    string3=arrayList112.get(2);   showsss.setText(string3);
					string4=arrayList112.get(3);   companys.setText(string4);
					string5 =arrayList112.get(4);  addressimage.setText(string5);
				}else if(arrayList112!=null&&arrayList112.size()==10){
					string1=arrayList112.get(5);   name.setText(string1);
					string2=arrayList112.get(6);   phone.setText(string2);
				    string3=arrayList112.get(7);   showsss.setText(string3);
					string4=arrayList112.get(8);   companys.setText(string4);
					string5 =arrayList112.get(9);  addressimage.setText(string5);
				}else if(arrayList112!=null&&arrayList112.size()==15){
					string1=arrayList112.get(10);   name.setText(string1);
					string2=arrayList112.get(11);   phone.setText(string2);
				    string3=arrayList112.get(12);   showsss.setText(string3);
					string4=arrayList112.get(13);   companys.setText(string4);
					string5 =arrayList112.get(14);  addressimage.setText(string5);
				}else if(arrayList112.size()>15){
					string1=arrayList112.get(10);   name.setText(string1);
					string2=arrayList112.get(11);   phone.setText(string2);
				    string3=arrayList112.get(12);   showsss.setText(string3);
					string4=arrayList112.get(13);   companys.setText(string4);
					string5 =arrayList112.get(14);  addressimage.setText(string5);
				}
			
				
				
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Plan.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO 自动生成的方法存根
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //显示岗位名称
				                 showsss.setText(strings[arg1]);	
				                 String fiveString =showsss.getText().toString();
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
				
					}
				});
				//保存
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					
						
						//添加电话
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Plan.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
					
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plan.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plan.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList112.size()>10){
								Toast.makeText(Plan.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList112.size()<16){
					     	arrayList112.add(name.getText().toString());                
					    	arrayList112.add(phone.getText().toString());                   
						    arrayList112.add(showsss.getText().toString());              
						    arrayList112.add(companys.getText().toString());               
						    arrayList112.add(addressimage.getText().toString()); 
						}
						System.out.println("储存的数据"+arrayList112);
						String stringone=new String();  
						
						if(arrayList112!=null&&arrayList112.size()==5){
							stringone=arrayList112.get(0);    
 						    nameone.setText(stringone);  
						}  else if(arrayList112!=null&&arrayList112.size()==10){
							stringone=arrayList112.get(5);
							nameone.setText(stringone); 
							}
						else if(arrayList112!=null&&arrayList112.size()==15){
							stringone=arrayList112.get(10);{
							nameone.setText(stringone);
		    	  }
				 }
	     	   }
		    }
		});
				 builder.show();
			}
		});
	
		
		
		//修改三位联系人  第二位
		nametwo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plan.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				companys=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList113.size()==0){
					string1=arrayList111.get(5);   name.setText(string1);
					string2=arrayList111.get(6);   phone.setText(string2);
					string3=arrayList111.get(7);   showsss.setText(string3);
					string4=arrayList111.get(8);   companys.setText(string4);
					string5 =arrayList111.get(9);  addressimage.setText(string5);
				}else if(arrayList113.size()==5){
					string1=arrayList113.get(0);   name.setText(string1);
					string2=arrayList113.get(1);   phone.setText(string2);
				    string3=arrayList113.get(2);   showsss.setText(string3);
					string4=arrayList113.get(3);   companys.setText(string4);
					string5 =arrayList113.get(4);  addressimage.setText(string5);
				}else if(arrayList113!=null&&arrayList113.size()==10){
					string1=arrayList113.get(5);   name.setText(string1);
					string2=arrayList113.get(6);   phone.setText(string2);
				    string3=arrayList113.get(7);   showsss.setText(string3);
					string4=arrayList113.get(8);   companys.setText(string4);
					string5 =arrayList113.get(9);  addressimage.setText(string5);
				}else if(arrayList113!=null&&arrayList113.size()==15){
					string1=arrayList113.get(10);   name.setText(string1);
					string2=arrayList113.get(11);   phone.setText(string2);
				    string3=arrayList113.get(12);   showsss.setText(string3);
					string4=arrayList113.get(13);   companys.setText(string4);
					string5 =arrayList113.get(14);  addressimage.setText(string5);
				}else if(arrayList113.size()>15){
					string1=arrayList113.get(10);   name.setText(string1);
					string2=arrayList113.get(11);   phone.setText(string2);
				    string3=arrayList113.get(12);   showsss.setText(string3);
					string4=arrayList113.get(13);   companys.setText(string4);
					string5 =arrayList113.get(14);  addressimage.setText(string5);
				}
			
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Plan.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO 自动生成的方法存根
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //显示岗位名称
				                 showsss.setText(strings[arg1]);	
				                 String fiveString =showsss.getText().toString();
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
				
					}
				});
				//保存
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					
						
						//添加电话
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Plan.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plan.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plan.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList113.size()>10){
								Toast.makeText(Plan.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList113.size()<16){
					     	arrayList113.add(name.getText().toString());                
					    	arrayList113.add(phone.getText().toString());                   
						    arrayList113.add(showsss.getText().toString());              
						    arrayList113.add(companys.getText().toString());               
						    arrayList113.add(addressimage.getText().toString()); 
						}
						System.out.println("储存的数据"+arrayList113);
						String stringone=new String();  
						
						if(arrayList113!=null&&arrayList113.size()==5){
							stringone=arrayList113.get(0);    
 						    nametwo.setText(stringone);  
						}  else if(arrayList113!=null&&arrayList113.size()==10){
							stringone=arrayList113.get(5);
							nametwo.setText(stringone); 
							}
						else if(arrayList113!=null&&arrayList113.size()==15){
							stringone=arrayList113.get(10);{
							nametwo.setText(stringone);
		    	  }
				 }
	     	   }
		    }
		});
				 builder.show();
			}
		});
		


		//修改三位联系人  第三位
		namethree.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plan.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				companys=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList114.size()==0){
					string1=arrayList111.get(10);   name.setText(string1);
					string2=arrayList111.get(11);   phone.setText(string2);
					string3=arrayList111.get(12);   showsss.setText(string3);
					string4=arrayList111.get(13);   companys.setText(string4);
					string5=arrayList111.get(14);  addressimage.setText(string5);
				}else if(arrayList114.size()==5){
					string1=arrayList114.get(0);   name.setText(string1);
					string2=arrayList114.get(1);   phone.setText(string2);
				    string3=arrayList114.get(2);   showsss.setText(string3);
					string4=arrayList114.get(3);   companys.setText(string4);
					string5=arrayList114.get(4);  addressimage.setText(string5);
				}else if(arrayList114!=null&&arrayList114.size()==10){
					string1=arrayList114.get(5);   name.setText(string1);
					string2=arrayList114.get(6);   phone.setText(string2);
				    string3=arrayList114.get(7);   showsss.setText(string3);
					string4=arrayList114.get(8);   companys.setText(string4);
					string5=arrayList114.get(9);  addressimage.setText(string5);
				}else if(arrayList114!=null&&arrayList114.size()==15){
					string1=arrayList114.get(10);   name.setText(string1);
					string2=arrayList114.get(11);   phone.setText(string2);
				    string3=arrayList114.get(12);   showsss.setText(string3);
					string4=arrayList114.get(13);   companys.setText(string4);
					string5=arrayList114.get(14);  addressimage.setText(string5);
				}else if(arrayList114.size()>15){
					string1=arrayList114.get(10);   name.setText(string1);
					string2=arrayList114.get(11);   phone.setText(string2);
				    string3=arrayList114.get(12);   showsss.setText(string3);
					string4=arrayList114.get(13);   companys.setText(string4);
					string5 =arrayList114.get(14);  addressimage.setText(string5);
				}
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Plan.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO 自动生成的方法存根
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //显示岗位名称
				                 showsss.setText(strings[arg1]);	
				                 String fiveString =showsss.getText().toString();
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
				
					}
				});
				//保存
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					
						
						//添加电话
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Plan.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plan.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plan.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList114.size()>10){
								Toast.makeText(Plan.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList114.size()<16){
					     	arrayList114.add(name.getText().toString());                
					    	arrayList114.add(phone.getText().toString());                   
						    arrayList114.add(showsss.getText().toString());              
						    arrayList114.add(companys.getText().toString());               
						    arrayList114.add(addressimage.getText().toString()); 
						}
						System.out.println("储存的数据"+arrayList114);
						String stringone=new String();  
						
						if(arrayList114!=null&&arrayList114.size()==5){
							stringone=arrayList114.get(0);    
 						    namethree.setText(stringone);  
						}  else if(arrayList114!=null&&arrayList114.size()==10){
							stringone=arrayList114.get(5);
							namethree.setText(stringone); 
							}
						else if(arrayList114!=null&&arrayList114.size()==15){
							stringone=arrayList114.get(10);{
							namethree.setText(stringone);
		    	  }
				 }
	     	   }
		    }
		});
				 builder.show();
			}
		});

	  
	  
    }
	 
	 //设置相机照相
	 class myAdpter extends BaseAdapter{
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
//			myAdpter.notifyDataSetChanged();

		}
		
	//设置返回键
			@Override
			public void onBackPressed() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Plan.this,Content.class);
				 intent.putExtra("key2","1");
				intent.putExtra("three", arrayList);
			    intent.putExtra("one", arrayList2);
				intent.putExtra("two", arrayList3);
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
				intent.putExtra("company", company2);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
			}
	}