package com.example.allproject;

import java.util.ArrayList;

import com.example.message.Homepage;
import com.example.message.Project;
import com.example.message.R;
import com.example.message.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class jJ extends Activity {
	ArrayList<String>arrayList,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
    ArrayList<String>arrayList111,arrayList112,arrayList113,arrayList114;
	String string,username,password;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.jia);
  
//接收传过来的token值
string=getIntent().getStringExtra("token");
System.out.println("本地项目界面接收到的token值"+string);
//接收传过来的登录名
username=getIntent().getStringExtra("name");
System.out.println("本地项目界面收到的用户名"+username);
//接收传过来的登录密码
password=getIntent().getStringExtra("password");
System.out.println("本地项目界面收到的登录密码"+password);

//土地规划
   arrayList=new ArrayList<String>();
   arrayList=getIntent().getStringArrayListExtra("one");	
   System.out.println("土地规划显示"+arrayList);
   arrayList1=new ArrayList<String>();
   arrayList1=getIntent().getStringArrayListExtra("two");	
   System.out.println("项目立项显示"+arrayList1);
//  地勘阶段
   arrayList2=new ArrayList<String>();
   arrayList2=getIntent().getStringArrayListExtra("three");	
   System.out.println("地勘阶段显示"+arrayList2);
//  设计阶段
   arrayList3=new ArrayList<String>();
   arrayList3=getIntent().getStringArrayListExtra("four");	
   System.out.println("设计阶段显示"+arrayList3);
//  出图阶段
   arrayList4=new ArrayList<String>();
   arrayList4=getIntent().getStringArrayListExtra("five");	
   System.out.println("出图阶段显示"+arrayList4);
 // 地平 
   arrayList5=new ArrayList<String>();
   arrayList5=getIntent().getStringArrayListExtra("six");	
   System.out.println("地平显示"+arrayList5);
 //  桩基基坑
   arrayList6=new ArrayList<String>();
   arrayList6=getIntent().getStringArrayListExtra("seven");	
   System.out.println("桩基基坑显示"+arrayList6);
 //  主体施工
   arrayList7=new ArrayList<String>();
   arrayList7=getIntent().getStringArrayListExtra("eight");	
   System.out.println("主体施工显示"+arrayList7);
 //消防绿化
   arrayList8=new ArrayList<String>();
   arrayList8=getIntent().getStringArrayListExtra("nine");	
   System.out.println("消防绿化显示"+arrayList8);
 //  装修阶段
   arrayList9=new ArrayList<String>();
   arrayList9=getIntent().getStringArrayListExtra("ten");	
   System.out.println("装修阶段显示"+arrayList9);
   arrayList111=new ArrayList<String>();
   arrayList111=getIntent().getStringArrayListExtra("user");	
   arrayList112=new ArrayList<String>();
   arrayList112=getIntent().getStringArrayListExtra("user1");	
   arrayList113=new ArrayList<String>();
   arrayList113=getIntent().getStringArrayListExtra("user2");	
   arrayList114=new ArrayList<String>();
   arrayList114=getIntent().getStringArrayListExtra("user3");	
   
   ImageView oneImageView=(ImageView) findViewById(id.onrfirst);
   oneImageView.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		Intent intent=new Intent(jJ.this,Project.class);
		intent.putExtra("one", arrayList);
		intent.putExtra("two", arrayList1);
		intent.putExtra("three", arrayList2);
		intent.putExtra("four", arrayList3);
		intent.putExtra("five", arrayList4);
		intent.putExtra("six", arrayList5);
		intent.putExtra("senven", arrayList6);
		intent.putExtra("eight", arrayList7);
		intent.putExtra("nine", arrayList8);
		intent.putExtra("ten", arrayList9);
		intent.putExtra("token", string);
		intent.putExtra("name", username);
		intent.putExtra("password", password);
		startActivity(intent);
		finish();
		
	}
});
   
    }
     //返回键设置
     @Override
     public void onBackPressed() {
  	// TODO 自动生成的方法存根
	Intent intent=new Intent(jJ.this,Homepage.class);
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
	startActivity(intent);
	finish();
	
   }
 }








//
//JSONObject obj = new JSONObject(string);
//JSONObject d = obj.getJSONObject("d");
//JSONArray data = d.getJSONArray("data");
//for (int i = 0; i < data.length(); i++) {
//JSONObject o = data.getJSONObject(i);
//if (o.has("baseContacts")) {
//JSONArray base = o.getJSONArray("baseContacts");
//for (int j = 0; j < base.length(); j++) {
//JSONObject p = base.getJSONObject(j);
//JSONArray bdata = p.getJSONArray("data");
//for (int k = 0; k < bdata.length(); k++) {
//JSONObject contact = bdata.getJSONObject(k);
//String name = contact.getString("name");
//System.out.println(name);
//}
//}
//}
//}





//JSONObject obj = new JSONObject(fileContent);
//JSONObject d = obj.getJSONObject("d");
//JSONArray data = d.getJSONArray("data");
//for (int i = 0; i < data.length(); i++) {
//	JSONObject o = data.getJSONObject(i);
//	Long investment = null;
//	if (o.has("investment")) {
//		investment = o.getLong("investment");
//	}
//	System.out.println(investment);
//}










