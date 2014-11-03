package com.example.myself;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.allproject.jJ;
import com.example.message.Homepage;
import com.example.message.R;
import com.example.message.R.id;
import com.example.sqlite.Information;




		public class Issue extends Activity {

			TextView name, one, two, three, four, five, six, nine, ten;
			ImageView photo, senven, eight, elevent;
			String string,username,password;
			ArrayList<String >cellphone,company,department;
			ArrayList<Information>arrayList=new ArrayList<Information>();
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__commonality);
		
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
		 
		 
		
		//��Ӽ�����
		senven = (ImageView)findViewById(id.senven);
	
		senven.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			
		Intent intent=new Intent(Issue.this,jJ.class);		
		startActivity(intent);
		finish();
			}
		});
	 }
		
//		ListView listView=(ListView) findViewById(id.list);
//		listView.setAdapter(new MyAdpter());
//		
//		
//		//һ���б�ĵ���¼�
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO �Զ����ɵķ������
//				
//			//ѡ������
//				AlertDialog.Builder builder=new AlertDialog.Builder(Issue.this);
//				builder.setTitle("ѡ��");
//				builder.setItems(new String[]{"������Ŀ","�鿴����"}, new AlertDialog.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface arg0, int arg1) {
//						// TODO �Զ����ɵķ������
//					
//						//������Ŀ
//						if(arg1==0){
//							
//						}
//						//�鿴����
//						else if(arg1==1){
//							
//						}
//					}
//				});
//				builder.setNegativeButton("����", null);
//				builder.show();
//			}
//		});
//	}
//		//���������
//		class MyAdpter extends BaseAdapter{
//
//			@Override
//			public int getCount() {
//				// TODO �Զ����ɵķ������
//				return arrayList.size();
//			}
//
//			@Override
//			public Object getItem(int arg0) {
//				// TODO �Զ����ɵķ������
//				return null;
//			}
//			
//
//			@Override
//			public long getItemId(int arg0) {
//				// TODO �Զ����ɵķ������
//				return 0;
//			}
//
//			@Override
//			public View getView(int arg0, View arg1, ViewGroup arg2) {
//				// TODO �Զ����ɵķ������
//				
//				View view = getLayoutInflater().inflate(R.layout.activity__commonality,null);
//
//				name = (TextView) view.findViewById(id.name);
//				one = (TextView) view.findViewById(id.one);
//				two = (TextView) view.findViewById(id.two);
//				three = (TextView) view.findViewById(id.three);
//				four = (TextView) view.findViewById(id.four);
//				five = (TextView) view.findViewById(id.five);
//				six = (TextView) view.findViewById(id.six);
//				nine = (TextView) view.findViewById(id.nine);
//				ten = (TextView) view.findViewById(id.ten);
//				photo = (ImageView) view.findViewById(id.photo);
//				senven = (ImageView) view.findViewById(id.senven);
//				eight = (ImageView) view.findViewById(id.eight);
//				elevent = (ImageView) view.findViewById(id.elevent);
//
//			
//				
//				
//				
//				return view;
//			}
		
		//���ؼ�����
			@Override
			public void onBackPressed() {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(Issue.this,Homepage.class);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				startActivity(intent);
				finish();
			}
	}