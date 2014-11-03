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
	
	String[] str={"�б�","����ʩ��","ʩ�����"};
	String string,password,username;
	ArrayList<String> arrayList;
	ArrayList<String >cellphone,company,department,province,district;
	ArrayList<String> arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__afforest);
		
		TextView afforest=(TextView) findViewById(id.jump);//���ص�֮ǰ����
		ImageView  back=(ImageView) findViewById(id.back);//���ص�֮ǰ����
		ImageView save=(ImageView) findViewById(id.save);//���浽����
    	TextView control=(TextView) findViewById(id.control);//����
    	TextView landscape=(TextView) findViewById(id.landscape);//�����̻�
    	final TextView show=(TextView) findViewById(id.show);//��ʾ�����׶�
    	final TextView shower=(TextView) findViewById(id.shower);//��ʾ�����̻��׶�
    	ImageView camera=(ImageView) findViewById(id.camera);//�����
    	
    	 //���մ�������tokenֵ
   	    string=getIntent().getStringExtra("token");
   	    System.out.println("�����̻�������յ���tokenֵ"+string);
        //���մ������ĵ�¼��
   	    username=getIntent().getStringExtra("name");
   	    System.out.println("�����̻������յ����û���"+username);
   	    //���մ������ĵ�¼����
   	    password=getIntent().getStringExtra("password");
   	    System.out.println("�����̻������յ��ĵ�¼����"+password);
   	    //���մ��������ֻ���
   	    cellphone=getIntent().getStringArrayListExtra("cellphone");
   	     System.out.println("�����̻������յ����ֻ���"+cellphone);
   	    //���մ�������������λ
   	     company=getIntent().getStringArrayListExtra("company");
   	     System.out.println("�����̻������յ���������λ"+company);
   	    //���մ�������ְ��
   	     department=getIntent().getStringArrayListExtra("department");
   	     System.out.println("�����̻������յ���ְ��"+department);
   	    //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
    	
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
        arrayList11=new ArrayList<String>();
        arrayList11=getIntent().getStringArrayListExtra("ten");	
        
    	
    	//���ص�֮ǰ����
   	    afforest.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO �Զ����ɵķ������
   				
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
   	    
   	    //���浽��Ŀ������
   	 save.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View arg0) {
 			// TODO �Զ����ɵķ������
 			
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
 		 Toast.makeText(Afforest.this, "���浽���سɹ�", Toast.LENGTH_SHORT).show();
 		}
 	});
   	    
   	//���ص�֮ǰ����
   	    back.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO �Զ����ɵķ������
   				
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
     
   	//�����
   	 camera.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO �Զ����ɵķ������
   				
   				 Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
   				 startActivityForResult(intent, 1);
   				 ImageView	 im=new ImageView(Afforest.this);
   				 setContentView(im);
   			}
   		});
   	    
   	//�����׶�
   	 control.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder=new AlertDialog.Builder(Afforest.this);
				builder.setItems(str, new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO �Զ����ɵķ������
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //��ʾ�Ƿ����
				                  show.setText(str[arg1]);	
				                  arg0.dismiss();
								}
							}
					}
				});
				builder.show();
			}
		});
    	
    
	//�����̻��׶�
   	landscape.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder=new AlertDialog.Builder(Afforest.this);
				builder.setItems(str, new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO �Զ����ɵķ������
					
							for(int i=0;i<str.length;i++){
								if(i==arg1){
						
						         //��ʾ�Ƿ����
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
   
    
	//���÷��ؼ�
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