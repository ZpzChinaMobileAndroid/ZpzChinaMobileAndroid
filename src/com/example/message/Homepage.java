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
	ArrayList<String >cellphone,company,department,city,province,district;
	SlidingMenu menu ;
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				Toast.makeText(Homepage.this, "�˳��ɹ�", Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(Homepage.this,MainActivity.class);
				startActivity(intent);
				finish();
			}else if(msg.what==2){
				Toast.makeText(Homepage.this, "�˳�ʧ�ܣ������³���", Toast.LENGTH_SHORT).show();
			}
			
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__homepage);
		
	 
	 project=(ImageView) findViewById(R.id.project);//�½���Ŀ
	 allproject=(ImageView) findViewById(R.id.allproject);//ȫ������
	 result=(ImageView) findViewById(R.id.result);//�˳�ҳ��
	 myself=(ImageView) findViewById(R.id.myself);//��������
	 name=(TextView) findViewById(R.id.name);//��¼�û�����Ϣ
	 moblile=(TextView) findViewById(id.mobile);//��ʾ�ֻ���
	 geographic=(TextView) findViewById(id.geographic);//��ʾ����
	 geographic1=(TextView) findViewById(id.geographic1);//��ʾ����
	 companyshow=(TextView) findViewById(id.company);//��ʾ������˾
	 title=(TextView) findViewById(id.title);//��ʾְ��
	 
	 cellphone=new ArrayList<String>();
	 //���մ�������tokenֵ
	 string=getIntent().getStringExtra("token").replace("[", "").replace("]", "");
	 System.out.println("��������յ���tokenֵ"+string);
	 //���մ������ĵ�¼��
	  username=getIntent().getStringExtra("name");
	 System.out.println("�������յ����û���"+username);
	 //���մ������ĵ�¼����
	 password=getIntent().getStringExtra("password");
	 System.out.println("�������յ��ĵ�¼����"+password);
	 //���մ��������ֻ���
	 cellphone=getIntent().getStringArrayListExtra("cellphone");
	 System.out.println("�������յ����ֻ���"+cellphone);
	 //���մ�������������λ
	 company=getIntent().getStringArrayListExtra("company");
	 System.out.println("�������յ���������λ"+company);
	 //���մ�������ְ��
	 department=getIntent().getStringArrayListExtra("department");
	 System.out.println("�������յ���ְ��"+department);
	//���մ�����������
	district=getIntent().getStringArrayListExtra("district");
	System.out.println("�������յ�������"+district);
	//���մ������ĳ���
	province=getIntent().getStringArrayListExtra("province");
	System.out.println("�������յ��ĳ���"+province);
	 
	
	
	//���þ�̬��
			if(Network.checkNetWorkStatus(Homepage.this)){
				
			}else{
				Toast.makeText(Homepage.this, "��ǰû������", Toast.LENGTH_SHORT).show();
			}
			
	 //��ʾְ����ϵ��ʽ
			if(cellphone!=null&&company!=null&&department!=null){
				
	           String string1 =cellphone.get(0);String string2=company.get(0);String string3=department.get(0);
	           name.setText(username);     moblile.setText(string1);   companyshow.setText(string2);    title.setText(string3);
	 }
	//��ʾ�������
			if(district!=null&&province!=null){
				String string=district.get(0);  geographic.setText(string);
				String string2=province.get(0); geographic1.setText(string2);
			}
			
			
		//�½�����
	 project.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO �Զ����ɵķ������
			
			Intent intent=new Intent(Homepage.this,Project.class);
			intent.putExtra("token", string);
			intent.putExtra("name", username);
			intent.putExtra("password", password);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("company", company);
			intent.putExtra("department", department);
			intent.putExtra("district", district);
			intent.putExtra("province", province);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
			finish();
		}
	});
	
		//��ת���˳�����
		result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
		    	menu.showMenu();
			}
		});
		
	//ȫ������
	 allproject.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(Homepage.this,Allproject.class);
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
	 //��������
	
	myself.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO �Զ����ɵķ������
			
			Intent intent=new Intent(Homepage.this,Myself.class);
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
	
	
	//��ȡ��Ļ�Ŀ��
	DisplayMetrics dm = new DisplayMetrics();getWindowManager().getDefaultDisplay().getMetrics(dm);
	int width = dm.widthPixels;//���
	int height = dm.heightPixels ;//�߶�
	int  screenWidth=getWindowManager().getDefaultDisplay().getWidth();
	
	//�໬����
	menu = new SlidingMenu(this);
	menu.setMode(SlidingMenu.LEFT);
    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//���û�������Ļ���ޣ�������Ϊȫ�����򶼿��Ի���
    menu.setShadowWidthRes(R.dimen.shadow_width);//���ð�Ӱ�Ŀ��
    menu.setShadowDrawable(R.drawable.shadow);//���ð�Ӱ
    menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//SlidingMenu����ʱ��ҳ����ʾ��ʣ����
    menu.setBehindWidth((int)(screenWidth*(5.0/6.0)));//����SlidingMenu�˵��Ŀ��
    menu.setFadeDegree(0.35f);//SlidingMenu����ʱ�Ľ���̶�
    menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//ʹSlidingMenu������Activity��
    menu.setMenu(R.layout.activity__retreat);//����menu�Ĳ����ļ�
    
    
    
    TextView eliminate=(TextView)menu.findViewById(id.eliminate);//�����������
	TextView retreat=(TextView)menu. findViewById(id.retreat);//�˳���½
	TextView modification=(TextView)menu. findViewById(id.modification);//�޸�����
	TextView users=(TextView)menu. findViewById(id.user);//�û�����ʾ
	users.setText(username);
	
	////�˳���¼
	 retreat.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View arg0) {
			// TODO �Զ����ɵķ������
			
		new Thread(){
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
			
			
		HttpClient httpClient=new DefaultHttpClient();
		HttpPost httpPost=new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/Users/LogOut");
		
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("token",string);
			jsonObject.put("deviceType"," null");
			
		} catch (JSONException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		System.out.println("�˳�ƴ�Ӻ�"+jsonObject.toString());
		
		try {
			httpPost.addHeader("Content-Type"," application/json; charset=UTF-8");
	        httpPost.setEntity(new StringEntity(jsonObject.toString()));
			HttpResponse response=httpClient.execute(httpPost);
			response.getStatusLine().getStatusCode();
			System.out.println("���յ�������ֵ��"+response.getStatusLine().getStatusCode());
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			};
		}.start();	
	   }
	});
	 
	 //�޸�����
	 
	 modification.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO �Զ����ɵķ������
			
			Intent  intent=new Intent(Homepage.this,Modification.class);
			intent.putExtra("token",string);
			intent.putExtra("username",username);
			intent.putExtra("userpassword",password);
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
	// ���÷��ؼ�
		@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub

			AlertDialog.Builder builder = new AlertDialog.Builder(Homepage.this);
			builder.setIcon(R.drawable.icon48);
			builder.setTitle("��ʾ");
			builder.setMessage("�Ƿ��˳�");
			builder.setPositiveButton("ȷ��", new AlertDialog.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO �Զ����ɵķ������
					finish();
				}
			});
			builder.setNegativeButton("ȡ��", null);
			builder.show();

		}
}