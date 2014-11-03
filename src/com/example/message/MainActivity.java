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
	ArrayList<String>arrayList=new ArrayList<String>();//用于储存账号
	ArrayList<String>arrayList1=new ArrayList<String>();//用于储存密码
	int num=0;
	ArrayList<String> messageArrayList = new ArrayList<String>();
	ArrayList<String> arrayList3 = new ArrayList<String>();
	ArrayList<String> arrayList4 = new ArrayList<String>();
	ArrayList<String> arrayList5 = new ArrayList<String>();
	ArrayList<String> arrayList6 = new ArrayList<String>();
	ArrayList<String> arrayList7 = new ArrayList<String>();
	ArrayList<String> arrayList8 = new ArrayList<String>();
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this, Homepage.class);
				intent.putExtra("token",messageArrayList.toString());// 将token值传出去
				intent.putExtra("name", yonghu);//将用户名传出去
				intent.putExtra("password", mima);//将密码传出去
				intent.putExtra("cellphone",arrayList3 );//将手机号码
				intent.putExtra("company", arrayList4);//将所属公司
				intent.putExtra("department", arrayList5);//将所属公司
				intent.putExtra("district", arrayList6);//将所属公司
				intent.putExtra("province", arrayList7);//将所属公司
				intent.putExtra("realname", arrayList8);//将所属公司
				startActivity(intent);
				finish();
			} else if (msg.what == 2) {
				Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.username);// 用户名
		userpassword = (EditText) findViewById(R.id.userpassword);// 用户密码
		langding = (ImageView) findViewById(R.id.langding);// 登录
//		remeber = (TextView) findViewById(R.id.remeber);// 记住密码
//		forget = (TextView) findViewById(R.id.forget);// 忘记密码
//		forgo = (ImageView) findViewById(R.id.chosse);// 没有选择记住
		chosse = (ImageView) findViewById(R.id.chosse1);// 选择记住

		// 设置输入框，取消周围框架
		username.setBackgroundDrawable(null);
		userpassword.setBackgroundDrawable(null);
		
		//调用静态类
		if(Network.checkNetWorkStatus(MainActivity.this)){
			
		}else{
			Toast.makeText(MainActivity.this, "当前没有网络", Toast.LENGTH_SHORT).show();
		}

		// 设置登陆所需要的设置

	langding.setOnClickListener(new OnClickListener() {


			@Override
		public void onClick(View arg0) {
				// TODO 自动生成的方法存根

				
				String str = username.getText().toString();
				if (str.trim().equals("")) {
					Toast.makeText(MainActivity.this, "请输入用户名",Toast.LENGTH_SHORT).show();
			}
				String str1 = userpassword.getText().toString();
				if (str1.trim().equals("")) {
					Toast.makeText(MainActivity.this, "请输入密码",Toast.LENGTH_SHORT).show();
			}
	

				new Thread() {
					public void run() {
						// 设置网络连接，登陆界面

						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httppost = new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/login");
						// //分装数据
						JSONObject jsonObject = new JSONObject();
						try {
							jsonObject.put("userName", username.getText());
							jsonObject.put("password", userpassword.getText());
							jsonObject.put("deviceType","android" );
						} catch (JSONException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						System.out.println("拼接后数据" + jsonObject.toString());

						try {
							httppost.addHeader("Content-Type"," application/json; charset=UTF-8");
							httppost.setEntity(new StringEntity(jsonObject.toString()));
							HttpResponse response = httpclient.execute(httppost);
							response.getStatusLine().getStatusCode();
							System.out.println("网络连接值:"+ response.getStatusLine().getStatusCode());
							if (response.getStatusLine().getStatusCode() == 200) {
								HttpEntity entity = response.getEntity();
								String string = EntityUtils.toString(entity);
								System.out.println("登陆后收到的返回值" + string);
								// 写一个解析返回值的方法
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
		

	}

	// 调用解析方法
	private void analysis(String string) {
		// TODO 自动生成的方法存根
		try {
			JSONObject jsonObject = new JSONObject(string);
			JSONObject jsonObject1 = jsonObject.getJSONObject("d");// 第一层名字
			JSONArray jsonArray = jsonObject1.getJSONArray("data");// 第二层名字
			JSONObject json = jsonArray.getJSONObject(0);

			
			// 获取需要的资料文本的键值
			String userid = json.getString("userID");
			String token = json.getString("userToken");
			String cellphone=json.getString("cellphone");
			String company=json.getString("company");
			String title=json.getString("department");
			String district=json.getString("district");
			String province=json.getString("province");
			String realname=json.getString("realName");

			System.out.println("用户ID值:" + userid);
			System.out.println("用户Token值:" + token);
			System.out.println("用户手机号:" + cellphone);
			System.out.println("用户所属公司:" +company);
			System.out.println("用户职称:" +title);
			System.out.println("用户区域:" +district);
			System.out.println("用户城市:" +province);
			System.out.println("用户名:" +realname);
			

			// 将解析出来的键值存起来
			messageArrayList.add(token);
			System.out.println("储存起来的东西"+messageArrayList);
			arrayList3.add(cellphone);
			System.out.println("储存起来的东西"+arrayList3);
			arrayList4.add(company);
			System.out.println("储存起来的东西"+arrayList4);
			arrayList5.add(title);
			System.out.println("储存起来的东西"+arrayList5);
			arrayList6.add(district);
			System.out.println("储存起来的东西"+arrayList6);
			arrayList7.add(province);
			System.out.println("储存起来的东西"+arrayList7);
			arrayList8.add(realname);
			System.out.println("储存起来的东西"+arrayList8);
			
			
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}