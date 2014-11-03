package com.example.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.call.Network;
import com.example.sqlite.Mysqlite;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Type;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends Activity {

	private EditText username;
	private EditText userpassword;
	private ImageView langding;
	private TextView register;
	private TextView remeber;
	private TextView forget;
	private ImageView forgo;
	private ImageView chosse;
	private String yonghu,mima;
	String[] keyString;
	ArrayList<String>arrayList=new ArrayList<String>();//���ڴ����˺�
	ArrayList<String>arrayList1=new ArrayList<String>();//���ڴ�������
	int num=0;
	ArrayList<String> messageArrayList = new ArrayList<String>();
	ArrayList<String> arrayList3 = new ArrayList<String>();
	ArrayList<String> arrayList4 = new ArrayList<String>();
	ArrayList<String> arrayList5 = new ArrayList<String>();
	ArrayList<String> arrayList6 = new ArrayList<String>();
	ArrayList<String> arrayList7 = new ArrayList<String>();
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				Toast.makeText(MainActivity.this, "��½�ɹ�", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this, Homepage.class);
				intent.putExtra("token",messageArrayList.toString());// ��tokenֵ����ȥ
				intent.putExtra("name", yonghu);//���û�������ȥ
				intent.putExtra("password", mima);//�����봫��ȥ
				intent.putExtra("cellphone",arrayList3 );//���ֻ�����
				intent.putExtra("company", arrayList4);//��������˾
				intent.putExtra("department", arrayList5);//��������˾
				intent.putExtra("district", arrayList6);//��������˾
				intent.putExtra("province", arrayList7);//��������˾
				startActivity(intent);
				finish();
			} else if (msg.what == 2) {
				Toast.makeText(MainActivity.this, "��½ʧ��", Toast.LENGTH_SHORT).show();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.username);// �û���
		userpassword = (EditText) findViewById(R.id.userpassword);// �û�����
		langding = (ImageView) findViewById(R.id.langding);// ��¼
//		remeber = (TextView) findViewById(R.id.remeber);// ��ס����
//		forget = (TextView) findViewById(R.id.forget);// ��������
//		forgo = (ImageView) findViewById(R.id.chosse);// û��ѡ���ס
		chosse = (ImageView) findViewById(R.id.chosse1);// ѡ���ס

		// ���������ȡ����Χ���
		username.setBackgroundDrawable(null);
		userpassword.setBackgroundDrawable(null);
		
		//���þ�̬��
		if(Network.checkNetWorkStatus(MainActivity.this)){
			
		}else{
			Toast.makeText(MainActivity.this, "��ǰû������", Toast.LENGTH_SHORT).show();
		}

		// ���õ�½����Ҫ������

	langding.setOnClickListener(new OnClickListener() {


			@Override
		public void onClick(View arg0) {
				// TODO �Զ����ɵķ������

//				//��ʱ���ݵ���ת 
		//		Intent intent = new Intent(MainActivity.this, Homepage.class);
		//		startActivity(intent);
		//		finish();
			//	 �ж����������
				
				String str = username.getText().toString();
				if (str.trim().equals("")) {
					Toast.makeText(MainActivity.this, "�������û���",Toast.LENGTH_SHORT).show();
			}
				String str1 = userpassword.getText().toString();
				if (str1.trim().equals("")) {
					Toast.makeText(MainActivity.this, "����������",Toast.LENGTH_SHORT).show();
			}
				yonghu=username.getText().toString();
				mima=userpassword.getText().toString();
				System.out.println("�����������û����ǣ�"+yonghu);
				//�洢�˺�����
				arrayList.add(yonghu);arrayList1.add(mima);
				System.out.println("�����������˺�"+arrayList);
				System.out.println("��������������"+arrayList1);
	

				new Thread() {
					public void run() {
						// �����������ӣ���½����

						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httppost = new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/login");
						// //��װ����
						JSONObject jsonObject = new JSONObject();
						try {
							jsonObject.put("userName", username.getText());
							jsonObject.put("password", userpassword.getText());
							jsonObject.put("deviceType","android" );
						} catch (JSONException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						System.out.println("ƴ�Ӻ�����" + jsonObject.toString());

						try {
							httppost.addHeader("Content-Type"," application/json; charset=UTF-8");
							httppost.setEntity(new StringEntity(jsonObject.toString()));
							HttpResponse response = httpclient.execute(httppost);
							response.getStatusLine().getStatusCode();
							System.out.println("��������ֵ:"+ response.getStatusLine().getStatusCode());
							if (response.getStatusLine().getStatusCode() == 200) {
								HttpEntity entity = response.getEntity();
								String string = EntityUtils.toString(entity);
								System.out.println("��½���յ��ķ���ֵ" + string);
								// дһ����������ֵ�ķ���
								analysis(string);
								if (string.contains("200")) {

									handler.sendEmptyMessage(1);

								} else {
									handler.sendEmptyMessage(2);
								}
							}
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
//		// ��¼��������
//		remeber.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO �Զ����ɵķ������
//				
//				//ͼ����л�
//				if(num%2==0){
//					   forgo.setVisibility(View.GONE);
//				       chosse.setVisibility(View.VISIBLE);
//				   	//��ס�˺�����Ĳ���
//				       arrayList.add(yonghu);arrayList1.add(mima);
//					System.out.println("�����������˺�"+arrayList);
//					System.out.println("��������������"+arrayList1);
//				//   username.setText(arrayList.toString().replace("[", "").replace("]", ""));
//				//  userpassword.setText(arrayList1.toString().replace("[", "").replace("]", ""));
//				}else {
//					 forgo.setVisibility(View.VISIBLE);
//				     chosse.setVisibility(View.GONE);
//				}
//				num++;		
//
//			}
//		});

//		// //�����������벽��
//		forget.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO �Զ����ɵķ������
//
//			}
//		});

	}

	// ���ý�������
	private void analysis(String string) {
		// TODO �Զ����ɵķ������
		try {
			JSONObject jsonObject = new JSONObject(string);
			JSONObject jsonObject1 = jsonObject.getJSONObject("d");// ��һ������
			JSONArray jsonArray = jsonObject1.getJSONArray("data");// �ڶ�������
			JSONObject json = jsonArray.getJSONObject(0);

			// ��ȡ��Ҫ�������ı��ļ�ֵ
			String userid = json.getString("userID");
			String token = json.getString("userToken");
			String cellphone=json.getString("cellphone");
			String company=json.getString("company");
			String title=json.getString("department");
			String district=json.getString("district");
			String province=json.getString("province");

			System.out.println("�û�IDֵ:" + userid);
			System.out.println("�û�Tokenֵ:" + token);
			System.out.println("�û��ֻ���:" + cellphone);
			System.out.println("�û�������˾:" +company);
			System.out.println("�û�ְ��:" +title);
			System.out.println("�û�����:" +district);
			System.out.println("�û�����:" +province);
			

			// �����������ļ�ֵ������
			messageArrayList.add(token);
			System.out.println("���������Ķ���"+messageArrayList);
			arrayList3.add(cellphone);
			System.out.println("���������Ķ���"+arrayList3);
			arrayList4.add(company);
			System.out.println("���������Ķ���"+arrayList4);
			arrayList5.add(title);
			System.out.println("���������Ķ���"+arrayList5);
			arrayList6.add(district);
			System.out.println("���������Ķ���"+arrayList6);
			arrayList7.add(province);
			System.out.println("���������Ķ���"+arrayList7);
			
			
		} catch (JSONException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
}