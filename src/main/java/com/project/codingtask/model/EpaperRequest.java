package com.project.codingtask.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.validator.constraints.NotEmpty;
import org.w3c.dom.Document;

public class EpaperRequest
{
	@Valid
	private DeviceInfo deviceInfo;
	@Valid
	private GetPages getPages;

	public GetPages getGetPages() {
		return getPages;
	}
	public void setGetPages(GetPages getPages) {
		this.getPages = getPages;
	}
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
}