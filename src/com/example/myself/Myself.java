package com.example.myself;

import java.util.ArrayList;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

import com.example.allproject.Allproject;
import com.example.message.Homepage;
import com.example.message.R;
import com.example.message.R.id;
import com.example.sqlite.Person;

public class Myself extends TabActivity{
	TabHost host;
	TabWidget widget;
	String string,username,password;
	ArrayList<String>arrayList,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
    ArrayList<String>arrayList111,arrayList112,arrayList113,arrayList114;
    ArrayList<String >cellphone,company,department;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity__myself);
		
		host = getTabHost();
	//	widget = host.getTabWidget();
		
		 //���մ�������tokenֵ
		 string=getIntent().getStringExtra("token");
		 System.out.println("������Ŀ������յ���tokenֵ"+string);
		 //���մ������ĵ�¼��
		 username=getIntent().getStringExtra("name");
		 System.out.println("������Ŀ�����յ����û���"+username);
		 //���մ������ĵ�¼����
		 password=getIntent().getStringExtra("password");
		 System.out.println("������Ŀ�����յ��ĵ�¼����"+password);
		 //���մ��������ֻ���
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("�������յ����ֻ���"+cellphone);
		 //���մ�������������λ
		 company=getIntent().getStringArrayListExtra("company");
		 System.out.println("�������յ���������λ"+company);
		 //���մ�������ְ��
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("�������յ���ְ��"+department);
		 
		 
		 
	        arrayList=new ArrayList<String>();
	        arrayList=getIntent().getStringArrayListExtra("one");	
	        arrayList1=new ArrayList<String>();
	        arrayList1=getIntent().getStringArrayListExtra("two");	
	        arrayList2=new ArrayList<String>();
	        arrayList2=getIntent().getStringArrayListExtra("three");	
	        arrayList3=new ArrayList<String>();
	        arrayList3=getIntent().getStringArrayListExtra("four");	
	        arrayList4=new ArrayList<String>();
	        arrayList4=getIntent().getStringArrayListExtra("five");	
	        arrayList5=new ArrayList<String>();
	        arrayList5=getIntent().getStringArrayListExtra("six");	
	        arrayList6=new ArrayList<String>();
	        arrayList6=getIntent().getStringArrayListExtra("seven");	
	        arrayList7=new ArrayList<String>();
	        arrayList7=getIntent().getStringArrayListExtra("eight");	
	        arrayList8=new ArrayList<String>();
	        arrayList8=getIntent().getStringArrayListExtra("nine");	
	        arrayList9=new ArrayList<String>();
	        arrayList9=getIntent().getStringArrayListExtra("ten");	
	        arrayList111=new ArrayList<String>();
	        arrayList111=getIntent().getStringArrayListExtra("user");	
	        arrayList112=new ArrayList<String>();
	        arrayList112=getIntent().getStringArrayListExtra("user1");	
	        arrayList113=new ArrayList<String>();
	        arrayList113=getIntent().getStringArrayListExtra("user2");	
	        arrayList114=new ArrayList<String>();
	        arrayList114=getIntent().getStringArrayListExtra("user3");	
		 
		 
		
		//����ʹ��TabHost���� ������
		LayoutInflater.from(this).inflate(R.layout.activity__myself, host.getTabContentView(),true);
		host.addTab(host.newTabSpec("tab1").setIndicator("�ҷ�������Ŀ").setContent(new Intent(Myself.this,Issue.class).putExtra("one", arrayList).putExtra("two", arrayList1).putExtra("three", arrayList2).putExtra("four", arrayList3).putExtra("five", arrayList4).putExtra("six", arrayList5).putExtra("seven", arrayList6).putExtra("eight", arrayList7).putExtra("nine", arrayList8).putExtra("ten", arrayList9).putExtra("name", username).putExtra("password", password).putExtra("token", string).putExtra("cellphone",cellphone).putExtra("company", company).putExtra("department", department)));
		host.addTab(host.newTabSpec("tab2").setIndicator("���ر�����Ŀ").setContent(new Intent(Myself.this,Preserve.class).putExtra("one", arrayList).putExtra("two", arrayList1).putExtra("three", arrayList2).putExtra("four", arrayList3).putExtra("five", arrayList4).putExtra("six", arrayList5).putExtra("seven", arrayList6).putExtra("eight", arrayList7).putExtra("nine", arrayList8).putExtra("ten", arrayList9).putExtra("name", username).putExtra("password", password).putExtra("token", string).putExtra("cellphone",cellphone).putExtra("company", company).putExtra("department", department)));
//		widget.getChildAt(0).setBackgroundResource(R.drawable.g5);
//		widget.getChildAt(1).setBackgroundResource(R.drawable.g4);
		 
		host.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				if(tabId.equals("tab1")){
	//				widget.getChildAt(0).setBackgroundResource(R.drawable.g5);
	//				widget.getChildAt(1).setBackgroundResource(R.drawable.g4);
					
				}else if(tabId.equals("tab2")){
		//			widget.getChildAt(0).setBackgroundResource(R.drawable.g4);
		//			widget.getChildAt(1).setBackgroundResource(R.drawable.g5);
				}
			}
		});
	}
	//���ؼ�����
		@Override
		public void onBackPressed() {
			// TODO �Զ����ɵķ������
			Intent intent=new Intent(Myself.this,Homepage.class);
			startActivity(intent);
			finish();
		}
}
