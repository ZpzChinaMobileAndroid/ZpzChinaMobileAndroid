package com.example.message;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.message.R.id;
import com.example.myself.Myself;
import com.example.sqlite.Information;
import com.example.sqlite.Sqlite;

public class Design extends Activity {
	
	
	
	String[] str={"结构","立面","幕墙","暖通","扩初","蓝图","送审","审结"}; 
	String[] strings={"建筑师","结构工程师","电气工程师","暖通工程师","给排水工程师","幕墙工程师"};
	String string,password,username;
	ArrayList<String >cellphone,company2,department,province,district;
	 private EditText name , phone, company , addressimage;
		private	 TextView  station,showsss,nameone,nametwo,namethree ;
		private ImageView saveimage;
	 ArrayList<String> arrayList, arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11, arrayList111,arrayList112,arrayList113,arrayList114;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__design);
		
    	TextView result=(TextView) findViewById(id.jump);//返回到之前界面
    	TextView  design=(TextView) findViewById(id.design);//增加信息
    	ImageView save=(ImageView) findViewById(id.imageView3);//保存项目
    	ImageView back=(ImageView) findViewById(id.back);//返回界面
    	ImageView choose=(ImageView) findViewById(id.choose);//增加信息
    	TextView stage=(TextView) findViewById(id.design1);//设计阶段
    	final TextView show=(TextView) findViewById(id.show);//显示设计阶段
    	 nameone=(TextView) findViewById(id.nameone);//显示名字
		 nametwo=(TextView) findViewById(id.nametwo);//显示名字2
		 namethree=(TextView) findViewById(id.namethree);//显示名字3
    	  //中转我的值
  	  //中转我的值
 	    arrayList2=new ArrayList<String>();
        arrayList2=getIntent().getStringArrayListExtra("one");	
        arrayList3=new ArrayList<String>();
        arrayList3=getIntent().getStringArrayListExtra("two");	
        arrayList4=new ArrayList<String>();
        arrayList4=getIntent().getStringArrayListExtra("three");	
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
        arrayList111=new ArrayList<String>();
        arrayList112=new ArrayList<String>();
        arrayList113=new ArrayList<String>();
        arrayList114=new ArrayList<String>();
      //接收传过来的token值
      		string=getIntent().getStringExtra("token");
      		System.out.println("设计界面接收到的token值"+string);
      		//接收传过来的登录名
      		username=getIntent().getStringExtra("name");
      		System.out.println("设计界面收到的用户名"+username);
      		//接收传过来的登录密码
      		password=getIntent().getStringExtra("password");
      		System.out.println("设计界面收到的登录密码"+password);
      		 //接收传过来的手机号
      		 cellphone=getIntent().getStringArrayListExtra("cellphone");
      		 System.out.println("设计界面收到的手机号"+cellphone);
      		 //接收传过来的所属单位
      		 company2=getIntent().getStringArrayListExtra("company");
      		 System.out.println("设计界面收到的所属单位"+company);
      		 //接收传过来的职务
      		 department=getIntent().getStringArrayListExtra("department");
      		 System.out.println("设计界面收到的职务"+department);
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
     			
     		Intent intent=new Intent(Design.this,Myself.class);
     		intent.putExtra("one", arrayList2);
     		intent.putExtra("two", arrayList3);
     		intent.putExtra("three", arrayList4);
     		intent.putExtra("four", arrayList);
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
//     		intent.putExtra("user", arrayList111);
//     		intent.putExtra("user1", arrayList112);
//     		intent.putExtra("user2", arrayList113);
//     		intent.putExtra("user3", arrayList114);
     		
     		startActivity(intent);
     		finish();
     		 Toast.makeText(Design.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
     		}
     	});
      		
      		
    	//返回到之前界面
    	 result.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO 自动生成的方法存根
    				arrayList=new ArrayList<String>();
    				arrayList.add(show.getText().toString());
    				
    				Intent intent=new Intent(Design.this,Content.class);
    				intent.putExtra("key3", "1");
    				intent.putExtra("four", arrayList);
    				intent.putExtra("one", arrayList2);
       				intent.putExtra("two", arrayList3);
       				intent.putExtra("three", arrayList4);
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
    	//返回到之前界面
    	 back.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO 自动生成的方法存根
    				arrayList=new ArrayList<String>();
    				arrayList.add(show.getText().toString());
    				
    				Intent intent=new Intent(Design.this,Content.class);
    				intent.putExtra("key3", "1");
    				intent.putExtra("four", arrayList);
    				intent.putExtra("one", arrayList2);
       				intent.putExtra("two", arrayList3);
       				intent.putExtra("three", arrayList4);
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
    	 
    	 
    	 //保存这一页面的输入值
    	 ArrayList<String>arrayList1=new ArrayList<String>();
    	 arrayList1=getIntent().getStringArrayListExtra("four");
    	 System.out.println("设计阶段的值"+arrayList1);
    	 String string=new String();
    	 //判断是否为null
    	 if(arrayList1!=null){
       	 string=arrayList1.get(0);show.setText(string);
    	 }
    	
    	 
    	//增加信息
    	design.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Design.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				company=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
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
					    	   Toast.makeText(Design.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Design.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Design.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Design.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList111.size()<16){
					     	arrayList111.add(name.getText().toString());                
					    	arrayList111.add(phone.getText().toString());                   
						    arrayList111.add(showsss.getText().toString());              
						    arrayList111.add(company.getText().toString());               
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
	
    	
    	
    	//增加信息
    	choose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Design.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				company=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
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
					    	   Toast.makeText(Design.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Design.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Design.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Design.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList111.size()<16){
					     	arrayList111.add(name.getText().toString());                
					    	arrayList111.add(phone.getText().toString());                   
						    arrayList111.add(showsss.getText().toString());              
						    arrayList111.add(company.getText().toString());               
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
				final AlertDialog builder=new AlertDialog.Builder(Design.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				company=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList112.size()==0){
					string1=arrayList111.get(0);   name.setText(string1);
					string2=arrayList111.get(1);   phone.setText(string2);
					string3=arrayList111.get(2);   showsss.setText(string3);
					string4=arrayList111.get(3);   company.setText(string4);
					string5 =arrayList111.get(4);  addressimage.setText(string5);
				}else if(arrayList112.size()==5){
					System.out.println("sssss"+arrayList112);
					string1=arrayList112.get(0);   name.setText(string1);
					string2=arrayList112.get(1);   phone.setText(string2);
				    string3=arrayList112.get(2);   showsss.setText(string3);
					string4=arrayList112.get(3);   company.setText(string4);
					string5 =arrayList112.get(4);  addressimage.setText(string5);
				}else if(arrayList112!=null&&arrayList112.size()==10){
					string1=arrayList112.get(5);   name.setText(string1);
					string2=arrayList112.get(6);   phone.setText(string2);
				    string3=arrayList112.get(7);   showsss.setText(string3);
					string4=arrayList112.get(8);   company.setText(string4);
					string5 =arrayList112.get(9);  addressimage.setText(string5);
				}else if(arrayList112!=null&&arrayList112.size()==15){
					string1=arrayList112.get(10);   name.setText(string1);
					string2=arrayList112.get(11);   phone.setText(string2);
				    string3=arrayList112.get(12);   showsss.setText(string3);
					string4=arrayList112.get(13);   company.setText(string4);
					string5 =arrayList112.get(14);  addressimage.setText(string5);
				}else if(arrayList112.size()>15){
					string1=arrayList112.get(10);   name.setText(string1);
					string2=arrayList112.get(11);   phone.setText(string2);
				    string3=arrayList112.get(12);   showsss.setText(string3);
					string4=arrayList112.get(13);   company.setText(string4);
					string5 =arrayList112.get(14);  addressimage.setText(string5);
				}
			
				
				
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
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
					    	   Toast.makeText(Design.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Design.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Design.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList112.size()>10){
								Toast.makeText(Design.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList112.size()<16){
					     	arrayList112.add(name.getText().toString());                
					    	arrayList112.add(phone.getText().toString());                   
						    arrayList112.add(showsss.getText().toString());              
						    arrayList112.add(company.getText().toString());               
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
				final AlertDialog builder=new AlertDialog.Builder(Design.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				company=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList113.size()==0){
					string1=arrayList111.get(5);   name.setText(string1);
					string2=arrayList111.get(6);   phone.setText(string2);
					string3=arrayList111.get(7);   showsss.setText(string3);
					string4=arrayList111.get(8);   company.setText(string4);
					string5 =arrayList111.get(9);  addressimage.setText(string5);
				}else if(arrayList113.size()==5){
					string1=arrayList113.get(0);   name.setText(string1);
					string2=arrayList113.get(1);   phone.setText(string2);
				    string3=arrayList113.get(2);   showsss.setText(string3);
					string4=arrayList113.get(3);   company.setText(string4);
					string5 =arrayList113.get(4);  addressimage.setText(string5);
				}else if(arrayList113!=null&&arrayList113.size()==10){
					string1=arrayList113.get(5);   name.setText(string1);
					string2=arrayList113.get(6);   phone.setText(string2);
				    string3=arrayList113.get(7);   showsss.setText(string3);
					string4=arrayList113.get(8);   company.setText(string4);
					string5 =arrayList113.get(9);  addressimage.setText(string5);
				}else if(arrayList113!=null&&arrayList113.size()==15){
					string1=arrayList113.get(10);   name.setText(string1);
					string2=arrayList113.get(11);   phone.setText(string2);
				    string3=arrayList113.get(12);   showsss.setText(string3);
					string4=arrayList113.get(13);   company.setText(string4);
					string5 =arrayList113.get(14);  addressimage.setText(string5);
				}else if(arrayList113.size()>15){
					string1=arrayList113.get(10);   name.setText(string1);
					string2=arrayList113.get(11);   phone.setText(string2);
				    string3=arrayList113.get(12);   showsss.setText(string3);
					string4=arrayList113.get(13);   company.setText(string4);
					string5 =arrayList113.get(14);  addressimage.setText(string5);
				}
			
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
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
					    	   Toast.makeText(Design.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Design.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Design.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList113.size()>10){
								Toast.makeText(Design.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList113.size()<16){
					     	arrayList113.add(name.getText().toString());                
					    	arrayList113.add(phone.getText().toString());                   
						    arrayList113.add(showsss.getText().toString());              
						    arrayList113.add(company.getText().toString());               
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
				final AlertDialog builder=new AlertDialog.Builder(Design.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//添加姓名
				phone=(EditText)view.findViewById(id.phone);//添加电话
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//显示岗位
				company=(EditText)view.findViewById(id.company);//拍卖单位
				addressimage=(EditText)view.findViewById(id.address);//拍卖单位
				saveimage=(ImageView)view.findViewById(id.save);//保存
				
				String string1=new String();   	String string2=new String();   	String string3=new String();
				String string4=new String();    String string5=new String();
				
				if(arrayList111!=null&&arrayList114.size()==0){
					string1=arrayList111.get(10);   name.setText(string1);
					string2=arrayList111.get(11);   phone.setText(string2);
					string3=arrayList111.get(12);   showsss.setText(string3);
					string4=arrayList111.get(13);   company.setText(string4);
					string5=arrayList111.get(14);  addressimage.setText(string5);
				}else if(arrayList114.size()==5){
					string1=arrayList114.get(0);   name.setText(string1);
					string2=arrayList114.get(1);   phone.setText(string2);
				    string3=arrayList114.get(2);   showsss.setText(string3);
					string4=arrayList114.get(3);   company.setText(string4);
					string5=arrayList114.get(4);  addressimage.setText(string5);
				}else if(arrayList114!=null&&arrayList114.size()==10){
					string1=arrayList114.get(5);   name.setText(string1);
					string2=arrayList114.get(6);   phone.setText(string2);
				    string3=arrayList114.get(7);   showsss.setText(string3);
					string4=arrayList114.get(8);   company.setText(string4);
					string5=arrayList114.get(9);  addressimage.setText(string5);
				}else if(arrayList114!=null&&arrayList114.size()==15){
					string1=arrayList114.get(10);   name.setText(string1);
					string2=arrayList114.get(11);   phone.setText(string2);
				    string3=arrayList114.get(12);   showsss.setText(string3);
					string4=arrayList114.get(13);   company.setText(string4);
					string5=arrayList114.get(14);  addressimage.setText(string5);
				}else if(arrayList114.size()>15){
					string1=arrayList114.get(10);   name.setText(string1);
					string2=arrayList114.get(11);   phone.setText(string2);
				    string3=arrayList114.get(12);   showsss.setText(string3);
					string4=arrayList114.get(13);   company.setText(string4);
					string5 =arrayList114.get(14);  addressimage.setText(string5);
				}
				
				//岗位
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
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
					    	   Toast.makeText(Design.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Design.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Design.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList114.size()>10){
								Toast.makeText(Design.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
							}else{
								builder.dismiss();
							}
					
						if(arrayList114.size()<16){
					     	arrayList114.add(name.getText().toString());                
					    	arrayList114.add(phone.getText().toString());                   
						    arrayList114.add(showsss.getText().toString());              
						    arrayList114.add(company.getText().toString());               
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

    	
    	//设计阶段
    	stage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder=new AlertDialog.Builder(Design.this);
				builder.setItems(str,new AlertDialog.OnClickListener() {
					
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
    	
    }
	//设置返回键
			@Override
			public void onBackPressed() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Design.this,Content.class);
				intent.putExtra("key3", "1");
				intent.putExtra("four", arrayList);
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
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