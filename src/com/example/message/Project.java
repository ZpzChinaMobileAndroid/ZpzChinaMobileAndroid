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
	String [] str={"��ҵ","�Ƶ��Բ���","����칫","סլ/�������÷�","������ҵ��ʩ","����"};
	String[] strings={"��Ŀ������"};
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
	
		 plot=(EditText) findViewById(R.id.plot); //��������
		 address=(EditText) findViewById(R.id.address);//�ؿ��ַ
		 area=(EditText) findViewById(R.id.area);//�������
		 volume=(EditText) findViewById(R.id.volume);//�����ݻ���
		 back=(ImageView) findViewById(R.id.back);//���ص�������
		 purpose=(TextView) findViewById(R.id.purpose);//������;
		 region=(TextView) findViewById(R.id.region);//��������
		 choose=(ImageView) findViewById(R.id.choosee);//�����û���Ϣ
		 bidders=(TextView) findViewById(id.bidders);//������λ
		 jump=(TextView) findViewById(id.jump);//��ת������ѡ��
		 show=(TextView) findViewById(id.show);//��ʾ��������
		 show11=(TextView) findViewById(id.show11);//��ʾ�������
		 shower=(TextView) findViewById(id.shower);//��ʾ��ѡ�������
		 nameone=(TextView) findViewById(id.nameone);//��ʾ����
		 nametwo=(TextView) findViewById(id.nametwo);//��ʾ����2
		 namethree=(TextView) findViewById(id.namethree);//��ʾ����3
		 ImageView save=(ImageView) findViewById(id.imageView3);//������Ŀ
		 gird = (GridView) findViewById(R.id.gridView1);
		 gird.setAdapter(myAdpter);
		
		 
		 
		//���öԻ���ı߿�
		 plot.setBackgroundDrawable(null);
		 address.setBackgroundDrawable(null);
		 area.setBackgroundDrawable(null);
		 volume.setBackgroundDrawable(null);
		 
		 //���մ�������tokenֵ
		 string=getIntent().getStringExtra("token");
		 System.out.println("���ع滮���յ���tokenֵ"+string);
		 //���մ������ĵ�¼��
		 username=getIntent().getStringExtra("name");
		 System.out.println("���ع滮���յ����û���"+username);
		 //���մ������ĵ�¼����
		 password=getIntent().getStringExtra("password");
		 System.out.println("���ع滮���յ��ĵ�¼����"+password);
		 //���մ��������ֻ���
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("���ع滮���յ����ֻ���"+cellphone);
		 //���մ�������������λ
		 company2=getIntent().getStringArrayListExtra("company");
		 System.out.println("���ع滮���յ���������λ"+company);
		 //���մ�������ְ��
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("���ع滮���յ���ְ��"+department);
		 //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
		 
		 //��ʾ�������
		 if(district!=null&&province!=null){
			 String ss=district.get(0);  String sss=province.get(0);
			 System.out.println("sss"+ss);  System.out.println("ddd"+sss);
			 show.setText(ss);    show11.setText(sss);
		 }
	
		 
			
		 
		 //���ɱ�Ĳ���
		 Mysqlite mysqlite=new Mysqlite(Project.this);
	     mysqlite.getWritableDatabase();
	 	//���ñ����Ӧ��
			arrayList111=new ArrayList<String>();//����������һ�ε�ֵ
			arrayList112=new ArrayList<String>();//���������ĵ�һ���޸ĵ�ֵ
			arrayList113=new ArrayList<String>();//���������ĵڶ����޸ĵ�ֵ
			arrayList114=new ArrayList<String>();//���������ĵ������޸ĵ�ֵ
		  //��ת�ҵ�ֵ
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
	     //����ֵ
	     ArrayList<String>stringssArrayList=getIntent().getStringArrayListExtra("one");
	     System.out.println("������������ʲô"+stringssArrayList);
	     //��ȡֵ����ֵ
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

	     
     //���浽����
	   save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO �Զ����ɵķ������
			  
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
		 Toast.makeText(Project.this, "���浽���سɹ�", Toast.LENGTH_SHORT).show();
		}
	});
	   
	   
	    //��תѡ��
			 jump.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO �Զ����ɵķ������
					
							// TODO �Զ����ɵķ������
					   
					//��������ֵ
					arrayList.add(plot.getText().toString());
					arrayList.add(show.getText().toString());
					arrayList.add(address.getText().toString());
					arrayList.add(area.getText().toString());
					arrayList.add(volume.getText().toString());
					arrayList.add(shower.getText().toString());
					
					System.out.println("����"+arrayList.toString());
					
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

         
		
		//�����û���Ϣ
		bidders.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//�������
				phone=(EditText)view.findViewById(id.phone);//��ӵ绰
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//��ʾ��λ
				company=(EditText)view.findViewById(id.company);//������λ
				addressimage=(EditText)view.findViewById(id.address);//������λ
				
				saveimage=(ImageView)view.findViewById(id.save);//����
				
				//��λ
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO �Զ����ɵķ������
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //��ʾ��λ����
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
				//����
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					
						
						//��ӵ绰
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Project.this, "�绰���벻��Ϊ�գ�������", Toast.LENGTH_SHORT).show();
					       }
						
						//�������
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Project.this, "��������Ϊ�գ�������", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Project.this, "���������Ϊ4λ������������", Toast.LENGTH_SHORT).show();
						}
						
						//�ж������ֵ�Ƿ���ϱ����Ҫ��
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Project.this, "������������ѡ���޸������û�", Toast.LENGTH_SHORT).show();
								
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
						System.out.println("���������"+arrayList111);
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
	
		
		
		
		
		//�����û���Ϣ
		choose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				View view = getLayoutInflater().inflate(R.layout.activity__message,null);
				final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
				builder.setView(view,0,0,0,0);
				name =(EditText)view.findViewById(id.name);//�������
				phone=(EditText)view.findViewById(id.phone);//��ӵ绰
				station=(TextView)view.findViewById(id.station);
				showsss=(TextView)view.findViewById(id.show);//��ʾ��λ
				company=(EditText)view.findViewById(id.company);//������λ
				addressimage=(EditText)view.findViewById(id.address);//������λ
				saveimage=(ImageView)view.findViewById(id.save);//����
				//��λ
				station.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
					builder.setItems(strings, new AlertDialog. OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO �Զ����ɵķ������
							for(int i=0;i<strings.length;i++){
								if(i==arg1){
						
						         //��ʾ��λ����
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
				//����
				saveimage.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					
						
						//��ӵ绰
						String two=phone.getText().toString();  int three=phone.getText().length();
						if(two.equals("")){
					    	   Toast.makeText(Project.this, "�绰���벻��Ϊ�գ�������", Toast.LENGTH_SHORT).show();
					       }
						
						//�������
					       String one=name.getText().toString(); int four=name.getText().length();
						if(one.equals("")){
					          Toast.makeText(Project.this, "��������Ϊ�գ�������", Toast.LENGTH_SHORT).show();
						}else if(four>4){
							Toast.makeText(Project.this, "���������Ϊ4λ������������", Toast.LENGTH_SHORT).show();
						}
						
						//�ж������ֵ�Ƿ���ϱ����Ҫ��
						if(!two.equals("")&&!one.equals("")&&four<5){
							if(arrayList111.size()>10){
								Toast.makeText(Project.this, "������������ѡ���޸������û�", Toast.LENGTH_SHORT).show();
								
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
						System.out.println("���������"+arrayList111);
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
		 
		 
		//�޸���λ��ϵ��  ��һλ
				nameone.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					
						View view = getLayoutInflater().inflate(R.layout.activity__message,null);
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
						builder.setView(view,0,0,0,0);
						name =(EditText)view.findViewById(id.name);//�������
						phone=(EditText)view.findViewById(id.phone);//��ӵ绰
						station=(TextView)view.findViewById(id.station);
						showsss=(TextView)view.findViewById(id.show);//��ʾ��λ
						company=(EditText)view.findViewById(id.company);//������λ
						addressimage=(EditText)view.findViewById(id.address);//������λ
						saveimage=(ImageView)view.findViewById(id.save);//����
						
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
					
						
						
						
						//��λ
						station.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
							builder.setItems(strings, new AlertDialog. OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									// TODO �Զ����ɵķ������
									for(int i=0;i<strings.length;i++){
										if(i==arg1){
								
								         //��ʾ��λ����
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
						//����
						saveimage.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							
								
								//��ӵ绰
								String two=phone.getText().toString();  int three=phone.getText().length();
								if(two.equals("")){
							    	   Toast.makeText(Project.this, "�绰���벻��Ϊ�գ�������", Toast.LENGTH_SHORT).show();
							       }
								
								//�������
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "��������Ϊ�գ�������", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "���������Ϊ4λ������������", Toast.LENGTH_SHORT).show();
								}
								
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList112.size()>10){
										Toast.makeText(Project.this, "���ֻ���޸����Σ���ѡ���޸������û�", Toast.LENGTH_SHORT).show();
										
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
								System.out.println("���������"+arrayList112);
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
			
				
				
				//�޸���λ��ϵ��  �ڶ�λ
				nametwo.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					
						View view = getLayoutInflater().inflate(R.layout.activity__message,null);
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
						builder.setView(view,0,0,0,0);
						name =(EditText)view.findViewById(id.name);//�������
						phone=(EditText)view.findViewById(id.phone);//��ӵ绰
						station=(TextView)view.findViewById(id.station);
						showsss=(TextView)view.findViewById(id.show);//��ʾ��λ
						company=(EditText)view.findViewById(id.company);//������λ
						addressimage=(EditText)view.findViewById(id.address);//������λ
						saveimage=(ImageView)view.findViewById(id.save);//����
						
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
					
						//��λ
						station.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
							builder.setItems(strings, new AlertDialog. OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									// TODO �Զ����ɵķ������
									for(int i=0;i<strings.length;i++){
										if(i==arg1){
								
								         //��ʾ��λ����
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
						//����
						saveimage.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							
								
								//��ӵ绰
								String two=phone.getText().toString();  int three=phone.getText().length();
								if(two.equals("")){
							    	   Toast.makeText(Project.this, "�绰���벻��Ϊ�գ�������", Toast.LENGTH_SHORT).show();
							       }
								
								//�������
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "��������Ϊ�գ�������", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "���������Ϊ4λ������������", Toast.LENGTH_SHORT).show();
								}
								
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList113.size()>10){
										Toast.makeText(Project.this, "���ֻ���޸����Σ���ѡ���޸������û�", Toast.LENGTH_SHORT).show();
										
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
								System.out.println("���������"+arrayList113);
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
				
		
		
				//�޸���λ��ϵ��  ����λ
				namethree.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
					
						View view = getLayoutInflater().inflate(R.layout.activity__message,null);
						final AlertDialog builder=new AlertDialog.Builder(Project.this).create();
						builder.setView(view,0,0,0,0);
						name =(EditText)view.findViewById(id.name);//�������
						phone=(EditText)view.findViewById(id.phone);//��ӵ绰
						station=(TextView)view.findViewById(id.station);
						showsss=(TextView)view.findViewById(id.show);//��ʾ��λ
						company=(EditText)view.findViewById(id.company);//������λ
						addressimage=(EditText)view.findViewById(id.address);//������λ
						saveimage=(ImageView)view.findViewById(id.save);//����
						
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
						
						//��λ
						station.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
							builder.setItems(strings, new AlertDialog. OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									// TODO �Զ����ɵķ������
									for(int i=0;i<strings.length;i++){
										if(i==arg1){
								
								         //��ʾ��λ����
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
						//����
						saveimage.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO �Զ����ɵķ������
							
								
								//��ӵ绰
								String two=phone.getText().toString();  int three=phone.getText().length();
								if(two.equals("")){
							    	   Toast.makeText(Project.this, "�绰���벻��Ϊ�գ�������", Toast.LENGTH_SHORT).show();
							       }
								
								//�������
							       String one=name.getText().toString(); int four=name.getText().length();
								if(one.equals("")){
							          Toast.makeText(Project.this, "��������Ϊ�գ�������", Toast.LENGTH_SHORT).show();
								}else if(four>4){
									Toast.makeText(Project.this, "���������Ϊ4λ������������", Toast.LENGTH_SHORT).show();
								}
								
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								//�ж������ֵ�Ƿ���ϱ����Ҫ��
								if(!two.equals("")&&!one.equals("")&&four<5){
									if(arrayList114.size()>10){
										Toast.makeText(Project.this, "���ֻ���޸����Σ���ѡ���޸������û�", Toast.LENGTH_SHORT).show();
										
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
								System.out.println("���������"+arrayList114);
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
		
				
				
		 //�ؿ���;����ѡ��Ի���
		 purpose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			final boolean[]	checkedItems =new boolean[]{false,false,false,false,false,false};
			
			AlertDialog.Builder builder=new AlertDialog.Builder(Project.this);
			AlertDialog.Builder builder2=new AlertDialog.Builder(Project.this);
			builder2.setTitle("��;");
			builder2.setMultiChoiceItems(str, checkedItems, new AlertDialog.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
					// TODO �Զ����ɵķ������
				checkedItems[arg1]=arg2;          //�ı䱻�����б��״̬
				}
			});
			builder2.setPositiveButton("ȷ��", new AlertDialog. OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO �Զ����ɵķ������

					String result="";          //���ڱ���ѡ����
					for(int i=0;i<checkedItems.length;i++){
						if(checkedItems[i]){
							result+=str[i]+"��";        //��ѡ��������ӵ�result��
						}
					}
					//�ж�һ��result��Ϊ�յ�ʱ�򣬽����õ��Ľ����ʾ����
				if(result.equals("")){
					shower.setText(null);
				}	
					content=result.substring(0,result.length());
						shower.setText(content);     //��ʾ��ѡ�������
					
				}
			});
			builder2.setNegativeButton("ȡ��", null);
			builder2.show();
				
			}
		});
		 
		 //��������
		 back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				//��������ֵ
				arrayList.add(plot.getText().toString());
				arrayList.add(show.getText().toString());
				arrayList.add(address.getText().toString());
				arrayList.add(area.getText().toString());
				arrayList.add(volume.getText().toString());
				arrayList.add(shower.getText().toString());
				
				System.out.println("����"+arrayList.toString());
				
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
	    

    //���÷��ؼ�
     @Override
    public void onBackPressed() {
	  // TODO Auto-generated method stub
	
    		//��������ֵ
			arrayList.add(plot.getText().toString());
			arrayList.add(show.getText().toString());
			arrayList.add(address.getText().toString());
			arrayList.add(area.getText().toString());
			arrayList.add(volume.getText().toString());
			arrayList.add(shower.getText().toString());
			
			System.out.println("����"+arrayList.toString());
			
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