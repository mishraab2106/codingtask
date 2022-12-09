package com.project.codingtask.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ScreenInfo {
@JacksonXmlProperty(isAttribute= true)
@NotNull
@Min(1)
private int width;
@JacksonXmlProperty(isAttribute= true)
@NotNull
@Min(1)
private int height;
@JacksonXmlProperty(isAttribute= true)
@NotNull
@Min(1)
private int dpi;
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getDpi() {
	return dpi;
}
public void setDpi(int dpi) {
	this.dpi = dpi;
}
}
