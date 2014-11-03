package com.example.allproject;

import com.example.message.Approve;
import com.example.message.R;
import com.example.message.R.id;
import com.guozg.wheelview.views.ArrayWheelAdapter;
import com.guozg.wheelview.views.OnWheelChangedListener;
import com.guozg.wheelview.views.WheelView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Advanced extends Activity{

	EditText keyword,companyname;
	TextView district,province,stage,category,show,show1,show2,show3;
	ImageView found,back;
	String[] strings={"��ҵ","�Ƶ꼰����","����칫","סլ/���������÷�","������ҵ��ʩ","����"};
	public String category1[] = new String[] {"������","�����","�Ϻ���","������","�ӱ�ʡ","ɽ��ʡ","���ɹ�ʡ","����ʡ","����ʡ","������ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ر�������","�����ر�������","����ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","�㶫ʡ",
			"����׳��������ʡ","���Ļ���������","�ຣʡ","�½�ά���������","����������","̨��ʡ","����ʡ","�Ĵ�ʡ","����ʡ","����ʡ","����ʡ","����ʡ" };
	   public String category2[] = new String[] {"������","�����","�Ϻ���","������","ʯ��ׯ�� ","��ɽ��","�ػʵ���","������","��̨��","������","�żҿ���","�е���","������","�ȷ���","��ˮ��",
	             "̫ԭ��","��ͬ��","��Ȫ��","������","������","˷����","������","�˳���","������","�ٷ���","������", "���ͺ�����","��ͷ��","�ں���","�����","ͨ����","������˹��","���ױ�����","�����׶���","�����첼��","�˰�����","���ֹ�������","����������",
	             "������","������","��ɽ��","��˳��","��Ϫ��","������","������","Ӫ����","������","������","�̽���","������","������","��«����", "������","������","��ƽ��","��Դ��","ͨ����","��ɽ��","��ԭ��","�׳���","�ӱ߳�����������",
	             "��������","���������","������","�׸���","˫Ѽɽ��","������","������","��ľ˹��","��̨����","ĵ������","�ں���","�绯��","���˰�����","�Ͼ���","������","������","������","������","��ͨ��","���Ƹ���","������","�γ���","������","����","̩����","��Ǩ��",
	             "������","������","������","������","������","������","����","������","��ɽ��","̨����","��ˮ��", "�Ϸ���","������","�ߺ���","������","������","��ɽ��","������","ͭ����","������","��ɽ��","������","������","������","������","������","������","������",
	             "������","������","������","������","Ȫ����","������","��ƽ��","������","������","�ϲ���","�������","��������","Ƽ����","�Ž���","������","ӥ̶��","������","������","�˴���","������","������","������","�ൺ��","�Ͳ���","��ׯ��","��Ӫ��","��̨��","Ϋ����",
	             "������","̩����","������","������","������","������","������","�ĳ���","������","������", "֣����","������","������","ƽ��ɽ��","������","�ױ���","������","������","�����","�����","�����","����Ͽ��","������","������","������","�ܿ���","פ�����",
	             "�人��","��ʯ��","ʮ����","�˲���","������","������","������","Т����","������","�Ƹ���","������","������","��ʩ����������������","������","Ǳ����","������","��ũ������","��ɳ��","������","��̶��","������","������","������","������",
	             "�żҽ���","������","������","������","������","¦����","��������������������","������","������","�麣��","��ɽ��","������","��ݸ��","��ɽ��","�ع���","������","������","÷����","��ͷ��","��β��","��Դ��","������","��Զ��","տ����","ï����","������","������","�Ƹ���",
	             "������","������","������","������","������","���Ǹ�","������","�����","������","��ɫ��","������","�ӳ���","������","������", "������","������","��ָɽ��","����","������","�Ĳ���","������","������","��ɳ��","������","�Ͳ���","������",
	             "�ٸ���","��ɳ����������","��������������","�ֶ�����������","��ˮ����������","��ͤ��������������","������������������",
	             "�ɶ���","�Թ���","������","������","������","������","��Ԫ��","������","�ڽ���","��ɽ��","�ϳ���","üɽ��","�˱���","�㰲��","������","�Ű���","������","��֦����","��������","��ɽ��","������",
	             "������","������","��Ϫ��","��ɽ��","��ͨ��","������","������","�ٲ���","������","������","��ɽ��","��˫������","�����","�º���","ŭ���ݵ�����",
	             "������","����ˮ��","������","��˳��","�Ͻ���","ͭ����","ǭ����","����������������","ǭ���ϲ���������������","ǭ�������嶱��������",
	             "������","ͭ����","������","������","μ����","�Ӱ���","������","������","������","������", "������","��������","�����","������","��ˮ��","������","��Ҵ��","ƽ����","��Ȫ��","������","������","¤����","���Ļ���������","���ϲ���������",
	             "������","ʯ��ɽ��","������","��ԭ��","������", "������","������","��������������","��������������","���ϲ���������","���ϲ���������","�������������","�����ɹ���������",
	             "��³ľ����","����������","��³��������","���ܵ�����","��������������","���������ɹ�������","���������ɹ�������","�����յ���","�������տ¶������ݿ�ʲ����","�������","���������������","���ǵ���","����̩����",
	             "ʯ������","��������","ͼľ�����","�������","������","���Ź���","˫����","������","����������","ɽ�ϵ�����","�տ������","��������","�������","��֥����",
	             "��۵�","������","�½���", "���Ű뵺","���е�","·����","·���" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__advanced);
		
		keyword=(EditText) findViewById(id.keyword);//��Ŀ�ؼ���
		companyname=(EditText) findViewById(id.companyname);//��˾����
		district=(TextView) findViewById(id.district);//����
		province=(TextView) findViewById(id.province);//ʡ��
		stage=(TextView) findViewById(id.stage);//��Ŀ�׶�
		category=(TextView) findViewById(id.category);//��Ŀ���
		found=(ImageView) findViewById(id.found);//ȷ������
		back=(ImageView) findViewById(id.back);//����
		show=(TextView) findViewById(id.show);
		show1=(TextView) findViewById(id.show1);
		show2=(TextView) findViewById(id.show2);
		show3=(TextView) findViewById(id.show3);
		
		//ȥ���߿�
		keyword.setBackgroundDrawable(null);
		companyname.setBackgroundDrawable(null);
		
		
		//ȷ������
		found.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
			final String companystringString=companyname.getText().toString();
			if(companystringString.equals("")){
				Toast.makeText(Advanced.this,"�����빫˾�����Ϣ",Toast.LENGTH_SHORT).show();
			}
			final String keywordstringString=keyword.getText().toString();
			if(keywordstringString.equals("")){
				Toast.makeText(Advanced.this,"������ؼ���",Toast.LENGTH_SHORT).show();
			}
			 if(!keywordstringString.equals("")&&!companystringString.equals("")){
				Intent intent=new Intent(Advanced.this,Searchresult.class);
				startActivity(intent);
				finish();
			 }	
			}
		});
		
		
	
		
		//����
		district.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				showSelectDialog(Advanced.this, "����ѡ��", category1);

	           }
	        });	 
			}

			private void showSelectDialog(Advanced advanced, String string,final String[] category1) {
				// TODO �Զ����ɵķ������
				 AlertDialog dialog = new AlertDialog.Builder(advanced).create();
			        dialog.setTitle(string);
			        LinearLayout llContent = new LinearLayout(advanced);
			        llContent.setOrientation(LinearLayout.HORIZONTAL);
			        
			        //��һ���б�
			        final WheelView wheelLeft = new WheelView(advanced);
			        wheelLeft.setVisibleItems(5);
			        wheelLeft.setCyclic(true);
			        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(category1));
			        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
			        paramsLeft.gravity = Gravity.RIGHT;
			       
			        llContent.addView(wheelLeft, paramsLeft);
			        
			        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
			            @Override
			            public void onClick(DialogInterface dialog, int which) {
			                int leftPosition = wheelLeft.getCurrentItem();
			                String vLeft = category1[leftPosition];
			                show.setText(vLeft);
			                dialog.dismiss();
			            }
			        });
			        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "ȡ��", new DialogInterface.OnClickListener() {
			            @Override
			            public void onClick(DialogInterface dialog, int which) {
			                dialog.dismiss();
			            }
			        });
			        dialog.setView(llContent);
			        if (!dialog.isShowing()) {
			            dialog.show();
			        }
		
			 	   //����
				      province.setOnClickListener(new OnClickListener() {
					
			  		@Override
				    	public void onClick(View arg0) {
						// TODO �Զ����ɵķ������
						
			  			showSelectDialog1(Advanced.this, "����ѡ��", category2);	
			  	
			 	           }
				        });	
					}

						private void showSelectDialog1(Advanced advanced,	String string, final String[] category1) {
							// TODO �Զ����ɵķ������
							  AlertDialog dialog = new AlertDialog.Builder(advanced).create();
						        dialog.setTitle(string);
						        LinearLayout llContent = new LinearLayout(advanced);
						        llContent.setOrientation(LinearLayout.HORIZONTAL);
						        
						        //��һ���б�
						        final WheelView wheelLeft = new WheelView(advanced);
						        wheelLeft.setVisibleItems(5);
						        wheelLeft.setCyclic(true);
						        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(category1));
						        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
						        paramsLeft.gravity = Gravity.RIGHT;
						       
						        llContent.addView(wheelLeft, paramsLeft);
						        
						        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
						            @Override
						            public void onClick(DialogInterface dialog, int which) {
						                int leftPosition = wheelLeft.getCurrentItem();
						                String vLeft = category1[leftPosition];
						                show1.setText(vLeft);
						                dialog.dismiss();
						            }
						        });
						        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "ȡ��", new DialogInterface.OnClickListener() {
						            @Override
						            public void onClick(DialogInterface dialog, int which) {
						                dialog.dismiss();
						            }
						        });
						        dialog.setView(llContent);
						        if (!dialog.isShowing()) {
						            dialog.show();
						        }
  
			        
			        
			        
					//��Ŀ�׶�
					stage.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO �Զ����ɵķ������
						
						AlertDialog.Builder builder=new AlertDialog.Builder(Advanced.this);	
						builder.setItems(strings, new AlertDialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO �Զ����ɵķ������
								for(int i=0;i<strings.length;i++){
									if(i==arg1){
							
					                  show2.setText(strings[arg1]);	
					                  arg0.dismiss();
									 }
								  }
						      }
						  });
						builder.show();
						}
					});
					
					//��Ŀ���
			           category.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO �Զ����ɵķ������
						
						AlertDialog.Builder builder=new AlertDialog.Builder(Advanced.this);	
						builder.setItems(strings, new AlertDialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO �Զ����ɵķ������
								for(int i=0;i<strings.length;i++){
									if(i==arg1){
							
					                  show3.setText(strings[arg1]);	
					                  arg0.dismiss();
									}}
						      }
						  });
						builder.show();
						}
					});
           
	 }	 
		//���÷��ؼ�
			@Override
			public void onBackPressed() {
				// TODO �Զ����ɵķ������
				
			Intent intent=new Intent(Advanced.this,Choosemenu.class);
			startActivity(intent);
			finish();
				
			}			
}
