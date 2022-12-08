package com.project.codingtask.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OsInfo {
	@JacksonXmlProperty(isAttribute= true)
	private String name;
	@JacksonXmlProperty(isAttribute= true)
	private double version;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}

}
