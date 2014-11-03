package com.example.message;




import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.allproject.Allproject;
import com.example.message.R.id;
import com.example.myself.Issue;
import com.example.myself.Myself;
import com.example.sqlite.Information;
import com.example.sqlite.Mysqlite;
import com.example.sqlite.Sqlite;
import com.guozg.wheelview.views.ArrayWheelAdapter;
import com.guozg.wheelview.views.OnWheelChangedListener;
import com.guozg.wheelview.views.WheelView;
import com.slidingmenu.lib.SlidingMenu;

public class Project extends Activity {
	
	private	EditText plot;
	private	EditText address;
	private	EditText area;
	private	EditText volume;
	private	ImageView back,camera,choose,showphoto;
	private	TextView purpose,bidders,jump,region,show,shower,nameone,nametwo,namethree;
	private EditText name , phone, company , addressimage;
	private	 TextView  station,showsss,show11;
	private ImageView saveimage;
	private	ImageView saveimaImageView;
    public final static int TAKE_PHOTO = 1;
    String content;
    public final static int PHOTO_RESULT = 2;
	public static final String IMAGE_UNSPECIFIED = "image/*";
	private String imageDir;
	String string,password,username;
	private ImageView avatar;
	public final static int PHOTO_ZOOM = 0;
	ArrayList<String>arrayList=new ArrayList<String>();
	ArrayList<String >cellphone,company2,department,district,province;
	ArrayList<String>arrayList111,arrayList112,arrayList113,arrayList114;
	String str1,str2,str3,str4,str5,str6,str7,str8;
	String [] str={"工业","酒店以餐饮","商务办公","住宅/经济适用房","公共事业设施","其他"};
	String[] strings={"项目负责人"};
	GridView gird;
	boolean bo = true;
	static List<Bitmap> list = new LinkedList<Bitmap>();
	SlidingMenu menu ;
	MyAdpter myAdpter=new MyAdpter();
	
	
	
	 ArrayList<String> arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__project);
	
		 plot=(EditText) findViewById(R.id.plot); //土地名称
		 address=(EditText) findViewById(R.id.address);//地块地址
		 area=(EditText) findViewById(R.id.area);//土地面积
		 volume=(EditText) findViewById(R.id.volume);//土地容积率
		 back=(ImageView) findViewById(R.id.back);//返回到主界面
		 purpose=(TextView) findViewById(R.id.purpose);//土地用途
		 region=(TextView) findViewById(R.id.region);//所在区域
		 choose=(ImageView) findViewById(R.id.choosee);//增加用户信息
		 bidders=(TextView) findViewById(id.bidders);//拍卖单位
		 jump=(TextView) findViewById(id.jump);//跳转到所有选项
		 show=(TextView) findViewById(id.show);//显示区域区域
		 show11=(TextView) findViewById(id.show11);//显示区域城市
		 shower=(TextView) findViewById(id.shower);//显示所选择的内容
		 nameone=(TextView) findViewById(id.nameone);//显示名字
		 nametwo=(TextView) findViewById(id.nametwo);//显示名字2
		 namethree=(TextView) findViewById(id.namethree);//显示名字3
		 ImageView save=(ImageView) findViewById(id.imageView3);//保存项目
		 gird = (GridView) findViewById(R.id.gridView1);
		 gird.setAdapter(myAdpter);
		
		 
		 
		//设置对话框的边框
		 plot.setBackgroundDrawable(null);
		 address.setBackgroundDrawable(null);
		 area.setBackgroundDrawable(null);
		 volume.setBackgroundDrawable(null);
		 
		 //接收传过来的token值
		 string=getIntent().getStringExtra("token");
		 System.out.println("土地规划接收到的token值"+string);
		 //接收传过来的登录名
		 username=getIntent().getStringExtra("name");
		 System.out.println("土地规划接收到的用户名"+username);
		 //接收传过来的登录密码
		 password=getIntent().getStringExtra("password");
		 System.out.println("土地规划接收到的登录密码"+password);
		 //接收传过来的手机号
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("土地规划接收到的手机号"+cellphone);
		 //接收传过来的所属单位
		 company2=getIntent().getStringArrayListExtra("company");
		 System.out.println("土地规划接收到的所属单位"+company);
		 //接收传过来的职务
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("土地规划接收到的职务"+department);
		 //接收传过来的区域
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("土地规划接收到的职务"+district);
		 //接收传过来的城市
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("土地规划接收到的职务"+province);
		 
		 //显示区域城市
		 if(district!=null&&province!=null){
			 String ss=district.get(0);  String sss=province.get(0);
			 System.out.println("sss"+ss);  System.out.println("ddd"+sss);
			 show.setText(ss);    show11.setText(sss);
		 }
	
		 
			
		 
		 //生成表的操作
		 Mysqlite mysqlite=new Mysqlite(Project.this);
	     mysqlite.getWritableDatabase();
	 	//设置保存的应用
			arrayList111=new ArrayList<String>();//这个用来存第一次的值
			arrayList112=new ArrayList<String>();//这个用来存的第一个修改的值
			arrayList113=new ArrayList<String>();//这个用来存的第二个修改的值
			arrayList114=new ArrayList<String>();//这个用来存的第三个修改的值
		  //中转我的值
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
	     //接受值
	     ArrayList<String>stringssArrayList=getIntent().getStringArrayListExtra("one");
	     System.out.println("看看传回来是什么"+stringssArrayList);
	     //截取值并赋值
	     str1=new String(); str2=new String(); str3=new String(); str4=new String(); str5=new String();
	     str6=new String(); str7=new String(); str8=new String(); 
	     
	     if(stringssArrayList!=null){
		     str1=stringssArrayList.get(0);     plot.setText(str1);
		     str2=stringssArrayList.get(1);     show.setText(str2);
		     str3=stringssArrayList.get(2);     address.setText(str3);
		     str4=stringssArrayList.get(3);     area.setText(str4);
		     str5=stringssArrayList.get(4);     volume.setText(str5);
		     str6=stringssArrayList.get(5);     shower.setText(str6);
		  //   str7=stringssArrayList.get(6);
		  //   str8=stringssArrayList.get(7);
	     }

	     
     //保存到本地
	   save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			  
		Intent intent=new Intent(Project.this,Myself.class);
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
		intent.putExtra("company", company2);
		intent.putExtra("department", department);
		intent.putExtra("district", district);
		intent.putExtra("province", province);
		intent.putExtra("user", arrayList111);
		intent.putExtra("user1", arrayList112);
		intent.putExtra("user2", arrayList113);
		intent.putExtra("user3", arrayList114);
		
		startActivity(intent);
		finish();
		 Toast.makeText(Project.this, "保存到本地成功", Toast.LENGTH_SHORT).show();
		}
	});
	   
	   
	    //跳转选项
			 jump.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 自动生成的方法存根
					
							// TODO 自动生成的方法存根
					   
					//保存界面的值
					arrayList.add(plot.getText().toString());
					arrayList.add(show.getText().toString());
					arrayList.add(address.getText().toString());
					arrayList.add(area.getText().toString());
					arrayList.add(volume.getText().toString());
					arrayList.add(shower.getText().toString());
					
					System.out.println("数据"+arrayList.toString());
					
					Intent intent=new Intent(Project.this,Content.class);
					intent.putExtra("key", "1");
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
					intent.putExtra("user", arrayList111);
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

         
		
		//增加用户信息
		bidders.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
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
					    	   Toast.makeText(Project.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Project.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Project.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Project.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
	
		
		
		
		
		//增加用户信息
		choose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
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
					AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
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
					    	   Toast.makeText(Project.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
					       }
						
						//添加姓名
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Project.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Project.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
						}
						
						//判断输入的值是否符合保存的要求
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Project.this, "名额已满，请选择修改其他用户", Toast.LENGTH_SHORT).show();
								
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
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
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
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
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
							    	   Toast.makeText(Project.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
							       }
								
								//添加姓名
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
								}
								
								//判断输入的值是否符合保存的要求
								//判断输入的值是否符合保存的要求
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList112.size()>10){
										Toast.makeText(Project.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
										
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
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
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
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
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
							    	   Toast.makeText(Project.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
							       }
								
								//添加姓名
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
								}
								
								//判断输入的值是否符合保存的要求
								//判断输入的值是否符合保存的要求
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList113.size()>10){
										Toast.makeText(Project.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
										
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
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
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
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
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
							    	   Toast.makeText(Project.this, "电话号码不能为空，请输入", Toast.LENGTH_SHORT).show();
							       }
								
								//添加姓名
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "姓名不能为空，请输入", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "姓名长度最长为4位，请重新输入", Toast.LENGTH_SHORT).show();
								}
								
								//判断输入的值是否符合保存的要求
								//判断输入的值是否符合保存的要求
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList114.size()>10){
										Toast.makeText(Project.this, "最多只能修改三次，请选择修改其他用户", Toast.LENGTH_SHORT).show();
										
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
		
				
				
		 //地块用途（多选择对话框）
		 purpose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			final boolean[]	checkedItems =new boolean[]{false,false,false,false,false,false};
			
			AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
			AlertDialog.Builder builder2=new AlertDialog.Builder(Project.this);
			builder2.setTitle("用途");
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
				if(result.equals("")){
					shower.setText(null);
				}	
					content=result.substring(0,result.length());
						shower.setText(content);     //显示所选择的内容
					
				}
			});
			builder2.setNegativeButton("取消", null);
			builder2.show();
				
			}
		});
		 
		 //返回设置
		 back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				//保存界面的值
				arrayList.add(plot.getText().toString());
				arrayList.add(show.getText().toString());
				arrayList.add(address.getText().toString());
				arrayList.add(area.getText().toString());
				arrayList.add(volume.getText().toString());
				arrayList.add(shower.getText().toString());
				
				System.out.println("数据"+arrayList.toString());
				
				Intent intent=new Intent(Project.this,Content.class);
				intent.putExtra("key", "1");
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
				intent.putExtra("company", company2);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				startActivity(intent);
				overridePendingTransition(R.anim.onout,R.anim.inout);
				finish();
				
			}
		});
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
	
    		//保存界面的值
			arrayList.add(plot.getText().toString());
			arrayList.add(show.getText().toString());
			arrayList.add(address.getText().toString());
			arrayList.add(area.getText().toString());
			arrayList.add(volume.getText().toString());
			arrayList.add(shower.getText().toString());
			
			System.out.println("数据"+arrayList.toString());
			
			Intent intent=new Intent(Project.this,Content.class);
			intent.putExtra("key", "1");
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
			intent.putExtra("company", company2);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			startActivity(intent);
			overridePendingTransition(R.anim.onout,R.anim.inout);
			finish();
      }
  }