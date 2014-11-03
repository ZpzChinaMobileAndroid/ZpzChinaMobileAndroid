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
	ArrayList<String >cellphone,company,department,province,district;
	String str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__content);
	
		//�������е�ֵ�����д���
	   final ArrayList<String> string1=getIntent().getStringArrayListExtra("one");
	   System.out.println("���ع滮���յ�ֵ"+string1);
	   final ArrayList<String> string2=getIntent().getStringArrayListExtra("two");
	   System.out.println("��Ŀ������յ�ֵ"+string2);
	   final ArrayList<String> string3=getIntent().getStringArrayListExtra("three");
	   System.out.println("�ؿ��׶ν��յ�ֵ"+string3);
	   final ArrayList<String> string4=getIntent().getStringArrayListExtra("four");
	   System.out.println("��ƽ׶ν��յ�ֵ"+string4);
	   final ArrayList<String> string5=getIntent().getStringArrayListExtra("five");
	   System.out.println("��ͼ�׶ν��յ�ֵ"+string5);
	   final ArrayList<String> string6=getIntent().getStringArrayListExtra("six");
	   System.out.println("��ƽ�׶ν��յ�ֵ"+string6);
	   final ArrayList<String> string7=getIntent().getStringArrayListExtra("senven");
	   System.out.println("׮�����ӽ��յ�ֵ"+string7);
	   final ArrayList<String> string8=getIntent().getStringArrayListExtra("six");
	   System.out.println("����ʩ�����յ�ֵ"+string8);
	   final ArrayList<String> string9=getIntent().getStringArrayListExtra("nine");
	   System.out.println("�����̻����յ�ֵ"+string9);
	   final ArrayList<String> string10=getIntent().getStringArrayListExtra("ten");
	   System.out.println("װ�޽׶ν��յ�ֵ"+string10);

	     //���մ�������tokenֵ
		 string=getIntent().getStringExtra("token");
		 System.out.println("������յ���tokenֵ"+string);
		 //���մ������ĵ�¼��
		 username=getIntent().getStringExtra("name");
		 System.out.println("�����յ����û���"+username);
		 //���մ������ĵ�¼����
		 password=getIntent().getStringExtra("password");
		 System.out.println("�����յ��ĵ�¼����"+password);
		 //���մ��������ֻ���
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("�����յ����ֻ���"+cellphone);
		 //���մ�������������λ
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("�����յ���������λ"+company);
		 //���մ�������ְ��
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("�����յ���ְ��"+department);
		 //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
		 
		 
		 
		auction=(TextView) findViewById(id.auction);//���ع滮/����
		approve=(TextView) findViewById(id.approve);//��Ŀ����
		plan=(TextView) findViewById(id.plan);//�ؿ��׶�
		design=(TextView) findViewById(id.design);//��ƽ׶�
		save=(ImageView) findViewById(R.id.imageView3);//������Ŀ
		back=(ImageView) findViewById(id.back);//���ػ�ȥ
		plot=(TextView) findViewById(id.plot);//��ͼ�׶�
		horizon =(TextView) findViewById(id.horizon);//��ƽ
		foundation =(TextView) findViewById(id.foundation);//׮������
		construct =(TextView) findViewById(id.construct);//����ʩ��
		afforest=(TextView) findViewById(id.afforest);//����/�����̻�
		fitment=(TextView) findViewById(id.fitment);//װ�޽׶�
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
		
		//���ع滮/���� 
		auction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
		
		//��Ŀ����
		approve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			}
		});
		
		
		//�ؿ��׶�
		plan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//��ƽ׶�
		design.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//��ͼ�׶�
		plot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//��ƽ
		horizon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//׮������
		foundation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//����ʩ��
		construct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//����/�����̻�
		afforest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		
		//װ�޽׶�
		fitment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				
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
				startActivity(intent);
				finish();	
				overridePendingTransition(R.anim.onout,R.anim.inout);
			
			}
		});
		
		//���ص�������
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent(Content.this,Homepage.class);
		        intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				startActivity(intent);
				finish();	
			}
		});
    }
	
	
	//���÷��ؼ�
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
		startActivity(intent);
		finish();	
	}
	
	// ���ò˵���
		@Override
		public boolean onCreateOptionsMenu(Menu arg0) {
			// TODO Auto-generated method stub
			arg0.add(0, 2, 3, "������").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {
						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
							AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
						    builder.setIcon(R.drawable.icon48);
						    builder.setTitle("��ʾ");
						    builder.setMessage("�Ƿ���������½�����Ŀ");
					     	builder.setPositiveButton("ȷ��",  new AlertDialog. OnClickListener() {
						     @Override
					    	 public void onClick(DialogInterface arg0, int arg1) {
						    // TODO �Զ����ɵķ������
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
					       builder.setNegativeButton("ȡ��", null);
					       builder.show();
						             return false;
				}
			});
			arg0.add(0,0, 1, "�鿴ȫ������").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
			AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
		    builder.setIcon(R.drawable.icon48);
		    builder.setTitle("��ʾ");
		    builder.setMessage("�Ƿ���������½�����Ŀ");
	     	builder.setPositiveButton("ȷ��",  new AlertDialog. OnClickListener() {
		     @Override
	    	 public void onClick(DialogInterface arg0, int arg1) {
		    // TODO �Զ����ɵķ������
			 finish();
	}
	});
	       builder.setNegativeButton("ȡ��", null);
	       builder.show();
		             return false;
						}
					});
			
			arg0.add(0, 3, 4, "�˳�����").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

	 	@Override
			public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
		  AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
	      builder.setIcon(R.drawable.icon48);
	      builder.setTitle("��ʾ");
	      builder.setMessage("�Ƿ��˳�");
	      builder.setPositiveButton("ȷ��",  new AlertDialog. OnClickListener() {
									
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
			finish();
			}
		});
	      builder.setNegativeButton("ȡ��", null);
		    builder.show();
		return false;
						}
					});
			
			arg0.add(0,1, 2, "�鿴��������").setOnMenuItemClickListener(
					new OnMenuItemClickListener() {

						@Override
						public boolean onMenuItemClick(MenuItem item) {
							// TODO Auto-generated method stub
         AlertDialog.Builder builder=new AlertDialog.Builder(Content.this);
	     builder.setIcon(R.drawable.icon48);
	     builder.setTitle("��ʾ");
		 builder.setMessage("�Ƿ���������½�����Ŀ");
         builder.setPositiveButton("ȷ��",  new AlertDialog. OnClickListener() {
		@Override
	     public void onClick(DialogInterface arg0, int arg1) {
			// TODO �Զ����ɵķ������
			Intent intent=new Intent(Content.this,Myself.class);
			startActivity(intent);
			finish();
		}
		});
	     builder.setNegativeButton("ȡ��", null);
		 builder.show();
		   return false;
						}
					});
			
			return super.onCreateOptionsMenu(arg0);
		}
	}