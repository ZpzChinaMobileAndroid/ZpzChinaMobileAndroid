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
	
	String[] str={"�б�","����ʩ��","ʩ�����"};
	String[] str1={"��װ��","��ȫװ��","����װ��","��װ��"};
	 ArrayList<String> arrayList,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	 String string,password,username;
	 ArrayList<String >cellphone,company,department,province,district;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__fitment);
		
		
		TextView fitment=(TextView) findViewById(id.jump);//���ص�֮ǰ����
		ImageView save=(ImageView) findViewById(id.imageView3);//������Ŀ
    	ImageView back=(ImageView) findViewById(id.back);//���ؽ���
    	TextView current=(TextView) findViewById(id.current);//���㰲װ
    	TextView condition=(TextView) findViewById(id.condition);//װ�����
    	TextView schedule=(TextView) findViewById(id.schedule);//װ�޽���
    	final TextView show=(TextView) findViewById(id.show);//��ʾ����
    	final TextView shower=(TextView) findViewById(id.shower);//���
    	final TextView showers=(TextView) findViewById(id.showers);//����
    	ImageView camera=(ImageView) findViewById(id.camera);//���
		
    	  //��ת�ҵ�ֵ
  	  //��ת�ҵ�ֵ
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
       
        //���մ�������tokenֵ
        string=getIntent().getStringExtra("token");
     	System.out.println("װ�޽�����յ���tokenֵ"+string);
        //���մ������ĵ�¼��
        username=getIntent().getStringExtra("name");
        System.out.println("װ�޽����յ����û���"+username);
      	//���մ������ĵ�¼����
      	password=getIntent().getStringExtra("password");
      	System.out.println("װ�޽����յ��ĵ�¼����"+password);
        //���մ��������ֻ���
     	 cellphone=getIntent().getStringArrayListExtra("cellphone");
     	 System.out.println("װ�޽����յ����ֻ���"+cellphone);
   	     //���մ�������������λ
   	    company=getIntent().getStringArrayListExtra("company");
   	    System.out.println("װ�޽����յ���������λ"+company);
     	 //���մ�������ְ��
     	 department=getIntent().getStringArrayListExtra("department");
     	 System.out.println("װ�޽����յ���ְ��"+department);
     	 //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
     
        	 
        //���浽����
 	   save.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View arg0) {
 			// TODO �Զ����ɵķ������
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
 		 Toast.makeText(Fitment.this, "���浽���سɹ�", Toast.LENGTH_SHORT).show();
 		}
 	});
    
    	//�����
      	 camera.setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View arg0) {
      				// TODO �Զ����ɵķ������
      				
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
      	    
      	//���ص�֮ǰ����
      	fitment.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO �Զ����ɵķ������
    				
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
      //���ص�֮ǰ����
      	back.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO �Զ����ɵķ������
    				
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
      	//���㰲װ
      	current.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO �Զ����ɵķ������
   				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
   				builder.setItems(str,new AlertDialog.OnClickListener() {
   					
   					@Override
   					public void onClick(DialogInterface arg0, int arg1) {
   						// TODO �Զ����ɵķ������
   					
   							for(int i=0;i<str.length;i++){
   								if(i==arg1){
   						
   						         //��ʾ���㰲װ
   				                  show.setText(str[arg1]);	
   				                  arg0.dismiss();
   								}
   							}
   					}
   				});
   				builder.show();
   			}
   		});
       	
       
   	//װ�����
      	condition.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO �Զ����ɵķ������
   				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
   				builder.setItems(str1, new AlertDialog.OnClickListener() {
   					@Override
   					public void onClick(DialogInterface arg0, int arg1) {
   						// TODO �Զ����ɵķ������
   					
   							for(int i=0;i<str1.length;i++){
   								if(i==arg1){
   						
   						         //��ʾװ�����
   				                  shower.setText(str1[arg1]);	
   				                  arg0.dismiss();
   								}
   							}
   					}
   				});
   				builder.show();
   			}
   		});
      
		
	//װ�޽���
      	schedule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder=new AlertDialog.Builder(Fitment.this);
				builder.setItems(str,new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO �Զ����ɵķ������
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //��ʾװ�޽���
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
    
	//���÷��ؼ�
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