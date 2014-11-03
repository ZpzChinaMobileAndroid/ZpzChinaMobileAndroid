package com.example.sqlite;


import java.util.ArrayList;

import com.example.message.Afforest;
import com.example.message.Approve;
import com.example.message.Content;
import com.example.message.Design;
import com.example.message.Fitment;
import com.example.message.Plot;
import com.example.message.Project;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Sqlite {
	
	private SQLiteDatabase database; 
	Cursor cur;
	Context con;
	Mysqlite sqlite;

	public Sqlite(Context con) {
		// TODO 自动生成的构造函数存根
		sqlite=new Mysqlite(con);
		}
	
		//储存数据
	    public  void content(Information information){
	    	SQLiteDatabase database=sqlite.getWritableDatabase();
	    	String string ="insert into user(projectID ,projectCode ,projectVersion ,landName ," +
	    			"district, province,city,landAddress,area ,plotRatio ,usage ,auctionUnit ," +
	    			"projectName ,description ,owner ,expectedStartTime ,expectedFinishTime ,investment ," +
	    			"areaOfStructure ,storeyHeight ,foreignInvestment ,ownerType ,longitude ,latitude ," +
	    			"mainDesignStage ,propertyElevator ,propertyAirCondition ,propertyHeating ," +
	    			"propertyExternalWallMeterial ,propertyStealStructure ,actualStartTime ,fireControl ," +
	    			"green ,electroweakInstallation ,decorationSituation ,decorationProgress ,url ) " +
	    			"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    	
	    database.execSQL(string,new String[]{information.getProjectID()+"",information.getProjectCode()+"",
	    		information.getProjectVersion()+"",information.getLandName()+"",information.getDistrict()+"",
	    		information.getProvince()+"",information.getCity()+"",information.getLandAddress()+"",
	    		information.getArea()+"",information.getPlotRatio()+"",information.getUsage()+"",
	    		information.getAuctionUnit()+"",information.getProjectName()+"",information.getDescription()+"",
	    		information.getOwner()+"",information.getExpectedStartTime()+"",information.getExpectedFinishTime()+"",
	    		information.getInvestment()+"",information.getAreaOfStructure()+"",information.getStoreyHeight()+"",
	    		information.getForeignInvestment()+"",information.getOwnerType()+"",information.getLongitude()+"",
	    		information.getLatitude()+"",information.getMainDesignStage()+"",information.getPropertyElevator()+"",
	    		information.getPropertyAirCondition()+"",information.getPropertyHeating()+"",information.getPropertyExternalWallMeterial()+"",
	    		information.getPropertyStealStructure()+"",information.getActualStartTime()+"",information.getFireControl()+"",
	    		information.getGreen()+"",information.getElectroweakInstallation()+"",information.getDecorationSituation()+"",
	    		information.getDecorationProgress()+""});
	    
	        database.close();
	    }
	    
	    //取数据
	    public ArrayList<Information>getInformations(){
	    SQLiteDatabase database=sqlite.getReadableDatabase();
	    ArrayList<Information>arrayList=new ArrayList<Information>();
	    Cursor cursor=database.query("user", null, null, null, null, null, "projectID asc");
	    while (cursor.moveToNext()) {
	    	
	    String projectID=cursor.getString(cursor.getColumnIndex("projectID")); 
	    String projectCode=cursor.getString(cursor.getColumnIndex("projectCode")); 
	    String projectVersion=cursor.getString(cursor.getColumnIndex("projectVersion")); 
	    String district=cursor.getString(cursor.getColumnIndex("district")); 
	    String landName=cursor.getString(cursor.getColumnIndex("landName")); 
	    String province=cursor.getString(cursor.getColumnIndex("province")); 
	    String city=cursor.getString(cursor.getColumnIndex("city")); 
	    String landAddress=cursor.getString(cursor.getColumnIndex("landAddress")); 
	    String area=cursor.getString(cursor.getColumnIndex("area")); 
	    String plotRatio=cursor.getString(cursor.getColumnIndex("plotRatio")); 
	    String usage=cursor.getString(cursor.getColumnIndex("usage")); 
	    String auctionUnit=cursor.getString(cursor.getColumnIndex("auctionUnit")); 
	    String projectName=cursor.getString(cursor.getColumnIndex("projectName")); 
	    String description=cursor.getString(cursor.getColumnIndex("description")); 
	    String owner=cursor.getString(cursor.getColumnIndex("owner")); 
	    String expectedStartTime=cursor.getString(cursor.getColumnIndex("expectedStartTime")); 
	    String expectedFinishTime=cursor.getString(cursor.getColumnIndex("expectedFinishTime")); 
	    String investment=cursor.getString(cursor.getColumnIndex("investment")); 
	    String areaOfStructure=cursor.getString(cursor.getColumnIndex("areaOfStructure")); 
	    String storeyHeight=cursor.getString(cursor.getColumnIndex("storeyHeight")); 
	    String foreignInvestment=cursor.getString(cursor.getColumnIndex("foreignInvestment")); 
	    String ownerType=cursor.getString(cursor.getColumnIndex("ownerType")); 
	    String longitude=cursor.getString(cursor.getColumnIndex("longitude")); 
	    String latitude=cursor.getString(cursor.getColumnIndex("latitude")); 
	    String mainDesignStage=cursor.getString(cursor.getColumnIndex("mainDesignStage")); 
	    String propertyElevator=cursor.getString(cursor.getColumnIndex("propertyElevator")); 
	    String propertyAirCondition=cursor.getString(cursor.getColumnIndex("propertyAirCondition")); 
	    String propertyHeating=cursor.getString(cursor.getColumnIndex("propertyHeating")); 
	    String propertyExternalWallMeterial=cursor.getString(cursor.getColumnIndex("propertyExternalWallMeterial")); 
	    String propertyStealStructure=cursor.getString(cursor.getColumnIndex("propertyStealStructure")); 
	    String actualStartTime=cursor.getString(cursor.getColumnIndex("actualStartTime")); 
	    String fireControl=cursor.getString(cursor.getColumnIndex("fireControl")); 
	    String green=cursor.getString(cursor.getColumnIndex("green")); 
	    String electroweakInstallation=cursor.getString(cursor.getColumnIndex("electroweakInstallation")); 
	    String decorationSituation=cursor.getString(cursor.getColumnIndex("decorationSituation")); 
	    String decorationProgress=cursor.getString(cursor.getColumnIndex("decorationProgress")); 
	    String url=cursor.getString(cursor.getColumnIndex("url")); 
	    
	    
	   Information information=new Information(projectID, projectCode, projectVersion, landName,
			   district, province, city, landAddress, area, plotRatio, usage, auctionUnit, projectName, 
			   description, owner, expectedStartTime, expectedFinishTime, investment, areaOfStructure,
			   storeyHeight, foreignInvestment, ownerType, longitude, latitude, mainDesignStage, 
			   propertyElevator, propertyAirCondition, propertyHeating, propertyExternalWallMeterial,
			   propertyStealStructure, actualStartTime, fireControl, green, electroweakInstallation,
			   decorationSituation, decorationProgress, url);
	   
	   arrayList.add(information);
	    }
	    
		return arrayList;}
}