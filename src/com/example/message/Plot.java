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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.message.R.id;
import com.example.myself.Myself;
import com.example.sqlite.Information;
import com.example.sqlite.Sqlite;
import com.guozg.wheelview.views.ArrayWheelAdapter;
import com.guozg.wheelview.views.OnWheelChangedListener;
import com.guozg.wheelview.views.WheelView;

public class Plot extends Activity {
	
	
	
	private	TextView plot,design,start,stop, elevator,condition,heating,material,structure,show,show1,show2,show3,show4,show5,show6;
	private	ImageView choose,save,back;
	String string,password,username;
	ArrayList<String >cellphone,company2,department,province,district;
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
	 private EditText name , phone, company , addressimage;
		private	 TextView  station,showsss,nameone,nametwo,namethree;
		private ImageView saveimage;
	ArrayList<String>arrayList=new ArrayList<String>();
	 ArrayList<String> arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11,arrayList111,arrayList112,arrayList113,arrayList114;
	String [] sringStrings={"已安装","未安装"};
	String[] strings={"项目负责人","项目经理","设计经理","项目总负责人","其他"};
	String str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__plot);
		
		elevator=(TextView) findViewById(id.elevator);//电梯
		condition=(TextView) findViewById(id.condition);//空调
		heating=(TextView) findViewById(id.heating);//供暖方式
		material=(TextView) findViewById(id.material);//外墙材料
		structure=(TextView) findViewById(id.structure);//钢结构
		plot=(TextView) findViewById(id.jump);//返回到前一个界面
		design=(TextView) findViewById(id.design);//增加信息
		start=(TextView) findViewById(id.start);//开始时间
		stop=(TextView) findViewById(id.stop);//竣工时间
		choose=(ImageView) findViewById(id.choose);//增加信息
		save=(ImageView) findViewById(id.save);//保存项目
		back=(ImageView) findViewById(id.back);//返回界面
		show=(TextView) findViewById(id.show);//显示电梯
		show1=(TextView) findViewById(id.show1);//显示空调
		show2=(TextView) findViewById(id.show2);//显示供暖方式
		show3=(TextView) findViewById(id.show3);//显示外墙材料
		show4=(TextView) findViewById(id.show4);//显示钢结构
		show5=(TextView) findViewById(id.show5);//显示开始时间
		show6=(TextView) findViewById(id.show6);//显示竣工时间
		 nameone=(TextView) findViewById(id.nameone);//显示名字
		 nametwo=(TextView) findViewById(id.nametwo);//显示名字2
		 namethree=(TextView) findViewById(id.namethree);//显示名字3
		 
		arrayList111=new ArrayList<String>();
		arrayList111=new ArrayList<String>();
		arrayList111=new ArrayList<String>();
		arrayList111=new ArrayList<String>();
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
       System.out.println("出图阶段界面接收到的token值"+string);
       //接收传过来的登录名
       username=getIntent().getStringExtra("name");
       System.out.println("出图阶段界面收到的用户名"+username);
       //接收传过来的登录密码
       password=getIntent().getStringExtra("password");
       System.out.println("出图阶段界面收到的登录密码"+password);
       //接收传过来的手机号
  	 cellphone=getIntent().getStringArrayListExtra("cellphone");
  	 System.out.println("出图阶段界面收到的手机号"+cellphone);
  	 //接收传过来的所属单位
  	 company2=getIntent().getStringArrayListExtra("company");
  	 System.out.println("出图阶段界面收到的所属单位"+company);
  	 //接收传过来的职务
  	 department=getIntent().getStringArrayListExtra("department");
  	 System.out.println("出图阶段界面收到的职务"+department);
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
		    arrayList.add(show5.getText().toString());
		    arrayList.add(show6.getText().toString());
		    arrayList.add(show.getText().toString());
		    arrayList.add(show1.getText().toString());
		    arrayList.add(show2.getText().toString());
			arrayList.add(show3.getText().toString());
			arrayList.add(show4.getText().toString());
				
			Intent intent=new Intent(Plot.this,Myself.class);
			intent.putExtra("one", arrayList2);
			intent.putExtra("two", arrayList3);
			intent.putExtra("three", arrayList4);
			intent.putExtra("four", arrayList5);
			intent.putExtra("five", arrayList);
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
//			intent.putExtra("user", arrayList111);
//			intent.putExtra("user1", arrayList112);
//			intent.putExtra("user2", arrayList113);
//			intent.putExtra("user3", arrayList114);
			
			startActivity(intent);
			finish();
			 Toast.makeText(Plot.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
			}
		});
	    
		//返回到前一个界面
		plot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
			    arrayList=new ArrayList<String>();
				arrayList.add(show5.getText().toString());
				arrayList.add(show6.getText().toString());
				arrayList.add(show.getText().toString());
				arrayList.add(show1.getText().toString());
				arrayList.add(show2.getText().toString());
				arrayList.add(show3.getText().toString());
				arrayList.add(show4.getText().toString());
				
				Intent intent=new Intent(Plot.this,Content.class);
				intent.putExtra("key4", "1");
				intent.putExtra("five", arrayList);
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
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
		
		//返回到前一个界面
				back.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO 自动生成的方法存根
						
					    arrayList=new ArrayList<String>();
						arrayList.add(show5.getText().toString());
						arrayList.add(show6.getText().toString());
						arrayList.add(show.getText().toString());
						arrayList.add(show1.getText().toString());
						arrayList.add(show2.getText().toString());
						arrayList.add(show3.getText().toString());
						arrayList.add(show4.getText().toString());
						
						Intent intent=new Intent(Plot.this,Content.class);
						intent.putExtra("key4", "1");
						intent.putExtra("five", arrayList);
						intent.putExtra("one", arrayList2);
		   				intent.putExtra("two", arrayList3);
		   				intent.putExtra("three", arrayList4);
		   				intent.putExtra("four", arrayList5);
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
		
		//显示保存值
		 arrayList6=new ArrayList<String>();
		 arrayList6=getIntent().getStringArrayListExtra("five");	
	     System.out.println("出图阶段的接受值"+arrayList6);
		str=new String();str1=new String();str2=new String();str3=new String();str4=new String();
		str5=new String();str6=new String();str7=new String();str8=new String();str9=new String();
		if(arrayList6!=null){
			str=arrayList6.get(0);      show5.setText(str);
			str1=arrayList6.get(1);     show6.setText(str1);
			str2=arrayList6.get(2);     show.setText(str2);
			str3=arrayList6.get(3);     show1.setText(str3);
			str4=arrayList6.get(4);     show2.setText(str4);
			str5=arrayList6.get(5);     show3.setText(str5);
			str6=arrayList6.get(6);     show4.setText(str6);
			
		}
		
		
		//增加信息
		design.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Plot.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
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
					    	   Toast.makeText(Plot.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Plot.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Plot.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Plot.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
		
		//开始时间
		start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectDialog(Plot.this, "区域选择", category1, category2,category3);
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
	                wheelRight.setAdapter(new ArrayWheelAdapter<String>(right[newValue]));
	                wheelRight.setCurrentItem(right[newValue].length );
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
	                show5.setText(vLeft + "-" + vRight+"-" +vLast);
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
	                showSelectDialog1(Plot.this, "工程时间", category1, category2,category3);
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
	        wheelLeft.setCyclic(false);
	        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(left));
	        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
	        paramsLeft.gravity = Gravity.LEFT;
	        
	        
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
	                show6.setText(vLeft + "-" + vRight+"-" +vLast);
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
		
		//增加信息
		   choose.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 自动生成的方法存根
					
					View view = getLayoutInflater().inflate(R.layout.activity__message,null);
					final AlertDialog builder=new AlertDialog.Builder(Plot.this).create();
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
						AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
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
						    	   Toast.makeText(Plot.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
						       }
							
							//添加姓名
						       String one=name.getText().toString(); int four=name.getText().length();
							if(one.equals("")){
						          Toast.makeText(Plot.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
							}else if(four>4){
								Toast.makeText(Plot.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
							}
							
							//判断输入的值是否符合保存的要求
							if(!two.equals("")&&!one.equals("")&&four<5){
								if(arrayList111.size()>10){
									Toast.makeText(Plot.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
									
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
					final AlertDialog builder=new AlertDialog.Builder(Plot.this).create();
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
						AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
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
						    	   Toast.makeText(Plot.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
						       }
							
							//添加姓名
						       String one=name.getText().toString(); int four=name.getText().length();
							if(one.equals("")){
						          Toast.makeText(Plot.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
							}else if(four>4){
								Toast.makeText(Plot.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
							}
							
							//判断输入的值是否符合保存的要求
							//判断输入的值是否符合保存的要求
							if(!two.equals("")&&!one.equals("")&&four<5){
								if(arrayList112.size()>10){
									Toast.makeText(Plot.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
									
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
					final AlertDialog builder=new AlertDialog.Builder(Plot.this).create();
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
						AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
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
						    	   Toast.makeText(Plot.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
						       }
							
							//添加姓名
						       String one=name.getText().toString(); int four=name.getText().length();
							if(one.equals("")){
						          Toast.makeText(Plot.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
							}else if(four>4){
								Toast.makeText(Plot.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
							}
							
							//判断输入的值是否符合保存的要求
							//判断输入的值是否符合保存的要求
							if(!two.equals("")&&!one.equals("")&&four<5){
								if(arrayList113.size()>10){
									Toast.makeText(Plot.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
									
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
					final AlertDialog builder=new AlertDialog.Builder(Plot.this).create();
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
						AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
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
						    	   Toast.makeText(Plot.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
						       }
							
							//添加姓名
						       String one=name.getText().toString(); int four=name.getText().length();
							if(one.equals("")){
						          Toast.makeText(Plot.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
							}else if(four>4){
								Toast.makeText(Plot.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
							}
							
							//判断输入的值是否符合保存的要求
							//判断输入的值是否符合保存的要求
							if(!two.equals("")&&!one.equals("")&&four<5){
								if(arrayList114.size()>10){
									Toast.makeText(Plot.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
									
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
	
		   
		   
		   //电梯
		   elevator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
				builder.setItems(sringStrings,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<sringStrings.length;i++){
								if(i==arg1){
						
						         //显示电梯
				                  show.setText(sringStrings[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
		   //显示空调
		   condition.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
				builder.setItems(sringStrings,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<sringStrings.length;i++){
								if(i==arg1){
						
						         //显示电梯
				                  show1.setText(sringStrings[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
		   //供暖方式
		   heating.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
				builder.setItems(sringStrings,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<sringStrings.length;i++){
								if(i==arg1){
						
						         //显示供暖方式
				                  show2.setText(sringStrings[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
		   //外墙材料
		   material.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
				builder.setItems(sringStrings,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<sringStrings.length;i++){
								if(i==arg1){
						
				                  show3.setText(sringStrings[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
		   //钢结构
		   structure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				AlertDialog.Builder builder=new AlertDialog.Builder(Plot.this);
				builder.setItems(sringStrings,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
					
							for(int i=0;i<sringStrings.length;i++){
								if(i==arg1){
						
				                  show4.setText(sringStrings[arg1]);	
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
				Intent intent=new Intent(Plot.this,Content.class);
				intent.putExtra("key4", "1");
				intent.putExtra("five", arrayList);
				intent.putExtra("one", arrayList2);
   				intent.putExtra("two", arrayList3);
   				intent.putExtra("three", arrayList4);
   				intent.putExtra("four", arrayList5);
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