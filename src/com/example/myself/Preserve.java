package com.example.myself;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Entity.NamedContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allproject.jJ;
import com.example.message.Homepage;
import com.example.message.Plot;
import com.example.message.R;
import com.example.message.R.id;
import com.example.sqlite.Information;
import com.example.sqlite.Sqlite;

public class Preserve extends Activity {
	
	TextView name, one, two, three, four, five, six, nine, ten;
	ImageView photo, senven, eight, elevent;
	String string,username,password;
	ArrayList<String >cellphone,company,department;
	String[] content={"查看项目详情","发布任务"};
	ArrayList<String>aList=new ArrayList<String>();
	ArrayList<String>arrayList,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11;
    ArrayList<String>arrayList111,arrayList112,arrayList113,arrayList114;
    String string0,string1,string2,string3,string4,string5,string6,string7,string8,string9,string10,string11,
           string12,string13,string14,string15,string16,string17,string18,string19,string20,string21,string22,string23,
           string24,string25,string26,string27,string28,string29,string30,string31,string32,string33,string34,string35,
           string36,string37;
    ArrayList<Information>xinxiArrayList=new ArrayList<Information>();
//    Handler handler=new Handler(){
//    public void handleMessage(android.os.Message msg) {
//    	if(msg.what==1){
//    		Toast.makeText(Preserve.this,"项目发布成功",Toast.LENGTH_SHORT).show();
//    	}else if(msg.what==2){
//    		Toast.makeText(Preserve.this,"项目发布失败",Toast.LENGTH_SHORT).show();
//    	}
//       };	
//    };
//    
    
    
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity__preserve);
	
	
			
			//接收传过来的token值
			 string=getIntent().getStringExtra("token").replace("[", "").replace("]", "");
			 System.out.println("本地项目界面接收到的token值"+string);
			 //接收传过来的登录名
			 username=getIntent().getStringExtra("name");
			 System.out.println("本地项目界面收到的用户名"+username);
			 //接收传过来的登录密码
			 password=getIntent().getStringExtra("password");
			 System.out.println("本地项目界面收到的登录密码"+password);
			 //接收传过来的手机号
			 cellphone=getIntent().getStringArrayListExtra("cellphone");
			 System.out.println("主界面收到的手机号"+cellphone);
			 //接收传过来的所属单位
			 company=getIntent().getStringArrayListExtra("company");
			 System.out.println("主界面收到的所属单位"+company);
			 //接收传过来的职务
			 department=getIntent().getStringArrayListExtra("department");
			 System.out.println("主界面收到的职务"+department);
			 
			 
			 ListView listView=(ListView) findViewById(id.listview);
			 listView.setAdapter(new MyAdpter());
			 
			 //土地规划
		        arrayList=new ArrayList<String>();
		        arrayList=getIntent().getStringArrayListExtra("one");	
		        System.out.println("本地项目土地规划显示"+arrayList);
		        if(arrayList!=null){
		            string0=new String();  string1=new String();string2=new String();  string3=new String();
		        	string4=new String();  string5=new String();string6=new String();string7=new String();
		        	
		        	string0=arrayList.get(0);string1=arrayList.get(1);string2=arrayList.get(2);string3=arrayList.get(3);string4=arrayList.get(4);
		        	string5=arrayList.get(5);
		        
		        }
		     // 项目立项
		        arrayList1=new ArrayList<String>();
		        arrayList1=getIntent().getStringArrayListExtra("two");	
		        System.out.println("本地项目项目立项显示"+arrayList1);
	            if(arrayList1!=null){
	            	string8=new String();  string9=new String(); string10=new String(); string11=new String();
		        	string12=new String();  string13=new String();string14=new String();  string15=new String();
		        	string16=new String();  string17=new String(); string18=new String(); 
		        	
		        	string8=arrayList1.get(0);string9=arrayList1.get(1);string10=arrayList1.get(2);string11=arrayList1.get(3);string12=arrayList1.get(4);
		         	string13=arrayList1.get(5);string14=arrayList1.get(6);string15=arrayList1.get(7);string16=arrayList1.get(8);string17=arrayList1.get(9);
		        	
	            }
		     //  地勘阶段
		        arrayList2=new ArrayList<String>();
		        arrayList2=getIntent().getStringArrayListExtra("three");	
		        System.out.println("本地项目地勘阶段显示"+arrayList2);
	            if(arrayList2!=null){
	            	 string19=new String(); 
			    }
		     //  设计阶段
		        arrayList3=new ArrayList<String>();
		        arrayList3=getIntent().getStringArrayListExtra("four");	
		        System.out.println("本地项目设计阶段显示"+arrayList3);
	            if(arrayList3!=null){
	            	 string20=new String(); string21=new String();
	            	
	            	string20=arrayList3.get(0);
	            }
		     //  出图阶段
		        arrayList4=new ArrayList<String>();
		        arrayList4=getIntent().getStringArrayListExtra("five");	
		        System.out.println("本地项目出图阶段显示"+arrayList4);
	            if(arrayList4!=null){
	            	 string22=new String(); string23=new String(); string24=new String();  string25=new String();
		        	 string26=new String();  string27=new String(); string28=new String();  string29=new String();
		        	
		        	string22=arrayList4.get(0);string23=arrayList4.get(1);string24=arrayList4.get(2);string25=arrayList4.get(3);
		        	string26=arrayList4.get(4);string27=arrayList4.get(5);string28=arrayList4.get(6);
			    }
		      // 地平 
		        arrayList5=new ArrayList<String>();
		        arrayList5=getIntent().getStringArrayListExtra("six");	
		        System.out.println("本地项目地平显示"+arrayList5);
	            if(arrayList5!=null){
	            string30=new String();  
	            	
	            	string30=arrayList5.get(0);
			    }
		      //  桩基基坑
		        arrayList6=new ArrayList<String>();
		        arrayList6=getIntent().getStringArrayListExtra("seven");	
		        System.out.println("本地项目桩基基坑显示"+arrayList6);
	            if(arrayList6!=null){
	            	 string32=new String();
	            	
	            	string32=arrayList6.get(0);
			    }
		      //  主体施工
		        arrayList7=new ArrayList<String>();
		        arrayList7=getIntent().getStringArrayListExtra("eight");	
		        System.out.println("本地项目主体施工显示"+arrayList7);
	            if(arrayList7!=null){
			    }
		      //消防绿化
		        arrayList8=new ArrayList<String>();
		        arrayList8=getIntent().getStringArrayListExtra("nine");	
		        System.out.println("本地项目消防绿化显示"+arrayList8);
	            if(arrayList8!=null){
	            	string33=new String(); string34=new String();
	            	
	            	string33=arrayList8.get(0);string34=arrayList8.get(1);
			    }
		      //  装修阶段
		        arrayList9=new ArrayList<String>();
		        arrayList9=getIntent().getStringArrayListExtra("ten");	
		        System.out.println("本地项目装修阶段显示"+arrayList9);
	            if(arrayList9!=null){
	            	string35=new String();  string36=new String(); string37=new String(); 
	            	
	            	string35=arrayList9.get(0);string36=arrayList9.get(1);string37=arrayList9.get(2);
			    }
		     //
		        arrayList111=new ArrayList<String>();
		        arrayList111=getIntent().getStringArrayListExtra("user");	
		      //  
		        arrayList112=new ArrayList<String>();
		        arrayList112=getIntent().getStringArrayListExtra("user1");	
		      //  
		        arrayList113=new ArrayList<String>();
		        arrayList113=getIntent().getStringArrayListExtra("user2");	
		      //  
		        arrayList114=new ArrayList<String>();
		        arrayList114=getIntent().getStringArrayListExtra("user3");	
	 
		        
		        
		      
		     
		        
			    
			    
			    
//			    
//			  //选择
//				senven = (ImageView)findViewById(id.senven);
//			
//				senven.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View arg0) {
//						// TODO 自动生成的方法存根
//				
//					AlertDialog.Builder builder=new AlertDialog.Builder(Preserve.this);
//					builder.setItems(content, new AlertDialog.OnClickListener() {
//						
//						@Override
//						public void onClick(DialogInterface arg0, int arg1) {
//							// TODO 自动生成的方法存根
//							
//						//查看项目详情
//						if(arg1==0){
//							Intent intent=new Intent(Preserve.this,jJ.class);	
//							intent.putExtra("one", arrayList);
//							intent.putExtra("two", arrayList3);
//							intent.putExtra("three", arrayList4);
//							intent.putExtra("four", arrayList5);
//							intent.putExtra("five", arrayList6);
//							intent.putExtra("six", arrayList7);
//							intent.putExtra("senven", arrayList8);
//							intent.putExtra("eight", arrayList9);
//							intent.putExtra("nine", arrayList10);
//							intent.putExtra("ten", arrayList11);
//							intent.putExtra("token", string);
//							intent.putExtra("name", username);
//							intent.putExtra("password", password);
//							intent.putExtra("cellphone", cellphone);
//							intent.putExtra("company", company);
//							intent.putExtra("department", department);
//							startActivity(intent);
//							finish();
//							
//						     //储存数据到数据库中
//							Information information=new Information();
//							information.setProjectID(null);
//							information.setProjectCode(null);
//							information.setProjectVersion(null);
//							information.setLandName(string0);
//							information.setDistrict(string1);
//							information.setProvince(string1);
//							information.setCity(string1);
//							information.setLandAddress(string2);
//							information.setArea(string3);
//							information.setPlotRatio(string4);
//							information.setUsage(string5);
//							information.setProjectName(string8);
//							information.setDescription(string10);
//							information.setOwner(null);
//							information.setExpectedStartTime(string11);
//							information.setExpectedFinishTime(string12);
//							information.setInvestment(string13);
//							information.setAreaOfStructure(string14);
//							information.setStoreyHeight(string15);
//							information.setForeignInvestment(string16);
//							information.setOwnerType(string17);
//							information.setLongitude(null);
//							information.setLatitude(null);
//							information.setMainDesignStage(string20);
//							information.setPropertyElevator(string24);
//							information.setPropertyAirCondition(string25);
//							information.setPropertyHeating(string26);
//							information.setPropertyExternalWallMeterial(string27);
//							information.setPropertyStealStructure(string28);
//							information.setActualStartTime(string30);
//							information.setFireControl(string33);
//							information.setGreen(string34);
//							information.setElectroweakInstallation(string35);
//							information.setDecorationSituation(string36);
//							information.setDecorationProgress(string37);
//						
//						    new Sqlite(Preserve.this).content(information);
//						}
//						
//		    //发布项目
//			else if(arg1==1){
//
//				//发布项目接口
//				new Thread(){
//					@Override
//					public void run() {
//					// TODO 自动生成的方法存根
//								
//					HttpClient httpClient=new DefaultHttpClient();
//					HttpPost httpPost=new HttpPost("http://EIPQAS.zhongjichina.com/ZPZChina.svc/projects/");
//							
//					JSONObject jsonObject=new JSONObject();
//					JSONObject data=new JSONObject();
//				
//					
//				try {
//					data.put("acl", "0");                     
//		        //  data.put("actualStartTime", string30);
//					data.put("area", string3);                     
//					data.put("areaOfStructure", string14);
//				//	data.put("city", string1);                     
//					data.put("decorationProgress", string37);
//					data.put("decorationSituation", string36);      
//				//	data.put("description", string10);
////				//	data.put("district", string1);                  
//					data.put("electroweakInstallation", string35);
////				//	data.put("expectedConstructionTime", string22); 
////				//	data.put("expectedFinishTime", string12);
////				//	data.put("expectedStartTime", string11);        
//					data.put("fireControl", string33);
//				//	data.put("foreignInvestment", string16);        
//					data.put("green", string34);
//					data.put("investment", string13);               
////				//	data.put("landAddress", string9);
//					data.put("landName", string0);                 
//					data.put("mainDesignStage", string20);
//					data.put("ownerType", string17);                
//					data.put("plotRatio", string4);
//					data.put("projectName", string8);               
//					data.put("propertyAirCondition", string25);
//					data.put("propertyElevator", string24);         
//	//				data.put("propertyExternalWallMeterial", string27);
//		//			data.put("propertyHeating", string26);         
//			//		data.put("propertyStealStructure", string28);
////				//	data.put("province", string1);                 
////					data.put("storeyHeight", string15);
////					data.put("usage", string5);        
//					jsonObject.put("data", data);
//					jsonObject.put("token",string);
//								
//				} catch (JSONException e) {
//					// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//				System.out.println("发布项目拼接"+jsonObject.toString());
//				
//				try {
//					httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
//					httpPost.setEntity(new StringEntity(jsonObject.toString()));
//					HttpResponse httpResponse=httpClient.execute(httpPost);
//					httpResponse.getStatusLine().getStatusCode();
//					System.out.println("发布任务的网络连接值"+httpResponse.getStatusLine().getStatusCode());
//					if(httpResponse.getStatusLine().getStatusCode()==400||httpResponse.getStatusLine().getStatusCode()==404){
//						  handler.sendEmptyMessage(2);
//					}
//					if(httpResponse.getStatusLine().getStatusCode()==200){
//						HttpEntity httpEntity=httpResponse.getEntity();
//						String string=EntityUtils.toString(httpEntity);
//						System.out.println("发布任务返回值"+string);
//						if (string.contains("200")) {
//							handler.sendEmptyMessage(1);
//						} else {
//							handler.sendEmptyMessage(2);
//						}
//					}
//				} catch (UnsupportedEncodingException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				} catch (ClientProtocolException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
//		};
//        }.start();		
//        
//        		//发布照片接口
//          new Thread(){
//    		public void run() {
//    			
//    			HttpClient httpClient=new DefaultHttpClient();
//    			HttpPost httpPost=new HttpPost("http://eipqas.zhongjichina.com/ZPZChina.svc/ProjectImgs/");
//    			
//    			JSONObject jsonObject =new JSONObject();
////    			jsonObject.put("auctionUnitContacts", dd);//拍卖单位联系人
////    			jsonObject.put("ownerUnitContacts", dd);//业主单位联系人
////    			jsonObject.put("explorationUnitContacts", dd);//地勘公司联系人
////    			jsonObject.put("designInstituteContacts", dd);//设计院联系人
////    			jsonObject.put("contractorUnitContacts", dd);//施工总承包联系人
////    			jsonObject.put("pileFoundationUnitContacts", dd);//桩基分包联系人
//    			
//    		};
//    	}.start();
//        		//发布联系人接口
//        	new Thread(){
//        		public void run() {
//        			
//        			HttpClient httpClient=new DefaultHttpClient();
//        			HttpPost httpPost=new HttpPost("http://eipqas.zhongjichina.com/ZPZChina.svc/BaseContacts/");
//        			
//        			
//        		};
//        	}.start();
//						  }
//					   }
//					});
//					builder.show();
//					}
//				});
				

}
	
	class MyAdpter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO 自动生成的方法存根
			return aList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO 自动生成的方法存根
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO 自动生成的方法存根
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

			name.setText("上海中技桩业项目名称");
			one.setText("投资额");
			two.setText("建筑面积");
			three.setText(xinxiArrayList.get(arg0).getAreaOfStructure());
			four.setText(xinxiArrayList.get(arg0).getInvestment());
			five.setText(xinxiArrayList.get(arg0).getExpectedStartTime());
			six.setText(xinxiArrayList.get(arg0).getExpectedFinishTime());
			nine.setText("华南区");
			ten.setText("上海市汶水路928号");
			
			return view;
		}
		
	}
	
	
//返回键设置
	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		Intent intent=new Intent(Preserve.this,Homepage.class);
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
		intent.putExtra("cellphone", cellphone);
		intent.putExtra("company", company);
		intent.putExtra("department", department);
		startActivity(intent);
		finish();
	}
	}