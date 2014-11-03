package com.example.sqlite;

import java.io.Serializable;

public class Information implements Serializable  {

	String projectID;//项目ID
	String projectCode;//项目编号
	String projectVersion;//版本号
	String landName;//地块名称
	String district;//所在区域
	String province;//所在省市
	String city;//市区县
	String landAddress;//地块地址（项目地址）
	String area;//土地面积
	String plotRatio;//土地容积率
	String usage;//地块用途
	String auctionUnit;//拍卖单位
	String projectName;//项目名称
	String description;//项目描述
	String owner;//业主单位
	String expectedStartTime;//预计开工时间
	String expectedFinishTime;//预计竣工时间
	String investment;//投资额
	String areaOfStructure;//建筑面积
	String storeyHeight;//建筑层高
	String foreignInvestment;//外资参与
	String ownerType;//业主类型
	String longitude;//经度
	String latitude;//纬度
	String mainDesignStage;//主体设计阶段
	String propertyElevator;//电梯
	String propertyAirCondition;//空调
	String propertyHeating;//供暖
	String propertyExternalWallMeterial;//外墙材料
	String propertyStealStructure;//钢结构
	String actualStartTime;//实际开工时间		
	String fireControl;//消防
	String green;//绿化
	String electroweakInstallation;//弱电安装
	String decorationSituation;//装修情况
	String decorationProgress;//装修进度
	String url;//url
	
	
	public Information() {
	     	super();
	     	
	} 	
		//所有的的数据赋值

  public Information(String projectID,String projectCode,String projectVersion,String landName,
		 String district,String province,String city,String landAddress,String area,
		 String plotRatio,String usage,String auctionUnit,String projectName,
		 String description,String owner,String expectedStartTime,String expectedFinishTime,
		 String investment,String areaOfStructure,String storeyHeight,String foreignInvestment,
		 String ownerType,String longitude,String latitude,String mainDesignStage,String propertyElevator,
		 String propertyAirCondition,String propertyHeating,String propertyExternalWallMeterial,
	     String propertyStealStructure,String actualStartTime,String fireControl,String green,
		 String electroweakInstallation,String decorationSituation,String decorationProgress,String url) {
	    		// TODO 自动生成的构造函数存根
	    	   	
		this.projectID = projectID;   this.projectID = projectID;    this.projectVersion = projectVersion;
		this.landName = landName;     this.district = district;      this.province = province;
		this.city = city;             this.landAddress = landAddress;    this.area = area;
		this.plotRatio = plotRatio;     this.usage = usage;          this.auctionUnit = auctionUnit;
		this.projectName = projectName;     this.description = description;    this.owner = owner;
		this.owner = owner;            this.expectedStartTime = expectedStartTime;   
		this.investment = investment;     this.areaOfStructure = areaOfStructure;    this.storeyHeight = storeyHeight;
		this.foreignInvestment = foreignInvestment;     this.ownerType = ownerType;    this.longitude = longitude;
		this.latitude = latitude;     this.mainDesignStage = mainDesignStage;    this.propertyElevator = propertyElevator;
		this.propertyAirCondition = propertyAirCondition;     this.propertyHeating = propertyHeating;   
		this.propertyExternalWallMeterial = propertyExternalWallMeterial;
		this.propertyStealStructure = propertyStealStructure;     this.actualStartTime = actualStartTime;   
		this.fireControl = fireControl;     this.url = url;   this.expectedFinishTime = expectedFinishTime;
		this.green = green;     this.electroweakInstallation = electroweakInstallation;  
		this.decorationSituation = decorationSituation; 	this.decorationProgress = decorationProgress;     
		
	
	}

	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectVersion() {
		return projectVersion;
	}
	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
	public String getLandName() {
		return landName;
	}
	public void setLandName(String landName) {
		this.landName = landName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLandAddress() {
		return landAddress;
	}
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPlotRatio() {
		return plotRatio;
	}
	public void setPlotRatio(String plotRatio) {
		this.plotRatio = plotRatio;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getAuctionUnit() {
		return auctionUnit;
	}
	public void setAuctionUnit(String auctionUnit) {
		this.auctionUnit = auctionUnit;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getExpectedStartTime() {
		return expectedStartTime;
	}
	public void setExpectedStartTime(String expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}
	public String getExpectedFinishTime() {
		return expectedFinishTime;
	}
	public void setExpectedFinishTime(String expectedFinishTime) {
		this.expectedFinishTime = expectedFinishTime;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getAreaOfStructure() {
		return areaOfStructure;
	}
	public void setAreaOfStructure(String areaOfStructure) {
		this.areaOfStructure = areaOfStructure;
	}
	public String getStoreyHeight() {
		return storeyHeight;
	}
	public void setStoreyHeight(String storeyHeight) {
		this.storeyHeight = storeyHeight;
	}
	public String getForeignInvestment() {
		return foreignInvestment;
	}
	public void setForeignInvestment(String foreignInvestment) {
		this.foreignInvestment = foreignInvestment;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMainDesignStage() {
		return mainDesignStage;
	}
	public void setMainDesignStage(String mainDesignStage) {
		this.mainDesignStage = mainDesignStage;
	}
	public String getPropertyElevator() {
		return propertyElevator;
	}
	public void setPropertyElevator(String propertyElevator) {
		this.propertyElevator = propertyElevator;
	}
	public String getPropertyAirCondition() {
		return propertyAirCondition;
	}
	public void setPropertyAirCondition(String propertyAirCondition) {
		this.propertyAirCondition = propertyAirCondition;
	}
	public String getPropertyHeating() {
		return propertyHeating;
	}
	public void setPropertyHeating(String propertyHeating) {
		this.propertyHeating = propertyHeating;
	}
	public String getPropertyStealStructure() {
		return propertyStealStructure;
	}
	public void setPropertyStealStructure(String propertyStealStructure) {
		this.propertyStealStructure = propertyStealStructure;
	}
	public String getActualStartTime() {
		return actualStartTime;
	}
	public void setActualStartTime(String actualStartTime) {
		this.actualStartTime = actualStartTime;
	}
	public String getFireControl() {
		return fireControl;
	}
	public void setFireControl(String fireControl) {
		this.fireControl = fireControl;
	}
	public String getGreen() {
		return green;
	}
	public void setGreen(String green) {
		this.green = green;
	}
	public String getElectroweakInstallation() {
		return electroweakInstallation;
	}
	public void setElectroweakInstallation(String electroweakInstallation) {
		this.electroweakInstallation = electroweakInstallation;
	}
	public String getDecorationSituation() {
		return decorationSituation;
	}
	public void setDecorationSituation(String decorationSituation) {
		this.decorationSituation = decorationSituation;
	}
	public String getDecorationProgress() {
		return decorationProgress;
	}
	public void setDecorationProgress(String decorationProgress) {
		this.decorationProgress = decorationProgress;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPropertyExternalWallMeterial() {
		return propertyExternalWallMeterial;
	}
	public void setPropertyExternalWallMeterial(String city) {
		this.propertyExternalWallMeterial = propertyExternalWallMeterial;
	}
	
}
