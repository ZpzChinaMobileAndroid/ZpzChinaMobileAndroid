 package com.example.allproject;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.message.Homepage;
import com.example.message.R;
import com.example.message.R.id;
import com.example.myself.Preserve;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Allproject extends Activity {
	ProgressDialog dialog;
	 String tokenkey;
		String string,username,password;
		 ArrayList<String >cellphone,company2,department,province,district;
			JSONArray jsonArray,jsonArray2,jsonArray3;
			int investment= 0;
			int areaOfStructure=0;
		 ArrayList<String>arrayList=new ArrayList<String>();
	/*
	 * Ϊ�˱����ڴ���� ������ ���ã����Ǵ��������õ�Bitmap����ϵͳ���Զ�����ʣ����ڴ�����������Ƿ�Ҫ�ͷ���Դ
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__allproject);
		
		//���մ�������tokenֵ
		string=getIntent().getStringExtra("token");
		System.out.println("׮��������յ���tokenֵ"+string);
		//���մ������ĵ�¼��
		username=getIntent().getStringExtra("name");
		System.out.println("׮�������յ����û���"+username);
		//���մ������ĵ�¼����
		password=getIntent().getStringExtra("password");
		System.out.println("׮�������յ��ĵ�¼����"+password);
		 //���մ��������ֻ���
		 cellphone=getIntent().getStringArrayListExtra("cellphone");
		 System.out.println("׮�������յ����ֻ���"+cellphone);
		 //���մ�������������λ
		 company2=getIntent().getStringArrayListExtra("company");
		 System.out.println("׮�������յ���������λ"+company2);
		 //���մ�������ְ��
		 department=getIntent().getStringArrayListExtra("department");
		 System.out.println("׮�������յ���ְ��"+department);
		 //���մ�����������
		 district=getIntent().getStringArrayListExtra("district");
		 System.out.println("���ع滮���յ���ְ��"+district);
		 //���մ������ĳ���
		 province=getIntent().getStringArrayListExtra("province");
		 System.out.println("���ع滮���յ���ְ��"+province);
		
	

        ListView listView = (ListView) findViewById(id.list);
		ImageView backImageView = (ImageView) findViewById(id.imageView3);
		ImageView save = (ImageView) findViewById(id.imageView2);
		ImageView advaced = (ImageView) findViewById(id.imageView1);
		
		//������
		listView.setAdapter(new MyAdpter());
		
		
		
		  
		// һ���б�ĵ���¼�
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
			}
		});
		
		
		
		//���и߼�������
		advaced.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent(Allproject.this,Choosemenu.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
			}
		});
			
				
	
		new Thread(){
			public void run(){
				//��������
				
		// ��������

				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet("http://eipqas.zhongjichina.com/ZPZChina.svc/projects/"+string+"?startIndex=0&pageSize=10");
				try {
					httpGet.addHeader("Content-Type",	"application/json; charset=UTF-8");
					HttpResponse response = httpClient.execute(httpGet);
					response.getStatusLine().getStatusCode();
					if (response.getStatusLine().getStatusCode() == 200) {
						HttpEntity httpEntity = response.getEntity();
						String string = EntityUtils.toString(httpEntity);
						System.out.println("ȫ����Ŀ�Ƿ��з���ֵ" + string);
						analysis(string);
					}
					
				} catch (ClientProtocolException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		
			
			// ��������
			private void analysis(String string) {
				// TODO �Զ����ɵķ������
				try {
					JSONObject jsonObject = new JSONObject(string);
					JSONObject jsonObject1 = jsonObject.getJSONObject("d");// ��һ������
					 jsonArray = jsonObject1.getJSONArray("data");// �ڶ�������
				
			
					 
				for(int i=0;i<jsonArray.length();i++){
					
				
					JSONObject jsonObject2 = jsonArray.getJSONObject(i);
					
					if (jsonObject2.has("baseContacts")) {
					
					 jsonArray2 = jsonObject2.getJSONArray("baseContacts");//������

					 //��������Ҫ��ֵ
					 if (jsonObject2.has("investment")) {
							investment = (int) jsonObject2.getLong("investment");
						}
					 
					 System.out.println(investment);
					 
				for(int i1=0;i1<jsonArray2.length();i1++){
						
						JSONObject jsonObject3 = jsonArray2.getJSONObject(i1);
					
						 jsonArray3 = jsonObject3.getJSONArray("data");//���Ĳ�
						 
						 
						for(int i2=0;i2<jsonArray3.length();i2++){
							
							JSONObject jsonObject4 = jsonArray3.getJSONObject(i2);
							
							
				        	
						  }
					  }
			        }	
			   	  }		 
				} catch (JSONException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

			};
		}.start();
		
		
		//���ص���ҳ
		backImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent(Allproject.this,Homepage.class);
				    intent.putExtra("token", string);
					intent.putExtra("name", username);
					intent.putExtra("password", password);
					intent.putExtra("cellphone", cellphone);
					intent.putExtra("company", company2);
					intent.putExtra("department", department);
					intent.putExtra("district", district);
					intent.putExtra("province", province);
				startActivity(intent);
				finish();
			}
		});
	}

	// ����������
	class MyAdpter extends BaseAdapter {
		LayoutInflater inflater;
		Context context;
		TextView name, one, two, three, four, five, six, nine, ten;
		ImageView photo, senven, eight, elevent;

		@Override
		public int getCount() {
			// TODO �Զ����ɵķ������
			return arrayList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO �Զ����ɵķ������
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO �Զ����ɵķ������
			View view = getLayoutInflater().inflate(R.layout.test,null);

			name = (TextView) view.findViewById(id.name);
			one = (TextView) view.findViewById(id.one);
			two = (TextView) view.findViewById(id.two);
			three = (TextView) view.findViewById(id.three);
			four = (TextView) view.findViewById(id.four);
			five = (TextView) view.findViewById(id.five);
			six = (TextView) view.findViewById(id.six);
			nine = (TextView) view.findViewById(id.nine);
			ten = (TextView) view.findViewById(id.ten);
			photo = (ImageView) view.findViewById(id.photo);
			senven = (ImageView) view.findViewById(id.senven);
			eight = (ImageView) view.findViewById(id.eight);
			elevent = (ImageView) view.findViewById(id.elevent);

			name.setText("�Ϻ��м�׮ҵ��Ŀ����");
			one.setText("Ͷ�ʶ�");
			two.setText("�������");
//			three.setText(investment);
//			four.setText(areaOfStructure);
			five.setText("2014-10-30");
			six.setText("2014-11-01");
			senven.setBackgroundResource(R.drawable.h4);
			eight.setBackgroundResource(R.drawable.h2);
			nine.setText("������");
			ten.setText("�Ϻ�����ˮ·928��");
			elevent.setBackgroundResource(R.drawable.h3);
			
			return view;
		}
	}
	//���ؼ�����
	@Override
	public void onBackPressed() {
		// TODO �Զ����ɵķ������
		Intent intent=new Intent(Allproject.this,Homepage.class);
		    intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company2);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
		startActivity(intent);
		finish();
	}
}
