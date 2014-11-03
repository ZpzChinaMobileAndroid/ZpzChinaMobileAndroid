package com.example.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlite extends SQLiteOpenHelper{

	private static final int VERSION=1;
	private static final String DBNAME="content.db";
	
	public Mysqlite(Context context) {
		
		//参数一:上下文环境 参数二：数据库的名字 参数四：版本号 参数三
		super(context, DBNAME, null, VERSION);
		// TODO 自动生成的构造函数存根
	}
	// 当要用到数据库时，系统会去检查当前程序中是否包含数据库，如果不包含，走Oncreate方法
	 // 注意：一开始创建了3个列的数据库，进行了一系列的测试，当有一天碰到要增加到4个列时，一定要先把原数据库删掉再去测试
	@Override
	public void onCreate(SQLiteDatabase arg0) {							//创建数据库
		// TODO 自动生成的方法存根
		// 一般来说，此处均是进行创建表的操作
		// create table 表名 （_id integer primary key autoincrement,列名  列存储的类型，。。。）；
	    // 执行下面的方法代表我要在数据库中创建一个名为gameInfo的表
		// 该数据库会被存放在data/data/程序包名/databases/
				
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
	//当数据库的版本号发生改变时会运行的方法，要干的事儿：删除原数据库，重新oncreate方法
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO 自动生成的方法存根
		//如果数据库中存在table这张表，就把这张表删除
	
		
	}
}
