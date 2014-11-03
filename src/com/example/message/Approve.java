package com.example.message;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.message.R.id;
import com.example.myself.Myself;
import com.example.sqlite.Information;
import com.example.sqlite.Sqlite;
import com.guozg.wheelview.views.ArrayWheelAdapter;
import com.guozg.wheelview.views.OnWheelChangedListener;
import com.guozg.wheelview.views.WheelView;

public class Approve extends Activity {
	
	private	EditText projectname,describe,invest,area,higth;
	private	TextView unit,address,address1,address2,start,stop,participation,owner,approve,show,shower,show1,shower1,nameone,nametwo,namethree;
	private	ImageView choose;
	String[] str={"外资独资","中外独资","私人企业","政府机关","国有企业","其他"};
	String[] str2={"参与","不参与"};
	ArrayList<String >cellphone,company2,department,province,district,realname;
	String[] strings={"项目负责人","项目经理","设计经理","项目总负责人","其他"};
	ArrayList<String>arrayList=new ArrayList<String>();
	String string,password,username;
	 TextView  station,showsss ;
	 String ss,sss;
	 ImageView saveimage;
	 EditText name,phone,addressimage,company;
	ArrayList<String>arrayList111,arrayList112,arrayList113,arrayList114;
	 ArrayList<String> arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	String str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14;
	//年月日
	public String category1[] = new String[] { "2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024年","2025","2026","2027","2028","2029","2030","2031","2032","2033"};
	public String category2[][] = new String[][]{{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },
			{"01","02","03","04","05","06","07","08","09","10","11","12" },{"01","02","03","04","05","06","07","08","09","10","11","12" },};
	public String category3[][] = new String[][] { {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},
			{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__approve);
		
	   projectname=(EditText) findViewById(id.prjoctname);//项目名称
	   address1=(TextView) findViewById(id.address1);//项目地址区域
	   address2=(TextView) findViewById(id.address2);//项目地址城市
	   address=(TextView) findViewById(id.address);//项目地址
	   describe=(EditText) findViewById(id.describe);//项目描述
	   invest=(EditText) findViewById(id.invest);//投资额
	   area=(EditText) findViewById(id.area);//面积
	   higth=(EditText) findViewById(id.higth);//层高
	   unit=(TextView) findViewById(id.unit);//业主单位
	   start=(TextView) findViewById(id.start);//开工时间
	   stop=(TextView) findViewById(id.stop);//竣工时间
	   participation=(TextView) findViewById(id.participation);//外资参与
	   owner=(TextView) findViewById(id.owner);//业主类型
	   choose=(ImageView) findViewById(id.choose);//增加用户信息
	   approve=(TextView) findViewById(id.jump);//项目立项返回之前界面
	   ImageView   result=(ImageView) findViewById(id.back);//项目立项返回之前界面
	   ImageView   save=(ImageView) findViewById(id.save);//保存项目
	   show=(TextView) findViewById(id.show);//显示是否参与
	   shower=(TextView) findViewById(id.shower);//类型显示
	   show1=(TextView) findViewById(id.show1);//显示开始工程
	   shower1=(TextView) findViewById(id.shower1);//显示竣工日程
	   nameone=(TextView) findViewById(id.nameone);//显示名字
	   nametwo=(TextView) findViewById(id.nametwo);//显示名字2
	   namethree=(TextView) findViewById(id.namethree);//显示名字3
	   //设置边框模式
	   projectname.setBackgroundDrawable(null);
	   describe.setBackgroundDrawable(null);
	   invest.setBackgroundDrawable(null);
	   area.setBackgroundDrawable(null);
	   higth.setBackgroundDrawable(null);
		
	   arrayList111=new ArrayList<String>();
	   arrayList112=new ArrayList<String>();
	   arrayList113=new ArrayList<String>();
	   arrayList114=new ArrayList<String>();
	   
	   
	   
	   //接收传过来的token值
		string=getIntent().getStringExtra("token");
		System.out.println("项目立项界面接收到的token值"+string);
		//接收传过来的登录名
		username=getIntent().getStringExtra("name");
		System.out.println("项目立项界面收到的用户名"+username);
		//接收传过来的登录密码
		password=getIntent().getStringExtra("password");
		System.out.println("项目立项界面收到的登录密码"+password);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("项目立项界面收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company2=getIntent().getStringArrayListExtra("company");
		 System.out.println("项目立项界面收到的所属单位"+company);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("项目立项界面收到的职务"+department);
		 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
		 //接收传过来的用户名
		 realname=getIntent().getStringArrayListExtra("realname");
		 System.out.println("土地规划接收到的名字"+realname);
	   
		  //中转我的值
	    arrayList2=new ArrayList<String>();
       arrayList2=getIntent().getStringArrayListExtra("one");	
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
       
       //显示区域城市
		 if(district!=null&&province!=null){
			  ss=district.get(0); sss=province.get(0);
			 System.out.println("sss"+ss);  System.out.println("ddd"+sss);
			 address1.setText(ss);    address2.setText(sss);
		 }
       
       
	   //项目立项返回之前界面
	   approve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				arrayList.add(projectname.getText().toString());
				arrayList.add(ss);
				arrayList.add(sss);
				arrayList.add(describe.getText().toString());
				arrayList.add(show1.getText().toString());
				arrayList.add(shower1.getText().toString());
				arrayList.add(invest.getText().toString());
				arrayList.add(area.getText().toString());
				arrayList.add(higth.getText().toString());
				arrayList.add(show.getText().toString());
				arrayList.add(shower.getText().toString());
				
				
				Intent intent=new Intent(Approve.this,Content.class);
				intent.putExtra("key1", "1");
				intent.putExtra("two", arrayList);
				intent.putExtra("one", arrayList2);
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
   				intent.putExtra("company", company2);
   				intent.putExtra("department", department);
   				intent.putExtra("district", district);
   				intent.putExtra("province", province);
   				intent.putExtra("realname", realname);
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
			
			arrayList.add(projectname.getText().toString());
			arrayList.add(address.getText().toString());
			arrayList.add(describe.getText().toString());
			arrayList.add(show1.getText().toString());
			arrayList.add(shower1.getText().toString());
			arrayList.add(invest.getText().toString());
			arrayList.add(area.getText().toString());
			arrayList.add(higth.getText().toString());
			arrayList.add(show.getText().toString());
			arrayList.add(shower.getText().toString());	  
			
		Intent intent=new Intent(Approve.this,Myself.class);
		intent.putExtra("one", arrayList2);
		intent.putExtra("two", arrayList);
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
		intent.putExtra("company", company2);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
		intent.putExtra("realname", realname);
//		intent.putExtra("user", arrayList111);
//		intent.putExtra("user1", arrayList112);
//		intent.putExtra("user2", arrayList113);
//		intent.putExtra("user3", arrayList114);
		
		startActivity(intent);
		finish();
		 Toast.makeText(Approve.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
		}
	});
	   
	   
	   //返回之前界面
	   result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				arrayList.add(projectname.getText().toString());
				arrayList.add(address.getText().toString());
				arrayList.add(describe.getText().toString());
				arrayList.add(show1.getText().toString());
				arrayList.add(shower1.getText().toString());
				arrayList.add(invest.getText().toString());
				arrayList.add(area.getText().toString());
				arrayList.add(higth.getText().toString());
				arrayList.add(show.getText().toString());
				arrayList.add(shower.getText().toString());
				
				
				Intent intent=new Intent(Approve.this,Content.class);
				intent.putExtra("key1", "1");
				intent.putExtra("two", arrayList);
				intent.putExtra("one", arrayList2);
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
   				intent.putExtra("company", company2);
   				intent.putExtra("department", department);
   				intent.putExtra("district", district);
   				intent.putExtra("province", province);
   				intent.putExtra("realname", realname);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
				
			}
		});
	   //接受的值，用于显示保存
	   ArrayList<String>arrayList1=new ArrayList<String>();
       arrayList1=getIntent().getStringArrayListExtra("two");	  
      
	   System.out.println("项目立项接受的值"+arrayList1);
	   str3=new String();str4=new String();str5=new String();str6=new String();str7=new String();str8=new String();
	   str9=new String();str10=new String();str11=new String();str12=new String();str13=new String();str14=new String();
    //判断一下不等于null的时候
	   if(arrayList1!=null){
       str3=arrayList1.get(0);     projectname.setText(str3);
	   str4=arrayList1.get(1);     describe.setText(str4);
	   str5=arrayList1.get(2);     show1.setText(str5);
	   str6=arrayList1.get(3);     shower1.setText(str6);
	   str7=arrayList1.get(4);     invest.setText(str7);
	   str8=arrayList1.get(5);     area.setText(str8);
	   str9=arrayList1.get(6);     higth.setText(str9);
	   str10=arrayList1.get(7);    show.setText(str10);
	   str11=arrayList1.get(8);    shower.setText(str11);
  //   str12=arrayList.get(0);    projectname.setText(str12);
  //   str13=arrayList.get(0);    projectname.setText(str13);
  //   str14=arrayList.get(0);    projectname.setText(str14);
}
	   
	
	   
	   
	 //外资参与
	   participation.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			
			AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
			builder.setItems(str2,new AlertDialog.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根
				
						for(int i=0;i<str2.length;i++){
							if(i==arg1){
					
					         //显示是否参与
			                  show.setText(str2[arg1]);	
			                  arg0.dismiss();
							}
						}
				}
			});
			builder.show();
		}
	});
	
	 //业主类型
	   owner.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			final boolean[]	checkedItems =new boolean[]{false,false,false,false,false,false};
			AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
			AlertDialog.Builder builder2=new AlertDialog.Builder(Approve.this);
			builder2.setTitle("提示");
			builder2.setMultiChoiceItems(str, checkedItems, new AlertDialog.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
					// TODO 自动生成的方法存根
				checkedItems[arg1]=arg2;          //改变被操作列表的状态
				}
			});
			builder2.setPositiveButton("确定", new AlertDialog. OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根

					String result="";          //用于保存选择结果
					for(int i=0;i<checkedItems.length;i++){
						if(checkedItems[i]){
							result+=str[i]+"、";        //将选项内容添加到result中
						}
					}
					//判断一下result不为空的时候，将所得到的结果显示出来
				if("".equals(result)){}	
					result=result.substring(0,result.length()-1);
					shower.setText(result);     //显示所选择的内容
				}
			});
			builder2.setNegativeButton("取消", null);
			builder2.show();
				
			}
		});
	   
	   
	
	   
	   
	 //增加用户信息
	   choose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Approve.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
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
						String two=phone.getText().toString();  
						if(two.equals("")){
					    	   Toast.makeText(Approve.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Approve.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Approve.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Approve.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
	   
		
	   
	 //业主单位
	   unit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Approve.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
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
					    	   Toast.makeText(Approve.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Approve.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Approve.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Approve.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
				final AlertDialog builder=new AlertDialog.Builder(Approve.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
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
					    	   Toast.makeText(Approve.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Approve.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Approve.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList112.size()>10){
								Toast.makeText(Approve.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
				final AlertDialog builder=new AlertDialog.Builder(Approve.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
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
					    	   Toast.makeText(Approve.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Approve.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Approve.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList113.size()>10){
								Toast.makeText(Approve.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
				final AlertDialog builder=new AlertDialog.Builder(Approve.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Approve.this);
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
					    	   Toast.makeText(Approve.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Approve.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Approve.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList114.size()>10){
								Toast.makeText(Approve.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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

	   
	 //开工时间  
	 
		 
		 start.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                showSelectDialog(Approve.this, "区域选择", category1, category2,category3);
	            }
	        });
		}
		 private void showSelectDialog(Context context, String title, final String[] left, final String[][] right, final String[][] last) {
		        AlertDialog dialog = new AlertDialog.Builder(context).create();
		        dialog.setTitle(title);
		        LinearLayout llContent = new LinearLayout(context);
		        llContent.setOrientation(LinearLayout.HORIZONTAL);
		        
		        //第一级列表
		        final WheelView wheelLeft = new WheelView(context);
		        wheelLeft.setVisibleItems(5);
		        wheelLeft.setCyclic(true);
		        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(left));
		        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
		        paramsLeft.gravity = Gravity.RIGHT;
		        
		        
		        //第二级列表
		        final WheelView wheelRight = new WheelView(context);
		        wheelRight.setVisibleItems(5);
		        wheelRight.setCyclic(true);
		        wheelRight.setAdapter(new ArrayWheelAdapter<String>(right[0]));
		        LinearLayout.LayoutParams paramsRight = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (float)0.6);
		        paramsRight.gravity = Gravity.RIGHT;
		        
		        
		        //第三级列表
		        final WheelView wheellast = new WheelView(context);
		        wheellast.setVisibleItems(5);
		        wheellast.setCyclic(true);
		        wheellast.setAdapter(new ArrayWheelAdapter<String>(last[0]));
		        LinearLayout.LayoutParams paramslast = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT, (float)0.6);
		        paramslast.gravity = Gravity.RIGHT;
		       
		          
		       
		        llContent.addView(wheelLeft, paramsLeft);
		        llContent.addView(wheelRight, paramsRight);
		        llContent.addView(wheellast, paramslast);
		        
		        wheelRight.addChangingListener(new OnWheelChangedListener() {
		            @Override
		            public void onChanged(WheelView wheel, int oldValue, int newValue) {
		                wheellast.setAdapter(new ArrayWheelAdapter<String>(last[newValue]));
		                wheellast.setCurrentItem(last[newValue].length );
		            }
		        });
		        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                int leftPosition = wheelLeft.getCurrentItem();
		                String vLeft = left[leftPosition];
		                String vRight = right[leftPosition][wheelRight.getCurrentItem()];
		                String vLast = last[leftPosition][wheellast.getCurrentItem()];
		                show1.setText(vLeft + "-" + vRight+"-" +vLast);
		                dialog.dismiss();
		            }
		        });
		        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                dialog.dismiss();
		            }
		        });
		        dialog.setView(llContent);
		        if (!dialog.isShowing()) {
		            dialog.show();
		        }
	   
	 //竣工时间
	   
	        stop.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                showSelectDialog1(Approve.this, "区域选择", category1, category2,category3);
	            }
	        });
		}
		 private void showSelectDialog1(Context context, String title, final String[] left, final String[][] right, final String[][] last) {
		        AlertDialog dialog = new AlertDialog.Builder(context).create();
		        dialog.setTitle(title);
		        LinearLayout llContent = new LinearLayout(context);
		        llContent.setOrientation(LinearLayout.HORIZONTAL);
		        
		        //第一级列表
		        final WheelView wheelLeft = new WheelView(context);
		        wheelLeft.setVisibleItems(5);
		        wheelLeft.setCyclic(true);
		        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(left));
		        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
		        paramsLeft.gravity = Gravity.RIGHT;
		        
		        
		        //第二级列表
		        final WheelView wheelRight = new WheelView(context);
		        wheelRight.setVisibleItems(5);
		        wheelRight.setCyclic(true);
		        wheelRight.setAdapter(new ArrayWheelAdapter<String>(right[0]));
		        LinearLayout.LayoutParams paramsRight = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (float)0.6);
		        paramsRight.gravity = Gravity.RIGHT;
		        
		        
		        //第三级列表
		        final WheelView wheellast = new WheelView(context);
		        wheellast.setVisibleItems(5);
		        wheellast.setCyclic(true);
		        wheellast.setAdapter(new ArrayWheelAdapter<String>(last[0]));
		        LinearLayout.LayoutParams paramslast = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT, (float)0.6);
		        paramslast.gravity = Gravity.RIGHT;
		       
		          
		       
		        llContent.addView(wheelLeft, paramsLeft);
		        llContent.addView(wheelRight, paramsRight);
		        llContent.addView(wheellast, paramslast);
		        
		        wheelRight.addChangingListener(new OnWheelChangedListener() {
		            @Override
		            public void onChanged(WheelView wheel, int oldValue, int newValue) {
		                wheellast.setAdapter(new ArrayWheelAdapter<String>(last[newValue]));
		                wheellast.setCurrentItem(last[newValue].length );
		            }
		        });
		        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                int leftPosition = wheelLeft.getCurrentItem();
		                String vLeft = left[leftPosition];
		                String vRight = right[leftPosition][wheelRight.getCurrentItem()];
		                String vLast = last[leftPosition][wheellast.getCurrentItem()];
		                shower1.setText(vLeft + "-" + vRight+"-" +vLast);
		                dialog.dismiss();
		            }
		        });
		        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                dialog.dismiss();
		            }
		        });
		        dialog.setView(llContent);
		        if (!dialog.isShowing()) {
		            dialog.show();
		        }
	        }
	//设置返回键
			@Override
			public void onBackPressed() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Approve.this,Content.class);
				intent.putExtra("key1", "1");
				intent.putExtra("two", arrayList);
				intent.putExtra("one", arrayList2);
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
   				intent.putExtra("company", company2);
   				intent.putExtra("department", department);
   				intent.putExtra("district", district);
   				intent.putExtra("province", province);
		        intent.putExtra("realname", realname);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
			}
	}