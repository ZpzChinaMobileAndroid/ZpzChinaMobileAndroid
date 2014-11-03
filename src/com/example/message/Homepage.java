package com.example.message;

import java.io.IOException;
import java.util.ArrayList;

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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allproject.Allproject;
import com.example.call.Network;
import com.example.message.R.id;
import com.example.myself.Myself;

import com.example.sqlite.Mysqlite;
import com.slidingmenu.lib.SlidingMenu;

	
public class Homepage extends Activity {
	
	private	 TextView name,moblile,companyshow,title,geographic,geographic1;
	private	 ImageView project,myself,allproject,result;
    String string,username,password;
	ArrayList<String >cellphone,company,department,city,province,district,realname;
	SlidingMenu menu ;
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				Toast.makeText(Homepage.this, "退出成功", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Homepage.this,MainActivity.class);
				startActivity(intent);
				finish();
			}else if(msg.what==2){
				Toast.makeText(Homepage.this, "退出失败，请重新尝试", Toast.LENGTH_SHORT).show();
			}
			
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__homepage);
		
	 
	 project=(ImageView) findViewById(R.id.project);//新建项目
	 allproject=(ImageView) findViewById(R.id.allproject);//全部任务
	 result=(ImageView) findViewById(R.id.result);//退出页面
	 myself=(ImageView) findViewById(R.id.myself);//本地任务
	 name=(TextView) findViewById(R.id.name);//登录用户的信息
	 moblile=(TextView) findViewById(id.mobile);//显示手机号
	 geographic=(TextView) findViewById(id.geographic);//显示区域
	 geographic1=(TextView) findViewById(id.geographic1);//显示城市
	 companyshow=(TextView) findViewById(id.company);//显示所属公司
	 title=(TextView) findViewById(id.title);//显示职称
	 
	 cellphone=new ArrayList<String>();
	 //接收传过来的token值
	 string=getIntent().getStringExtra("token").replace("[", "").replace("]", "");
	 System.out.println("主界面接收到的token值"+string);
	 //接收传过来的登录名
	  username=getIntent().getStringExtra("realname");
	 System.out.println("主界面收到的用户名"+username);
	 //接收传过来的登录密码
	 password=getIntent().getStringExtra("password");
	 System.out.println("主界面收到的登录密码"+password);
	 //接收传过来的手机号
	 cellphone=getIntent().getStringArrayListExtra("cellphone");
	 System.out.println("主界面收到的手机号"+cellphone);
	 //接收传过来的所属单位
	 company=getIntent().getStringArrayListExtra("company");
	 System.out.println("主界面收到的所属单位"+company);
	 //接收传过来的职务
	 department=getIntent().getStringArrayListExtra("department");
	 System.out.println("主界面收到的职务"+department);
	//接收传过来的区域
	district=getIntent().getStringArrayListExtra("district");
	System.out.println("主界面收到的区域"+district);
	//接收传过来的城市
	province=getIntent().getStringArrayListExtra("province");
	System.out.println("主界面收到的城市"+province);
	//接收传过来的城市
	realname=getIntent().getStringArrayListExtra("realname");
	System.out.println("主界面收到的城市"+realname);
	 
	
	
	//调用静态类
			if(Network.checkNetWorkStatus(Homepage.this)){
				
			}else{
				Toast.makeText(Homepage.this, "当前没有网络", Toast.LENGTH_SHORT).show();
			}
			
	 //显示职务联系方式
			if(cellphone!=null&&company!=null&&department!=null&&realname!=null){
				
	           String string1 =cellphone.get(0);String string2=company.get(0);String string3=department.get(0); String string4=realname.get(0);
	           name.setText(string4);     moblile.setText(string1);   companyshow.setText(string2);    title.setText(string3);
	          
			}
	//显示区域城市
			if(district!=null&&province!=null){
				String string=district.get(0);  geographic.setText(string);
				String string2=province.get(0); geographic1.setText(string2);
			}
			
			
		//新建设置
	 project.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			
			Intent intent=new Intent(Homepage.this,Project.class);
			intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			intent.putExtra("realname", realname);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
			finish();
		}
	});
	
		//跳转到退出界面
		result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
		    	menu.showMenu();
			}
		});
		
	//全部任务
	 allproject.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(Homepage.this,Allproject.class);
				intent.putExtra("token", string);
				intent.putExtra("name", username);
				intent.putExtra("password", password);
				intent.putExtra("cellphone", cellphone);
				intent.putExtra("company", company);
				intent.putExtra("department", department);
				intent.putExtra("district", district);
				intent.putExtra("province", province);
				intent.putExtra("realname", realname);
				startActivity(intent);
				finish();
			}
		});
	 //本地任务
	
	myself.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			
			Intent intent=new Intent(Homepage.this,Myself.class);
			intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			intent.putExtra("realname", realname);
			startActivity(intent);
			finish();
		}
	});
	
	
	//获取屏幕的宽高
	DisplayMetrics dm = new DisplayMetrics();getWindowManager().getDefaultDisplay().getMetrics(dm);
	int width = dm.widthPixels;//宽度
	int height = dm.heightPixels ;//高度
	int  screenWidth=getWindowManager().getDefaultDisplay().getWidth();
	
	//侧滑设置
	menu = new SlidingMenu(this);
	menu.setMode(SlidingMenu.LEFT);
    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置滑动的屏幕局限，该设置为全屏区域都可以滑动
    menu.setShadowWidthRes(R.dimen.shadow_width);//设置暗影的宽度
    menu.setShadowDrawable(R.drawable.shadow);//设置暗影
    menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//SlidingMenu划出时主页面显示的剩余宽度
    menu.setBehindWidth((int)(screenWidth*(5.0/6.0)));//设置SlidingMenu菜单的宽度
    menu.setFadeDegree(0.35f);//SlidingMenu滑动时的渐变程度
    menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//使SlidingMenu附加在Activity上
    menu.setMenu(R.layout.activity__retreat);//设置menu的布局文件
    
    
    
    TextView eliminate=(TextView)menu.findViewById(id.eliminate);//清除本地数据
	TextView retreat=(TextView)menu. findViewById(id.retreat);//退出登陆
	TextView modification=(TextView)menu. findViewById(id.modification);//修改密码
	TextView users=(TextView)menu. findViewById(id.user);//用户名显示
	users.setText(realname.toString().replace("[","").replace("]",""));
	
	////退出登录
	 retreat.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			
		new Thread(){
			@Override
			public void run() {
				// TODO 自动生成的方法存根
			
			
		HttpClient httpClient=new DefaultHttpClient();
		HttpPost httpPost=new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/LogOut");
		
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("token",string);
			jsonObject.put("deviceType"," null");
			
		} catch (JSONException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		System.out.println("退出拼接后"+jsonObject.toString());
		
		try {
			httpPost.addHeader("Content-Type"," application/json; charset=UTF-8");
	        httpPost.setEntity(new StringEntity(jsonObject.toString()));
			HttpResponse response=httpClient.execute(httpPost);
			response.getStatusLine().getStatusCode();
			System.out.println("接收到的网络值："+response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode()==200){
				HttpEntity entity=response.getEntity();
				String result=EntityUtils.toString(entity);
				if(result.contains("200")){
					handler.sendEmptyMessage(1);
				}else {
					handler.sendEmptyMessage(2);
				}
			}
			
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			};
		}.start();	
	   }
	});
	 
	 //修改密码
	 
	 modification.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			
			Intent  intent=new Intent(Homepage.this,Modification.class);
			intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			intent.putExtra("realname", realname);
			startActivity(intent);
			finish();
		}
	});
	
	
	
	
	}
	// 设置返回键
		@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub

			AlertDialog.Builder builder = new AlertDialog.Builder(Homepage.this);
			builder.setIcon(R.drawable.icon48);
			builder.setTitle("提示");
			builder.setMessage("是否退出");
			builder.setPositiveButton("确定", new AlertDialog.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根
					finish();
				}
			});
			builder.setNegativeButton("取消", null);
			builder.show();
		}
}