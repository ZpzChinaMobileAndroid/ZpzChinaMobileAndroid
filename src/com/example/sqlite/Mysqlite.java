package com.example.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlite extends SQLiteOpenHelper{

	private static final int VERSION=1;
	private static final String DBNAME="content.db";
	
	public Mysqlite(Context context) {
		
		//����һ:�����Ļ��� �����������ݿ������ �����ģ��汾�� ������
		super(context, DBNAME, null, VERSION);
		// TODO �Զ����ɵĹ��캯�����
	}
	// ��Ҫ�õ����ݿ�ʱ��ϵͳ��ȥ��鵱ǰ�������Ƿ�������ݿ⣬�������������Oncreate����
	 // ע�⣺һ��ʼ������3���е����ݿ⣬������һϵ�еĲ��ԣ�����һ������Ҫ���ӵ�4����ʱ��һ��Ҫ�Ȱ�ԭ���ݿ�ɾ����ȥ����
	@Override
	public void onCreate(SQLiteDatabase arg0) {							//�������ݿ�
		// TODO �Զ����ɵķ������
		// һ����˵���˴����ǽ��д�����Ĳ���
		// create table ���� ��_id integer primary key autoincrement,����  �д洢�����ͣ�����������
	    // ִ������ķ���������Ҫ�����ݿ��д���һ����ΪgameInfo�ı�
		// �����ݿ�ᱻ�����data/data/�������/databases/
				
		arg0.execSQL("create table user(_id integer primary key autoincrement, projectID text," +
				"projectCode text,projectVersion text,landName text,district text, province text,city text," +
				"landAddress text,area text,plotRatio text,usage text,auctionUnit text,projectName text," +
				"description text,owner text,expectedStartTime text,expectedFinishTime text,investment text," +
				"areaOfStructure text,storeyHeight text,foreignInvestment text,ownerType text,longitude text," +
				"latitude text,mainDesignStage text,propertyElevator text,propertyAirCondition text," +
				"propertyHeating text,propertyExternalWallMeterial text,propertyStealStructure text," +
				"actualStartTime text,fireControl text,green text,electroweakInstallation text," +
				"decorationSituation text,decorationProgress text,url text)");
	         
	 }
	//�����ݿ�İ汾�ŷ����ı�ʱ�����еķ�����Ҫ�ɵ��¶���ɾ��ԭ���ݿ⣬����oncreate����
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO �Զ����ɵķ������
		//������ݿ��д���table���ű��Ͱ����ű�ɾ��
	
		
	}
}
