package com.project.codingtask.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class DeviceInfo {

@JacksonXmlProperty(isAttribute= true)
private String name;
@JacksonXmlProperty(isAttribute= true)
private String id;

private ScreenInfo screenInfo;
private OsInfo osInfo;
private AppInfo appInfo;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public ScreenInfo getScreenInfo() {
	return screenInfo;
}
public void setScreenInfo(ScreenInfo screenInfo) {
	this.screenInfo = screenInfo;
}
public OsInfo getOsInfo() {
	return osInfo;
}
public void setOsInfo(OsInfo osInfo) {
	this.osInfo = osInfo;
}
public AppInfo getAppInfo() {
	return appInfo;
}
public void setAppInfo(AppInfo appInfo) {
	this.appInfo = appInfo;
}

}
