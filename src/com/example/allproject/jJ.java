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
	// TODO �Զ����ɵķ������
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.jia);
  
//���մ�������tokenֵ
string=getIntent().getStringExtra("token");
System.out.println("������Ŀ������յ���tokenֵ"+string);
//���մ������ĵ�¼��
username=getIntent().getStringExtra("name");
System.out.println("������Ŀ�����յ����û���"+username);
//���մ������ĵ�¼����
password=getIntent().getStringExtra("password");
System.out.println("������Ŀ�����յ��ĵ�¼����"+password);

//���ع滮
   arrayList=new ArrayList<String>();
   arrayList=getIntent().getStringArrayListExtra("one");	
   System.out.println("���ع滮��ʾ"+arrayList);
   arrayList1=new ArrayList<String>();
   arrayList1=getIntent().getStringArrayListExtra("two");	
   System.out.println("��Ŀ������ʾ"+arrayList1);
//  �ؿ��׶�
   arrayList2=new ArrayList<String>();
   arrayList2=getIntent().getStringArrayListExtra("three");	
   System.out.println("�ؿ��׶���ʾ"+arrayList2);
//  ��ƽ׶�
   arrayList3=new ArrayList<String>();
   arrayList3=getIntent().getStringArrayListExtra("four");	
   System.out.println("��ƽ׶���ʾ"+arrayList3);
//  ��ͼ�׶�
   arrayList4=new ArrayList<String>();
   arrayList4=getIntent().getStringArrayListExtra("five");	
   System.out.println("��ͼ�׶���ʾ"+arrayList4);
 // ��ƽ 
   arrayList5=new ArrayList<String>();
   arrayList5=getIntent().getStringArrayListExtra("six");	
   System.out.println("��ƽ��ʾ"+arrayList5);
 //  ׮������
   arrayList6=new ArrayList<String>();
   arrayList6=getIntent().getStringArrayListExtra("seven");	
   System.out.println("׮��������ʾ"+arrayList6);
 //  ����ʩ��
   arrayList7=new ArrayList<String>();
   arrayList7=getIntent().getStringArrayListExtra("eight");	
   System.out.println("����ʩ����ʾ"+arrayList7);
 //�����̻�
   arrayList8=new ArrayList<String>();
   arrayList8=getIntent().getStringArrayListExtra("nine");	
   System.out.println("�����̻���ʾ"+arrayList8);
 //  װ�޽׶�
   arrayList9=new ArrayList<String>();
   arrayList9=getIntent().getStringArrayListExtra("ten");	
   System.out.println("װ�޽׶���ʾ"+arrayList9);
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
		// TODO �Զ����ɵķ������
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
     //���ؼ�����
     @Override
     public void onBackPressed() {
  	// TODO �Զ����ɵķ������
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










