package com.project.codingtask.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class DeviceInfo {

@JacksonXmlProperty(isAttribute= true)
@NotEmpty
private String name;
@JacksonXmlProperty(isAttribute= true)
@NotEmpty
@Email
private String id;
@Valid
private ScreenInfo screenInfo;

@Valid
private OsInfo osInfo;
@Valid
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
